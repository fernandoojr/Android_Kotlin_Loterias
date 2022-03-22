package com.example.conferirnmeroslotofacil.Activities

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.conferirnmeroslotofacil.R
import com.example.conferirnmeroslotofacil.databinding.ActivityLotofacilBinding

class LotoFacilActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLotofacilBinding
    private var cont: Int = 0
    private var botoes = Array(25, {i->false})

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLotofacilBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var qt = intent.getIntExtra("qt", 15)

        val sorteados = mutableListOf<Int>(qt)

        binding.btnSalvar.setOnClickListener(){
            if(cont == qt){
                val numeros: IntArray = IntArray(qt)
                var j = 0
                for(i: Int in 0..24) {
                    if (botoes[i]) {
                        numeros[j] = i+1
                        j++
                    }
                }
                var jogo: String = ""
                for(i: Int in numeros){
                    jogo = jogo + i + ","
                }

                val banco: SQLiteDatabase = openOrCreateDatabase("app", MODE_PRIVATE, null)
                banco.execSQL("CREATE TABLE IF NOT EXISTS loteria (loto VARCHAR, numeros VARCHAR)")
                var sql = "INSERT INTO loteria(loto, numeros) VALUES ('lotofacil', '" + jogo + "')"
                banco.execSQL(sql)
            }else{
                Toast.makeText(this, "Números insuficientes", Toast.LENGTH_LONG).show()
            }
        }

        binding.btn1.setOnClickListener(){
            if(cont < qt && !botoes[0]) {
                cont++
                botoes[0] = true
                binding.btn1.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[0]){
                cont--
                botoes[0] = false
                binding.btn1.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn2.setOnClickListener(){
            if(cont < qt && !botoes[1]) {
                cont++
                botoes[1] = true
                binding.btn2.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[1]){
                cont--
                botoes[1] = false
                binding.btn2.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn3.setOnClickListener(){
            if(cont < qt && !botoes[2]) {
                cont++
                botoes[2] = true
                binding.btn3.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[2]){
                cont--
                botoes[2] = false
                binding.btn3.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn4.setOnClickListener(){
            if(cont < qt && !botoes[3]) {
                cont++
                botoes[3] = true
                binding.btn4.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[3]){
                cont--
                botoes[3] = false
                binding.btn4.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn5.setOnClickListener(){
            if(cont < qt && !botoes[4]) {
                cont++
                botoes[4] = true
                binding.btn5.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[4]){
                cont--
                botoes[4] = false
                binding.btn5.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn6.setOnClickListener(){
            if(cont < qt && !botoes[5]) {
                cont++
                botoes[5] = true
                binding.btn6.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[5]){
                cont--
                botoes[5] = false
                binding.btn6.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn7.setOnClickListener(){
            if(cont < qt && !botoes[6]) {
                cont++
                botoes[6] = true
                binding.btn7.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[6]){
                cont--
                botoes[6] = false
                binding.btn7.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn8.setOnClickListener(){
            if(cont < qt && !botoes[7]) {
                cont++
                botoes[7] = true
                binding.btn8.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[7]){
                cont--
                botoes[7] = false
                binding.btn8.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn9.setOnClickListener(){
            if(cont < qt && !botoes[8]) {
                cont++
                botoes[8] = true
                binding.btn9.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[8]){
                cont--
                botoes[8] = false
                binding.btn9.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn10.setOnClickListener(){
            if(cont < qt && !botoes[9]) {
                cont++
                botoes[9] = true
                binding.btn10.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[9]){
                cont--
                botoes[9] = false
                binding.btn10.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn11.setOnClickListener(){
            if(cont < qt && !botoes[10]) {
                cont++
                botoes[10] = true
                binding.btn11.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[10]){
                cont--
                botoes[10] = false
                binding.btn11.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn12.setOnClickListener(){
            if(cont < qt && !botoes[11]) {
                cont++
                botoes[11] = true
                binding.btn12.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[11]){
                cont--
                botoes[11] = false
                binding.btn12.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn13.setOnClickListener(){
            if(cont < qt && !botoes[12]) {
                cont++
                botoes[12] = true
                binding.btn13.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[12]){
                cont--
                botoes[12] = false
                binding.btn13.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn14.setOnClickListener(){
            if(cont < qt && !botoes[13]) {
                cont++
                botoes[13] = true
                binding.btn14.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[13]){
                cont--
                botoes[13] = false
                binding.btn14.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn15.setOnClickListener(){
            if(cont < qt && !botoes[14]) {
                cont++
                botoes[14] = true
                binding.btn15.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[14]){
                cont--
                botoes[14] = false
                binding.btn15.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn16.setOnClickListener(){
            if(cont < qt && !botoes[15]) {
                cont++
                botoes[15] = true
                binding.btn16.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[15]){
                cont--
                botoes[15] = false
                binding.btn16.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn17.setOnClickListener(){
            if(cont < qt && !botoes[16]) {
                cont++
                botoes[16] = true
                binding.btn17.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[16]){
                cont--
                botoes[16] = false
                binding.btn17.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn18.setOnClickListener(){
            if(cont < qt && !botoes[17]) {
                cont++
                botoes[17] = true
                binding.btn18.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[17]){
                cont--
                botoes[17] = false
                binding.btn18.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn19.setOnClickListener(){
            if(cont < qt && !botoes[18]) {
                cont++
                botoes[18] = true
                binding.btn19.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[18]){
                cont--
                botoes[18] = false
                binding.btn19.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn20.setOnClickListener(){
            if(cont < qt && !botoes[19]) {
                cont++
                botoes[19] = true
                binding.btn20.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[19]){
                cont--
                botoes[19] = false
                binding.btn20.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn21.setOnClickListener(){
            if(cont < qt && !botoes[20]) {
                cont++
                botoes[20] = true
                binding.btn21.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[20]){
                cont--
                botoes[20] = false
                binding.btn21.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn22.setOnClickListener(){
            if(cont < qt && !botoes[21]) {
                cont++
                botoes[21] = true
                binding.btn22.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[21]){
                cont--
                botoes[21] = false
                binding.btn22.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn23.setOnClickListener(){
            if(cont < qt && !botoes[22]) {
                cont++
                botoes[22] = true
                binding.btn23.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[22]){
                cont--
                botoes[22] = false
                binding.btn23.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn24.setOnClickListener(){
            if(cont < qt && !botoes[23]) {
                cont++
                botoes[23] = true
                binding.btn24.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[23]){
                cont--
                botoes[23] = false
                binding.btn24.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn25.setOnClickListener(){
            if(cont < qt && !botoes[24]) {
                cont++
                botoes[24] = true
                binding.btn25.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[24]){
                cont--
                botoes[24] = false
                binding.btn25.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
    }
}