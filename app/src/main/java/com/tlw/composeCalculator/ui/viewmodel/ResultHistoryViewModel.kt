package com.tlw.composeCalculator.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tlw.composeCalculator.data.model.ResultEntity
import com.tlw.composeCalculator.data.repository.ResultRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResultHistoryViewModel @Inject constructor(private val repository: ResultRepository) :
    ViewModel() {
    private val _result = MutableStateFlow<List<ResultEntity>>(emptyList())
    val resultEntity: StateFlow<List<ResultEntity>> = _result

    init {
        viewModelScope.launch {
            repository.getResult().collect { result ->
                _result.value = result
            }
        }
    }

    fun deleteResult(result: ResultEntity){
        viewModelScope.launch {
            repository.deleteResult(result)
            repository.getResult().collect { _result ->
                _result.remove(result)
            }
        }
    }
}
