package org.example.com.khjin.tdd_in_kotlin.wk1.calculator

import org.example.com.khjin.tdd_in_kotlin.wk1.exception.InvalidExpressionException

class Calculator {

    private val delimiterPrefix = "//"

    fun add(expression: String): Int{
        if(expression.isEmpty()){
            return 0
        }else if( !isNumeric(expression) ){

            if(expression.startsWith(delimiterPrefix)) {
                val delimiter = extractDelimiter(expression)
                val newExpression = expression.substring(delimiterPrefix.length + delimiter.length + 1)
                return newExpression.split(delimiter).sumOf { n -> n.toInt() }

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
