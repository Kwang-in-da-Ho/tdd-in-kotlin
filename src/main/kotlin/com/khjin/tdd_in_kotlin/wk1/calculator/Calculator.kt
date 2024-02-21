package org.example.com.khjin.tdd_in_kotlin.wk1.calculator

import org.example.com.khjin.tdd_in_kotlin.wk1.exception.InvalidExpressionException

class Calculator {

    private val delimiterPrefix = "//"

    fun add(expression: String): Int{
        if(expression.isEmpty()){
            return 0

        }else if( !isNumeric(expression) ){

            if (expression.startsWith(delimiterPrefix) ) {
                val delimiter = extractDelimiter(expression)
                val newExpression = expression.substring(delimiterPrefix.length + delimiter.length + 1)

                if( newExpression.substring(newExpression.length - delimiter.length, newExpression.length) == delimiter) {
                    throw InvalidExpressionException("Expression should not end with delimiters")
                }

                // check if other delimiter is included
                val numList = newExpression.split(delimiter)
                var sum = 0
                for(i in numList.indices){
                    val messageBuilder = StringBuilder()
                    if( !isNumeric(numList[i]) ){
                        // get position of invalid delimiter
                        var pos = 0
                        val invalidDelimiter = StringBuilder()

                        for(prev in 0 until i){
                            pos += numList[prev].length
                        }

                        var foundInvalid = false
                        for(c in numList[i].toCharArray().indices){
                            if( !numList[i][c].isDigit() ){
                                if( !foundInvalid ) foundInvalid = true
                                pos++
                                invalidDelimiter.append(numList[i][c])
                            }else{
                                if(foundInvalid) break
                            }
                        }
                        messageBuilder.append("'").append(delimiter).append("' expected but '")
                            .append(invalidDelimiter.toString()).append("' found at position ").append(pos)
                        throw InvalidExpressionException(messageBuilder.toString())
                    }
                    else {
                        sum += numList[i].toInt()
                    }
                }

                return sum
            }

            if(expression.last() == ',' || expression.last() == '\n'){
                throw InvalidExpressionException("Expression should not end with delimiters")
            }

            val numList = expression.split(",", "\n")
            return numList.sumOf { n -> n.toInt() }

        }else{
            return expression.toInt()
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
