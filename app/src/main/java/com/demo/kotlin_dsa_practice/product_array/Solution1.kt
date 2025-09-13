package com.demo.kotlin_dsa_practice.product_array

fun main() {
    var numArr = intArrayOf(1, 2, 3, 4)
    var output = multiply(numArr)
    println(output.contentToString())
}

fun multiply(numArr: IntArray): IntArray {
    var list = mutableListOf<Int>()

    for (i in 0 until numArr.size) {
        var multiplyInd = 1
        for (j in 0 until numArr.size) {
            if (i != j) {
                multiplyInd = multiplyInd * numArr[j]
            }
        }
        list.add(multiplyInd)
    }
    return list.toIntArray()
}

//fun multiplyOptimize(numArr: IntArray): IntArray {
//    var resultArr = IntArray(numArr.size)
//
//    var leftProduct = 1
//    for (i in 0 until numArr.size) {
//        resultArr[i] = leftProduct
//        leftProduct =  leftProduct * numArr[i]
//    }
//
//    var rightProduct = 1
//    for (i in numArr.size - 1 downTo 0) {
//        resultArr[i] = resultArr[i] * rightProduct
//        rightProduct = rightProduct * numArr[i]
//    }
//    return resultArr
//}
