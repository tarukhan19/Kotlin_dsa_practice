package com.demo.kotlin_dsa_practice.solve_problem.array1.easy

/*
Time Complexity:
O(n) + O(n) + O(n) → O(n)

Space Complexity:
In-place operations → O(1)
 */
fun main() {
    var numArr = intArrayOf(1, 2, 2, 1, 1, 0)
    val arr = applyOperation(numArr)
    println(arr.contentToString())
}

fun applyOperation(arr: IntArray): IntArray {
    var k = 0
    for (i in 0 until arr.size - 1) {
        if (arr[i] == arr[i + 1]) {
            arr[i] = arr[i] * 2
            arr[i + 1] = 0
        }
    }

    for (i in 0 until arr.size) {

        if (arr[i] != 0) {
            arr[k] = arr[i]
            k++
        }
    }

    for (j in k until arr.size) {
        arr[j] = 0
    }

    return arr
}
