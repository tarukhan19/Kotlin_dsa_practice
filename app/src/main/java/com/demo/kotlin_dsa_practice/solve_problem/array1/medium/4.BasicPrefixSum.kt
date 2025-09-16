package com.demo.kotlin_dsa_practice.solve_problem.array1.medium

fun main() {
    var arr = intArrayOf(-1, 2, 3, -5)
    var leftIndex = intArrayOf(0, 1)
    var rightIndex = intArrayOf(3, 3)
    var output = prefixSum(arr, leftIndex, rightIndex)
    println(output.contentToString())
}

fun prefixSum(arr: IntArray, leftIndex: IntArray, rightIndex: IntArray): IntArray {
    var range = leftIndex.size
    var newArr = IntArray(range)

    for (j in 0 until range) {
        val L = leftIndex[j]
        val R = rightIndex[j]

        var currentSum = 0
        var maxSum = Int.MIN_VALUE

        for (i in L..R) {
            currentSum = currentSum + arr[i]

            if (currentSum > maxSum) {
                maxSum = currentSum
            }
        }

        newArr[j] = maxSum
    }

    return newArr
}
