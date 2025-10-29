package com.demo.kotlin_dsa_practice.solve_problem.array.medium

/*
https://leetcode.com/problems/majority-element-ii/description/
Moore's voting algorithm
 */
fun main() {
    var numArr = intArrayOf(1, 1, 1, 3, 3, 2, 2, 2)
    var output = majorityElem2(numArr)
    println(output)
}

/*
Time Complexity: O(n²)
Space Complexity: O(1)
 */
fun majorityElem(nums: IntArray): List<Int> {
    var appear = nums.size / 3
    var list = mutableListOf<Int>()

    for (i in 0 until nums.size) {
        var count = 0

        if (list.isEmpty() || !list.contains(nums[i]))
            for (j in i until nums.size) {
                if (nums[i] == nums[j]) {
                    count++
                }
            }
        if (count > appear) {
            list.add(nums[i])
        }
    }
    return list
}

/*
Time Complexity: O(n)
Space Complexity: O(n)
 */
fun majorityElem1(nums: IntArray): List<Int> {
    var appear = nums.size / 3
    var hashmap = HashMap<Int, Int>()
    var list = mutableListOf<Int>()

    for (i in 0 until nums.size) {
        hashmap[nums[i]] = hashmap.getOrDefault(nums[i], 0) + 1
    }

    for ((key, value) in hashmap) {
        if (value > appear) {
            list.add(key)
        }
    }

    return list
}

/*
Time = O(n),
Space = O(1).
 */

fun majorityElem2(nums: IntArray): List<Int> {
    var result = mutableListOf<Int>()
    var n = nums.size / 3

    var freq1 = 0
    var freq2 = 0

    var elem1: Int? = null
    var elem2: Int? = null

    for (num in nums) {
        when {
            elem1 == num -> freq1++
            elem2 == num -> freq2++
            freq1 == 0 -> {
                elem1 = num
                freq1 = 1
            }
            freq2 == 0 -> {
                elem2 = num
                freq2 = 1
            }
            else -> {
                freq1--
                freq2--
            }
        }
    }

    // Step 2: Verify counts
    freq1 = 0
    freq2 = 0
    for (num in nums) {
        if (num == elem1) freq1++
        else if (num == elem2) freq2++
    }

    if (freq1 > n) {
        result.add(elem1!!)
    }
    if (freq2 > n) {
        result.add(elem2!!)
    }


    return result
}