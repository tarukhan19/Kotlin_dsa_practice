package com.demo.kotlin_dsa_practice.solve_problem.recursion

fun main() {
    var rec = factorialNumber(1)
    println(rec)
}

fun factorialNumber(i: Int): Int {
    if (i == 0 || i == 1) {
        return 1
    }
    return (i * factorialNumber(i - 1))
}
