package com.demo.kotlin_dsa_practice.string_question

fun main() {
    var needle = "sad"
    var haystack = "lsadutad"
    var index = findNeedle(needle, haystack)
    println(index)
}

fun findNeedle(needle: String, haystack: String): Int {
    var k = haystack.length - needle.length

    for (i in 0..k) {
        var j = 0
        while (j < needle.length && haystack[i + j] == needle[j]) {
            println("  Match found: haystack[${i + j}] = '${haystack[i + j]}' and needle[$j] = '${needle[j]}'")
            j++
        }

        if (j == needle.length) {
            println("✅ Full match found at index $i")
            return i
        } else {
            println("❌ Match failed at haystack index $i")
        }

    }
    println("No match found")
    return -1
}

fun isSubsequence(needle: String, haystack: String): Boolean {
    var i = 0
    var j = 0
    while (i < needle.length && j < haystack.length) {
        if (needle[i] == haystack[j]) {
            i++
        }
        j++
    }
    return i == needle.length
}


