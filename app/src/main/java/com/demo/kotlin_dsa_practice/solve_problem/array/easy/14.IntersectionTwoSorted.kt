package com.demo.kotlin_dsa_practice.solve_problem.array.easy


fun main() {
    val arr1 = intArrayOf(1, 2, 2, 3, 3, 4, 5, 6)
    val arr2 = intArrayOf(2, 3, 3, 5, 6, 6, 7)

    var intersection = findIntersection1(arr1, arr2)
    println(intersection.contentToString())
}


/*
Output = [2, 3, 3, 5, 6]

It is a Brute Force Approach
Time Complexity: O(n * m) in worst case, where n and m is length of arr1 & arr2
Space Complexity: O(m) for frequency array + O(k) for intersection array

Important: In most algorithm discussions, the space for the output is not counted when talking about auxiliary space.
So auxiliary space = O(m), but total space including the output array = O(m+k).
*/

fun findIntersection(arr1: IntArray, arr2: IntArray): IntArray {
    // Create a frequency array for arr2 to keep track of which elements have already been included in the intersection
    var freq = IntArray(arr2.size)

    // List to store the intersection elements
    var intersectionArr = mutableListOf<Int>()

    // Traverse each element of arr1
    for (i in 0 until arr1.size) {
        // Compare current element of arr1 with each element of arr2
        for (j in 0 until arr2.size) {
            if (arr1[i] == arr2[j] && freq[j] == 0) {
                // If elements match and arr2[j] is not already counted
                intersectionArr.add(arr1[i])
                // Add the element to the intersection
                freq[j] = 1
                // Stop inner loop, move to next element of arr1
                break
            }

            // Optimization: if arr2[j] > arr1[i], we can break early, This assumes arrays are sorted in ascending order
            if (arr2[j] > arr1[i]) {
                break
            }
        }
    }
    return intersectionArr.toIntArray()
}

/*
It is a optimized Two Pointer Approach
Time Complexity = O(n+m)
Space complexity = O(1)

Important: In most algorithm discussions, the space for the output is not counted when talking about auxiliary space.
So auxiliary space = O(1), but total space including the output array = O(k).
 */
fun findIntersection1(arr1: IntArray, arr2: IntArray): IntArray {

    // List to store the intersection elements
    var intersectionArr = mutableListOf<Int>()

    // Initialize two pointers for traversing arr1 and arr2
    var i = 0
    var j = 0

    // Traverse both arrays until one of them is fully processed
    while (i < arr1.size && j < arr2.size) {
        when {
            // Case 1: Current element in arr1 is smaller → move pointer i
            arr1[i] < arr2[j] -> {
                i++
            }

            // Case 2: Current element in arr2 is smaller → move pointer j
            arr2[j] < arr1[i] -> {
                j++
            }

            // Case 3: Elements are equal → add to intersection and move both pointers
            arr2[j] == arr1[i] -> {
                intersectionArr.add(arr1[i])
                j++
                i++
            }
        }
    }

    return intersectionArr.toIntArray()
}
