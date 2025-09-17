package com.demo.kotlin_dsa_practice.solve_problem.sorting

fun main() {
    var arr = intArrayOf(4, 5, 2, 1, 3)
    var sortedArr = recursiveBubbleSort(arr, arr.size)
    println(sortedArr.contentToString())
}

/*
push the maximum element to the last by adjacent swap

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
    for (j in arr.size - 1 downTo 0) {
        var swapped = false

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

/*
Final Answer

Time Complexity:
Best: O(n)
Average: O(n^2)
Worst: O(n^2)

🔹 Let’s break it down
Suppose n = 5 (array of size 5).
First call (n = 5): loop runs 4 comparisons.
Second call (n = 4): loop runs 3 comparisons.
Third call (n = 3): loop runs 2 comparisons.
Fourth call (n = 2): loop runs 1 comparison.
👉 Total work = 4 + 3 + 2 + 1 = 10 comparisons ≈ n(n−1)/2.
That’s O(n²).

Space Complexity: O(n) because of recursion stack.
 */
fun recursiveBubbleSort(arr: IntArray, n: Int): IntArray {

    if (n == 1) return arr
    var isSwapped = false
    for (i in 0 until n - 1) {
        if (arr[i] > arr[i + 1]) {
            var temp = arr[i]
            arr[i] = arr[i + 1]
            arr[i + 1] = temp
            isSwapped = true
        }
    }

    if (!isSwapped) {
        return arr
    }
    recursiveBubbleSort(arr, n - 1)
    return arr
}


