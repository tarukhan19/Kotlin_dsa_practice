package com.demo.kotlin_dsa_practice.majority_element


fun main() {
    var numArr = intArrayOf(2)
    val majorityElm = majorityElement(numArr)
    println(majorityElm)
}

fun majorityElement(numArr: IntArray): Int {
    val len = numArr.size
    var majorityElem = 0

    for (pointer in 0 until numArr.size) {
        var element = numArr[pointer]
        var lenCount = 0

        for (i in 0 until numArr.size) {
            if (element == numArr[i]) {
                lenCount++
            }
        }

        if (lenCount > len / 2) {
            majorityElem = numArr[pointer]
            break
        }
    }
    return majorityElem
}
