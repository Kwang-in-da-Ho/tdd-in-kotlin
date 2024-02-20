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

    @Test
    fun shouldReturnSum_whenExpressionHasTwoNumbersSeparatedByComma() {
        val calculator = Calculator()
        assertEquals(3, calculator.add("1,2"))
        assertEquals(30, calculator.add("12,18"))
        assertNotEquals(0, calculator.add("1,2"))
    }

    @Test
    fun shouldReturnSum_whenExpressionHasMoreThanTwoNumbersSeparatedByComma() {
        val calculator = Calculator()
        assertEquals(10, calculator.add("1,2,3,4"))
        assertEquals(195, calculator.add("19,29,39,49,59"))
        assertNotEquals(10,calculator.add("123,454,123,55"))
    }

    @Test
    fun shouldReturnSum_whenDelimiterIsCommaOrNewline() {
        val calculator = Calculator()
        assertEquals(15, calculator.add("1,2\n3,4\n5"))
        assertEquals(150, calculator.add("10\n20\n30\n40\n50"))
        assertNotEquals(10,calculator.add("12\n45,23\n55"))
    }
}