package com.khjin.tdd_in_kotlin.wk1.calculator

import org.example.com.khjin.tdd_in_kotlin.wk1.calculator.Calculator
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class CalculatorTest {

    @Test
    fun shouldReturnZero_whenExpressionIsEmpty() {
        val calculator = Calculator()
        assertEquals(0, calculator.add(""))
        assertNotEquals(123, calculator.add(""))
    }

    @Test
    fun shouldReturnNumber_whenExpressionHasOnlyOneNumber() {
        val calculator = Calculator()
        assertEquals(1, calculator.add("1"))
        assertEquals(999, calculator.add("999"))
        assertNotEquals(0, calculator.add("1"))
    }
}