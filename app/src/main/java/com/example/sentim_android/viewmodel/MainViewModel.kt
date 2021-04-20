package com.example.sentim_android.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sentim_android.data.remote.response.SentimentResponse
import com.example.sentim_android.data.repositories.MainRepository
import com.example.sentim_android.utils.Result
import kotlinx.coroutines.launch

class MainViewModel(
    private val repo : MainRepository
) : ViewModel() {

    private val _analysis = MutableLiveData<Result<SentimentResponse>>()
    val analysis : LiveData<Result<SentimentResponse>>
        get() = _analysis


    fun getTextAnalysis(text: String) = viewModelScope.launch {
        _analysis.value = Result.Loading
        val result = repo.getSentimentAnalysisOfText(text)
        when(result) {
            is Result.Success -> _analysis.value = result
            is Result.Error -> _analysis.value = result
        }
    }

}