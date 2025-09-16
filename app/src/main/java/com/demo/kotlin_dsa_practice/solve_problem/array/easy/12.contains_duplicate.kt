package com.demo.kotlin_dsa_practice.solve_problem.array.easy

fun main() {
    val isDuplicate = checkDuplicate()
    println(isDuplicate)
}

// brute force.. double loop so TimeComplexity is n square
fun checkDuplicate(): Boolean? {
    val arr = intArrayOf(1, 2, 3, 1, 5, 6)
    for (i in 0 until arr.size - 1) {
        for (j in i + 1 until arr.size) {
            if (arr[i] == arr[j]) {
                println("${i}  ---------  ${j}")
                return true
            }
        }
    }
    return false
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