package com.demo.kotlin_dsa_practice.solve_problem.binarySearch.easy

fun main() {
    var arr = intArrayOf(-1, 0, 3, 5, 9, 12, 14)
    var elem = 9
    var result = binarySearch(arr, elem)
    println(result)
}

fun binarySearch(arr: IntArray, elem: Int): Int {
    var left = 0
    var right = arr.size - 1

    while (left <= right) {
        var mid = (left + right) / 2
        when {
            arr[mid] == elem -> {
                return mid
            }

            arr[mid] < elem -> { left = mid + 1 }
            else -> { right = mid - 1 }
        }
    }

    return -1
}