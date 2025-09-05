package com.demo.kotlin_dsa_practice.remove_element

fun main() {
    var numArr = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2)
    var element = 2
    var countArr = removeElement(numArr, element)
    println(countArr)
}

fun removeElement(numArr: IntArray, element: Int): Int {
    var list = mutableListOf<Int>()
    for (i in 0 until numArr.size) {
        if (numArr[i] != element) {
            list.add(numArr[i])
        }
    }
    println(list.toIntArray().contentToString())
    return list.size
}