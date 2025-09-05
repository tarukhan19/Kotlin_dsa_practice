package com.demo.kotlin_dsa_practice.remove_element

// when order doesn't matters
fun main() {
    var numArr = intArrayOf(3, 2, 2, 3)
    var element = 3
    var countArr = removeElement2Pointer(numArr, element)
    println(countArr)
}

fun removeElement2Pointer(numArr: IntArray, element: Int): Int {
    var i = 0
    var n = numArr.size

    while (i < n) {
        if (numArr[i] == element) {
            numArr[i] = numArr[n - 1]
            n--
        } else {
            i++
        }
    }
    println(numArr.contentToString())
    return n
}
