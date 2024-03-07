package com.tlw.composeCalculator.ui.events

sealed class CalculatorOperation(val symbols: String) {
    object Add: CalculatorOperation("+")
    object Subtract: CalculatorOperation("-")
    object Multiply: CalculatorOperation("x")
    object Division: CalculatorOperation("/")
    object Remainder: CalculatorOperation("%")
}