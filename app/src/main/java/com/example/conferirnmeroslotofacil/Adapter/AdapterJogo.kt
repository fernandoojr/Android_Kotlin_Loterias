package com.example.conferirnmeroslotofacil.Adapter

import android.app.Activity
import android.database.sqlite.SQLiteDatabase
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.conferirnmeroslotofacil.R

class AdapterJogo(lista: MutableList<String>, ac: Activity) : RecyclerView.Adapter<AdapterJogo.MyViewHolder>() {
    private val listaJogo: MutableList<String> = lista
    private val activity: Activity = ac

    //init {
    //    listaJogo = lista
    //}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemLista: View = LayoutInflater.from(parent.context).inflate(R.layout.adapter_jogo, parent, false)
        return MyViewHolder(itemLista)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val jogo: String = listaJogo[position]
        holder.txtSeuJogo.setText(jogo)
        holder.btnRemover.setOnClickListener{
            val banco: SQLiteDatabase = activity.openOrCreateDatabase("app", AppCompatActivity.MODE_PRIVATE, null)
            val consulta = "DELETE FROM loteria where numeros = '$jogo'"
            banco.execSQL(consulta)
            listaJogo.remove(jogo)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return listaJogo.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtSeuJogo: TextView = itemView.findViewById(R.id.txtSeuJogo)
        var btnRemover: Button = itemView.findViewById(R.id.btnRemover)

        //init {
        //titulo = itemView.findViewById(R.id.textTitulo)
        //ano = itemView.findViewById(R.id.textAno)
        //genero = itemView.findViewById(R.id.textGenero)
        //}
    }
}