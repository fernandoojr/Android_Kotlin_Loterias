package com.example.conferirnmeroslotofacil.Services

import com.example.conferirnmeroslotofacil.Model.Result
import retrofit2.Call
import retrofit2.http.GET

interface EndPoint {

    @GET("lotofacil/2027")
    fun getConcurso() : Call<Result>
}