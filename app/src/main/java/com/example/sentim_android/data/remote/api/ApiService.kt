package com.example.sentim_android.data.remote.api

import com.example.sentim_android.utils.Constants.BASE_URL
import com.example.sentim_android.data.remote.model.TextAnalysis
import com.example.sentim_android.data.remote.response.SentimentResponse
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("/api/v1/")
    suspend fun postTextForAnalysis(@Body text: TextAnalysis) : Response<SentimentResponse>

    companion object {

        private val client = OkHttpClient
            .Builder()
            .addInterceptor(HeaderInterceptor())
            .build()

        private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        fun getApiService() = retrofit.create(ApiService::class.java)
    }
}