package com.example.homework4android3.data.remote.api

import com.example.homework4android3.data.models.AnimeResponse
import com.example.homework4android3.data.repository.NarutoCharacterRepository
import retrofit2.Call
import retrofit2.http.GET

private const val CHARACTER = "database.json"

interface NarutoCharacterApi {

    @GET(CHARACTER)
    fun getCharacter(): Call<AnimeResponse>
}