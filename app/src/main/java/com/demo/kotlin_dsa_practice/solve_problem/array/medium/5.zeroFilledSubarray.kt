package com.demo.kotlin_dsa_practice.solve_problem.array.medium

fun main() {
    var arr = intArrayOf(0,0,2)
    var count = zeroFilledSubArray1(arr)
    println(count)
}

fun zeroFilledSubArray1(arr: IntArray): Long {
    var count = 0L
    for (i in 0 until arr.size) {
        var isSubArray = true
        for (j in i until arr.size) {
            if (arr[j] != 0) {
                isSubArray = false
                break
            } else {
                count++
            }
        }
    }
    return count
}

fun zeroFilledSubArray(arr: IntArray): Long {
    var count = 0L
    var result = 0L

    for (i in 0 until arr.size) {
        if (arr[i] == 0) {
            count++
            result = result + count
        } else {
            count = 0
        }
    }
    return result
}
