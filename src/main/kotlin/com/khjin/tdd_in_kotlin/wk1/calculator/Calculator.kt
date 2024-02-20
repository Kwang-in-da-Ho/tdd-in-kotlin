package org.example.com.khjin.tdd_in_kotlin.wk1.calculator

class Calculator {

    fun add(expression: String): Int{
        if(expression.isEmpty()){
            return 0
        }else if(expression.contains(",")){
            val numList = expression.split(",")
            return numList.sumOf { n -> n.toInt() }
        }else{
            return expression.toInt()
        }
    }

}
