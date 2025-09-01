package com.demo.kotlin_dsa_practice.remove_duplicate_sorted_arr

/*
two pointer approach
Input: nums = [1,1,1,2,2,3]
Output: 5, nums = [1,1,2,2,3,_]
*/

fun main() {
    var numArr = intArrayOf(1, 1, 1, 2, 2, 3, 3)
    val sortArrLen = removeDuplicate(numArr)
    println(sortArrLen)
}

fun removeDuplicate(numArr: IntArray): Int {
    var pointer = 2

    for (i in 2 until numArr.size) {

        if (numArr[i] != numArr[pointer - 2]) {
            numArr[pointer] = numArr[i]
            pointer++
        }
    }

    println(numArr.contentToString())
    return pointer
}
