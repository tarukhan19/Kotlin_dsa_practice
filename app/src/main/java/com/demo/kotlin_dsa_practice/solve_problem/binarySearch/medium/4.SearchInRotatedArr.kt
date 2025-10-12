package com.demo.kotlin_dsa_practice.solve_problem.binarySearch.medium

/*
https://www.youtube.com/watch?v=6WNZQBHWQJs

📌 Note to Remember (Search in Rotated Sorted Array)

The array is sorted but rotated → at least one half (left or right) is always sorted.
Steps in binary search:

Find mid.

If arr[mid] == target, return mid.

Check which half is sorted:
If arr[left] <= arr[mid] → left half is sorted.
Else → right half is sorted.

If the target lies inside the sorted half → shrink search to that half.

Otherwise → search the other half.

Keep adjusting left and right until found or left > right.

If not found → return -1.

Think of it as "Find the sorted half, check if target lies inside, if not → go to the other half."

 */
fun main() {
    var arr = intArrayOf(1, 0, 1, 1, 1)
    var target = 0

    var result = searchInRotatedArr(arr, target)
    println(result)
}

fun searchInRotatedArr(arr: IntArray, target: Int): Int {
    var left = 0
    var right = arr.size - 1

    while (left <= right) {
        // 1. Find middle index
        var mid = (left + right) / 2

        when {
            // 2. Check if target is at mid
            arr[mid] == target -> {
                return mid
            }

            // if elements are not unique
            arr[left] == arr[mid] && arr[mid] == arr[right] -> {
                left++
                right--
            }

            // 3. Check if LEFT half is sorted
            arr[left] <= arr[mid] -> {

                // Case A: target lies within left half
                if (target >= arr[left] && target <= arr[mid]) {
                    right = mid - 1  // move search to left side
                } else {
                    left = mid + 1 // else move to right side
                }
            }

            // 4. Otherwise, RIGHT half must be sorted
            else -> {
                if (target >= arr[mid] && target <= arr[right]) {
                    left = mid + 1  // target lies in right half
                } else {
                    right = mid - 1  // else move to left side
                }
            }

        }
    }
    return -1
}
