package com.demo.kotlin_dsa_practice.solve_problem.recursion

fun main() {
    var rec = print(5)
}

fun factorial(n: Int): Int {
    if (n == 0 || n == 1) return 1  // base case
    return n * factorial(n - 1)     // recursive case
}
