package com.demo.kotlin_dsa_practice.string_question

fun main() {
    var needle ="sad"
    var haystack = "sadbutsad"
    var index = findNeedle(needle, haystack)
    println(index)
}

fun findNeedle(needle: String, haystack: String) : Int {
    var m = haystack.length
    var n = needle.length
    var k = m-n
    for ( i in 0 until k) {

    }

    return -1
}
