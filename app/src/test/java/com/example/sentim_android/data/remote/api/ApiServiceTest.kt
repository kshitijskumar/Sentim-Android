package com.example.sentim_android.data.remote.api

import com.example.sentim_android.data.remote.model.TextAnalysis
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ApiServiceTest {

    private lateinit var api : ApiService

    @Before
    fun setup() {
        api = ApiService.getApiService()
    }

    @Test
    fun postTextForAnalysis_forSuccess_returnsListOfSentimentAnalysis() = runBlocking {
        val text = TextAnalysis("This text will act as a test usecase.")
        val response = api.postTextForAnalysis(text)

        assertNotNull(response)
    }
}