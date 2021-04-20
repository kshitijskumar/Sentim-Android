package com.example.sentim_android.data.repositories

import com.example.sentim_android.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.lang.Exception

abstract class BaseRepository {

    suspend fun <T>safeApiCall(call : suspend () -> Response<T>) : Result<T> {
        return withContext(Dispatchers.IO) {
            try {
                val response = call.invoke()
                if(response.isSuccessful && response.body() != null) {
                    Result.Success(response.body()!!)
                }else {
                    Result.Error("Something went wrong.")
                }
            }catch (e: Exception) {
                Result.Error("Something went wrong. Please check your internet condition")
            }
        }
    }
}