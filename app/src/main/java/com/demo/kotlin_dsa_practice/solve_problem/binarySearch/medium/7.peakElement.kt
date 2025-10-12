package com.demo.kotlin_dsa_practice.solve_problem.binarySearch.medium

fun main() {
    var arr = intArrayOf(1,2,3,4,5)
    var result = findPeakElement(arr)
    println(result)
}

fun findPeakElement(arr: IntArray): Int {
    var left = 0
    var right = arr.size - 1

    while (left <= right) {
        var mid = (left + right) / 2
        when {
            mid == 0 -> {
                return if (arr[mid] > arr[mid + 1]) {
                    mid
                } else {
                    mid + 1
                }
            }

            mid == arr.size - 1 -> {
                return if (arr[mid] > arr[mid - 1]) {
                    mid
                } else {
                    mid + 1
                }
            }

            (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) -> {
                return mid
            }

            arr[mid] >= arr[mid-1] -> {
                left = mid + 1
            }

            else -> {
                right = mid - 1
            }
        }
    }

    return -1
}