package com.demo.kotlin_dsa_practice.solve_problem.array1.medium

/*
Given an integer array nums, return true if there exists a triple of indices (i, j, k)
such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
 */
fun main() {
    var numArr = intArrayOf(0, 4, 2, 1, 0, -1, -3)
    val isTriple = solution1(numArr)
    println(isTriple)
}

// i<j<k
fun solution1(arr: IntArray): Boolean {
    var isTriple = false
    for (i in 0..arr.size - 3) {
        for (j in i + 1..arr.size - 2) {
            for (k in j + 1..arr.size - 1) {
                if (arr[i] < arr[j] && arr[j] < arr[k]) {
                    isTriple = true
                    break
                }
            }
        }
    }
    return isTriple
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