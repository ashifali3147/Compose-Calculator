package com.tlw.composeCalculator.data.model

import com.tlw.composeCalculator.ui.events.CalculatorOperation

data class CalculatorState(
    val number1: String = "",
    val number2: String = "",
    val operation: CalculatorOperation? = null
)