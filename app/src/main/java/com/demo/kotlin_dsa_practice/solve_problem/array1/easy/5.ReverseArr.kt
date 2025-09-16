package com.demo.kotlin_dsa_practice.solve_problem.array1.easy

fun main() {
    val arr = intArrayOf(5, 4, 3, 2, 1)
//    var reversedArr = reverseArrOptimize(arr)
//    println(reversedArr.contentToString())

    var strArr = charArrayOf('h', 'e', 'l', 'l', 'o')
    var reversedStrArr = reverseArr(strArr)
    println(reversedStrArr)
}


/*
Complexity
Time: O(n) → single loop through the array.
Space: O(n) → because you created a new list of size n
 */

fun reverseArr(arr: CharArray): CharArray {
    var right = arr.size - 1
    var left = 0
    while (left < right) {
        val temp = arr[right]
        arr[right] = arr[left]
        arr[left] = temp
        right--
        left++
    }

    return arr
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
