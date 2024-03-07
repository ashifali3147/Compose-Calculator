package com.tlw.composeCalculator.ui.events

sealed class CalculatorAction {
    data class NumberEnter(val number: Int): CalculatorAction()
    data class NumberDoubleZero(val number: String): CalculatorAction()
    object Clear: CalculatorAction()
    object Delete: CalculatorAction()
    object Decimal: CalculatorAction()
    object Calculate: CalculatorAction()
    data class Operation(val operation: CalculatorOperation): CalculatorAction()
}
