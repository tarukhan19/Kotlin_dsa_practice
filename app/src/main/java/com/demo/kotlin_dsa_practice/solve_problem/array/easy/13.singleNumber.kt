package com.demo.kotlin_dsa_practice.solve_problem.array.easy

fun main() {
    val arr = intArrayOf(4, 1, 2, 1, 2)
    var singleNumber = singleNumber1(arr)
    println(singleNumber)
}

fun singleNumber(nums: IntArray): Int {
    var hashmap = HashMap<Int, Int>()

    for (num in nums) {
        hashmap[num] = hashmap.getOrDefault(num, 0) + 1
    }

    // Find the element that appears once
    for ((key, value) in hashmap) {
        if (value == 1) {
            return key   // return number, not index
        }
    }
    return -1
}

/*
Key Idea:

XOR of a number with itself is 0 → a ^ a = 0
XOR of a number with 0 is the number itself → a ^ 0 = a
XOR is commutative and associative → order doesn’t matter.

So if every element appears twice except one, XORing all elements will cancel out the pairs and
leave only the unique element.
 */

//4, 1, 2, 1, 2
fun singleNumber1(nums: IntArray): Int {
    var result = 0
    for (num in nums) {
        result = result xor num
    }
    return result
}