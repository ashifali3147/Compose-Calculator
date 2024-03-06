package com.tlw.composeCalculator

sealed class CalculatorOperation {
    object Add: CalculatorOperation()
    object Subtract: CalculatorOperation()
    object Multiply: CalculatorOperation()
    object Division: CalculatorOperation()
    object Remainder: CalculatorOperation()
}