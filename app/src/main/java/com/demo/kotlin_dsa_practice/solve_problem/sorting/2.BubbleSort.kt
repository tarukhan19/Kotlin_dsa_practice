package com.demo.kotlin_dsa_practice.solve_problem.sorting

fun main() {
    var arr = intArrayOf(13, 46, 24, 52, 20, 9)
    var sortedArr = bubbleSort(arr)
    println(sortedArr.contentToString())
}

/*
push the maximum to the last by adjacent swap

⏱ Time Complexity

Best Case (Already Sorted Array): O(n)
One full pass, no swaps → loop breaks immediately.

Average Case (Random Array):O(n²)
Still requires ~n² comparisons.

Worst Case (Reverse Sorted Array): O(n²)
Still ~n² comparisons and swaps.

💾 Space Complexity

In-place, only swapped and temp used.
O(1)
*/

fun bubbleSort(arr: IntArray): IntArray {
    var swapped = false
    for (j in arr.size - 1 downTo 0) {
        for (i in 0 until j) {
            if (arr[i] > arr[i + 1]) {
                var temp = arr[i]
                arr[i] = arr[i + 1]
                arr[i + 1] = temp
                swapped = true
            }
        }
        // If no elements were swapped in this pass, array is already sorted
        if (!swapped) break
    }
    return arr
}
