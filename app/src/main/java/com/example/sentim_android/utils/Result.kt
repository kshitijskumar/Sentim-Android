package com.example.sentim_android.utils

sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    object Loading : Result<Nothing>()
    data class Error(val errorMsg: String) : Result<Nothing>()
}
