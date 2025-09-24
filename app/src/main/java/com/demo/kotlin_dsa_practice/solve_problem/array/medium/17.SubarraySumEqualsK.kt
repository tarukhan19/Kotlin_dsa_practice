package com.demo.kotlin_dsa_practice.solve_problem.array.medium

/*
PREFIX SUM
https://www.youtube.com/watch?v=KDH4mhFVvHw

https://leetcode.com/problems/subarray-sum-equals-k/description/
 */
fun main() {
    var numArr = intArrayOf(9, 4, 0, 20, 3, 10, 15)
    var k = 33
    var output = subArrSumEqualK1(numArr, k)
    println(output)
}

/*
TC= O(n^2)
SC = O(1)
 */
fun subArrSumEqualK(nums: IntArray, k: Int): Int {
    var subArrCount = 0
    for (i in 0 until nums.size) {
        var sum = 0
        for (j in i until nums.size) {
            sum += nums[j]
            if (sum == k) {
                subArrCount++
            }
        }
    }
    return subArrCount
}

/*
TC= O(n)
SC = O(1)
 */
fun subArrSumEqualK1(nums: IntArray, k: Int): Int {
    var subArrCount = 0
    var map = mutableMapOf<Int, Int>() // stores prefixSum → frequency

    // Step 1: Convert nums[] into prefixSum array
    var sum = 0
//    for (i in 0 until nums.size) {
//       sum +=  nums[i]
//       nums[i] = sum   // overwrite nums with prefix sum
//    }


    // Step 2: Iterate over prefix sums to count valid subarrays
    for (j in 0 until nums.size) {

        sum +=  nums[j]
        // Case 1: Subarray starts from index 0
        if (sum == k) {
            subArrCount++
        }

        /*
         Case 2: // 👉 Why check this?
         nums[i] is the current prefix sum = sum of elements from index 0..i
         We want a subarray ending at i that has sum = k
         Formula: subarraySum(j..i) = prefix[i] - prefix[j-1]
         Rearranged: prefix[j-1] = prefix[i] - k
         → So if (prefix[i] - k) exists in map, then a subarray sum = k is found
         */

        var elem = sum - k

        if (map.containsKey(elem)) {
            /*
              map[diff] gives how many times prefix[j-1] = diff has appeared so far
              Each occurrence corresponds to one valid subarray ending at i
             */
            subArrCount += map[elem] ?: 0
        }
        // Store/update current prefixSum frequency
        map[sum] = map.getOrDefault(sum, 0) + 1

    }
    return subArrCount
}