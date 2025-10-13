package com.demo.kotlin_dsa_practice.solve_problem.string.easy

fun main() {
    var str = "  hello world  "

    var result = reverseWords2(str)
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

// it will not remove the extra space
fun reverseWords1(s: String): String {
    val arr = s.toCharArray()

    // Step 1: Reverse the whole array
    reverse(arr, 0, arr.size - 1)

    var i = 0
    while (i < arr.size) {

        while (i < arr.size && arr[i] == ' ') {
            i++
        }
        if (i >= arr.size) break

        var start = i
        while (i < arr.size && arr[i] != ' ') {
            i++
        }
        var end = i - 1

        // Reverse the word
        reverse(arr, start, end)
    }
    return String(arr)
}

/*
Time	O(n)
Space	O(1)

// it will remove the extra space

 */

fun reverseWords2(s: String): String {
    val arr = s.toCharArray()

    // Reverse the whole array
    reverse(arr, 0, arr.size - 1)

    var i = 0
    var write = 0

    while (i < arr.size) {

        while (i < arr.size && arr[i] == ' ') {
            i++
        }
        if (i >= arr.size) break

        var start = i
        while (i < arr.size && arr[i] != ' ') {
            i++
        }
        var end = i - 1

        // Reverse the word
        reverse(arr, start, end)

        // Copy word to write pointer
        for (j in start..end) {
            arr[write] = arr[j]
            write++
        }
        // Skip extra spaces
        while (i < arr.size && arr[i] == ' ') i++

        // Add single space if more words ahead
        if (i < arr.size) {
            arr[write] = ' '
            write++
        }


    }
    return String(arr, 0, write)
}


// Reverse a section [start, end)
fun reverse(arr: CharArray, start: Int, end: Int) {
    var i = start
    var j = end
    while (i < j) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
        i++
        j--
    }
}

