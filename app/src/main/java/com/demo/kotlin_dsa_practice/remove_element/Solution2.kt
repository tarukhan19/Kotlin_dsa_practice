package com.demo.kotlin_dsa_practice.remove_element

// when order matters
fun main() {
    var numArr = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2)
    var element = 2
    var countArr = removeElementTwoPointer(numArr, element)
    println(countArr)
}

fun removeElementTwoPointer(numArr: IntArray, element: Int): Int {
    var pointer = 0

    for (i in 0 until numArr.size) {
        if (numArr[i] != element) {
            numArr[pointer] = numArr[i]
            pointer++
        }
    }
    println(numArr.contentToString())
    return pointer
}
