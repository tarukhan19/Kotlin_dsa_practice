package com.demo.kotlin_dsa_practice.basic_question_arr

fun main() {
    val arr = intArrayOf(5, 4, 3, 2, 1)
    var reversedArr = reverseArrOptimize(arr)
    println(reversedArr.contentToString())
}

/*
Complexity
Time: O(n) → single loop through the array.
Space: O(n) → because you created a new list of size n
 */

fun reverseArr(arr: IntArray): IntArray {
    var listArr = mutableListOf<Int>()
    for (i in arr.size - 1 downTo 0) {
        listArr.add(arr[i])
    }
    return listArr.toIntArray()
}

/*
Time: O(n) → each element is swapped once.
Space: O(1) → only temp variable used.
 */
fun reverseArrOptimize(arr: IntArray): IntArray {
    var left = 0
    var right = arr.size - 1

    while (left < right) {
        var temp = arr[left]
        arr[left] = arr[right]
        arr[right] = temp
        left++
        right--
    }

    return arr
}
