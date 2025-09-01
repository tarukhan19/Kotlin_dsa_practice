package com.demo.kotlin_dsa_practice.time_to_buy_sell_stock

fun main() {
    var numArr = intArrayOf(7,1,5,3,6,4)
    val diff = buySellStock(numArr)
    println("difference ----> $diff")
}

fun buySellStock(numArr: IntArray): Int {
    var maxProfit = 0

    for (i in 0 until numArr.size) {
        for (j in i+1 until numArr.size) {
            var profit = numArr[j] - numArr[i]
            if (profit > maxProfit) {
                maxProfit = profit
            }
        }
    }
    return maxProfit

}

fun findSmallest(numArr: IntArray) {
    var pointer = 0

    for (i in 0 until numArr.size) {
        if (numArr[i] < numArr[pointer]) {
            pointer = i
        }
        println(numArr[pointer])
    }
}

fun findLargest(numArr: IntArray) {
    var pointer = 0

    for (i in 0 until numArr.size) {
        if (numArr[i] > numArr[pointer]) {
            pointer = i
        }
        println(numArr[pointer])
    }

}