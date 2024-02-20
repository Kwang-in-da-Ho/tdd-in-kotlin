package com.khjin.tdd_in_kotlin.wk1.fizzbuzz

import org.example.com.khjin.tdd_in_kotlin.wk1.fizzbuzz.FizzBuzz
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/*
1. Write a “fizzBuzz” method that accepts a number as input and returns it as a String.

Notes:

* start with the minimal failing solution
* keep the three rules in mind and always write just sufficient enough code
* do not forget to refactor your code after each passing test
* write your assertions relating to the exact requirements
2. For multiples of three return “Fizz” instead of the number

3. For the multiples of five return “Buzz”

4. For numbers that are multiples of both three and five return “FizzBuzz”.
 */

class FizzBuzzTest {

    @Test
    fun shouldReturnFizz_whenInputIsMultipleOfThree() {
        val fizzBuzz = FizzBuzz()

        assertEquals("Fizz", fizzBuzz.fizzBuzz(3))
    }

    @Test
    fun `shouldReturBuzz_whenInputIsMultipleOfFive()`() {
        val fizzBuzz = FizzBuzz()

        assertEquals("Buzz", fizzBuzz.fizzBuzz(10))
        assertEquals("Buzz", fizzBuzz.fizzBuzz(20))
        assertEquals("Buzz", fizzBuzz.fizzBuzz(25))
        assertEquals("Buzz", fizzBuzz.fizzBuzz(35))
    }

    @Test
    fun shouldReturnFizzBuzz_whenInputIsMultipleOfThreeAndFive() {
        val fizzBuzz = FizzBuzz()

        assertEquals("FizzBuzz", fizzBuzz.fizzBuzz(15))
        assertEquals("FizzBuzz", fizzBuzz.fizzBuzz(30))
        assertEquals("FizzBuzz", fizzBuzz.fizzBuzz(45))
    }

    @Test
    fun shouldReturnNumberInString_whenNumberIsNotMulitpleOfThreeOrFive() {
        val fizzBuzz = FizzBuzz()

        assertEquals("17", fizzBuzz.fizzBuzz(17))
        assertEquals("23", fizzBuzz.fizzBuzz(23))
        assertEquals("44", fizzBuzz.fizzBuzz(44))
    }
}