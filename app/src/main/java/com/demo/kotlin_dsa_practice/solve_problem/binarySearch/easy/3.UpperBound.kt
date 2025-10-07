package com.demo.kotlin_dsa_practice.solve_problem.binarySearch.easy

/*
For a sorted array and a value x, the Upper Bound is the index of the first
element in the array that is strictly greater than (>) x.
 */
fun main() {
    var arr = intArrayOf(-1, 0, 3, 5, 10, 12, 14)
    var elem = 11
    var result = implementUpperBound1(arr, elem)
    println(result)
}

fun implementUpperBound1(arr: IntArray, target: Int): Int {
    var index = arr.size

    for (i in 0 until arr.size) {
        if (arr[i] > target) {
            index = i
            break
        }
    }

    return index
}

/*
TC = O(log n)
SC = O(1)
 */
fun implementUpperBound(arr: IntArray, target: Int): Int {
    var left = 0
    var right = arr.size - 1

    var index = arr.size

    while (left <= right) {
        var mid = (left + right) / 2

        when {
            arr[mid] > target -> {
                index = mid
                right = mid - 1
            }

            else -> {
                left = mid + 1
            }
        }
    }

    return index
}
