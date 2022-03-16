package com.example.conferirnmeroslotofacil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
                val intent = Intent(this, LotoFacilActivity::class.java)
                startActivity(intent)
            }
        }
    }
}