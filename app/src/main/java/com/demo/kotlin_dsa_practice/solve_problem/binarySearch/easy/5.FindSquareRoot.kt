package com.demo.kotlin_dsa_practice.solve_problem.binarySearch.easy

fun main() {
    var elem = 2147483647
    var result = findSqrRoot1(elem)
    println(result)
}

fun findSqrRoot(elem: Int): Int {
    if (elem == 0 || elem == 1) return elem

    var i = 1
    var result = 1

    while (i * i <= elem) {
        result = i
        i++
    }
    return result
}

fun findSqrRoot1(n: Int): Int {

    var left = 1
    var right = n

    var result = 1

    while (left <= right) {
        val mid = left + (right - left) / 2
        val value = mid.toLong() * mid.toLong()

        when {
            value == n.toLong() -> {
                return mid
            }
            value < n.toLong() -> {
                result = mid
                left = mid + 1
            }
            else -> {
                right = mid - 1
            }
        }
    }
    return result
}
