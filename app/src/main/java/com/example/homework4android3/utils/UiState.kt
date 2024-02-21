package com.example.homework4android3.utils

data class UiState<T>(
    val isLoading : Boolean = true,
    val errorMessage:String? = null,
    val success: T? = null
)