package com.example.conferirnmeroslotofacil

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.conferirnmeroslotofacil.databinding.ActivityLoteriaSelecionadaBinding
import com.example.conferirnmeroslotofacil.databinding.ActivityMainBinding
import java.util.*

class LoteriaSelecionadaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoteriaSelecionadaBinding
    private var cont = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoteriaSelecionadaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var concuso = intent.getStringExtra("concurso")

        binding.btn1.setOnClickListener(){

        }
        binding.btn2.setOnClickListener(){

        }
        binding.btn3.setOnClickListener(){

        }
        binding.btn4.setOnClickListener(){

        }
        binding.btn5.setOnClickListener(){

        }
        binding.btn6.setOnClickListener(){

        }
        binding.btn7.setOnClickListener(){

        }
        binding.btn8.setOnClickListener(){

        }
        binding.btn9.setOnClickListener(){

        }
        binding.btn10.setOnClickListener(){

        }
        binding.btn11.setOnClickListener(){

        }
        binding.btn12.setOnClickListener(){

        }
        binding.btn13.setOnClickListener(){

        }
        binding.btn14.setOnClickListener(){

        }
        binding.btn15.setOnClickListener(){

        }
        binding.btn16.setOnClickListener(){

        }
        binding.btn17.setOnClickListener(){

        }
        binding.btn18.setOnClickListener(){

        }
        binding.btn19.setOnClickListener(){

        }
        binding.btn20.setOnClickListener(){

        }
        binding.btn21.setOnClickListener(){

        }
        binding.btn22.setOnClickListener(){

        }
        binding.btn23.setOnClickListener(){

        }
        binding.btn24.setOnClickListener(){

        }
        binding.btn25.setOnClickListener(){

        }
    }
}