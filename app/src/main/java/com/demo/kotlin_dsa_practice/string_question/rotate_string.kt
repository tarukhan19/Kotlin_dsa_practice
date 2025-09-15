package com.demo.kotlin_dsa_practice.string_question

fun main() {
    var str = "aa"
    var goal = "a"
    var isRotate = rotateStr(str, goal)
    println(isRotate)
}

/*
If lengths differ → impossible, return false.
Concatenate str + str.
Check if goal is a substring of that.


TIME COMPLEXITY ->
Concatenation str + str → O(n)
Outer loop runs up to n times (0..k, where k = n).
Inner loop can, in the worst case, check goal.length = n characters.

SPACE COMPLEXITY ->
newStr = str + str → length 2n → O(n) extra space.
A few counters (i, j, k) → O(1).
Total = O(n).
So worst case = O(n * n) = O(n²)


 */
fun rotateStr(str: String, goal: String): Boolean {
    if (goal.length != str.length){return false}
    var newStr = str + str

    var k = newStr.length - goal.length

    for (i in 0..k) {
        var j = 0
        while (j < goal.length && newStr[i + j] == goal[j]) {
            j++
        }
        if (j == goal.length) {
            return true
        }
    }

    return false
}

// solved same as subsequence