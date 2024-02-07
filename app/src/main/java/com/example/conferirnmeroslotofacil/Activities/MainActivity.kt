package com.example.conferirnmeroslotofacil.Activities

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
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

        //val banco: SQLiteDatabase = openOrCreateDatabase("app", MODE_PRIVATE, null)
        //banco.execSQL("DROP TABLE loteria")

        val intent = Intent(this, LoteriaSelecionadaActivity::class.java)

        binding.btnMegaSena.setOnClickListener(){
            intent.putExtra("concurso", "mega-sena")
            startActivity(intent)
        }
        binding.btnQuina.setOnClickListener(){
            intent.putExtra("concurso", "quina")
            startActivity(intent)
        }
        binding.btnLotoFacil.setOnClickListener(){
            intent.putExtra("concurso", "lotofacil")
            startActivity(intent)
        }
        binding.btnLotoMania.setOnClickListener(){
            intent.putExtra("concurso", "lotomania")
            startActivity(intent)
        }
        //teste
    }
}