package com.demo.kotlin_dsa_practice.solve_problem.sorting


fun main() {
    var arr = intArrayOf(13, 46, 24, 52, 20, 9)
    var sortedArr = selectionSort1(arr)
    println(sortedArr.contentToString())
}

/*
1) select minimum element
2) swap it

time complexity =O(n^2)
space complexity = O(1)
*/

fun selectionSort(arr: IntArray): IntArray {
    var minNum = Int.MAX_VALUE
    for (i in 0 until arr.size - 1) {
        var index = 0

        for (j in i until arr.size) {
            if (arr[j] < minNum) {
                minNum = arr[j]
                index = j
            }
        }

        var temp = arr[i]
        arr[i] = minNum
        arr[index] = temp

        minNum = Int.MAX_VALUE
    }

    return arr
}

fun selectionSort1(arr: IntArray): IntArray {
    for (i in 0 until arr.size - 1) {
        var index = i

        for (j in i until arr.size) {
            if (arr[j] < arr[index]) {
                index = j
            }
        }

        var temp = arr[i]
        arr[i] = arr[index]
        arr[index] = temp
    }

    return arr
}