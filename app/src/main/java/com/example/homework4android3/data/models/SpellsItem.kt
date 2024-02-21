package com.example.homework4android3.data.models

import com.google.gson.annotations.SerializedName

data class SpellsItem(
    @SerializedName("spell")
    val spell: String = "",
    @SerializedName("use")
    val use: String = ""
)