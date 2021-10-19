package com.synthesizer.source.empty.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.synthesizer.source.empty.data.CharacterListResponse
import com.synthesizer.source.empty.data.api.ApiService
import com.synthesizer.source.empty.data.mapper.Character
import com.synthesizer.source.empty.data.mapper.toDomain
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val service: ApiService, private val message: String) : ViewModel() {

    private val _characterList = MutableLiveData<List<Character>>()
    val characterList: LiveData<List<Character>> = _characterList

    init {
        println("message: $message")
        fetchCharacters()
    }

    private fun fetchCharacters() {
        service.getAllCharacters().enqueue(object : Callback<CharacterListResponse> {
            override fun onResponse(
                call: Call<CharacterListResponse>,
                response: Response<CharacterListResponse>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()!!
                    _characterList.value = data.results.map {
                        it.toDomain()
                    }
                }
            }

            override fun onFailure(call: Call<CharacterListResponse>, t: Throwable) {
                println(t.message)
            }

        })
    }
}