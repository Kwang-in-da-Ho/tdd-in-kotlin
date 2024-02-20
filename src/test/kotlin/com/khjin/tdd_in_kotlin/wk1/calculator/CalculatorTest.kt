package com.khjin.tdd_in_kotlin.wk1.calculator

import org.example.com.khjin.tdd_in_kotlin.wk1.calculator.Calculator
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CalculatorTest {

    @Test
    fun shouldReturnZero_whenExpressionIsEmpty() {
        val calculator = Calculator()
        assertEquals(0, calculator.add(""))
    }
}