package com.demo.kotlin_dsa_practice.solve_problem.binarySearch.medium

fun main() {
    var arr = intArrayOf(5, 7, 7, 8, 8, 10)
    var target = 6

    var result = findFirstLastOccur(arr, target)
    println(result.contentToString())
}

fun findFirstLastOccur1(arr: IntArray, target: Int): IntArray {
    var fp = -1
    var lp = -1

    for (i in 0 until arr.size) {
        if (arr[i] == target) {
            if (fp == -1) {
                fp = i
            }
            lp = i
        }
    }

    return intArrayOf(fp, lp)
}

/*
F → first → go Left
L → last → go Right
 */

fun findFirstLastOccur(arr: IntArray, target: Int): IntArray {
    var fp = -1
    var lp = -1

    var left = 0
    var right = arr.size - 1

    // find last place
    while (left <= right) {
        var mid = (left + right) / 2
        when {
            arr[mid] == target -> {
                lp = mid
                left = mid + 1
            }

            arr[mid] < target -> {
                left = mid + 1
            }

            else -> {
                right = mid - 1
            }
        }
    }

    // find first place
    left = 0
    right = arr.size - 1
    while (left <= right) {
        var mid = (left + right) / 2
        when {
            arr[mid] == target -> {
                fp = mid
                right = mid - 1
            }

            arr[mid] < target -> {
                left = mid + 1
            }

            else -> {
                right = mid - 1
            }
        }
    }
    return intArrayOf(fp, lp)
}
