package com.demo.kotlin_dsa_practice.solve_problem.sorting

fun main() {
    var arr = intArrayOf(4, 5, 2, 1, 3)
    var sortedArr = recursiveInsertionSort(arr, arr.size, 1)
    println(sortedArr.contentToString())
}

/*
take an element and place it in its correct position
I tried below approach but This function is not the standard implementation of insertion sort—it’s closer
to a hybrid of insertion and selection sort. In standard insertion sort, best case is O(n)

Complexity
Best case: O(n²)
Even if the array is sorted, your inner loop still compares j from 0..i. (In standard insertion sort, best case is O(n).)

Average & Worst case: O(n²)
Because every element can compare with roughly half of the array and swap.

Space complexity: O(1) (in-place swaps only).
 */

fun hybridInsertionSort(arr: IntArray): IntArray {

    for (i in 0 until arr.size) {
        for (j in 0 until i + 1) {
            if (arr[j] > arr[i]) {
                var temp = arr[j]
                arr[j] = arr[i]
                arr[i] = temp
            }
        }
    }

    return arr
}

/*
swap-based insertion sort
So the pattern to remember is:
👉 Outer loop: pick element
👉 Inner loop: compare & swap left
👉 Repeat until sorted

Best case (already sorted): O(n) (inner while does nothing).
Worst case (reverse sorted): O(n²) (every new element swaps all the way to front).
Average case: O(n²)

Space: O(1)
 */

fun insertionSort(arr: IntArray): IntArray {
    for (i in 1 until arr.size) {
        var j = i
        while (j > 0 && arr[j - 1] > arr[j]) {
            var temp = arr[j - 1]
            arr[j - 1] = arr[j]
            arr[j] = temp
            j--
        }
    }
    return arr
}

/*
shift-based version

    for (i in 1 until arr.size) {
        var temp = arr[i]
        var j = i - 1
        while (j >= 0 && arr[j] > temp) {
            arr[j + 1] = arr[j]
            j--
        }
        arr[j+1] = temp
    }

Time Complexity =
Best case: O(n)
Average case: O(n²)
Worst case: O(n²)

Space Complexity = O(1)
 */

fun recursiveInsertionSort(arr: IntArray, n: Int, i: Int): IntArray {
    if (n == i) {
        return arr
    }
    var j = i
    while (j > 0 && arr[j - 1] > arr[j]) {
        var temp = arr[j]
        arr[j] = arr[j - 1]
        arr[j - 1] = temp
        j--
    }

    return recursiveInsertionSort(arr, n, i + 1)
}

/*
Outer recursion (i from 0 to n-1): Runs n times.
Inner while loop: In the worst case (array sorted in descending order), each i may shift all the way to index 0.
That means ~1 + 2 + 3 + … + (n-1) = n(n-1)/2 =n^2

Time Complexity:

Best: O(n)
Average: O(n^2)
Worst: O(n^2)

Space Complexity:O(n) (due to recursion stack)
 */