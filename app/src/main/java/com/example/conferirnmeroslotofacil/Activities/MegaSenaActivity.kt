package com.example.conferirnmeroslotofacil.Activities

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.conferirnmeroslotofacil.R
import com.example.conferirnmeroslotofacil.databinding.ActivityMegaSenaBinding

class MegaSenaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMegaSenaBinding
    private var cont: Int = 0
    private var botoes = Array(60, {i->false})

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMegaSenaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var qt = intent.getIntExtra("qt", 15)
        binding.textView.text = "Selecione os $qt números desejados"

        binding.btnSalvar.setOnClickListener(){
            if(cont == qt){
                val numeros: IntArray = IntArray(qt)
                var j = 0
                for(i: Int in 0..59) {
                    if (botoes[i]) {
                        numeros[j] = i+1
                        j++
                    }
                }
                var jogo = ""
                for(i: Int in numeros){
                    jogo = jogo + i + ","
                }

                val banco: SQLiteDatabase = openOrCreateDatabase("app", MODE_PRIVATE, null)
                banco.execSQL("CREATE TABLE IF NOT EXISTS loteria (loto VARCHAR, numeros VARCHAR)")
                var sql = "INSERT INTO loteria(loto, numeros) VALUES ('mega-sena', '" + jogo + "')"
                banco.execSQL(sql)
                finish()
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
        binding.btn26.setOnClickListener(){
            if(cont < qt && !botoes[25]) {
                cont++
                botoes[25] = true
                binding.btn26.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[25]){
                cont--
                botoes[25] = false
                binding.btn26.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn27.setOnClickListener(){
            if(cont < qt && !botoes[26]) {
                cont++
                botoes[26] = true
                binding.btn27.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[26]){
                cont--
                botoes[26] = false
                binding.btn27.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn28.setOnClickListener(){
            if(cont < qt && !botoes[27]) {
                cont++
                botoes[27] = true
                binding.btn28.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[27]){
                cont--
                botoes[27] = false
                binding.btn28.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn29.setOnClickListener(){
            if(cont < qt && !botoes[28]) {
                cont++
                botoes[28] = true
                binding.btn29.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[28]){
                cont--
                botoes[28] = false
                binding.btn29.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn30.setOnClickListener(){
            if(cont < qt && !botoes[29]) {
                cont++
                botoes[29] = true
                binding.btn30.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[29]){
                cont--
                botoes[29] = false
                binding.btn30.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn31.setOnClickListener(){
            if(cont < qt && !botoes[30]) {
                cont++
                botoes[30] = true
                binding.btn31.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[30]){
                cont--
                botoes[30] = false
                binding.btn31.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn32.setOnClickListener(){
            if(cont < qt && !botoes[31]) {
                cont++
                botoes[31] = true
                binding.btn32.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[31]){
                cont--
                botoes[31] = false
                binding.btn32.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn33.setOnClickListener(){
            if(cont < qt && !botoes[32]) {
                cont++
                botoes[32] = true
                binding.btn33.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[32]){
                cont--
                botoes[32] = false
                binding.btn33.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn34.setOnClickListener(){
            if(cont < qt && !botoes[33]) {
                cont++
                botoes[33] = true
                binding.btn34.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[33]){
                cont--
                botoes[33] = false
                binding.btn34.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn35.setOnClickListener(){
            if(cont < qt && !botoes[34]) {
                cont++
                botoes[34] = true
                binding.btn35.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[34]){
                cont--
                botoes[34] = false
                binding.btn35.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn36.setOnClickListener(){
            if(cont < qt && !botoes[35]) {
                cont++
                botoes[35] = true
                binding.btn36.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[35]){
                cont--
                botoes[35] = false
                binding.btn36.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn37.setOnClickListener(){
            if(cont < qt && !botoes[36]) {
                cont++
                botoes[36] = true
                binding.btn37.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[36]){
                cont--
                botoes[36] = false
                binding.btn37.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn38.setOnClickListener(){
            if(cont < qt && !botoes[37]) {
                cont++
                botoes[37] = true
                binding.btn38.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[37]){
                cont--
                botoes[37] = false
                binding.btn38.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn39.setOnClickListener(){
            if(cont < qt && !botoes[38]) {
                cont++
                botoes[38] = true
                binding.btn39.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[38]){
                cont--
                botoes[38] = false
                binding.btn39.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn40.setOnClickListener(){
            if(cont < qt && !botoes[39]) {
                cont++
                botoes[39] = true
                binding.btn40.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[39]){
                cont--
                botoes[39] = false
                binding.btn40.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn41.setOnClickListener(){
            if(cont < qt && !botoes[40]) {
                cont++
                botoes[40] = true
                binding.btn41.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[40]){
                cont--
                botoes[40] = false
                binding.btn41.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn42.setOnClickListener(){
            if(cont < qt && !botoes[41]) {
                cont++
                botoes[41] = true
                binding.btn42.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[41]){
                cont--
                botoes[41] = false
                binding.btn42.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn43.setOnClickListener(){
            if(cont < qt && !botoes[42]) {
                cont++
                botoes[42] = true
                binding.btn43.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[42]){
                cont--
                botoes[42] = false
                binding.btn43.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn44.setOnClickListener(){
            if(cont < qt && !botoes[43]) {
                cont++
                botoes[43] = true
                binding.btn44.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[43]){
                cont--
                botoes[43] = false
                binding.btn44.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn45.setOnClickListener(){
            if(cont < qt && !botoes[44]) {
                cont++
                botoes[44] = true
                binding.btn45.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[44]){
                cont--
                botoes[44] = false
                binding.btn45.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn46.setOnClickListener(){
            if(cont < qt && !botoes[45]) {
                cont++
                botoes[45] = true
                binding.btn46.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[45]){
                cont--
                botoes[45] = false
                binding.btn46.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn47.setOnClickListener(){
            if(cont < qt && !botoes[46]) {
                cont++
                botoes[46] = true
                binding.btn47.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[46]){
                cont--
                botoes[46] = false
                binding.btn47.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn48.setOnClickListener(){
            if(cont < qt && !botoes[47]) {
                cont++
                botoes[47] = true
                binding.btn48.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[47]){
                cont--
                botoes[47] = false
                binding.btn48.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn49.setOnClickListener(){
            if(cont < qt && !botoes[48]) {
                cont++
                botoes[48] = true
                binding.btn49.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[48]){
                cont--
                botoes[48] = false
                binding.btn49.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn50.setOnClickListener(){
            if(cont < qt && !botoes[49]) {
                cont++
                botoes[49] = true
                binding.btn50.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[49]){
                cont--
                botoes[49] = false
                binding.btn50.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn51.setOnClickListener(){
            if(cont < qt && !botoes[50]) {
                cont++
                botoes[50] = true
                binding.btn51.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[50]){
                cont--
                botoes[50] = false
                binding.btn51.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn52.setOnClickListener(){
            if(cont < qt && !botoes[51]) {
                cont++
                botoes[51] = true
                binding.btn52.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[51]){
                cont--
                botoes[51] = false
                binding.btn52.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn53.setOnClickListener(){
            if(cont < qt && !botoes[52]) {
                cont++
                botoes[52] = true
                binding.btn53.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[52]){
                cont--
                botoes[52] = false
                binding.btn53.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn54.setOnClickListener(){
            if(cont < qt && !botoes[53]) {
                cont++
                botoes[53] = true
                binding.btn54.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[53]){
                cont--
                botoes[53] = false
                binding.btn54.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn55.setOnClickListener(){
            if(cont < qt && !botoes[54]) {
                cont++
                botoes[54] = true
                binding.btn55.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[54]){
                cont--
                botoes[54] = false
                binding.btn55.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn56.setOnClickListener(){
            if(cont < qt && !botoes[55]) {
                cont++
                botoes[55] = true
                binding.btn56.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[55]){
                cont--
                botoes[55] = false
                binding.btn56.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn57.setOnClickListener(){
            if(cont < qt && !botoes[56]) {
                cont++
                botoes[56] = true
                binding.btn57.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[56]){
                cont--
                botoes[56] = false
                binding.btn57.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn58.setOnClickListener(){
            if(cont < qt && !botoes[57]) {
                cont++
                botoes[57] = true
                binding.btn58.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[57]){
                cont--
                botoes[57] = false
                binding.btn58.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn59.setOnClickListener(){
            if(cont < qt && !botoes[58]) {
                cont++
                botoes[58] = true
                binding.btn59.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[58]){
                cont--
                botoes[58] = false
                binding.btn59.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
        binding.btn60.setOnClickListener(){
            if(cont < qt && !botoes[59]) {
                cont++
                botoes[59] = true
                binding.btn60.setBackgroundColor(getResources().getColor(R.color.black))
            }else if(botoes[59]){
                cont--
                botoes[59] = false
                binding.btn60.setBackgroundColor(getResources().getColor(R.color.teal_700))
            }else{
                Toast.makeText(this, "Desmarque um número para adicionar outro", Toast.LENGTH_LONG).show()
            }
        }
    }
}