package com.example.lovecalculator.model

import androidx.lifecycle.LiveData
import com.example.lovecalculator.app.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(private val repository: Repository): androidx.lifecycle.ViewModel() {

    fun makeRequest(firstName: String, secondName: String): LiveData<CalculateModel> {
        return repository.makeRequest(firstName, secondName)
    }
}