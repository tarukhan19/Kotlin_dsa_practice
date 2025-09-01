package com.demo.kotlin_dsa_practice.remove_duplicate_sorted_arr

/*
two pointer approach
Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
*/

fun main() {
    var numArr = intArrayOf(1, 1, 1, 2, 2, 3)
    val sortArrLen = removeDuplicates(numArr)
    println(sortArrLen)
}

fun removeDuplicates(numArr: IntArray): Int {
    var pointer = 1

    for (i in 1 until numArr.size) {
        if (numArr[i] != numArr[pointer-1]) {
            numArr[pointer] = numArr[i]
            pointer++
        }
    }
    return pointer
}