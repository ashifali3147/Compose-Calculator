package com.tlw.composeCalculator

import java.text.DateFormatSymbols

sealed class CalculatorOperation(val symbols: String) {
    object Add: CalculatorOperation("+")
    object Subtract: CalculatorOperation("-")
    object Multiply: CalculatorOperation("x")
    object Division: CalculatorOperation("/")
    object Remainder: CalculatorOperation("%")
}