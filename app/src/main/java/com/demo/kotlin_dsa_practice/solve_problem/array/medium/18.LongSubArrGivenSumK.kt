package com.demo.kotlin_dsa_practice.solve_problem.array.medium

/*
Example 1:
Input Format: N = 3, k = 5, array[] = {2,3,5}
Result: 2
Explanation: The longest subarray with sum 5 is {2, 3}. And its length is 2.

Example 2:
Input Format: N = 5, k = 10, array[] = {2,3,5,1,9}
Result: 3
Explanation: The longest subarray with sum 10 is {2, 3, 5}. And its length is 3.
 */
fun main() {
    var numArr = intArrayOf(3, 2 ,1, 2, -1, 2, 1, 0)
    var k = 5
    var output = longestSubArrSumEqualK1(numArr, k)
    println(output)
}


fun longestSubArrSumEqualK(nums: IntArray, k: Int): Int {
    var subArrLen = 0
    var maxLen = Int.MIN_VALUE

    for (i in 0 until nums.size) {
        var sum = 0
        for (j in i until nums.size) {
            sum += nums[j]
            if (sum == k) {
                subArrLen = (j - i) + 1
            }
            if (subArrLen > maxLen) {
                maxLen = subArrLen
            }
        }
    }
    return maxLen
}

fun longestSubArrSumEqualK1(nums: IntArray, k: Int): Int {
    var longest = 0
    val map = mutableMapOf<Int, Int>()
    var sum = 0

    for (j in nums.indices) {
        sum += nums[j]

        if (sum == k) {
            longest = j + 1
        }

        val diff = sum - k
        if (map.containsKey(diff)) {
            longest = maxOf(longest, j - map[diff]!!)
        }

        if (!map.containsKey(sum)) {
            map[sum] = j // store first occurrence only
        }

        println(map)
    }

    return longest
}


