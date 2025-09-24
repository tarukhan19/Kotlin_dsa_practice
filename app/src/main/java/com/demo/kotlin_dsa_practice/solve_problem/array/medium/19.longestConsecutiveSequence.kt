package com.demo.kotlin_dsa_practice.solve_problem.array.medium


fun main() {
    var numArr = intArrayOf(100,4,200,1,3,2)
    var output = longestSubSequence(numArr)
    println(output)
}

fun longestSubSequence(arr: IntArray) : Int {
    var maxCount = Int.MIN_VALUE

    for (i in 0 until arr.size) {
        var x = arr[i]
        var count = 0

        for (j in 0 until arr.size) {
            if (arr[j] == x) {
                x +=1
                count++
            }
        }

        if (count > maxCount) {
            maxCount = count
        }
    }
return maxCount
}
