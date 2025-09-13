package com.demo.kotlin_dsa_practice.increasing_triplet_subsequence

fun main() {
    var numArr = intArrayOf(1, 5, 0, 4, 1, 3)
    val isTriple = solution2(numArr)
    println(isTriple)
}

fun solution2(arr: IntArray): Boolean {
    var firstNumber = Int.MAX_VALUE
    var secondNumber = Int.MAX_VALUE

    for (i in 0..arr.size - 1) {
        when {
            arr[i] <= firstNumber -> {
                firstNumber = arr[i]
            }

            arr[i] <= secondNumber -> {
                secondNumber = arr[i]
            }

            else -> {
                return true
            }
        }

    }

    return false
}