package com.demo.kotlin_dsa_practice.solve_problem.string.medium

fun main() {
    var str = " -91283472332"

    var result = atoiStr(str)
    println(result)
}

fun atoiStr(str: String): Int {
    if (str.isEmpty()) {
        return 0
    }

    var result = 0
    var sign = 1
    var n = str.length
    var i = 0

    // Step 1: Ignore leading whitespaces
    while (i < n && str[i] == ' ') {
        i++
    }

    // Step 2: Handle sign
    if (i < n && (str[i] == '-' || str[i] == '+')) {
        sign = if (str[i] == '-') -1 else 1
        i++

    }

    // Step 3: Convert digits
    while (i < n && str[i].isDigit()) {
        val digit = str[i] - '0'

        // Step 4: Handle overflow before adding digit
        if (result > (Int.MAX_VALUE - digit) / 10) {
            return if (sign == 1) Int.MAX_VALUE else Int.MIN_VALUE
        }
        result = result * 10 + digit
        i++
    }

    return result * sign
}
