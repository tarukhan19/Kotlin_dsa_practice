package com.demo.kotlin_dsa_practice.solve_problem.string.easy

fun main() {
    var str = "4206"
    var result = largestOddNumber2(str)
    println(result)
}

/*
Time: O(n^2)
Space: O(n)
 */
fun largestOddNumber(str: String): String {
    var result = ""

    for (i in 0 until str.length) {

        var builder = StringBuilder()
        for (j in i until str.length) {
            builder.append(str[j])

            // character digit into its integer value.
            val digit = str[j] - '0'

            if (digit % 2 != 0) {
                if (builder.length > result.length) {
                    result = builder.toString()
                }
            }
        }
    }

    return result
}


/*
Time: O(n)
Space: O(n)
 */
fun largestOddNumber2(str: String): String {
    var index = -1

    for (i in str.length - 1 downTo 0) {
        var elem = str[i] - '0'

        if (elem % 2 != 0) {
            index = i
            break
        }
    }

    var builder = StringBuilder()
    for (i in 0 until index + 1) {
        builder.append(str[i])
    }

    return builder.toString()
}


/*
Time: O(n)
Space: O(1)
 */
fun largestOddNumber1(str: String): String {

    for (i in str.length - 1 downTo 0) {
        var elem = str[i] - '0'

        if (elem % 2 != 0) {
            return str.substring(0, i + 1)
        }
    }

    return ""
}
