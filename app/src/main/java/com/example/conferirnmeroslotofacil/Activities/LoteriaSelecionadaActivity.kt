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
import com.example.conferirnmeroslotofacil.R
import com.example.conferirnmeroslotofacil.databinding.ActivityLoteriaSelecionadaBinding
import java.lang.NumberFormatException
import kotlin.Exception

class LoteriaSelecionadaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoteriaSelecionadaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoteriaSelecionadaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var concurso = intent.getStringExtra("concurso")

        binding.txtTexto.text = concurso


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
                cursor.moveToNext();
            }
        }catch (ex: Exception){

        }

        binding.btnCadastrarJogo.setOnClickListener(){
            if(concurso.equals("LotoFacil")){
                /*
                val builder = AlertDialog.Builder(this)
                builder.setMessage("teste")
                builder.setPositiveButton("Confirmar", DialogInterface.OnClickListener{
                        dialog, id ->
                        val intent = Intent(this, LotoFacilActivity::class.java)
                        startActivity(intent)
                    })
                    .setNegativeButton("Cancelar", DialogInterface.OnClickListener{
                        dialog, id ->
                    })
                builder.create().show()*/

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
    }
}