package com.demo.kotlin_dsa_practice.solve_problem.string2.easy

fun main() {
    var str = "A man, a plan, a canal: Panama"
    var isPalind = isPalindrome(str)
    println(isPalind)
}

fun isPalindrome(char: String): Boolean {
    var left = 0
    var right = char.length - 1
    var regex = Regex("[A-Za-z1-2]")

    while (left < right) {
        if (!regex.matches(char[left].toString())) {
            left ++
            continue
        }

        if (!regex.matches(char[right].toString())) {
            right --
            continue
        }

        if (char[left].lowercase() != char[right].lowercase()) {
            return false
        }
        left++
        right--
    }
    return true
}

fun isPalindrome1(char: String): Boolean {
    var left = 0
    var right = char.length - 1

    while (left < right) {
        if (!char[left].isLetterOrDigit()) {
            left ++
            continue
        }

         if (!char[right].isLetterOrDigit()) {
            right --
            continue
        }

        if (char[left].lowercase() != char[right].lowercase()) {
            return false
        }
        left++
        right--
    }
    return true
}
