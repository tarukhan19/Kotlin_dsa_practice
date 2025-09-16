package com.demo.kotlin_dsa_practice.solve_problem.string.medium

fun main() {
    var str1 = "list"
    var str2 = "slit"
    var isAnagram = findAnagram3(str1, str2)
    println(isAnagram)
}

fun findAnagram(str1: String, str2: String): Boolean {
    if (str1.length != str2.length) {
        return false
    }
    var hashmap1 = HashMap<Char, Int>()
    var hashmap2 = HashMap<Char, Int>()

    for (char1 in str1) {
        var count = 0
        for (j in 0 until str1.length) {
            if (char1 == str1[j]) {
                count++
            }
        }
        hashmap1.put(char1, count)
    }

    for (char2 in str2) {
        var count = 0
        for (j in 0 until str2.length) {
            if (char2 == str2[j]) {
                count++
            }
        }
        hashmap2.put(char2, count)
    }

    return hashmap1 == hashmap2
}

fun findAnagram1(str1: String, str2: String): Boolean {
    if (str1.length != str2.length) {
        return false
    }

    var hashmap1 = HashMap<Char, Int>()
    var hashmap2 = HashMap<Char, Int>()

    for (char1 in str1) {
        hashmap1[char1] = hashmap1.getOrDefault(char1, 0) + 1
    }

    for (char2 in str2) {
        hashmap2[char2] = hashmap2.getOrDefault(char2, 0) + 1
    }

    return hashmap1 == hashmap2
}

/*
Use IntArray(size) when you know the size first, and will fill values later.
Use intArrayOf(...) when you know the values upfront.

str1[i] - 'a'
we’re doing character arithmetic:
Example:
If str1[i] = 'a' → 'a' - 'a' = 97 - 97 = 0
If str1[i] = 'b' → 'b' - 'a' = 98 - 97 = 1
If str1[i] = 'z' → 'z' - 'a' = 122 - 97 = 25

Time Complexity: O(n)
Space Complexity: O(1)
 */
fun findAnagram2(str1: String, str2: String): Boolean {
    if (str1.length != str2.length) {
        return false
    }

    var freq = IntArray(26)
    for (i in str1.indices) {

        var index1 = str1[i] - 'a'
        var index2 = str2[i] - 'a'

        freq[index1] = freq[index1] + 1
        freq[index2] = freq[index2] - 1

    }

    for (count in freq) {
        if (count != 0) return false
    }

    return true
}


//sorting
fun findAnagram3(str1: String, str2: String): Boolean {
    if (str1.length != str2.length) {
        return false
    }
    var asciiArr1 = IntArray(str1.length)
    var asciiArr2 = IntArray(str2.length)

    var pointer = 0

    for (char1 in str1) {
        var ascii = char1.code
        asciiArr1[pointer] = ascii
        pointer++
    }

    for (i in 0 until asciiArr1.size - 1) {
        for (j in i + 1 until asciiArr1.size) {
            if (asciiArr1[i] < asciiArr1[j]) {
                var temp = asciiArr1[i]
                asciiArr1[i] = asciiArr1[j]
                asciiArr1[j] = temp
            }
        }
    }

    pointer = 0
    for (char2 in str2) {
        var ascii = char2.code
        asciiArr2[pointer] = ascii
        pointer++
    }

    for (i in 0 until asciiArr2.size-1) {
        for (j in i + 1 until asciiArr2.size) {
            if (asciiArr2[i] < asciiArr2[j]) {
                var temp = asciiArr2[j]
                asciiArr2[j] = asciiArr2[i]
                asciiArr2[i] = temp
            }
        }
    }

    return asciiArr1.joinToString("") == asciiArr2.joinToString("")
}
