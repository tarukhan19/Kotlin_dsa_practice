package com.demo.kotlin_dsa_practice.solve_problem.array1.easy

fun main() {
    var arr = intArrayOf(1, 4, 3, 16, 8, 12)
    var maxNum = findSecondSmallest(arr)
    println(maxNum)
}

// brute force
fun findSecondLargeSmall(arr: IntArray): Pair<Int, Int> {
    for (i in 0..arr.size - 1) {
        for (j in i + 1..arr.size - 1) {
            if (arr[i] > arr[j]) {
                var temp = arr[j]
                arr[j] = arr[i]
                arr[i] = temp
            }
        }
    }

    var n = arr.size
    var secondLargest = arr[n - 2]
    var secondSmallest = arr[1]
    return Pair(secondLargest, secondSmallest)
}

fun findSecondSmallest(array: IntArray): Pair<Int, Int> {
    var smallestNo = Int.MAX_VALUE
    var secSmallestNo = Int.MAX_VALUE

    for (i in 0 until array.size) {
        if (array[i] < smallestNo) {
            secSmallestNo = smallestNo
            smallestNo = array[i]

        } else if (array[i] > smallestNo &&  array[i] < secSmallestNo) {
            secSmallestNo = array[i]
        }
    }
    return Pair(smallestNo, secSmallestNo)
}

fun findSecondLargestOptimize(arr: IntArray): Pair<Int, Int> {
    var largest = Int.MIN_VALUE
    var secLargest = Int.MIN_VALUE

    for (i in 0 until arr.size) {
        if (arr[i] > largest) {
            secLargest = largest
            largest = arr[i]
        } else if (arr[i] < largest && arr[i] > secLargest) {
            secLargest = arr[i]
        }
    }

    return Pair(largest, secLargest)
}
