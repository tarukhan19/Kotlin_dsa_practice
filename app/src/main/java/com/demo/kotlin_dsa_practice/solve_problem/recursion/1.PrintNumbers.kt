package com.demo.kotlin_dsa_practice.solve_problem.recursion

fun main() {
    printNum(5)
}

fun printNum(i: Int) {
    if (i == 0) {
        return
    }
    println(i)
    return printNum(i - 1)
}

