package com.demo.kotlin_dsa_practice.solve_problem.array.medium

/*
 KADANE'S ALGORITHM
 https://leetcode.com/problems/maximum-subarray/description/
 */
fun main() {
    var numArr = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
    var output = findMaxSumSubArr(numArr)
    println(output)
}

/*
TC = O(n^3)
SP = O(1)
 */
fun maxSumSubArr(arr: IntArray): Int {
    var maxSum = Int.MIN_VALUE

    for (i in 0 until arr.size) {
        for (j in i until arr.size) {
            var sum = 0
            for (k in i..j) {
                sum += arr[k]
            }
            if (sum > maxSum) {
                maxSum = sum
            }
        }
    }

    return maxSum
}

/*
TC = O(n^3)
SP = O(1)
 */
fun maxSumSubArr1(arr: IntArray): Int {
    var maxSum = Int.MIN_VALUE

    for (i in 0 until arr.size) {
        var sum = 0
        for (j in i until arr.size) {
            sum += arr[j]
            if (sum > maxSum) {
                maxSum = sum
            }
        }
    }

    return maxSum
}

/*
Time: O(n)
Space: O(1)
 */

fun findMaxSumSubArr(arr: IntArray): Int {
    var sum = 0
    var maxSum = Int.MIN_VALUE

    for (i in 0 until arr.size) {
        sum += arr[i]
        if (sum > maxSum) {
            maxSum = sum
        }

        if (sum < 0) {
            sum = 0
        }
    }

    return maxSum
}


// it will return subarray with max sum
fun returnMaxSumSubArr(arr: IntArray): IntArray {
    var ansArr = mutableListOf<Int>()
    var sum = 0
    var maxSum = Int.MIN_VALUE
    var start = 0
    var tempStart = 0
    var end = 0

    for (i in 0 until arr.size) {
        sum += arr[i]
        if (sum > maxSum) {
            maxSum = sum
            start = tempStart
            end = i
        }

        if (sum < 0) {
            sum = 0
            tempStart = i + 1
        }
    }

    for (i in start..end) {
        ansArr.add(arr[i])
    }
    return ansArr.toIntArray()
}
