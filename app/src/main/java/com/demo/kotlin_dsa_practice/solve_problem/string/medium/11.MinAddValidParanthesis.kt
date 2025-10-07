package com.demo.kotlin_dsa_practice.solve_problem.string.medium

fun main(){
    var str = "()(("
    var result = findCount(str)
    println(result)
}

fun findCount(str: String) : Int {
    var count = 0
    var openCount = 0

    for (ch in str) {
        if (ch == '(') {
            openCount++
        } else {
            openCount--
            if (openCount < 0) {
                openCount = 0
                count++
            }
        }
    }
    return openCount + count

}
