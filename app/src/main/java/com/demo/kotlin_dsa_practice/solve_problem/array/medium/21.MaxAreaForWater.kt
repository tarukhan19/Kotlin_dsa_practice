package com.demo.kotlin_dsa_practice.solve_problem.array.medium

import kotlin.math.max

/*
https://leetcode.com/problems/container-with-most-water/description/

Imagine two walls with a floor between them —
the water fills up only to the height of the shorter wall,
and the amount of water depends on how far apart those walls are.

So geometrically and physically:
waterArea = height of shorter wall * distance between walls
*/

fun main() {
    var height = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
    var maxArea = findMaxAreaOptimize(height)
    println(maxArea)
}

fun findMaxArea(height: IntArray): Int {
    var maxArea = 0
    for (i in 0 until height.size) {
        for (j in i + 1 until height.size) {
            var height = minOf(height[i], height[j])
            var width = j - i
            var area = height * width
            if (area > maxArea) {
                maxArea = area
            }
        }
    }

    return maxArea
}

fun findMaxAreaOptimize(arr: IntArray): Int {
    var maxArea = 0
    var i = 0
    var j = arr.size - 1

    while (i < j) {
        var height = minOf(arr[i], arr[j])
        var width = j - i
        var area = height * width
        if (area > maxArea) {
            maxArea = area
        }

        if (arr[i] < arr[j]) {
            i++
        } else {
            j--
        }
    }
    return maxArea
}

