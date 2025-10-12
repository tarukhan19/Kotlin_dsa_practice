package com.demo.kotlin_dsa_practice.solve_problem.binarySearch.medium

fun main() {
    var arr = intArrayOf(2, 3, 4, 7, 11)
    var k = 5
    var result = findKthPositive1(arr, k)
    println(result)
}

fun findKthPositive(arr: IntArray, k: Int): Int {
    var count = k
    for (i in 0 until arr.size) {
        if (arr[i] <= count) {
            count++
        }
        else {
            break
        }
    }
    return count
}

fun findKthPositive1(arr: IntArray, k: Int): Int {
    var left = 0
    var right = arr.size - 1

    while (left <= right) {
        var mid = (left) + (right - left) / 2
        var missingNum = arr[mid] - (mid + 1)

        if (missingNum < k) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return left + k
}
