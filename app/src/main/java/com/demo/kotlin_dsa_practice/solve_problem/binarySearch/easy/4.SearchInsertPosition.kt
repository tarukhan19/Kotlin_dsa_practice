package com.demo.kotlin_dsa_practice.solve_problem.binarySearch.easy

fun main() {
    var arr = intArrayOf(-1, 0, 3, 5, 9, 12, 14)
    var elem = 17
    var result = searchInsertPosition(arr, elem)
    println(result)
}

fun searchInsertPosition(arr: IntArray, target: Int): Int {
    var left = 0
    var right = arr.size - 1

    var index = arr.size

    while (left <= right) {
        var mid = (left + right) / 2
        when {
            arr[mid] == target -> {
                return mid
            }

            arr[mid] < target -> {
                left = mid + 1
            }

            else -> {
                index = mid
                right = mid - 1
            }
        }
    }

    return index
}