package com.example.conferirnmeroslotofacil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.conferirnmeroslotofacil.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private var todosNumeros = mutableListOf<Int>(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
    private var numerosSorteados = mutableListOf<Int>(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
    private lateinit var binding: ActivityMainBinding
    private val listaNumeros1: IntArray = intArrayOf(1,2,4,5,7,10,11,12,13,14,16,20,21,22,24)
    private val acertos: IntArray = intArrayOf(0, 0, 0)
    private val listaNumeros2: IntArray = intArrayOf(2,3,4,6,8,10,13,14,15,17,18,19,21,23,25)
    private val listaNumeros3: IntArray = intArrayOf(1,2,3,5,9,10,11,13,14,17,19,20,22,24,25)
    private val matriz = arrayListOf<IntArray>(listaNumeros1, listaNumeros2, listaNumeros3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.txtNumeros.text = "Atualmente estão sendo conferidos os seguintes jogos: \n"
        for(i: IntArray in matriz) {
            for (j: Int in i) {
                binding.txtNumeros.text = binding.txtNumeros.text.toString() + j + ", "
            }
            binding.txtNumeros.text = binding.txtNumeros.text.toString()+"\n"
        }
        for(i: Int in 0..24){
            todosNumeros[i] = i+1
        }

        Collections.shuffle(todosNumeros)

        for(i: Int in 0..14){
            numerosSorteados[i] = todosNumeros[i]
        }

        for(j: Int in 0..2) {
            for (i: Int in 0..14) {
                var numeroSorteado = numerosSorteados[i]
                if(matriz[j].contains(numeroSorteado))
                    acertos[j] += 1
            }
        }
        binding.txtTeste.text = "Os números sorteados foram: \n"
        for(i: Int in numerosSorteados){
            binding.txtTeste.text = binding.txtTeste.text.toString()+ i + ", "
        }
        binding.txtTeste.text = binding.txtTeste.text.toString() + "\nAcertos no jogo 1: "+acertos[0] +
                "\nAcertos no jogo 2: "+acertos[1]+"\nAcertos no jogo 3: "+acertos[2]
    }
}