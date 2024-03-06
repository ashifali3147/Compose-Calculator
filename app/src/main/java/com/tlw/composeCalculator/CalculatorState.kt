package com.tlw.composeCalculator

data class CalculatorState(
    val number1: String = "",
    val number2: String = "",
    val operation: String? = null
)