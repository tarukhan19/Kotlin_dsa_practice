package com.demo.kotlin_dsa_practice.solve_problem.string.easy

fun main() {
    var str = " a   good "
    var result = reverseWordsInPlace(str)
    println(result)
}

/*
Time	O(n)
Space	O(n)
 */
fun reverseString(str: String): String {
    var strBuilder = StringBuilder()
    var list = arrayListOf<String>()
    var i = 0
    var n = str.length

    while (i < n) {
        if (str[i] != ' ') {
            strBuilder.append(str[i])
        } else {
            if (strBuilder.isNotEmpty()) {
                list.add(strBuilder.toString())
                strBuilder = StringBuilder()
            }
        }
        i++
    }
    if (strBuilder.isNotEmpty()) {
        list.add(strBuilder.toString())
        strBuilder = StringBuilder()
    }

    for (i in list.size - 1 downTo 0) {
        strBuilder.append(list[i])
        if (i != 0) strBuilder.append(" ")

    }

    return strBuilder.toString()
}

/*
Time	O(n)
Space	O(1)
 */
fun reverseWordsInPlace(s: String): String {
    val arr = s.toCharArray()
    val n = arr.size

    // Step 1: Reverse the whole array
    reverse(arr, 0, n)

    var write = 0
    var read = 0

    while (read < n) {
        if (arr[read] != ' ') {
            val startWrite = write

            // Copy word to write position
            while (read < n && arr[read] != ' ') {
                arr[write++] = arr[read++]
            }

            // Reverse the word
            reverse(arr, startWrite, write)

            // Skip spaces in read
            while (read < n && arr[read] == ' ') read++

            // Add single space if more words ahead
            if (read < n) arr[write++] = ' '
        } else {
            read++
        }
    }

    return String(arr, 0, write)
}

// Reverse a section [start, end)
fun reverse(arr: CharArray, start: Int, end: Int) {
    var i = start
    var j = end - 1
    while (i < j) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
        i++
        j--
    }
}



