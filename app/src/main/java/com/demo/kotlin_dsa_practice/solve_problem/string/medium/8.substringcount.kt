package com.demo.kotlin_dsa_practice.solve_problem.string.medium

fun main() {
    var str = "abcbaa"
    var k = 3

    var result = subStrCountExactlyKBruteForce(str, k)
    println(result)

}

// print all substring
fun findSubString(str: String) {
    var result = mutableListOf<String>()

    for (i in 0 until str.length) {
        for (j in i until str.length) {
            result.add(str.substring(i, j + 1))
        }
    }
    println(result)
}

fun subStrCountExactlyKBruteForce(str: String, k: Int) : Int {
    var result = mutableListOf<String>()
    var count = 0
    for (i in 0 until str.length) {
        for (j in i until str.length) {
            var subStr = str.substring(i, j + 1)

            var distinctChar = subStr.toSet().size

            if (distinctChar == k) {
                count++
                result.add(subStr)
            }

        }
    }
    println("Valid substrings with exactly $k distinct chars: $result")
    return count

}