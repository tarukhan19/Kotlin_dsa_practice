package com.demo.kotlin_dsa_practice.solve_problem.array1.easy


fun main() {
    val arr = intArrayOf(5, 4, 3, 2, 1)
    var isSorted = isArrSorted5(arr)
    println(isSorted)
}

// descending order
fun isArrSorted1(arr: IntArray): Boolean {
    for (i in 0 until arr.size - 1) {
        for (j in i + 1 until arr.size) {
            if (arr[i] < arr[j]) {
                return false
            }
        }
    }
    return true
}

// ascending order
fun isArrSorted2(arr: IntArray): Boolean {
    for (i in 0 until arr.size - 1) {
        for (j in i + 1 until arr.size) {
            if (arr[i] > arr[j]) {
                return false
            }
        }
    }
    return true
}

// descending order
fun isArrSorted3(arr: IntArray): Boolean {

    for (i in 0 until arr.size - 1) {
        if (arr[i] < arr[i + 1]) {
            return false
        }
    }
    return true
}

// ascending order
fun isArrSorted4(arr: IntArray): Boolean {
    for (i in 0 until arr.size - 1) {
        if (arr[i] > arr[i + 1]) {
            return false
        }
    }
    return true
}


/*
check both ascending and descending

Boolean OR (||) refresher

true || true → true
true || false → true
false || true → true
false || false → false

So, if at least one of them is true, the whole expression is true.
 */
fun isArrSorted5(arr: IntArray): Boolean {
    if (arr.size <= 1) {
        return true
    }
    var isAscending = true
    var isDescending = true

    for (i in 0 until arr.size - 1) {
        if (arr[i] > arr[i + 1]) {
            isDescending = false
        }
        if (arr[i] < arr[i + 1]) {
            isAscending = false
        }
    }
    return isAscending || isDescending
}