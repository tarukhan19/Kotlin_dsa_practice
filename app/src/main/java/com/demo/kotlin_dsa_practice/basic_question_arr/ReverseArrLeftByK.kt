package com.demo.kotlin_dsa_practice.basic_question_arr

fun main() {
    var arr = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    var k = 3
    var newArr = rotateArrLeftOptimize(arr, k)
    println(newArr.contentToString())
}

// 7654 321
// 4567 123

fun rotateArrLeft(arr: IntArray, k: Int): IntArray {
    var count = k
    while (count != 0) {
        var temp = arr[0]
        for (i in 0 until arr.size) {
            if (i == arr.size - 1) {
                arr[i] = temp
                break
            }
            arr[i] = arr[i + 1]
        }
        count--
    }

    return arr
}

/*
For left rotation by k:

Reverse the whole array
Reverse the first n - k elements
Reverse the last k elements

Rotation by k positions
If k >= n (array size), then k is reduced by modulus.
steps = k % n
Because every n rotations brings the array back to the original.
So rotating by k and rotating by k % n give the same result.
 */

fun rotateArrLeftOptimize(arr: IntArray, k: Int): IntArray {
    var steps = k % arr.size

    var pointer = arr.size - 1
    for (i in 0 until arr.size) {
        if (i < pointer) {
            var temp = arr[pointer]
            arr[pointer] = arr[i]
            arr[i] = temp
            pointer--
        } else {
            break
        }
    }

    pointer = arr.size - steps - 1
    for (i in 0 until arr.size - steps) {
        if (i < pointer) {
            var temp = arr[pointer]
            arr[pointer] = arr[i]
            arr[i] = temp
            pointer--
        } else {
            break
        }
    }

    pointer = arr.size - 1
    for (i in arr.size - steps until arr.size) {
        if (i < pointer) {
            var temp = arr[pointer]
            arr[pointer] = arr[i]
            arr[i] = temp
            pointer--
        } else {
            break
        }
    }
    return arr
}
