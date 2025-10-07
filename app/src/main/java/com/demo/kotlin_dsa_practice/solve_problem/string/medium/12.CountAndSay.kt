package com.demo.kotlin_dsa_practice.solve_problem.string.medium

fun main() {
    var elem = 4
    var result = countAndSay(elem)
    println(result)
}

/*
https://www.youtube.com/watch?v=9fI_26Dl1IA
1  - 1
11  - 2
21  - 3
1211 - 4
111221  - 5
 */
fun countAndSay(n: Int): String {
    if (n == 1) {
        return "1"
    }

    var str = countAndSay(n - 1)

    var counter = 0
    var result = StringBuilder()

    for (i in 0 until str.length) {
        counter++
        if (i == str.length - 1 || str[i] != str[i + 1]) {
            result.append(counter).append(str[i])
            counter = 0
        }
    }
    return result.toString()

}