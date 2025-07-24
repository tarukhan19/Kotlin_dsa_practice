package com.demo.kotlin_dsa_practice.twoSum.unsortedArr

/*

📌 Approach: Brute Force (Nested Loops)
🧠 Core Idea:
Try every possible pair of elements.

If their sum equals the target, return their indices.
Guaranteed only one solution exists, and the same element cannot be used twice.

📘 Loop Explanation:
✅ Outer loop: for (i in 0 until len - 1)
i goes from index 0 to len - 2.
We exclude the last index because there’s no j > i left to pair with it.

✅ Inner loop: for (j in i + 1 until len)
j starts from the next index after i and goes up to len - 1.
Ensures we don’t reuse the same element, and no duplicate pairs (like (0,1) and (1,0)).

❓ Why until len - 1 for i?
When i = len - 1, j = i + 1 = len  —> which is out of bounds.
No valid pair can be formed for the last index.
So, we avoid looping over it.

🧠 Memory Tip:
When forming all pairs (i, j) with j > i, stop i at len - 2,
because the last element has no next element to pair with.


🕒 Time Complexity: O(n²)
Outer loop runs from i = 0 to n - 2 → up to n - 1 times
Inner loop runs from j = i + 1 to n - 1 → decreasing range

So the total comparisons:
(n - 1) + (n - 2) + (n - 3) + ... + 1 = n(n - 1)/2
This is O(n²) in Big-O notation.

✅ Brute-force = Check all possible pairs → Quadratic time.

💾 Space Complexity: O(1)
You are not using any extra data structure like a HashMap or List.

Only a fixed-size array (intArrayOf(i, j)) is returned → constant space.
✅ You only store two indices → constant extra space
*/

fun main() {
    bruteForceApproach()
}

fun bruteForceApproach(): IntArray? {

    val arr = intArrayOf(2,7,11,15)
    val target = 9

    val len = arr.size

    for (i in 0 until len - 1) {
        for (j in i+1 until len) {
            val sum = arr[i] + arr[j]

            if (sum == target) {
                val result = intArrayOf(i, j)
                println("i = $i  ---- j = $j")
                return result
            }
        }
    }

    return null
}