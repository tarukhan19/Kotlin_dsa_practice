package com.demo.kotlin_dsa_practice.solve_problem.array.medium

import kotlin.math.max

/*
Longest Consecutive Sequence

https://leetcode.com/problems/longest-consecutive-sequence/description/
https://www.youtube.com/watch?v=oO5uLE7EUlM&feature=youtu.be


“Only start counting from the first block, then walk forward until it ends.”

“First block” → means check num - 1 doesn’t exist → it’s the start of a sequence.

“Walk forward” → means keep checking num + 1 in the set → count the consecutive numbers.

“Until it ends” → stop when num + 1 is not in the set → update max.
 */

fun main() {
    var numArr = intArrayOf(100, 4, 200, 1, 3, 2)
    var output = longestSubSequenceOptimize(numArr)
    println(output)
}

/*
TC= O(n^3)
SC = O(1)
 */
fun longestSubSequence(arr: IntArray): Int {
    var maxCount = 0

    for (i in 0 until arr.size) {
        var x = arr[i]
        var count = 0
        while (linearSearch(x, arr) == true) {
            x += 1
            count += 1
        }

        if (count > maxCount) {
            maxCount = count
        }
    }
    return maxCount
}

fun linearSearch(elem: Int, arr: IntArray): Boolean {

    for (i in 0 until arr.size) {
        if (elem == arr[i]) {
            return true
        }
    }
    return false
}


fun longestSubSequenceOptimize(arr: IntArray): Int {
    // If the array is empty, the longest consecutive subsequence is 0
    if (arr.isEmpty()) {
        return 0
    }

    // Use a set to store all elements for O(1) lookup
    var setArr = mutableSetOf<Int>()
    var maxCount = 0

    // Add all elements from the array to the set
    for (num in arr) {
        setArr.add(num)
    }

    // Iterate through each element in the set
    for (elem in setArr) {
        // Only start counting if 'elem' is the start of a sequence
        // i.e., 'elem - 1' is not in the set
        if (!setArr.contains(elem - 1)) {
            var currentNum = elem
            var count = 1

            // Count consecutive numbers starting from 'elem'
            while (setArr.contains(currentNum + 1)) {
                currentNum += 1
                count++
            }
            // Update maxCount if this sequence is longer than previous ones
            maxCount = max(count, maxCount)
        }

    }


    return maxCount
}
