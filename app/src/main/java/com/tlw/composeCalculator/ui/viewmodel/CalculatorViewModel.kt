package com.tlw.composeCalculator.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tlw.composeCalculator.data.model.CalculatorState
import com.tlw.composeCalculator.data.model.ResultEntity
import com.tlw.composeCalculator.data.repository.ResultRepository
import com.tlw.composeCalculator.ui.events.CalculatorAction
import com.tlw.composeCalculator.ui.events.CalculatorOperation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CalculatorViewModel @Inject constructor(private val repository: ResultRepository): ViewModel() {
//class CalculatorViewModel : ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(action: CalculatorAction) {
        when (action) {
            is CalculatorAction.NumberEnter -> enterNumber(action.number)
            is CalculatorAction.Clear -> state = CalculatorState()
            is CalculatorAction.Delete -> performDelete()
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Calculate -> showResult()
            is CalculatorAction.Operation -> performOperation(action.operation)
            is CalculatorAction.NumberDoubleZero -> enterDoubleZero(action.number)
        }
    }

    private fun enterDoubleZero(number: String) {
        if (state.operation == null) {
            if (state.number1.length >= MAX_INT_LIMIT) {
                return
            }
            state = state.copy(number1 = state.number1 + number)
            return
        }
        if (state.number2.length >= MAX_INT_LIMIT) {
            return
        }
        state = state.copy(number2 = state.number2 + number)
    }

    private fun performOperation(operation: CalculatorOperation) {
        if (state.number1.isNotEmpty()) {
            state = state.copy(operation = operation)
        }
    }

    private fun showResult() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if (number1 != null && number2 != null) {
            val result = when (state.operation) {
                is CalculatorOperation.Add -> number1 + number2
                CalculatorOperation.Division -> number1 / number2
                CalculatorOperation.Multiply -> number1 * number2
                CalculatorOperation.Remainder -> number1 % number2
                CalculatorOperation.Subtract -> number1 - number2
                null -> return
            }
            viewModelScope.launch {
                repository.addResult(ResultEntity(state.number1, state.number2, state.operation!!.symbols, result.toString().take(15)))
            }
            state = state.copy(number1 = result.toString().take(15), number2 = "", operation = null)
        }
    }

    private fun enterDecimal() {
        if (state.operation == null && !state.number1.contains(".") && state.number1.isNotBlank()) {
            state = state.copy(number1 = state.number1 + ".")
            return
        }
        if (state.number1.isNotBlank() && !state.number2.contains(".")) {
            state = state.copy(number2 = state.number2 + ".")
        }
    }

    private fun performDelete() {
        when {
            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )

            state.operation != null -> state = state.copy(
                operation = null
            )

            state.number1.isNotBlank() -> state = state.copy(
                number1 = state.number1.dropLast(1)
            )
        }
    }

    private fun enterNumber(number: Int) {
        if (state.operation == null) {
            if (state.number1.length >= MAX_INT_LIMIT) {
                return
            }
            state = state.copy(number1 = state.number1 + number)
            return
        }
        if (state.number2.length >= MAX_INT_LIMIT) {
            return
        }
        state = state.copy(number2 = state.number2 + number)
    }

    companion object {
        const val MAX_INT_LIMIT = 8
    }
}