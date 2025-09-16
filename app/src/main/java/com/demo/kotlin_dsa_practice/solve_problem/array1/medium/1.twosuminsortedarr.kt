package com.demo.kotlin_dsa_practice.solve_problem.array1.medium

/*
⏱ Time Complexity: O(n)
Why?
We use two pointers: left (starts at 0), and right (starts at n - 1).
In each iteration of the while loop, we either increment left or decrement right.
That means each step moves one of the pointers closer to the other, and we never move a pointer backward.
So in the worst case, we move through the entire array once: at most n steps.
✅ Hence, Time Complexity = O(n)

🧠 Space Complexity: O(1) (Constant space)
Why?
We're only using:
Two integer pointers (left and right)
A variable to store the sum
And the final intArrayOf(...) for the return value (which is just 2 integers)
We don't use any extra data structures (like hash maps, lists, etc.) that grow with input size.
✅ Hence, Space Complexity = O(1)
 */
fun main() {
    twoSumDecreaseOrder()
}

/*
---------------------------------- TWO POINTER APPROACH ---------------------------------

If the array is sorted, you can use the Two Pointers approach:
👉 Steps:

Initialize left = 0 and right = nums.size - 1.

While left < right:

Calculate sum = nums[left] + nums[right].
If sum == target: return the pair.
If sum < target: move left++.
If sum > target: move right--.
 */
fun twoSumIncreaseOrder() : IntArray? {

    val numArr = intArrayOf(2,7,11,15)
    val target = 9

    var left = 0
    var right = numArr.size-1

    while (left < right) {

        val sum = numArr[left] + numArr[right]
        if (sum == target) {
            var result = intArrayOf(left, right)
            println("left $left -- right $right")

            println(result)
            return result
        }
        else if (sum < target) {
            left++
            println("<<<left = $left right = $right")
        }
        else {
            right --
            println(">>>left = $left right = $right")
        }
    }
    return  null
}

fun twoSumDecreaseOrder() : IntArray? {

    val numArr = intArrayOf(15,11,7,2)
    val target = 9

    var left = 0
    var right = numArr.size-1

    while (left < right) {

        val sum = numArr[left] + numArr[right]
        if (sum == target) {
            var result = intArrayOf(left, right)
            println("left $left -- right $right")

            println(result)
            return result
        }
        else if (sum < target) {
            right--
            println("<<<left = $left right = $right")
        }
        else {
            left++
            println(">>>left = $left right = $right")
        }
    }
    return  null
}