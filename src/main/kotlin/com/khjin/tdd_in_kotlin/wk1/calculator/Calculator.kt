package org.example.com.khjin.tdd_in_kotlin.wk1.calculator

class Calculator {

    fun add(expression: String): Int {
        val numList = parse(expression)

        return numList.sum()
    }

    fun add_v4(expression:String): Int {
        var result = 0

        if( expression.isEmpty() ) return 0
        if( expression.length == 1) return expression.toInt()

        val nums = expression.split(",|\\r\\n")
        for(n in nums)
            result += n.toInt()

        return result
    }

    // add version 3
    fun add_v3(input: String): Int{
        var result = 0

        if( input.isEmpty() ) return 0
        if( input.length == 1) return input.toInt()

        var nums = input.split(",")
        for(n in nums)
          result += n.toInt()

        return result
    }

    // add version 2
    fun add_v2(input: String): Int{
        return if (input.isEmpty()) 0 else input.toInt()
    }

    // add version 1
    fun add_v1(input: String): Int {
        return 0
    }


    /**
     * parses a string expression to a list of numbers
     */
    fun parse(expression: String):List<Int>{
        val result = ArrayList<Int>()
        val defaultDelimiter = arrayOf(',', '\n')
        var numInString = ""
        var isValid = true

        if( expression.isEmpty() or !expression.last().isDigit() )
            throw IllegalArgumentException("Invalid Expression");

        for(c in expression.toCharArray()){
            if( defaultDelimiter.contains(c) ){
                if( numInString.isNotEmpty() ){
                    result.add(numInString.toInt())
                    numInString = ""
                }else {
                    isValid = false
                    break
                }

            }else if(c.isDigit()){
                numInString += c
            }else{
                isValid = false
            }
        }

        if( !isValid ) throw IllegalArgumentException("Invalid Expression");
        if( numInString.isNotEmpty() ) result.add(numInString.toInt())

        return result
    }

}
