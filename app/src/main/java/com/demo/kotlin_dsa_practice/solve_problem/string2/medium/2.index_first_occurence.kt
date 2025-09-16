package com.demo.kotlin_dsa_practice.solve_problem.string2.medium

fun main() {
    var needle = "cdeab"
    var haystack = "abcdeabcde"
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

/// this is how we solve substring question
