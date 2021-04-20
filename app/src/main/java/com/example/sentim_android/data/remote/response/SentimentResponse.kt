package com.example.sentim_android.data.remote.response

data class SentimentResponse(
    val result: SentimentResult = SentimentResult(),
    val sentences: List<SentenceAnalysis> = listOf()
)
