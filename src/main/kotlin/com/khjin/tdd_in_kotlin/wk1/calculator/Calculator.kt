package org.example.com.khjin.tdd_in_kotlin.wk1.calculator

import org.example.com.khjin.tdd_in_kotlin.wk1.exception.InvalidExpressionException

class Calculator {

    private val delimiterPrefix = "//"

    fun add(expression: String): Int{

        if(expression.isEmpty()){   //empty string
            return 0

        }else if( isNumeric(expression) ){ //one number
            return expression.toInt()

        }else{ //expression

            var sum = 0
            val exceptionMessageBuilder = StringBuilder()
            val invalidDelimiter = StringBuilder()
            var invalidDelimiterPos = 0
            val negativeNums = arrayListOf<Int>()
            val validDelimiters = arrayListOf<String>()

            if (expression.startsWith(delimiterPrefix) ) { // delimiter change
                val delimiter = extractDelimiter(expression)
                validDelimiters.add(delimiter)
                val newExpression = expression.substring(delimiterPrefix.length + delimiter.length + 1)

                val numList = newExpression.split(delimiter)
                // if last elemet of numList is an empty string, then the last part of the expression is the delimiter

                if(numList.last().isEmpty()) {
                    throw InvalidExpressionException("Expression should not end with delimiters")
                }

                for(i in numList.indices){

                    if( isNumeric(numList[i] )){
                        val num = numList[i].toInt()
                        if(num < 0){
                            negativeNums.add(num)
                        }
                        sum += num

                    }else { // check if other delimiter is included

                        // get position of invalid delimiter
                        for(prev in 0 until i){
                            invalidDelimiterPos += numList[prev].length
                        }

                        // extract invalid Delimiter
                        var foundInvalid = false
                        for(c in numList[i].toCharArray().indices){
                            if( !numList[i][c].isDigit() ){
                                if( !foundInvalid ) foundInvalid = true
                                invalidDelimiterPos++
                                invalidDelimiter.append(numList[i][c])
                            }else{
                                if(foundInvalid) break
                            }
                        }
                    }
                }

            }else{ // default delimiter

                val numList = expression.split(",", "\n")

                if(numList.last().isEmpty()) {
                    throw InvalidExpressionException("Expression should not end with delimiters")
                }

                for(i in numList.indices){
                    val num = numList[i].toInt()
                    if(num < 0){
                        negativeNums.add(num)
                    }
                    sum += num
                }

            }

            if(negativeNums.isNotEmpty()){
                // build exception message
                exceptionMessageBuilder.append("Negative number(s) not allowed : ")
                    .append(negativeNums.joinToString(", "))
            }

            if(invalidDelimiter.isNotEmpty()){
                if(exceptionMessageBuilder.isNotEmpty()){
                    exceptionMessageBuilder.append("\n")
                }
                exceptionMessageBuilder
                    .append("'").append(validDelimiters[0]).append("' expected but '")
                    .append(invalidDelimiter.toString()).append("' found at position ").append(invalidDelimiterPos)
            }

            if( exceptionMessageBuilder.isNotEmpty() ){
                println(exceptionMessageBuilder.toString())
                throw InvalidExpressionException(exceptionMessageBuilder.toString())
            }

            return sum
        }
    }

    private fun isNumeric(str : String): Boolean {
        return str.toIntOrNull() != null
    }

    fun extractDelimiter(expression: String): String{
        var delimiterEndIdx = 2
        for( i in delimiterPrefix.length until expression.length ){
            if( expression[i].isDigit() ){
                delimiterEndIdx = i-1
                break
            }
        }
        return expression.substring(delimiterPrefix.length, delimiterEndIdx)
    }

}
