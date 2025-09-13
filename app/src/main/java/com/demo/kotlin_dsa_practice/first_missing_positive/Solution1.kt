package com.demo.kotlin_dsa_practice.first_missing_positive

fun main() {
    var arr = intArrayOf(1)
    var missingPositive = findPositiveNumber2(arr)
    println(missingPositive)
}

fun findPositiveNumber1(arr: IntArray): Int {
    var firstPositive = 0

    for (i in 1..arr.size + 1) {
        var isMiss = true
        for (j in 0 until arr.size) {
            if (arr[j] == i) {
                isMiss = false
                break
            }
        }

        if (isMiss) {
            firstPositive = i
            break
        }
    }
    return firstPositive
}

fun findPositiveNumber2(arr: IntArray): Int {
    var arrSet = HashSet<Int>()
    for (i in 0..arr.size - 1) {
        arrSet.add(arr[i])
    }

    for (i in 1..arr.size + 1) {
        if (!arrSet.contains(i)) {
            return i
        }
    }
    return 1
}
