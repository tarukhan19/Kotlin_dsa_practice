package com.demo.kotlin_dsa_practice.string_question

fun main() {
    var str = "loveleetcode" // abab
    var index = firstUniqueChar3(str)
    println(index)
}

fun firstUniqueChar1(str: String): Int {

    for (i in 0..str.length - 1) {
        var char = str[i]
        var count = 0
        for (j in 0..str.length - 1) {
            if (char == str[j]) {
                count++
            }
        }
        if (count == 1) {
            return i
        }
    }
    return -1
}

fun firstUniqueChar2(str: String): Int {
    var freqMap = HashMap<Char, Int>()

    for (i in 0 until str.length) {
        freqMap[str[i]] = freqMap.getOrDefault(str[i], 0) + 1
    }

    for (i in 0 until str.length) {
        if (freqMap[str[i]] == 1) {
            return i
        }
    }

    return -1
}
/*
Time: O(n) (two passes over the string)
Space: O(k), where k = number of distinct characters (at most 26 if lowercase letters, or 128/256 for ASCII).
 */

fun firstUniqueChar3(str: String): Int {
    var freq = IntArray(26)

    for (i in 0 until str.length) {
        var index = str[i] - 'a'
        freq[index]++
    }

    for (i in 0 until str.length) {
        if (freq[str[i] - 'a'] == 1) {
            return i
        }
    }
    return -1

}

/*
Time: O(n) (two passes).
Space: O(26) → constant, very efficient.
 */