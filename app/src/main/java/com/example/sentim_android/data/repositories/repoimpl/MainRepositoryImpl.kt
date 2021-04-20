package com.example.sentim_android.data.repositories.repoimpl

import com.example.sentim_android.data.remote.api.ApiService
import com.example.sentim_android.data.remote.model.TextAnalysis
import com.example.sentim_android.data.remote.response.SentimentResponse
import com.example.sentim_android.data.repositories.BaseRepository
import com.example.sentim_android.data.repositories.MainRepository
import com.example.sentim_android.utils.Result

class MainRepositoryImpl(
    private val api: ApiService = ApiService.getApiService()
) : MainRepository, BaseRepository() {

    override suspend fun getSentimentAnalysisOfText(text: String): Result<SentimentResponse> {
        val textBody = TextAnalysis(text)
        return safeApiCall { api.postTextForAnalysis(textBody) }
    }
}