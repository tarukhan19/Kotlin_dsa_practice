package com.demo.kotlin_dsa_practice.solve_problem.array.medium

fun main() {
    var numArr = intArrayOf(-1, 2, 3, 4, -3, 1)
    var output = arrangeArr3(numArr)
    println(output.contentToString())
}

/*
Time Complexity = O(N) + O(N/2) = O(N)
Space Complexity = O(N)
 */
fun arrangeArr(arr: IntArray): IntArray {
    var posArr = mutableListOf<Int>()
    var negArr = mutableListOf<Int>()

    for (i in 0 until arr.size) {
        if (arr[i] > 0) {
            posArr.add(arr[i])
        } else {
            negArr.add(arr[i])
        }
    }

    for (i in 0 until arr.size / 2) {
        arr[2 * i] = posArr[i]
        arr[(2 * i) + 1] = negArr[i]
    }
    return arr
}

/*
Time Complexity = O(N)
Space Complexity = O(N)
 */
fun arrangeArr1(arr: IntArray): IntArray {
    var posInd = 0
    var negInd = 1
    var ansArr = IntArray(arr.size)

    for (i in 0 until arr.size) {
        if (arr[i] > 0) {
            ansArr[posInd] = arr[i]
            posInd += 2
        } else {
            ansArr[negInd] = arr[i]
            negInd += 2
        }
    }

    return ansArr
}

/*
https://www.youtube.com/watch?v=h4aBagy4Uok
Time Complexity

Splitting into posArr & negArr
Loop over the array once → O(n).
Arranging alternately
First loop (up to min(posArr.size, negArr.size)) → O(min(p, q)), but that’s ≤ O(n).
Second loop (append leftovers) → O(|p - q|), again ≤ O(n).

👉 Total = O(n).

Space Complexity

We store positives in posArr and negatives in negArr.
Together, they hold all elements once → O(n) extra space.
The arrangement happens in-place on the original array, so no additional big structures.

👉 Total = O(n) auxiliary space.
 */
fun arrangeArr3(arr: IntArray): IntArray {
    var posArr = mutableListOf<Int>()
    var negArr = mutableListOf<Int>()

    for (i in 0 until arr.size) {
        if (arr[i] > 0) {
            posArr.add(arr[i])
        } else {
            negArr.add(arr[i])
        }
    }

    if (posArr.size > negArr.size) {
        for (i in 0 until negArr.size) {
            arr[2 * i] = posArr[i]
            arr[(2 * i) + 1] = negArr[i]
        }
        var startInd = negArr.size * 2
        for (j in negArr.size until posArr.size) {
            arr[startInd] = posArr[j]
            startInd++
        }
    } else {
        for (i in 0 until posArr.size) {
            arr[2 * i] = posArr[i]
            arr[(2 * i) + 1] = negArr[i]
        }
        var startInd = posArr.size * 2
        for (j in posArr.size until negArr.size) {
            arr[startInd] = negArr[j]
            startInd++
        }

    }

    return arr

}
