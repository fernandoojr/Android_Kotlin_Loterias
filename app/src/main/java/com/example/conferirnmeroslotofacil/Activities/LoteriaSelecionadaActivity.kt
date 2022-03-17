package com.example.conferirnmeroslotofacil.Activities

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.conferirnmeroslotofacil.databinding.ActivityLoteriaSelecionadaBinding

class LoteriaSelecionadaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoteriaSelecionadaBinding

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
                builder.setMessage("Selecione a quantidade de números")
                    .setPositiveButton("Confirmar", DialogInterface.OnClickListener{
                        dialog, id ->
                        val intent = Intent(this, LotoFacilActivity::class.java)
                        startActivity(intent)
                    })
                    .setNegativeButton("Cancelar", DialogInterface.OnClickListener{
                        dialog, id ->
                    })
                builder.create().show()

            }
        }
    }
}