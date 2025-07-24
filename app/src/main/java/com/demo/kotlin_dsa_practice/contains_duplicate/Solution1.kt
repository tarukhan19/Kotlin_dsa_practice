package com.demo.kotlin_dsa_practice.contains_duplicate

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

fun checkDuplicateHashMap() : Boolean {
    val arr = intArrayOf(1, 2, 3, 1, 5, 6)

    return false
}