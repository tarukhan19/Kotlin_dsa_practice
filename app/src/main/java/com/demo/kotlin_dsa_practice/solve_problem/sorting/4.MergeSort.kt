package com.demo.kotlin_dsa_practice.solve_problem.sorting

/*
what this you tubeVideo for clarity
https://www.youtube.com/watch?v=cQDtOBTy7_Y&t=2s

🔹 What is Merge Sort?
A Divide and Conquer sorting algorithm.

Steps:
Divide the array into two halves.
Conquer → recursively sort each half.
Combine → merge the two sorted halves.

*/

fun main() {
    var arr = intArrayOf(5, 3, 8, 4, 2)
    var sortedArr = mergeSort(arr, 0, arr.size - 1)
    println(sortedArr.contentToString())
}

fun mergeSort(arr: IntArray, low: Int, high: Int): IntArray {

    if (low < high) {

        var mid = low + (high - low) / 2
        // Recursively sort the left half
        mergeSort(arr, low, mid)
        // Recursively sort the right half
        mergeSort(arr, mid + 1, high)

        // Merge the two sorted halves
        mergeArr(arr, low, mid, high)
    }

    return arr
}

fun mergeArr(arr: IntArray, low: Int, mid: Int, high: Int): IntArray {
    var i = low
    var j = mid + 1
    var tempArr = mutableListOf<Int>()

    // Compare elements from both halves and insert smaller into tempArr
    while (i <= mid && j <= high) {
        // If you want ascending order → (arr[i] <= arr[j]
        // If you want descending order → (arr[i] >= arr[j]
        if (arr[i] <= arr[j]) {
            tempArr.add(arr[i])
            i++
        } else {
            tempArr.add(arr[j])
            j++
        }
    }

    // Copy remaining elements from left half (if any)
    while (i <= mid) {
        tempArr.add(arr[i])
        i++
    }

    // Copy remaining elements from right half (if any)
    while (j <= high) {
        tempArr.add(arr[j])
        j++
    }

    // Copy sorted tempArr back into original array
    for (k in 0 until tempArr.size) {
        arr[k + low] = tempArr[k]
    }

    return arr

}
/*

Time Complexity:
Best = O(n log n)
Average = O(n log n)
Worst = O(n log n)

Space Complexity: O(n) (for temp array + recursion stack).

“Merge Sort always runs in O(n log n) time in best, average, and worst cases,
because it divides the array into halves recursively and merges them in linear time.
Its space complexity is O(n), since we need an auxiliary array to hold elements while merging, plus O(log n) for recursion stack.”
*/