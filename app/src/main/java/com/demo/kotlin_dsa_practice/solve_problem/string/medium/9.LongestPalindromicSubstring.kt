package com.demo.kotlin_dsa_practice.solve_problem.string.medium

fun main() {
    var str = "babad"
    var result = findLongestPalindrome1(str)
    println(result)

}

/*
Time Complexity = O(n³)
Space Complexity = O(n)
 */

fun findLongestPalindrome(str: String): String {

    var result = ""

    for (i in 0 until str.length) {
        for (j in i until str.length) {
            if (isPalindrome(str, i, j) && (j - i + 1) > result.length) {
                result = str.substring(i, j + 1)
            }
        }
    }

    return result.toString()
}

fun isPalindrome(str: String, start: Int, end: Int): Boolean {
    var i = start
    var j = end

    while (i <= j) {
        if (str[i] != str[j]) {
            return false
        }
        i++
        j--
    }
    return true
}


/*
Time Complexity = O(n^2)
Space Complexity = O(1)
 */

fun findLongestPalindrome1(str: String): String {
    var start = 0
    var end = 0

    for (center in str.indices) {
        var lenOdd = expandFromCenter(str, center, center)
        var lenEven = expandFromCenter(str, center, center + 1)

        var maxLen = maxOf(lenEven, lenOdd)

        if (maxLen > end - start) {
            start = center - (maxLen - 1) / 2
            end = center + maxLen / 2
        }
    }

    return str.substring(start, end + 1)
}

fun expandFromCenter(str: String, left: Int, right: Int): Int {
    var l = left
    var r = right
    println()
    while (l >= 0 && r < str.length && str[l] == str[r]) {
        l--
        r++
    }
    return r - l - 1
}