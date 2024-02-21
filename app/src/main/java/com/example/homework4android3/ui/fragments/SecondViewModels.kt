package com.example.homework4android3.ui.fragments

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework4android3.data.models.CharactersItem
import com.example.homework4android3.data.repository.NarutoCharacterRepository
import com.example.homework4android3.utils.UiState

class SecondViewModels : ViewModel() {

    private val narutoCharacterRepository = NarutoCharacterRepository()
    private val _characterLiveData = MutableLiveData<UiState<List<CharactersItem>>>()
    val characterLiveData: LiveData<UiState<List<CharactersItem>>> = _characterLiveData

    init {
        Log.e("narte", "model" )
        narutoCharacterRepository.getCharacter(
            onResponse = {data->
                Log.e("TAG", "bleach,$data" )
                _characterLiveData.value = UiState(isLoading = false, success = data)
            },
            onFailure = {t->

                Log.e("narte", "model,$t" )
                _characterLiveData.value = UiState(isLoading = false,errorMessage = t.message?:"error")

            }
        )
    }
}