package com.synthesizer.source.empty.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBase {
    private const val BASE_URL = "https://rickandmortyapi.com/api/"

    private val retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    val service: ApiService = retrofit.create(ApiService::class.java)
}