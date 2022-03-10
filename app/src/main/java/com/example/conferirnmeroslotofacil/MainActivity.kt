package com.example.conferirnmeroslotofacil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.conferirnmeroslotofacil.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent = Intent(this, LoteriaSelecionadaActivity::class.java)

        binding.btnMegaSena.setOnClickListener(){
            intent.putExtra("concurso", "megaSena")
            startActivity(intent)
        }
        binding.btnQuina.setOnClickListener(){
            intent.putExtra("concurso", "quina")
            startActivity(intent)
        }
        binding.btnLotoFacil.setOnClickListener(){
            intent.putExtra("concurso", "lotoFacil")
            startActivity(intent)
        }
        binding.btnLotoMania.setOnClickListener(){
            intent.putExtra("concurso", "lotoMania")
            startActivity(intent)
        }
    }
}