package com.demo.kotlin_dsa_practice.contains_duplicate

fun main() {
    println(isDuplicate())
}

fun isDuplicate(): Boolean {
    val arr = intArrayOf(1, 2, 3, 1)
    var arrHashSet = mutableSetOf<Int>()

    for (i in arr.indices) {
        // add Returns: true if the element has been added, false if the element is already contained in the set.
        if (!arrHashSet.add(arr[i])) {
            println(arrHashSet)
            return true
        }
    }
    return false
}