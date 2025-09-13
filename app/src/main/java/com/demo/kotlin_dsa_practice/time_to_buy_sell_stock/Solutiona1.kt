package com.demo.kotlin_dsa_practice.time_to_buy_sell_stock


fun main() {
    var numArr = intArrayOf(1, 2, 3, 4, 5)
    val diff = buySellStock2(numArr)
    println("difference ----> $diff")
}

fun buySellStock2(arr: IntArray): Int {
    var maxProfit = 0

    for (i in 1 until arr.size) {
       if (arr[i] > arr[i-1]) {
           maxProfit += arr[i] - arr[i-1]
       }
    }
    return maxProfit
}
