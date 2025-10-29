package com.demo.kotlin_dsa_practice.solve_problem.array.easy.twod

fun main() {
    var grid = arrayOf(intArrayOf(1,3) , intArrayOf(2,2))
    var result = calculate(grid)
    println(result.contentToString())
}

// TC = O(N^2)
fun calculate(grid: Array<IntArray>) : IntArray {
    var seen = mutableSetOf<Int>()
    val n = grid.size

    var expectedSum = 0
    var actualSum = 0

    var repeating = 0
    var missing = 0

    for (i in 0 until n) {
        for (j in 0 until n) {
            var value = grid[i][j]
            println(value)
            actualSum += value

            if (seen.contains(value)) {
                repeating = value
            }

            seen.add(value)
        }
    }

    var total = n * n
    expectedSum = total * (total + 1) / 2

    missing = expectedSum + repeating - actualSum
    return intArrayOf(repeating , missing)
}
