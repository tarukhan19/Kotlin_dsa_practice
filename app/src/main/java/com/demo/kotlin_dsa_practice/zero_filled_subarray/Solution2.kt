package com.demo.kotlin_dsa_practice.zero_filled_subarray

fun main() {
    var arr = intArrayOf(0, 0, 2, 0 ,0)
    var count = zeroFilledSubArray(arr)
    println(count)
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

