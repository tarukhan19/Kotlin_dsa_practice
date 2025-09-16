package com.demo.kotlin_dsa_practice.solve_problem.string.easy

fun main() {
    var str = "hello sir"
    var strChar = reverseStr(str.toCharArray())
    println(strChar)
}

fun printChar(str: String) {
    for (ch in str) {
        println(ch)
    }
}

fun countStr(str: String): Int {
    var count = 0
    for (ch in str) {
        count++
    }
    return count
}

fun reverseStr(str: CharArray) : String {
    var i = 0
    var j = str.size - 1

    while (i < j) {
        var temp = str[i]
        str[i] = str[j]
        str[j] = temp
        i++
        j--
    }
    return str.contentToString()
}
