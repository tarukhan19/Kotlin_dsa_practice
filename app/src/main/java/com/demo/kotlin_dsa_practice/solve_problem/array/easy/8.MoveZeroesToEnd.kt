package com.demo.kotlin_dsa_practice.solve_problem.array.easy

fun main() {
    var numArr = intArrayOf(0, 1, 0, 3, 12)
    val arr = moveZeroes(numArr)
    println(arr.contentToString())
}

fun moveZeroesBruteForce(numArr: IntArray): IntArray {
    var temArr = mutableListOf<Int>()
    for (i in 0 until numArr.size) {
        if (numArr[i] != 0) {
            temArr.add(numArr[i])
        }
    }
    val zeroCount = numArr.size - temArr.size
    repeat(zeroCount) {
        temArr.add(0)
    }
    return temArr.toIntArray()
}

fun moveZeroes(numArr: IntArray): IntArray {
    var pointer = 0

    for (i in 0 until numArr.size) {
        if (numArr[i] != 0) {
            var tempNum = numArr[i]
            numArr[i] = numArr[pointer]
            numArr[pointer] = tempNum

            pointer++
        }
    }

    return numArr
}