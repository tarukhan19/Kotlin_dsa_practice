package com.demo.kotlin_dsa_practice.product_array

fun main() {
    var numArr = intArrayOf(1, 2, 3, 4)
    var output = multiply2(numArr)
    println(output.contentToString())
}


fun multiply2(numArr: IntArray) : IntArray {
    var n = numArr.size
    var resultArr = IntArray(n)

    var multiplyRes = 1
    for (i in 0..n-1) {
        resultArr[i] = multiplyRes
        multiplyRes = multiplyRes * numArr[i]
    }

    multiplyRes = 1
    for (j in n-1 downTo 0) {
        resultArr[j] = resultArr[j] * multiplyRes
        multiplyRes = multiplyRes * numArr[j]
    }

    return resultArr
}
