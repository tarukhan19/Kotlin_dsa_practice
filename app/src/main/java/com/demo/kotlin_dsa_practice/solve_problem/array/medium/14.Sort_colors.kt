package com.demo.kotlin_dsa_practice.solve_problem.array.medium

/*
DUTCH NATIONAL FLAG ALGORITHM
https://leetcode.com/problems/sort-colors/
 */
fun main() {
    var numArr = intArrayOf(2, 0, 2, 1, 1, 0)
    var output = mostOptimizeSortColor(numArr)
    println(output.contentToString())
}

/* brute force
 Time complexity = O(n log n)
 */

fun sortArr(arr: IntArray): String {
    arr.sort()
    var ar = arr.joinToString()
    return ar
}

/*
 Time complexity = O(2n)
 Space Complexity = O(1)

 better approach
 */


fun sortColors(arr: IntArray): IntArray {
    var count0 = 0
    var count1 = 0
    var count2 = 0

    for (i in 0 until arr.size) {
        if (arr[i] == 0) {
            count0++
        } else if (arr[i] == 1) {
            count1++
        } else {
            count2++
        }
    }

    for (i in 0 until count0) {
        arr[i] = 0
    }
    for (i in count0 until count1 + count0) {
        arr[i] = 1
    }
    for (i in count1 + count0 until count2 + count0 + count1) {
        arr[i] = 2
    }

    return arr
}

/*
https://www.youtube.com/watch?v=J48aGjfjYTI
This algorithm is based on 3 rules
1) [0.....low-1] -> 0   extreme left
2) [low....mid-1] -> 1
3) [high+1, n-1] -> 2  extreme right

remember pseudocode ->
Maintain three pointers:
low → 0
mid → 0
high → arr.size - 1

Traverse with mid:

If nums[mid] == 0:
Swap nums[low] and nums[mid].
Increment both low and mid (since both sides are correct).

If nums[mid] == 1:
Just move mid++ (white is already in the middle).

If nums[mid] == 2:
Swap nums[mid] and nums[high].
Decrement high (don’t increment mid yet, because the swapped element at mid still needs to be checked).

Stop when mid >= high.

 Time complexity = O(n)
 Space Complexity = O(1)


*/

fun mostOptimizeSortColor(arr: IntArray): IntArray {

    var mid = 0
    var high = arr.size - 1
    var low = 0

    while (mid <= high) {
        if (arr[mid] == 0) {
            var tem = arr[mid]
            arr[mid] = arr[low]
            arr[low] = tem

            mid++
            low++
        } else if (arr[mid] == 1) {
            mid++
        } else {
            var tem = arr[mid]
            arr[mid] = arr[high]
            arr[high] = tem

            high--
        }
    }
    return arr
}