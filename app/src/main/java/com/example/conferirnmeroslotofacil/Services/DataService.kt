package com.example.conferirnmeroslotofacil.Services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DataService {

    companion object{
        fun getRetrofitInstance(path: String): Retrofit{
            return Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}