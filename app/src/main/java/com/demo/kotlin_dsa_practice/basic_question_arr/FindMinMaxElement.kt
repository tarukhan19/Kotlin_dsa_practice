package com.demo.kotlin_dsa_practice.basic_question_arr

fun main() {
    val arr = intArrayOf(2, 1, 3, 5, 88, 6, 7, 4, 33, 0)
    var minMaxNum = findMinMax(arr)
    println(minMaxNum)
}

fun findMin(arr: IntArray): Int {
    var minNumber = Int.MAX_VALUE

    for (i in 0..arr.size - 1) {
        if (arr[i] < minNumber) {
            minNumber = arr[i]
        }
    }
    return minNumber
}

fun findMax(arr: IntArray): Int {
    var maxValue = Int.MIN_VALUE

    for (i in 0..arr.size - 1) {
        if (arr[i] > maxValue) {
            maxValue = arr[i]
        }
    }
    return maxValue
}

fun findMinMax(arr: IntArray): Pair<Int, Int> {
    var maxNum = Int.MIN_VALUE
    var minNum = Int.MAX_VALUE

    for (i in 0 until arr.size) {
        if (arr[i] > maxNum) {
            maxNum = arr[i]
        }

        if (arr[i] < minNum) {
            minNum = arr[i]
        }
    }

    return Pair(maxNum, minNum)
}
