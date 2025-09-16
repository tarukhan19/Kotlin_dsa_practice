package com.demo.kotlin_dsa_practice.solve_problem.string2.easy

fun main() {
    var str = "takeuforward"
    var convertCase = countCharFreq(str)
    println(convertCase)
}

// Time: O(n²)
// Space: O(k) (where k = number of unique characters, ≤ n).
fun countCharacterFreq(str: String): HashMap<Char, Int> {
    var hashMap = HashMap<Char, Int>()
    for (char in str) {
        var count = 0
        for (j in 0 until str.length) {
            if (str[j] == char) {
                count++
            }
        }
        hashMap.put(char, count)
    }
    return hashMap
}

fun countCharacterFreqOptimize(str: String): HashMap<Char, Int> {
    var hashMap = HashMap<Char, Int>()
    for (char in str) {
       hashMap[char] = hashMap.getOrDefault(char, 0 ) + 1
    }
    return hashMap
}

fun countCharFreq(str: String): Map<Char, Int> {
    return str.groupingBy { it }.eachCount()
}