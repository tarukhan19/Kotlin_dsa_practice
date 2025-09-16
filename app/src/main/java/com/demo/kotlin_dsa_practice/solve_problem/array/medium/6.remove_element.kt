package com.demo.kotlin_dsa_practice.solve_problem.array.medium

fun main() {
    var numArr = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2)
    var element = 2
    var countArr = removeElement(numArr, element)
    println(countArr)
}

fun removeElement(numArr: IntArray, element: Int): Int {
    var list = mutableListOf<Int>()
    for (i in 0 until numArr.size) {
        if (numArr[i] != element) {
            list.add(numArr[i])
        }
    }
    println(list.toIntArray().contentToString())
    return list.size
}

fun removeElementTwoPointer(numArr: IntArray, element: Int): Int {
    var pointer = 0

    for (i in 0 until numArr.size) {
        if (numArr[i] != element) {
            numArr[pointer] = numArr[i]
            pointer++
        }
    }
    println(numArr.contentToString())
    return pointer
}

fun removeElement2Pointer(numArr: IntArray, element: Int): Int {
    var i = 0
    var n = numArr.size

    while (i < n) {
        if (numArr[i] == element) {
            numArr[i] = numArr[n - 1]
            n--
        } else {
            i++
        }
    }
    println(numArr.contentToString())
    return n
}