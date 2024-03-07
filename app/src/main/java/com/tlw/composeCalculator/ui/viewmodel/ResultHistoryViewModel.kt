package com.tlw.composeCalculator.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tlw.composeCalculator.data.model.ResultEntity
import com.tlw.composeCalculator.data.repository.ResultRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResultHistoryViewModel @Inject constructor(private val repository: ResultRepository): ViewModel() {
    private val resultHistory = repository.getResult()
    private var _result: MutableList<ResultEntity> = mutableListOf()
    val resultEntity: MutableState<MutableList<ResultEntity>> = mutableStateOf(_result)

    init {
        viewModelScope.launch {
            resultHistory.collect { result ->
                Log.e("sldkvnslkvn", "Size: ${result.size}")
                _result.addAll(result)
                resultEntity.value = _result
            }
        }
    }
}