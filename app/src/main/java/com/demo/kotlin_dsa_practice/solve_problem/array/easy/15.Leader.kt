package com.demo.kotlin_dsa_practice.solve_problem.array.easy

import kotlin.math.max

fun main() {
    val arr = intArrayOf(10, 22, 12, 3, 0, 6)
    var leaderArr = findLeader2(arr)
    println(leaderArr.contentToString())
}

/*
Time complexity = O(n^2)
Space Complexity = O(N) { There is no extra space being used in this approach. But, a O(N)
of space for ans array will be used in the worst case }.
 */
fun findLeaders(arr: IntArray): IntArray {
    var leaderArr = mutableListOf<Int>()
    var pointer = 0

    while (pointer < arr.size) {
        var isLeader = true
        for (i in pointer + 1 until arr.size) {
            if (arr[pointer] < arr[i]) {
                isLeader = false
                break
            }
        }
        if (isLeader) {
            leaderArr.add(arr[pointer])
        }
        pointer++
    }

    return leaderArr.toIntArray()
}

/*
Time complexity = O(n)
Space Complexity = O(n)
 */

fun findLeader1(arr: IntArray): IntArray {
    var leaderArr = mutableListOf<Int>()
    var maxNum = Int.MIN_VALUE

    for (i in arr.size - 1 downTo 0) {
        if (arr[i] > maxNum) {
            maxNum = arr[i]
            leaderArr.add(maxNum)
        }
    }
    return leaderArr.toIntArray()
    // Output = [6,12,22]
}

/*
addFirst(element) inserts an element at the beginning (front) of the deque. This means new elements
go to the front instead of the end (like addLast or add)
 */
fun findLeader2(arr: IntArray): IntArray {
    var leaderArr = ArrayDeque<Int>()
    var maxNum = Int.MIN_VALUE

    for (i in arr.size - 1 downTo 0) {
        if (arr[i] > maxNum) {
            maxNum = arr[i]
            leaderArr.addFirst(maxNum)
        }
    }
    return leaderArr.toIntArray()
    // Output = [22,12,6]

}