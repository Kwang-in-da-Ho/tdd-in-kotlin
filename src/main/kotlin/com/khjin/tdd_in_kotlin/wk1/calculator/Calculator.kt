package org.example.com.khjin.tdd_in_kotlin.wk1.calculator

import org.example.com.khjin.tdd_in_kotlin.wk1.exception.InvalidExpressionException

class Calculator {

    fun add(expression: String): Int{
        if(expression.isEmpty()){
            return 0
        }else if(expression.contains(",") || expression.contains("\n")){

            if(expression.last() == ',' || expression.last() == '\n'){
                throw InvalidExpressionException("Expression should not end with delimiters")
            }

            val numList = expression.split(",", "\n")
            return numList.sumOf { n -> n.toInt() }
        }else{
            return expression.toInt()
        }
    }

}
