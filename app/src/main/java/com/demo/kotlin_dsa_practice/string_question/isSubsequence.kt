package com.demo.kotlin_dsa_practice.string_question

fun main() {
    var s = "abck"
    var t = "ahbgdc"
    var index = findSubsequence(s, t)
    println(index)
}

/*
s = "abc", t = "ahbgdc"
j runs from 0 → 6 (length of t).
At most 6 iterations.

Each iteration = O(1) work.
So → O(6) = O(|t|)

✅ Final:
Loop runs at most |t| times.
Hence Time Complexity = O(|t|).
 */

fun findSubsequence(s: String, t: String): Boolean {
    if(s.length > t.length) return false

    var i = 0
    var j = 0

    while (i < s.length && j < t.length) {
        if (s[i] == t[j]) {
            i++
        }
        j++

    }
    return i == s.length
}
