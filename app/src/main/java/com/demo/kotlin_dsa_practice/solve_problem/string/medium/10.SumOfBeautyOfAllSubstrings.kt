package com.demo.kotlin_dsa_practice.solve_problem.string.medium

fun main() {
    var str = "aabcb"
    var result = findBeautySum1(str)
    println(result)
}
/*
Total time complexity: O(n³)
Auxiliary space complexity: O(n)
 */
fun findBeautySum(str: String): Int {
    var result = 0

    for (i in 0 until str.length) {
        for (j in i until str.length) {
            var hashmap = mutableMapOf<Char, Int>()

            var subString = str.substring(i, j + 1)
            if (subString.length >= 3) {
                println(subString)

                for (ch in subString) {
                    hashmap[ch] = hashmap.getOrDefault(ch, 0) + 1
                }

                var diff = (hashmap.values.maxOrNull() ?: 0) - (hashmap.values.minOrNull() ?: 0)

                result += diff

            }
        }
    }

    return result
}

/*
Time: O(n²)
Space: O(1)
 */
fun findBeautySum1(str: String): Int {
    var result = 0

    for (i in 0 until str.length) {
        var freq = IntArray(26)

        for (j in i until str.length) {
            // ascii value a-z --> 97 - 122
            val index = str[j] - 'a'
            freq[index]++
            println(freq.contentToString())
            if (j - i + 1 >= 3) {
               var maxVal = freq.maxOrNull() ?: 0
               var minValue = freq.filter { it > 0 }.minOrNull() ?: 0

                var diff = maxVal - minValue

                result += diff

            }
        }
    }

    return result
}
