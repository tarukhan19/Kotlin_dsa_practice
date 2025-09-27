package com.demo.kotlin_dsa_practice.solve_problem.string.easy

fun main() {
    var strs = arrayOf("flower", "flow", "flight")

    var isIsomorphic = longestCommonPrefix(strs)
    println(isIsomorphic)

}

fun longestCommonPrefix(str: Array<String>): String {
    var result = StringBuilder()

    for (i in 0 until str.size) {
        var elem = str[i]
        for (j in i until str.size) {

        }
    }

    return result.toString()
}
