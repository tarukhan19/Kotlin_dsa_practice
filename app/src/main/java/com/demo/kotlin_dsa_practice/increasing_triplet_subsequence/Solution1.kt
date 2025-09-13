package com.demo.kotlin_dsa_practice.increasing_triplet_subsequence

fun main() {
    var numArr = intArrayOf(0, 4, 2, 1, 0, -1, -3)
    val isTriple = solution1(numArr)
    println(isTriple)
}

// i<j<k
fun solution1(arr: IntArray): Boolean {
    var isTriple = false
    for (i in 0..arr.size - 3) {
        for (j in i + 1..arr.size - 2) {
            for (k in j + 1..arr.size - 1) {
                if (arr[i] < arr[j] && arr[j] < arr[k]) {
                    isTriple = true
                    break
                }
            }
        }
    }
    return isTriple
}