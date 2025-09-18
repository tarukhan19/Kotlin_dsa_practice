package com.demo.kotlin_dsa_practice.solve_problem.sorting

/*
what this you tubeVideo for clarity
https://www.youtube.com/watch?v=8MNB0Mba_Dc

🔹 Algorithm Flow

Pick a pivot (here, last element). Partition the array so:
Elements ≤ pivot move to the left.
Elements > pivot move to the right.

Recursively apply QuickSort to:
Left subarray (low → pivotIndex - 1)
Right subarray (pivotIndex + 1 → high)

 */
fun main() {
    var arr = intArrayOf(5, 3, 8, 4, 2)
    var low = 0
    var high = arr.size - 1
    var sortedArr = quickSort(arr, low, high)
    println(sortedArr.contentToString())

}

fun quickSort(arr: IntArray, low: Int, high: Int): IntArray {
    if (low < high) {
        var pivotIndex = partition(arr, low, high)

        // left subArray
        quickSort(arr, low, pivotIndex - 1)

        // right subArray
        quickSort(arr, pivotIndex + 1, high)
    }
    return arr
}

fun partition(arr: IntArray, low: Int, high: Int): Int {
    var index = low - 1
    // Pick a pivot
    var pivot = arr[high]
    /*
     we perform this operation to move our array elements to its correct position in a way that
     Shift smaller elements(i.e. Smaller than the pivot) on the left of the pivot and larger ones to the right.
     */

    for (j in low until high) {
        // If you want ascending order → use <= pivot.
        // If you want descending order → keep >= pivot.
        if (arr[j] <= pivot) {
            index++
            // swap(index , j)
            var temp = arr[index]
            arr[index] = arr[j]
            arr[j] = temp
        }
    }

    // we perform this operation to move our pivot to its correct position
    index++
    // swap(index , high)
    var temp = arr[index]
    arr[index] = arr[high]
    arr[high] = temp

    return index
}

/*
Best Case: O(n log n) time
Average Case: O(n log n) time
Worst Case: O(n²) time , when Pivot is always smallest or largest

Space Complexity = O(1)
 */