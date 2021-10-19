package com.synthesizer.source.empty.data.api

import com.synthesizer.source.empty.data.CharacterListResponse
import com.synthesizer.source.empty.data.CharacterResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("character")
    fun getAllCharacters(): Call<CharacterListResponse>

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): Response<CharacterResponse>
}