package com.demo.kotlin_dsa_practice.solve_problem.array.easy

fun main() {
    val arr1 = intArrayOf(1, 1, 2, 3, 4, 5)
    val arr2 = intArrayOf(2, 2, 3, 3, 4, 5, 6)

    var union = findUnion1(arr1, arr2)
    println(union.contentToString())
}

/*
 brute force approach
*/
fun findUnion(arr1: IntArray, arr2: IntArray): IntArray {
    var set = mutableSetOf<Int>()
    for (i in 0 until arr1.size) {
        set.add(arr1[i])
    }

    for (j in 0 until arr2.size) {
        set.add(arr2[j])
    }

    return set.toIntArray()
}

/*
Optimal Approach => Two Pointer
output = 1,2,3,4,5,6

Time complexity = O(n+m)
Space complexity = O(n+m)

where n and m is length of array

⏱ Time Complexity

You traverse arr1 once (O(n))
You traverse arr2 once (O(m))
The while loops at the end just finish the leftover elements → at most O(n) or O(m) more.
Total = O(n + m) ✅

💾 Space Complexity

You store the union in unionArr.
In the worst case (no duplicates at all), the union will have n + m elements.
No extra data structures besides that.
Total = O(n + m) ✅
 */
fun findUnion1(arr1: IntArray, arr2: IntArray): IntArray {
    // Initialize a list to store the union of both arrays
    var unionArr = mutableListOf<Int>()

    // Initialize two pointers for traversing arr1 and arr2
    var i = 0
    var j = 0

    // Traverse both arrays until one of them is fully processed
    while (i < arr1.size && j < arr2.size) {
        when {
            // Case 1: Current element in arr1 is smaller
            arr1[i] < arr2[j] -> {
                // Add element to unionArr if it's not a duplicate
                if (unionArr.isEmpty() || unionArr.last() != arr1[i]) {
                    unionArr.add(arr1[i])
                }
                i++
            }

            // Case 2: Current element in arr2 is smaller
            arr2[j] < arr1[i] -> {
                // Add element to unionArr if it's not a duplicate
                if (unionArr.isEmpty() || unionArr.last() != arr2[j]) {
                    unionArr.add(arr2[j])
                }
                j++
            }

            // Case 3: Elements are equal in both arrays
            arr1[i] == arr2[j] -> {
                // Add element once to avoid duplicates
                if (unionArr.isEmpty() || unionArr.last() != arr1[i]) {
                    unionArr.add(arr1[i])
                }
                i++
                j++
            }
        }
    }

    // Add remaining elements from arr1 (if any)
    while (i < arr1.size) {
        if (unionArr.isEmpty() || unionArr.last() != arr1[i]) {
            unionArr.add(arr1[i])
        }
        i++
    }

    // Add remaining elements from arr2 (if any)
    while (j < arr2.size) {
        if (unionArr.isEmpty() || unionArr.last() != arr2[j]) {
            unionArr.add(arr2[j])
        }
        j++
    }

    // Convert mutable list to IntArray and return
    return unionArr.toIntArray()
}