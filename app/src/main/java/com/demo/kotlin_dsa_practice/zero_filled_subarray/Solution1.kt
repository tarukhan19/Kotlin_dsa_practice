package com.demo.kotlin_dsa_practice.zero_filled_subarray

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
