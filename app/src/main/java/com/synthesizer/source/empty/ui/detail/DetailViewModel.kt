package com.synthesizer.source.empty.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.synthesizer.source.empty.data.CharacterResponse
import com.synthesizer.source.empty.data.api.RetrofitBase
import kotlinx.coroutines.launch

class DetailViewModel(private val id: Int) : ViewModel() {

    private val _character = MutableLiveData<CharacterResponse>()
    val character: LiveData<CharacterResponse> = _character

    init {
        fetchDetail()
    }

    private fun fetchDetail() = viewModelScope.launch {
        _character.value = RetrofitBase.service.getCharacterById(id).body()!!
    }
}