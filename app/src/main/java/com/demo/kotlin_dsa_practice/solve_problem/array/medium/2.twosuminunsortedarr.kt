package com.demo.kotlin_dsa_practice.solve_problem.array.medium

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
    hashMapApproach()
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


/*
Now that we know what a hashmap is we can use one to solve our problem.

Traverse the list once.
--define an empty hashmap
--For each element:
  compute the difference: diff = target - currentElement.
  check if diff already exists in the map as a key.
--If yes → that means: diff + currentElement = target
  return their indices.
--If not → store the current element in the map as: arr[i] → i
--If loop ends with no match → return null.

"I'm using a HashMap-based approach to optimize the search.
Instead of checking every possible pair (which takes O(n²)),
I use a HashMap to store elements as I iterate, so I can check if the complement exists in O(1) time."

--We store arr[i] as the key in the HashMap so we can check for the complement in O(1) time using containsKey(diff).”

Since HashMap keys provide O(1) lookup, storing numbers as keys allows me to check for the complement
in constant time using map.containsKey(complement).

If I stored the number as a value instead of a key, I'd have to loop through all the values to find  the complement
, which would take O(n) time and defeat the purpose of optimization.”
if (map.values.contains(complement))  // ❌ O(n)

 */

fun hashMapApproach() : IntArray? {
    val arr = intArrayOf(3,2,4)
    val target = 6

    //"I initialize a mutable map to store element → index pairs as I traverse the array."
    var arrHashMap = mutableMapOf<Int, Int>()

    // "I loop through each index of the array. For every number, I calculate the difference between
    // the target and the current number — that's the number I need to find in the map."
    for (i in arr.indices) {
        println("i = $i -- target = $target -- indices = ${arr.indices}")

        val complement = target - arr[i]
        println("complement = $complement")

        if (arrHashMap.containsKey(complement)) {
            println("result = ${arrHashMap[complement]!!} , $i")
            return intArrayOf(arrHashMap[complement]!!, i)
        }
        arrHashMap[arr[i]] = i
        println("arrHashMap = ${arr[i]} --- i = $i")
        println()

    }
    return  null
}
