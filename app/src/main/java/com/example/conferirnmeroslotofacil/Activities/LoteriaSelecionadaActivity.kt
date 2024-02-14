package com.example.conferirnmeroslotofacil.Activities

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.conferirnmeroslotofacil.Adapter.AdapterJogo
import com.example.conferirnmeroslotofacil.Model.Result
import com.example.conferirnmeroslotofacil.R
import com.example.conferirnmeroslotofacil.Services.DataService
import com.example.conferirnmeroslotofacil.Services.EndPoint
import com.example.conferirnmeroslotofacil.databinding.ActivityLoteriaSelecionadaBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoteriaSelecionadaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoteriaSelecionadaBinding
    private lateinit var concurso:String
    private var listaString = arrayListOf<String>()

    override fun onStart() {
        super.onStart()
        listaString.clear()

        //binding.txtJogo.text = ""

        try {
            val banco: SQLiteDatabase = openOrCreateDatabase("app", MODE_PRIVATE, null)
            var consulta = "SELECT loto, numeros FROM loteria where loto = '"+concurso+"'"
            var cursor: Cursor = banco.rawQuery(consulta, null)

            var indiceNumeros = cursor.getColumnIndex("numeros")

            cursor.moveToFirst()

            while (cursor != null) {
                var numeros: String = cursor.getString(indiceNumeros)
                listaString.add(numeros)
                //binding.txtJogo.text = binding.txtJogo.text.toString() + numeros + "\n"
                cursor.moveToNext();
            }
            cursor.close()
            banco.close()
        }catch (ex: IndexOutOfBoundsException){

        }catch (ex: Exception){
            //binding.txtJogo.text = "Você não possui jogo cadastrado ainda"
        }

        //Configurar adapter
        var adapterJogo = AdapterJogo(listaString, this)

        var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(getApplicationContext())
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL));
        binding.recyclerView.setAdapter(adapterJogo);
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
            builder.setPositiveButton("Confirmar") { _, _ ->
                if (concurso.equals("lotofacil")) {
                    val intent = Intent(this, LotoFacilActivity::class.java)
                    intent.putExtra("qt", txtNumeros.text.toString().toInt())
                    startActivity(intent)
                }
                if (concurso.equals("megasena")) {
                    val intent = Intent(this, MegaSenaActivity::class.java)
                    intent.putExtra("qt", txtNumeros.text.toString().toInt())
                    startActivity(intent)
                }
            }
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

        var aux = listaString
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
                for (i in 0 until acertosArray.size){
                    binding.txtResult.text = binding.txtResult.text.toString() + "\nJogo "+(i+1)+": "+acertosArray[i]
                }
                var ganhadores = response.body()!!.premiacoes[0].ganhadores
                var premiacao = response.body()!!.premiacoes[0].valorPremio
                var premioFormatado: String
                if(premiacao == 0.0){
                    premioFormatado = "0,00"
                }else{
                    premioFormatado = formatarDinheiro(premiacao)
                }

                binding.txtInfo.text = "Total de ganhadores: $ganhadores\n Prêmio com 15 acertos: R$ $premioFormatado"

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

    fun  formatarDinheiro(premio: Double): String{
        var premioformatado = premio.toString()
        var aux = premioformatado.split(".")
        var decimal = aux[1]
        var array = aux[0].toCharArray()
        var i: Int = array.size-1
        var formatado = ""
        var contador = 0
        while ( i >= 0){
            if (contador == 3){
                formatado += "."
                contador = 0
            }
            formatado += array[i].toString()
            contador++
            i--
        }
        array = formatado.toCharArray()
        var formatado2 = ""
        i = array.size-1
        while ( i >= 0){
            formatado2 += array[i].toString()
            i--
        }
        array = decimal.toCharArray()
        if(array.size <2)
            decimal += "0"

        return "$formatado2,$decimal"
    }
}