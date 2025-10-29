package com.demo.kotlin_dsa_practice.solve_problem.array.easy

fun main() {
    var arr = intArrayOf(-1, -100, 3, 99)
    var k = 2

    val step = k % arr.size

    rotate(arr, 0, arr.size - 1)
    rotate(arr, 0, step - 1)
    rotate(arr, step, arr.size - 1)

    println(arr.contentToString())

}

/*
Outer loop runs k times.
Inner loop shifts n elements each time.
Time = O(n × k)
Space = O(1)
 */
fun rotateArr(arr: IntArray, k: Int): IntArray {
    var count = k

    while (count != 0) {
        var temp = arr[arr.size - 1]
        for (j in arr.size - 1 downTo 0) {
            if (j == 0) {
                arr[j] = temp
                break
            }
            arr[j] = arr[j - 1]
        }
        count--
    }
    return arr
}

/*
For right rotation by k:
Reverse the whole array
Reverse the first k elements
Reverse the remaining n - k elements

Rotation by k positions
If k >= n (array size), then k is reduced by modulus.
steps = k % n
Because every n rotations brings the array back to the original.
So rotating by k and rotating by k % n give the same result.
 */

fun rotateArrOptimize(arr: IntArray, k: Int): IntArray {
    val steps = k % arr.size

    var pointer = arr.size - 1
    for (i in 0 until arr.size) {
        if (pointer > i) {
            var temp = arr[pointer]
            arr[pointer] = arr[i]
            arr[i] = temp
            pointer--
        } else break
    }

    pointer = steps - 1
    for (i in 0 until steps) {
        if (pointer > i) {
            var tem = arr[i]
            arr[i] = arr[pointer]
            arr[pointer] = tem
            pointer--
        } else break
    }

    pointer = arr.size - 1
    for (i in steps until arr.size) {
        if (pointer > i) {
            var tem = arr[pointer]
            arr[pointer] = arr[i]
            arr[i] = tem
            pointer--
        } else break
    }
    return arr
}

fun rotate(arr: IntArray, left: Int, right: Int): IntArray {
    var i = left
    var j = right

    while (i < j) {
        var tem = arr[i]
        arr[i] = arr[j]
        arr[j] = tem
        i++
        j--
    }

    return arr
}
