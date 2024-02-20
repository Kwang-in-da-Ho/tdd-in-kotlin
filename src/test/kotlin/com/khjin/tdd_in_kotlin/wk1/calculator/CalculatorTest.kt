package com.khjin.tdd_in_kotlin.wk1.calculator

import org.example.com.khjin.tdd_in_kotlin.wk1.calculator.Calculator
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class CalculatorTest {

    @Test
    fun shouldReturnZero_whenInputIsEmptyString() {
        val calculator = Calculator()
        assertEquals(0, calculator.add(""))
        assertNotEquals(10, calculator.add(""))
    }

    @Test
    fun shouldReturnNumber_whenInputIsSingleNumberInString() {
        val calculator = Calculator()
        assertEquals(1, calculator.add("1"))
        assertEquals(10, calculator.add("10"))
        assertNotEquals(10, calculator.add("5"))
    }

    @Test
    fun shouldParseToNumberList_whenDelimiterIsComma() {
        val calculator = Calculator()
        assertEquals(listOf(1,2,3), calculator.parse("1,2,3"))
        assertEquals(listOf(123,456,789,1,2,3), calculator.parse("123,456,789,1,2,3"))
    }

    @Test
    fun shouldReturnSum_whenInputIsNumberSeparatedByComma() {
        val calculator = Calculator()
        assertEquals(3, calculator.add("1,2"))
        assertEquals(5, calculator.add("2,3"))
        assertEquals(12, calculator.add("2,4,6"))
        assertEquals(115, calculator.add("1,2,3,4,5,100"))
        assertNotEquals(10, calculator.add("1,2,3"))
    }

    @Test
    fun shouldParseToNumberList_whenDelimiterIsCommaOrNewline() {
        val calculator = Calculator()
        assertEquals(listOf(1,2,3), calculator.parse("1,2\n3"))

    }

    @Test
    fun shouldThrowIllegalArgumentException_whenDelimiterIsNotCommaOrNewLine() {
        val calculator = Calculator()
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            calculator.parse("1\\2\\3")
        }
    }

    @Test
    fun shouldThrowIllegalArgumentException_whenExpressionHasConsecutiveDelimiters() {
        val calculator = Calculator()
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            calculator.parse("1,2,\n3")
        }
    }
}