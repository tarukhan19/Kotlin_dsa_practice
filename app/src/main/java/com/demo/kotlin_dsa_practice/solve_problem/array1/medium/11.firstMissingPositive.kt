package com.demo.kotlin_dsa_practice.solve_problem.array1.medium

fun main() {
    var arr = intArrayOf(1)
    var missingPositive = findPositiveNumber2(arr)
    println(missingPositive)
}

// positive number start from 1 to n
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

fun findPositiveNumber3(arr: IntArray): Int {
    var i = 0
    var n = arr.size

    while (i < n) {
        var correctInd = arr[i] - 1
        if (arr[i] in 1..n && arr[i] != arr[correctInd]) {
            var temp = arr[i]
            arr[i] = arr[correctInd]
            arr[correctInd] = temp
        } else {
            i++
        }
    }

    for (i in 0 until n) {
        if (arr[i] != i + 1) {
            return i + 1
        }
    }
    return n + 1
}