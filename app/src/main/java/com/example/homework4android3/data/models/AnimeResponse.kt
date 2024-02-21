package com.example.homework4android3.data.models

import com.google.gson.annotations.SerializedName

data class AnimeResponse(
    @SerializedName("characters")
    val characters: List<CharactersItem>?,
    @SerializedName("spells")
    val spells: List<SpellsItem>?,
    @SerializedName("info")
    val info: List<InfoItem>?
)