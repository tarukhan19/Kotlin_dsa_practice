package com.demo.kotlin_dsa_practice.solve_problem.binarySearch.medium

fun main() {
    var arr = intArrayOf(2, 2, 3, 3, 3, 3, 4)
    var target = 3

    var result = countOccurance1(arr, target)
    println(result)
}

fun countOccurance(arr: IntArray, target: Int): Int {
    var count = 0

    for (i in 0 until arr.size) {
        if (arr[i] == target) {
            count++
        }
    }

    return count
}

fun countOccurance1(arr: IntArray, target: Int): Int {
    var fo = -1
    var lo = -1

    var left = 0
    var right = arr.size - 1

    // find first occurance
    while (left <= right) {
        var mid = (left + right) / 2
        when {
            (arr[mid] == target) -> {
                fo = mid
                right = mid - 1
            }

            (arr[mid] < target) -> {
                left = mid + 1
            }

            else -> {
                right = mid - 1
            }
        }
    }

    left = 0
    right = arr.size - 1

    // find last occurance
    while (left <= right) {
        var mid = (left + right) / 2
        when {
            (arr[mid] == target) -> {
                lo = mid
                left = mid + 1
            }

            (arr[mid] < target) -> {
                left = mid + 1
            }

            else -> {
                right = mid - 1
            }
        }
    }

    return lo - fo + 1
}

