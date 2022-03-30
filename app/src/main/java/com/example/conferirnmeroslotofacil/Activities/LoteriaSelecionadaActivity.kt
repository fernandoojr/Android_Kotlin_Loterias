package com.example.conferirnmeroslotofacil.Activities

import android.content.DialogInterface
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.conferirnmeroslotofacil.Model.Result
import com.example.conferirnmeroslotofacil.R
import com.example.conferirnmeroslotofacil.Services.DataService
import com.example.conferirnmeroslotofacil.Services.EndPoint
import com.example.conferirnmeroslotofacil.databinding.ActivityLoteriaSelecionadaBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.IndexOutOfBoundsException
import kotlin.Exception

class LoteriaSelecionadaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoteriaSelecionadaBinding
    private lateinit var concurso:String

    override fun onStart() {
        super.onStart()

        binding.txtJogo.text = ""

        try {
            val banco: SQLiteDatabase = openOrCreateDatabase("app", MODE_PRIVATE, null)
            var consulta = "SELECT loto, numeros FROM loteria where loto = '"+concurso+"'"
            var cursor: Cursor = banco.rawQuery(consulta, null)

            var indiceNumeros = cursor.getColumnIndex("numeros")

            cursor.moveToFirst()
            while (cursor != null) {
                var numeros: String = cursor.getString(indiceNumeros)
                binding.txtJogo.text = binding.txtJogo.text.toString() + numeros + "\n"
                //if(binding.txtJogo.text == "\n" || binding.txtJogo.text == "" || binding.txtJogo.text == null)
                //binding.txtJogo.text = "Você não possui jogo cadastrado ainda"

                cursor.moveToNext();
            }
            cursor.close()
        }catch (ex: IndexOutOfBoundsException){

        }catch (ex: Exception){
            binding.txtJogo.text = "Você não possui jogo cadastrado ainda"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoteriaSelecionadaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        concurso = intent.getStringExtra("concurso").toString()

        getUltimo()

        binding.txtTexto.text = concurso

        binding.btnCadastrarJogo.setOnClickListener(){

            val builder = AlertDialog.Builder(this)
            val inflater = layoutInflater
            builder.setTitle("Selecione a quantidade de números do jogo")
            val dialogLayout = inflater.inflate(R.layout.numeros, null)
            var txtNumeros  = dialogLayout.findViewById<EditText>(R.id.txtNumeros)
            builder.setView(dialogLayout)
            builder.setPositiveButton("Confirmar", DialogInterface.OnClickListener{
                _, _ ->
                if(concurso.equals("lotofacil")){
                    val intent = Intent(this, LotoFacilActivity::class.java)
                    intent.putExtra("qt", txtNumeros.text.toString().toInt())
                    startActivity(intent)
                }
                if(concurso.equals("mega-sena")){
                    val intent = Intent(this, MegaSenaActivity::class.java)
                    intent.putExtra("qt", txtNumeros.text.toString().toInt())
                    startActivity(intent)
                }
            })
            builder.show()
        }

        binding.btnTeste.setOnClickListener(){
            getResult()
        }
    }

    fun getResult() {
        val retrofitClient = DataService
            .getRetrofitInstance("https://loteriascaixa-api.herokuapp.com/api/"+concurso+"/")

        val endpoint = retrofitClient.create(EndPoint::class.java)
        val nConcurso = binding.spinner.selectedItem.toString()
        val callback = endpoint.getConcurso(nConcurso)

        var aux = binding.txtJogo.text.split("\n")
        var lista = mutableListOf<ArrayList<Int>>()
        var array = arrayListOf<Int>()
        var acertosArray = arrayListOf<Int>()

        for(i in aux){
            if(i!="") {
                var aux2 = i.split(",")
                for (j in aux2) {
                    if (j != "")
                        array.add(j.toInt())
                }
                val copiaArray = arrayListOf<Int>()
                copiaArray.addAll(array)
                lista.add(copiaArray)
                array.clear()
            }
        }

        callback.enqueue(object : Callback<Result> {
            override fun onFailure(call: Call<Result>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }


            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                var acertos = 0
                for(jogo in lista){
                    for(numero in response.body()!!.dezenas){
                        if(jogo.contains(numero.toInt())){
                            acertos++
                        }
                    }
                    acertosArray.add(acertos)
                    acertos=0
                }
                binding.txtResult.text = "Acertos em cada jogo: \n"
                for (i in 0..acertosArray.size-1){
                    binding.txtResult.text = binding.txtResult.text.toString() + "\nJogo "+(i+1)+": "+acertosArray[i]
                }
            }
        })
    }


    fun getUltimo() {
        val retrofitClient = DataService
            .getRetrofitInstance("https://loteriascaixa-api.herokuapp.com/api/"+concurso+"/")

        val endpoint = retrofitClient.create(EndPoint::class.java)
        val callback = endpoint.getConcurso("latest")

        callback.enqueue(object : Callback<Result> {
            override fun onFailure(call: Call<Result>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }


            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                montarListaDeJogos(response.body()!!.concurso)
            }
        })
    }

    fun montarListaDeJogos(last: Int){
        val list = MutableList(last) { index -> last - index }
        val adapter = ArrayAdapter(this,
            android.R.layout.simple_spinner_item, list)
        binding.spinner.adapter = adapter
    }

}