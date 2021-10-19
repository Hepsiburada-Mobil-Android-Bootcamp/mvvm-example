package com.synthesizer.source.empty.data


import com.google.gson.annotations.SerializedName

data class CharacterListResponse(
    @SerializedName("info")
    val info: InfoResponse,
    @SerializedName("results")
    val results: List<CharacterResponse>
)