package com.demo.kotlin_dsa_practice.twoSum.unsortedArr

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
fun main() {
    hashMapApproach()
}

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


