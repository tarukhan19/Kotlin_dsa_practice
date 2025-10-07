package com.demo.kotlin_dsa_practice.solve_problem.string.medium

fun main() {
    var a = "abc"
    var b = "cabcabca"
    var result = repeatedStrMatch(a, b)
    println(result)
}

fun repeatedStrMatch(a: String, b: String): Int {
    var count = 1

    if (a.contains(b)) {
        return count
    }
    var original = a

    var minRepeat = (a.length + b.length) / a.length
    repeat(minRepeat) {
        original += a
        count++
        if (original.contains(b)) {
            println(original)
            return count
        }
    }
    return -1
}
