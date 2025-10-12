package com.demo.kotlin_dsa_practice.solve_problem.binarySearch.easy

fun main() {
    var target = 64
    var n = 3
    var result = findNRoot(target, n)
    println(result)
}

fun findNRoot(target: Int, n: Int): Int {

    var result = 1
    var left = 1
    var right = target

    while (left <= right) {
        var mid = left + (right - left) / 2
        var value = 1L

        for (i in 1..n) {
            value = value.toLong() * mid.toLong()
            if (value > target) break
        }

        when {
            value == target.toLong() -> {
                return mid
            }

            value > target -> {
                right = mid - 1
            }

            else -> {
                left = mid + 1
            }
        }

    }
    return result
}

