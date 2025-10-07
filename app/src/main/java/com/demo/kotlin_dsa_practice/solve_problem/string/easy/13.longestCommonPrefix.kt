package com.demo.kotlin_dsa_practice.solve_problem.string.easy

fun main() {
    var strs = arrayOf("flow", "flower", "flown")

    var prefix = longestCommonPrefix(strs)
    println(prefix)

}

fun longestCommonPrefix(str: Array<String>): String {
    if (str.isEmpty()) {
        return ""
    }

    var result = StringBuilder()
    var elem = str[0]

    for (i in 0 until elem.length) {
        var currentChar = elem[i]

        for (j in 1 until str.size) {
            var currentStr = str[j]
            if (i >= currentStr.length || currentStr[i] != currentChar) {
                return result.toString()
            }
        }

        result.append(currentChar)
    }

    return result.toString()
}



