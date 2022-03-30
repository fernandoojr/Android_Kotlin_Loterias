package com.example.conferirnmeroslotofacil.Services

import com.example.conferirnmeroslotofacil.Model.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface EndPoint {

    @GET("lotofacil/{id}")
    fun getConcurso(@Path("id") id: String) : Call<Result>
}