package com.demo.kotlin_dsa_practice.solve_problem.array.medium

/*

Input: nums = [1,1,1,2,2,3]
Output: 5, nums = [1,1,2,2,3,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,0,1,1,1,1,2,3,3]
Output: 7, nums = [0,0,1,1,2,3,3,_,_]
Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
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
