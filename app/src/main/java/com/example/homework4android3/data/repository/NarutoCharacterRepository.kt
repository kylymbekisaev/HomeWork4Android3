package com.example.homework4android3.data.repository

import com.example.homework4android3.data.models.AnimeResponse
import com.example.homework4android3.data.models.CharactersItem
import com.example.homework4android3.data.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NarutoCharacterRepository {

    private val apiServise = RetrofitClient.narutoCharacterApi

    fun getCharacter(
        onResponse: (character: List<CharactersItem>) -> Unit,
        onFailure: (t: Throwable) -> Unit
    ) {
        apiServise.getCharacter().enqueue(object : Callback<AnimeResponse> {

            override fun onResponse(
                call: Call<AnimeResponse>,
                response: Response<AnimeResponse>
            ) {
                if (response.isSuccessful && response.body() != null)
                    onResponse(response.body()?.characters!!)
            }

            override fun onFailure(call: Call<AnimeResponse>, t: Throwable) {
                onFailure(t)

            }
        })
    }
}