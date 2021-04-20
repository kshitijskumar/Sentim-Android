package com.example.sentim_android.data.repositories

import com.example.sentim_android.data.remote.response.SentimentResponse
import com.example.sentim_android.utils.Result

interface MainRepository {

    suspend fun getSentimentAnalysisOfText(text: String) : Result<SentimentResponse>
}