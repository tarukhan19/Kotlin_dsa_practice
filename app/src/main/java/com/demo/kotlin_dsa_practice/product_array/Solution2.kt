package com.demo.kotlin_dsa_practice.product_array

fun main() {
    var numArr = intArrayOf(1, 2, 3, 4)
    var output = multiply1(numArr)
    println(output.contentToString())
}

// 1,2,3,4
// 1,1,2,6
// 24,12,4,1

//24,12,8,6
fun multiply1(arr: IntArray): IntArray {
    var n = arr.size
    var result = IntArray(n)
    var prefixArr = IntArray(n)
    var suffixArr = IntArray(n)

    var multiplyInt = 1
    for (i in 0 until n) {
        prefixArr[i] = multiplyInt
        multiplyInt = multiplyInt * arr[i]
    }

    multiplyInt = 1
    for (j in n - 1 downTo 0) {
        suffixArr[j] = multiplyInt
        multiplyInt = multiplyInt * arr[j]
    }

    for (k in 0 until result.size) {
        result[k] = suffixArr[k] * prefixArr[k]
    }
    return result
}
