package com.demo.kotlin_dsa_practice.solve_problem.binarySearch.medium

/*
https://www.youtube.com/watch?v=w2G2W8l__pc
 */
fun main() {
    var arr = intArrayOf(4, 5, 1, 2, 3)
    var result = minInRotatedArr1(arr)
    println(result)
}

fun minInRotatedArr(arr: IntArray): Int {

    var minNum = Int.MAX_VALUE

    for (i in 0 until arr.size) {
        if (arr[i] < minNum) {
            minNum = arr[i]
        }
    }

    return minNum
}

/*
We can easily observe that the number of rotations in an array is equal to the index of its minimum element.
 */

fun minInRotatedArr1(arr: IntArray): Int {
    var left = 0
    var right = arr.size - 1
    var minNum = Int.MAX_VALUE
    var index = -1

    while (left <= right) {
        var mid = (left + right) / 2

        when {
            arr[left] <= arr[mid] -> {
                if (arr[left] < minNum) {
                    minNum = arr[left]
                    index = left
                }
                left = mid + 1
            }
            else -> {
                if (arr[mid] < minNum) {
                    minNum = arr[mid]
                    index = mid
                }
                right = mid - 1
            }
        }
    }
    return minNum
}
