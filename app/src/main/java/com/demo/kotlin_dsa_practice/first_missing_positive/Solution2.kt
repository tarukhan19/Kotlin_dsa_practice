package com.demo.kotlin_dsa_practice.first_missing_positive

fun main() {
    var arr = intArrayOf(1)
    var missingPositive = findPositiveNumber3(arr)
    println(missingPositive)
}

// positive number start from 1 to n

fun findPositiveNumber3(arr: IntArray): Int {
    var i = 0
    var n = arr.size

    while (i < n) {
        var correctInd = arr[i] - 1
        if (arr[i] in 1..n && arr[i] != arr[correctInd]) {
            var temp = arr[i]
            arr[i] = arr[correctInd]
            arr[correctInd] = temp
        } else {
            i++
        }
    }

    for (i in 0 until n) {
        if (arr[i] != i + 1) {
            return i + 1
        }
    }
    return n + 1
}
