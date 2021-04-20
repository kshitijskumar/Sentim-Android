package com.example.sentim_android.data.remote.response

data class SentimentResult(
    val polarity : Double = 0.0,
    val type: String = "neutral"
)
