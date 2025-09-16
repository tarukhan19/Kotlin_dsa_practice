package com.demo.kotlin_dsa_practice.solve_problem.recursion


fun main() {
    val n = 10
    printFibSeries(n)
}

fun printFibonacciSeries(n: Int) {
    var a = 0
    var b = 1

    if (n <= 0) return
    println("Fibonacci series up to $n terms:")

    for (i in 1..n) {
        print("$a ")
        val c = a + b
        a = b
        b = c
    }
}

fun fibonacciSeries(i: Int): Int {
    if (i == 0 || i == 1) return i
    return fibonacciSeries(i - 2) + fibonacciSeries(i - 1)
}

fun printFibSeries(n: Int) {
    println("Fibonacci series up to $n terms:")
    for (i in 0 until n) {
        print("${fibonacciSeries(i)} ")
    }
}

