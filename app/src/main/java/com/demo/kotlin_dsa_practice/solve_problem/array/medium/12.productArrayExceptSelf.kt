package com.demo.kotlin_dsa_practice.solve_problem.array.medium


/*
Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 */

fun main() {
    var numArr = intArrayOf(1, 2, 3, 4)
    var output = multiply(numArr)
    println(output.contentToString())
}

fun multiply(numArr: IntArray): IntArray {
    var list = mutableListOf<Int>()

    for (i in 0 until numArr.size) {
        var multiplyInd = 1
        for (j in 0 until numArr.size) {
            if (i != j) {
                multiplyInd = multiplyInd * numArr[j]
            }
        }
        list.add(multiplyInd)
    }
    return list.toIntArray()
}

fun multiply1(arr: IntArray): IntArray {
    var n = arr.size
    var result = IntArray(n)
    var prefixArr = IntArray(n)
    var suffixArr = IntArray(n)

    var multiplyInt = 1
    for (i in 0 until n) {
        prefixArr[i] = multiplyInt
        multiplyInt = multiplyInt * arr[i]
    }

    multiplyInt = 1
    for (j in n - 1 downTo 0) {
        suffixArr[j] = multiplyInt
        multiplyInt = multiplyInt * arr[j]
    }

    for (k in 0 until result.size) {
        result[k] = suffixArr[k] * prefixArr[k]
    }
    return result
}

fun multiply2(numArr: IntArray): IntArray {
    var n = numArr.size
    var resultArr = IntArray(n)

    var multiplyRes = 1
    for (i in 0..n - 1) {
        resultArr[i] = multiplyRes
        multiplyRes = multiplyRes * numArr[i]
    }

    multiplyRes = 1
    for (j in n - 1 downTo 0) {
        resultArr[j] = resultArr[j] * multiplyRes
        multiplyRes = multiplyRes * numArr[j]
    }

    return resultArr
}