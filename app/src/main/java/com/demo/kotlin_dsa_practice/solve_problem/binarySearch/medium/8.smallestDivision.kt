package com.demo.kotlin_dsa_practice.solve_problem.binarySearch.medium

import kotlin.math.ceil

/*
https://www.youtube.com/watch?v=UvBKTVaG6U8&feature=youtu.be
 */
fun main() {
    var arr = intArrayOf(44,22,33,11,1)
    var threshold = 5
    var result = findSmallestDivision(arr, threshold)
    println(result)
}

fun findSmallestDivision(nums: IntArray, threshold: Int): Int {
    var left = 1
    var right = nums.maxOrNull() ?: 0
    var result = 1

    while (left <= right) {
        var mid = left + (right - left) / 2
        var sum = 0

        for (i in 0..nums.size - 1) {
            sum += ceil(nums[i].toDouble() / mid).toInt()
        }

        when {
           sum <= threshold -> {
              result = mid
              right = mid - 1
           }
           else -> {
              left = mid + 1
           }
        }
    }

    return result
}
