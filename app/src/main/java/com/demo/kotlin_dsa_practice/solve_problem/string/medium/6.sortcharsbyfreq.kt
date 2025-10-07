package com.demo.kotlin_dsa_practice.solve_problem.string.medium

fun main() {
    var str = "tree"

    var sortedChar = frequencySort(str)
    println(sortedChar)
}

/*
Time:
O(n) (map build) + O(n log n) (sort) + O(n) (build result) = O(n log n)

Space:
Frequency map O(n) + sorting overhead O(n) + result string O(n) = O(n)
*/

fun frequencySort(str: String) : String {
    var mapping = mutableMapOf<Char, Int>()

    for (i in 0 until str.length) {
        mapping[str[i]] = mapping.getOrDefault(str[i], 0) + 1
    }

    var sortedChars = mapping.entries.sortedByDescending { it.value }

    var result = StringBuilder()
    for ((key, values) in sortedChars) {
        repeat(values) {
            result.append(key)
        }
    }
    return result.toString()
}
