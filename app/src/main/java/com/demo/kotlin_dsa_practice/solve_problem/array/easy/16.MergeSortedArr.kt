package com.demo.kotlin_dsa_practice.solve_problem.array.easy

fun main() {
    var nums1 = intArrayOf( 0)
    var m = 0
    var nums2 = intArrayOf(1)
    var n = 1
    var result = mergeOptimize(nums1, m, nums2, n)
    println(result.contentToString())
}

/*
Time Complexity

O(m+n)+O(m+n)=O(m+n)
So, time complexity = O(m + n).

Space Complexity

You create a new array result of size m + n.
Everything else is just integers (index, i, j, k) → O(1).
✅ Total space complexity = O(m + n).
 */
fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): IntArray {
    var index = 0
    var i = 0
    var j = 0

    var result = IntArray(m + n)

    while (i < m && j < n) {
        if (nums1[i] <= nums2[j]) {
            result[index] = nums1[i]
            index++
            i++
        } else {
            result[index] = nums2[j]
            index++
            j++
        }
    }

    while (i < m) {
        result[index++] = nums1[i++]
    }

    while (j < n) {
        result[index++] = nums2[j++]
    }

    for (k in 0 until result.size) {
        nums1[k] = result[k]
    }
    return nums1
}

/*
Time complexity: O(m + n) — each element is visited at most once.
Space complexity: O(1) — merging is done in-place, no extra array is needed.
 */
fun mergeOptimize(nums1: IntArray, m: Int, nums2: IntArray, n: Int): IntArray {
    var index = (m + n) - 1
    var i = m - 1
    var j = n - 1

    while (i >= 0 && j >= 0) {
        if (nums1[i] >= nums2[j]) {
            nums1[index] = nums1[i]
            index--
            i--
        } else {
            nums1[index] = nums2[j]
            index--
            j--
        }
    }

    while (i >= 0) {
        nums1[index--] = nums1[i--]
    }

    while (j >= 0) {
        nums1[index--] = nums2[j--]
    }
    return nums1
}