package com.example.conferirnmeroslotofacil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.conferirnmeroslotofacil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent = Intent(this, LoteriaSelecionadaActivity::class.java)

        binding.btnMegaSena.setOnClickListener(){
            intent.putExtra("concurso", "Mega-Sena")
            startActivity(intent)
        }
        binding.btnQuina.setOnClickListener(){
            intent.putExtra("concurso", "Quina")
            startActivity(intent)
        }
        binding.btnLotoFacil.setOnClickListener(){
            intent.putExtra("concurso", "LotoFacil")
            startActivity(intent)
        }
        binding.btnLotoMania.setOnClickListener(){
            intent.putExtra("concurso", "LotoMania")
            startActivity(intent)
        }
    }
}