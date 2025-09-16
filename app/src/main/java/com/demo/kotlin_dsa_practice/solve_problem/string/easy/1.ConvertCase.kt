package com.demo.kotlin_dsa_practice.solve_problem.string.easy

fun main() {
    var str = "First leTTeR of EACH Word"
    var convertCase = convertFirstChar(str)
    println(convertCase)
}

fun convertStrCase(str: String): StringBuilder {
    var result = StringBuilder()
    for (char in str) {
        when {
            char.isUpperCase() -> result.append(char.lowercaseChar())
            char.isLowerCase() -> result.append(char.uppercaseChar())
            else -> result.append(char)
        }
    }
    return result
}

fun convertStrCase1(str: String): StringBuilder {
    var result = StringBuilder()

    for (char in str) {
        var ascii = char.code

        when {
            ascii in 65..90 -> result.append((ascii + 32).toChar()) // convert to lowercase
            ascii in 97..122 -> result.append((ascii - 32).toChar()) // convert to uppercase
            else -> result.append(char)
        }
    }
    return result
}

fun capitalizeTitle(str: String): String {
    return str.split(" ").joinToString(" ") { word ->
        when {
            word.length <= 2 -> {
                word.lowercase()
            }

            else -> {
                word[0].uppercaseChar() + word.substring(1).lowercase()
            }
        }
    }
}

fun convertFirstChar(str: String): String {
    return str.split(" ").joinToString(" ") { word ->
        var result = StringBuilder()
        when {
            word.length <= 2 -> {
                for (ch in word) {
                    var ascii = ch.code
                    if (ascii in 65..90) {
                        result.append((ascii + 32).toChar())
                    } else {
                        result.append(ascii.toChar())
                    }
                }
            }

            else -> {
                var ascii = word[0].code
                if (ascii in 97..122) {
                    result.append((ascii - 32).toChar())
                } else {
                    result.append(ascii.toChar())
                }

                for (ch in word.substring(1)) {
                    var ascii = ch.code
                    if (ascii in 65..90) {
                        result.append((ascii + 32).toChar())
                    } else {
                        result.append(ascii.toChar())
                    }
                }
            }
        }
        result.toString()
    }
}