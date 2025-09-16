package com.demo.kotlin_dsa_practice.solve_problem.string.easy


fun main() {
    var str = "hello sir"
    var strChar = remove(str)
    println(strChar)
}

fun removeSpace(str: String) : String {
    var result = StringBuilder()
    for (char in str) {
        if (char != ' ') {
            result.append(char)
        }
    }
    return result.toString()
}

fun remove1(str: String) : String {
    return str.replace(" ", "")
}

fun remove(str: String) : String {
    return str.replace("\\s".toRegex(), "")
}