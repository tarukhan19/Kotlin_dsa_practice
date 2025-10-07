package com.demo.kotlin_dsa_practice.solve_problem.binarySearch.medium

fun main() {
    var arr = intArrayOf(3, 4, 4, 7, 8, 10)
    var target = 8

    var result = findFloorAndCeiling(arr, target)
    println(result)
}

fun findFloorAndCeiling(arr: IntArray, target: Int): Pair<Int, Int> {

    var left = 0
    var right = arr.size

    var floor = 0
    var ceiling = 0

    while (left <= right) {
        var mid = (left + right) / 2
        when {
            arr[mid] == target -> {
                floor = arr[mid]
                ceiling = arr[mid]
                return Pair(floor, ceiling)
            }

            arr[mid] > target -> {
                ceiling = arr[mid]
                right = mid - 1
            }

            else -> {
                floor = arr[mid]
                left = mid + 1
            }
        }
    }
    return Pair(floor, ceiling)
}
