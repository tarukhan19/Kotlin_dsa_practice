package com.demo.kotlin_dsa_practice.solve_problem.array1.easy

fun main() {
    var str = "hello sir"
    var strChar = removeDuplicateChar1(str)
    println(strChar)
}

// Time Complexity: O(n²)
// Space Complexity: O(n) (storing the result string)

fun removeDuplicateChar(str: String): String {
    var result = ""
    for (ch in str) {
        if (!result.contains(ch)) {
            result += ch
        }
    }
    return result.toString()
}

// Time Complexity: O(n³) worst case, O(n²) on average
// Space Complexity: O(1) (in-place, except the char array copy of size n)

fun removeDuplicates(str: String): String {
    var char = str.toCharArray()
    var n = char.size
    var i = 0

    while (i < n) {
        var j = i + 1
        while (j < n) {
            if (char[i] == char[j]) {
                for (k in j until char.size - 1) {
                    char[k] = char[k + 1]
                }
                j--
                n--
            }
            j++
        }
        i++
    }
    return String(char, 0, n)
}

// Time Complexity: O(n)
// Space Complexity: O(n) (for HashSet + result)

fun removeDuplicateChar1(str: String): String {
    var seen = HashSet<Char>()
    val result = StringBuilder()

    for (ch in str) {
        if (seen.add(ch)) {
            result.append(ch)
        }
    }
    return result.toString()
}
