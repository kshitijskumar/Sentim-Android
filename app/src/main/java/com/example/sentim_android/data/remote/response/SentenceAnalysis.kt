package com.example.sentim_android.data.remote.response

data class SentenceAnalysis(
    val sentence: String = "",
    val sentiment: SentimentResult = SentimentResult()
)
