package com.demo.kotlin_dsa_practice

fun main() {
    val arr = intArrayOf(3, 1, 3, 4, 2)
    var duplicateNum = findDuplicate(arr)
    println(duplicateNum)
}

fun findDuplicate(arr: IntArray): Int {
    var duplicateNum = 0

    for (i in 0 until arr.size - 1) {
        for (j in i + 1 until arr.size) {
            if (arr[j] == arr[i]) {
                duplicateNum = arr[j]
                break
            }
        }
    }
    return duplicateNum
}