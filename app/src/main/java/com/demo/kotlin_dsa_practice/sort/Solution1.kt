package com.demo.kotlin_dsa_practice.sort

fun main() {
    var arr = intArrayOf(1, 14, 3, 16, 8, 12)
    var maxNum = sortElement(arr)
    println(maxNum.contentToString())
}

fun sortElement(arr: IntArray): IntArray {
    for (i in 0..arr.size - 2) {
        for (j in i + 1..arr.size-1) {
            if (arr[i] > arr[j]) {
                var temp = arr[j]
                arr[j] = arr[i]
                arr[i] = temp
            }
        }
    }
    return arr
}
