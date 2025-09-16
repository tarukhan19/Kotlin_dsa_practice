package com.demo.kotlin_dsa_practice.solve_problem.array.easy

fun main() {
    val arr = intArrayOf(5, 4, 3, 2, 1)
    var sum = sumArr(arr)
    println(sum)
}

fun sumArr(arr: IntArray): Int {
    var sum = 0
    for (i in 0 until arr.size) {
        sum = sum + arr[i]
    }
    return sum
}
