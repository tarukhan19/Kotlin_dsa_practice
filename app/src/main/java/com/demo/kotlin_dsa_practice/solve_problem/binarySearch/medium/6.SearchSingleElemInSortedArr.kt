package com.demo.kotlin_dsa_practice.solve_problem.binarySearch.medium

/*
https://www.youtube.com/watch?v=qsbCBduIs40
 */
fun main() {
    var arr = intArrayOf(1, 1, 2, 3, 3, 4, 4, 8, 8)
    var result = searchElem2(arr)
    println(result)
}

fun searchElem(nums: IntArray): Int {
    if (nums.size == 1) return nums[0]

    for (i in 0 until nums.size) {
        if (i == 0) {
            if (nums[i] != nums[i + 1]) {
                return nums[i]
            }
        } else if (i == nums.size - 1) {
            if (nums[i] != nums[i - 1]) {
                return nums[i]
            }
        } else {
            if (nums[i] != nums[i + 1] && nums[i] != nums[i - 1]) {
                return nums[i]
            }
        }
    }

    return -1
}

fun searchElem1(nums: IntArray): Int {
    var result = 0

    for (i in 0 until nums.size) {
        result = result xor nums[i]

    }

    return result
}

fun searchElem2(nums: IntArray): Int {
    var left = 0
    var right = nums.size - 1

    while (left <= right) {
        var mid = (left + right) / 2
        when {

            mid == 0 -> {
                if (nums[mid] != nums[mid + 1]) {
                    return nums[mid]
                }
            }

            (mid == nums.size - 1) -> {
                if (nums[mid] != nums[mid - 1]) {
                    return nums[mid]
                }
            }


            (nums[mid - 1] != nums[mid] && nums[mid + 1] != nums[mid]) -> {
                return nums[mid]
            }

            (mid % 2 == 0) -> {
                if (nums[mid - 1] == nums[mid])
                    right = mid - 1
                else
                    left = mid + 1
            }

            else -> {
                if (nums[mid - 1] == nums[mid])
                    left = mid + 1
                else
                    right = mid - 1
            }

        }
    }

    return -1
}