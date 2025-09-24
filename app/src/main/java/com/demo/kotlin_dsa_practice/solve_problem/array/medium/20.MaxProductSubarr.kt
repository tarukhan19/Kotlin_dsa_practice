package com.demo.kotlin_dsa_practice.solve_problem.array.medium

import kotlin.math.max

fun main() {
    var numArr = intArrayOf(2, 3, -2, 4)
    var output = maxProdSubArrMax(numArr)
    println(output)
}

/*
TC = O(n^2)
SC = O(1)
 */
fun maxProdSubArr(nums: IntArray): Int {
    var maxMultiply = Int.MIN_VALUE

    for (i in 0 until nums.size) {
        var multiply = 1

        for (j in i until nums.size) {
            multiply = nums[j] * multiply

            if (multiply > maxMultiply) {
                maxMultiply = multiply
            }
        }
    }

    return maxMultiply
}

/*
TC = O(n)
SC = O(1)
 */
fun maxProdSubArrMax(nums: IntArray): Int {

    var maxMultiply = Int.MIN_VALUE
    var suffix = 1
    var prefix = 1
    for (i in 0 until nums.size) {
        if (suffix == 0) {
            suffix = 1
        }
        if (prefix == 0) {
            prefix = 1
        }
        suffix = suffix * nums[i]
        prefix = prefix * nums[nums.size - 1 - i]
        maxMultiply = max(maxMultiply, max(prefix, suffix))
    }

    return maxMultiply

}