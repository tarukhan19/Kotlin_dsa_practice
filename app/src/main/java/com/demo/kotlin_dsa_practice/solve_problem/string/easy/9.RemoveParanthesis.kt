package com.demo.kotlin_dsa_practice.solve_problem.string.easy

fun main() {
    var str = "(())(())"
    var result = removeParenthesis1(str)
    println(result)
}

/*
Time Complexity: O(n) → single pass over string
Space Complexity: O(n) → result string
 */
fun removeOuterParenthesis(str: String): String {
    var result = StringBuilder()
    var j = 0
    var balance = 0

    for (i in 0 until str.length) {
        if (str[i] == '(') {
            balance++
        } else {
            balance--
        }

        if (balance == 0) {
            result.append(str.substring(j + 1, i))
            j = i + 1
        }
    }

    return result.toString()
}

/*
Time Complexity: O(n) → single pass over string
Space Complexity: O(n) → result string
 */
fun removeParenthesis1(str: String): String {

    var balance = 0
    var result = StringBuilder()

    for (i in 0 until str.length) {
        if (str[i] == '(') {
            if (balance > 0) {
                result.append(str[i])
            }
            balance++
        } else {
            balance--
            if (balance > 0) {
                result.append(str[i])
            }
        }
    }
    return result.toString()

}


