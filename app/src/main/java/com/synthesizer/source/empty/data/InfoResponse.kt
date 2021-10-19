package com.synthesizer.source.empty.data


import com.google.gson.annotations.SerializedName

data class InfoResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("prev")
    val prev: Any?
)