package com.demo.kotlin_dsa_practice.solve_problem.string2.easy

/*
Subsequence

A subsequence of a string is formed by deleting zero or more characters from the string without
changing the relative order of the remaining characters.
Example:
String = "abcde"
Subsequences include:

"abcde" (the whole string)

"ace" (deleted b and d)

"bd" (deleted a, c, e)

"" (empty string is always a subsequence)

👉 Key: Order is preserved, but characters don’t need to be consecutive.
 */
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
