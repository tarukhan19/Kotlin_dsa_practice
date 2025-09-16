package com.demo.kotlin_dsa_practice.solve_problem.array.easy

fun main() {
    var arr = intArrayOf(0, 1, 2, 4, 3, 5, 7)
    var number = findMissingNumber(arr)
    println(number)
}

// brute force
// time complexity = n^2

fun findMissingNumber(arr: IntArray): Int {

    for (i in 0..arr.size) {
        var found = false
        for (j in 0 until arr.size) {
            if (i == arr[j]) {
                found = true
                break
            }
        }

        if (!found)
            return i
    }

    return -1
}

fun findMissingNumberOptimize(arr: IntArray): Int {
    var n = arr.size
    var size = n * (n + 1) / 2 //10
    var numSize = 0
    for (i in 0 until arr.size) {
        numSize = numSize + arr[i]
    }

    var diff = size - numSize
    return diff
}