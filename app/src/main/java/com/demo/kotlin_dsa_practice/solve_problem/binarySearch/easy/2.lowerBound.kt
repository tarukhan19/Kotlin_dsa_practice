package com.demo.kotlin_dsa_practice.solve_problem.binarySearch.easy

/*
Given a sorted array and a value x,
the Lower Bound is the index of the first element in the array that is greater than or equal to (>=) x.
*/
fun main() {
    var arr = intArrayOf(-1, 0, 3, 5, 9, 12, 14)
    var elem = 18
    var result = implementLowerBound(arr, elem)
    println(result)
}

fun implementLowerBound1(arr: IntArray, elem: Int): Int {

    for (i in 0 until arr.size) {
        if (arr[i] >= elem) {
            return i
        }
    }
    return -1
}

/*
TC = O(log n)
SC = O(1)
 */
fun implementLowerBound(arr: IntArray, elem: Int): Int {
    var left = 0
    var right = arr.size - 1

    var index = arr.size

    while (left <= right) {
        var mid = (left + right) / 2

        when {
            arr[mid] >= elem -> {
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
