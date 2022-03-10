package com.example.conferirnmeroslotofacil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.conferirnmeroslotofacil.databinding.ActivityLoteriaSelecionadaBinding
import com.example.conferirnmeroslotofacil.databinding.ActivityMainBinding
import java.util.*

class LoteriaSelecionadaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoteriaSelecionadaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoteriaSelecionadaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var concuso = intent.getStringExtra("concurso")

        binding.txtTeste.text = concuso

    }
}