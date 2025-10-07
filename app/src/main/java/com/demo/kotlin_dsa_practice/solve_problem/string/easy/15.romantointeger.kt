package com.demo.kotlin_dsa_practice.solve_problem.string.easy

fun main() {
    var result = convert("LVIII")
    println(result)
}

/*
If a symbol is smaller or equal to the one after it, → add.
If a symbol is smaller and comes before a bigger one, → subtract.

O(n) time, O(1) space
 */
fun convert(s : String) : Int {
    var romans = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )
    var sum = 0
    var prevVal = romans[s[0]]!!

    for (i in 1 until s.length) {
        var currentVal = romans[s[i]]!!

        if (currentVal > prevVal) {
            sum -= prevVal
        } else {
            sum += prevVal
        }

        prevVal = currentVal
    }
    sum += prevVal
    return sum
}