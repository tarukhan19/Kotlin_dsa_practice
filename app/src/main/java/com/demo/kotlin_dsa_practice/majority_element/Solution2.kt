package com.demo.kotlin_dsa_practice.majority_element


/*
Boyer-Moore Majority Voting Algorithm
O(n) time and O(1) space


Step 1: Brute Force (show you start simple)
"The simplest approach is brute force — pick each element and count how many times it occurs. If its count is more than n/2, return it. This works, but it’s O(n²), so not efficient for large arrays."

Step 2: Improve with HashMap / Sorting (show optimization mindset)
"We can improve this with a HashMap to count frequencies in O(n), though it uses extra space. Another approach is sorting — since the majority element appears more than n/2 times, the middle element after sorting will always be the majority. That’s O(n log n)."

Step 3: Optimal Solution — Boyer–Moore Voting (show depth & confidence)
"The most optimal approach is the Boyer–Moore Voting Algorithm. It works in O(n) time and O(1) space. The intuition is that we ‘cancel out’ pairs of different elements. Since the majority element appears more than half the time, it can’t be fully canceled and will remain as the final candidate."

Step 4: Wrap-up (show clarity)
"So, in short: brute force is O(n²), HashMap or sorting brings it down to O(n) or O(n log n), and the Boyer–Moore Voting Algorithm is optimal at O(n) time and O(1) space."
 */

fun main() {
    var numArr = intArrayOf(3,2,3)
    val majorityElm = optimizeMajorityElement(numArr)
    println(majorityElm)
}

fun optimizeMajorityElement(numArr: IntArray): Int {
    var majorityElem = numArr[0]
    var count = 0

    if (numArr.size == 1) {
        return numArr[0]
    }

    for (i in 0 until numArr.size) {
        if (count == 0) {
            majorityElem = numArr[i]
        }

        if (majorityElem == numArr[i]) {
            count++
        } else {
            count--
        }

    }

    return majorityElem
}
