package com.demo.kotlin_dsa_practice.solve_problem.array1.easy

fun main() {
    val arr = intArrayOf(5, 4, 3, 2, 1)
    var searchResult = binarySearchIndex2(arr, 2)
    println(searchResult)
}

fun linearSearchIndex(arr: IntArray, elem: Int): Int {
    var index = 0
    for (i in 0..arr.size - 1) {
        if (arr[i] == elem) {
            index = i
        }
    }
    return index
}

// if sorted in increasing order
fun binarySearchIndex1(arr: IntArray, elem: Int): Int {

    var startPos = 0
    var endPos = arr.size - 1

    while (startPos <= endPos) {
        var midPos = (startPos + endPos) / 2
        when {
            (arr[midPos] == elem) -> return midPos
            elem > arr[midPos] -> startPos = midPos + 1
            elem < arr[midPos] -> endPos = midPos - 1
        }
    }
    return -1
}

// if sorted in decreasing order
fun binarySearchIndex2(arr: IntArray, elem: Int): Int {
    var startPos = 0
    var endPos = arr.size - 1

    while (startPos <= endPos) {
        var midPos = (startPos + endPos) / 2
        when {
            (arr[midPos] == elem) -> return midPos
            elem > arr[midPos] -> endPos = midPos - 1
            elem < arr[midPos] -> startPos = midPos + 1
        }
    }
    return -1
}
