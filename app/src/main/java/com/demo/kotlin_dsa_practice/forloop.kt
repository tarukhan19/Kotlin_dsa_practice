package com.demo.kotlin_dsa_practice

fun main() {

    var arr = intArrayOf(1,2,3,4,5)
    println(arr.size)
 var i = Int.MAX_VALUE
    for (i in 0 until arr.size) {
        println("until  -->"+i +" -- "+ arr[i])
    }

    for (i in 0..arr.size-1) {
        println("..   -->"+i +" -- "+ arr[i])
    }

    for (i in arr.size-1 downTo 0) {
        println("downTo   -->"+i +" -- "+ arr[i])
    }

    for (i in 0..arr.size step 2) {
        println("step   -->"+i +" -- "+ arr[i])
    }
}