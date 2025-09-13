package com.demo.kotlin_dsa_practice.cyclic_sort

fun main() {
    var arr = intArrayOf(2, 5, 3,-2, 4, 6, 1, -1, 0)
    var sortedArr = cyclicSort(arr)
    println(sortedArr.contentToString())
}

fun cyclicSort(arr: IntArray): IntArray {
    var len = arr.size
    var i = 0

    while (i < len) {
        var correctInd = arr[i] - 1
        if (arr[i] in 1..len && arr[i] != arr[correctInd]) {
            var temp = arr[i]
            arr[i] = arr[correctInd]
            arr[correctInd] = temp
        } else {
            i++
        }
    }
    return arr
}
