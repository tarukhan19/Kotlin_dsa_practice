package com.demo.kotlin_dsa_practice.move_zeroes

fun main() {
    var numArr = intArrayOf(0,1,0,3,12)
    val arr = moveZeroes(numArr)
    println(arr.contentToString())
}

fun moveZeroes(numArr: IntArray) : IntArray {

    var pointer = 0

    for (i in 0 until numArr.size){
        if (numArr[i] != 0)
        {
            var tempNum = numArr[i]
            numArr[i] = numArr[pointer]
            numArr[pointer] = tempNum

            pointer++
        }
    }

    return numArr
}
