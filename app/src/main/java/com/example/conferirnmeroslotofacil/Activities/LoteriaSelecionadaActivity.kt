package com.example.conferirnmeroslotofacil.Activities

import android.content.DialogInterface
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
import java.lang.NumberFormatException
import kotlin.Exception

class LoteriaSelecionadaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoteriaSelecionadaBinding

    override fun onStart() {
        super.onStart()

        binding.txtJogo.text = ""

        try {
            val banco: SQLiteDatabase = openOrCreateDatabase("app", MODE_PRIVATE, null)
            var consulta: String = "SELECT loto, numeros FROM loteria where loto = 'lotofacil'"
            var cursor: Cursor = banco.rawQuery(consulta, null);

            var indiceLoto = cursor.getColumnIndex("loto")
            var indiceNumeros = cursor.getColumnIndex("numeros")



            cursor.moveToFirst()
            while (cursor != null) {
                var loto: String = cursor.getString(indiceLoto)
                var numeros: String = cursor.getString(indiceNumeros)
                binding.txtJogo.text = binding.txtJogo.text.toString() + numeros + "\n"
                //if(binding.txtJogo.text == "\n" || binding.txtJogo.text == "" || binding.txtJogo.text == null)
                //binding.txtJogo.text = "Você não possui jogo cadastrado ainda"

                cursor.moveToNext();
            }
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

        var concurso = intent.getStringExtra("concurso")

        binding.txtTexto.text = concurso

        binding.btnCadastrarJogo.setOnClickListener(){
            if(concurso.equals("LotoFacil")){
                val builder = AlertDialog.Builder(this)
                val inflater = layoutInflater
                builder.setTitle("Selecione a quantidade de números do jogo")
                val dialogLayout = inflater.inflate(R.layout.numeros_lotofacil, null)
                var txtNumeros  = dialogLayout.findViewById<EditText>(R.id.txtNumeros)
                builder.setView(dialogLayout)
                builder.setPositiveButton("Confirmar", DialogInterface.OnClickListener{
                    dialog, which ->
                    val intent = Intent(this, LotoFacilActivity::class.java)
                    intent.putExtra("qt", txtNumeros.text.toString().toInt())
                    startActivity(intent)
                })
                builder.show()
            }
        }

        binding.btnTeste.setOnClickListener(){
            getData()
        }
    }

    fun getData() {
        val retrofitClient = DataService
            .getRetrofitInstance("https://loteriascaixa-api.herokuapp.com/api/")

        val endpoint = retrofitClient.create(EndPoint::class.java)
        val callback = endpoint.getConcurso()

        callback.enqueue(object : Callback<Result> {
            override fun onFailure(call: Call<Result>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }


            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                    binding.txtResult.text = binding.txtResult.text.toString().plus(response.body())
            }
        })

    }
}