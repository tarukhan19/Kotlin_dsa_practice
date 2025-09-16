package com.demo.kotlin_dsa_practice.solve_problem.array.medium

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

/*
Optimized One Pass Approach

--> Initialize variables for tracking the minimum price seen so far (minPrice) and maximum profit (maxProfit).
--> Iterate through the prices.
--> For each price:

Update the minPrice if the current price is lower than the minPrice.
Calculate the profit if the stock were sold today.
Update maxProfit if the calculated profit is greater than maxProfit.
--> Return maxProfit after processing all prices.

Time Complexity: O(n) since we only pass through the prices array once.
Space Complexity: O(1) as no additional space is required beyond a few variables.
 */

fun buySellStockOptimize(numArr: IntArray): Int {

    var minPrice = Int.MAX_VALUE
    var maxProfit = 0

    for (price in 0 until numArr.size) {
        if (numArr[price] < minPrice){
            minPrice = numArr[price]
        }
        var profit = numArr[price] - minPrice
        if (profit > maxProfit) {
            maxProfit = profit
        }
    }
    return maxProfit
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