package com.demo.kotlin_dsa_practice.solve_problem.string.easy

fun main() {
    var str = "A man, 12 a plan, a canal Panama 123"
    countCharacters(str)
}

fun countCharacters(str: String) {
    var vowels = 0
    var constants = 0
    var digits = 0
    var spaces = 0

    for (ch in str) {
        when {
            ch.lowercaseChar() in listOf('a', 'e', 'i', 'o', 'u') -> vowels++
            ch.lowercaseChar().isLetter() -> constants++
            ch.lowercaseChar().isDigit() -> digits++
            ch == ' ' -> spaces++
        }
    }

    println(buildString {
        append("vowels = ")
        append(vowels)
        append(" constants= ")
        append(constants)
        append(" digits= ")
        append(digits)
        append(" spaces= ")
        append(spaces)
    })

}
