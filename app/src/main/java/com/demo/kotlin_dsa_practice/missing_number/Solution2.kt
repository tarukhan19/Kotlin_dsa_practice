package com.demo.kotlin_dsa_practice.missing_number

fun main() {
    var arr = intArrayOf(0, 1, 2, 4)
    var number = findMissingNumberOptimize(arr)
    println(number)
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