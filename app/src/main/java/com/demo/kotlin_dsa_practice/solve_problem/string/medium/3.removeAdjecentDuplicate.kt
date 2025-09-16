package com.demo.kotlin_dsa_practice.solve_problem.string.medium

import java.util.Stack

fun main() {
    var s = "abbaca"  //ca
    var index = removeAdjacentDuplicate1(s)
    println(index)
}

/*
Worst case:
O(n²) (string rebuild each pass).
Space: O(n) for StringBuilder.
 */
fun removeAdjacentDuplicate(str1: String): String {
    var s = str1
    var isChanged = true
    while (isChanged) {
        isChanged = false
        var strBuilder = StringBuilder()
        var i = 0

        while (i < s.length) {
            if (i < s.length - 1 && s[i] == s[i + 1]) {
                i = i + 2
                isChanged = true
            } else {
                strBuilder.append(s[i])
                i++
            }
        }
        s = strBuilder.toString()
    }

    return s
}

/*
🔹 Time Complexity

Looping You scan from left to right.

Each time you find a duplicate, you call removeRange.
Since Kotlin strings are immutable, this creates a new string.
Copying characters takes O(n) time.

Worst case scenario
Input: "aaaaaaaa..." (all same characters).
Each removal deletes 2 characters, but costs O(n).
About n/2 removals happen.

Total cost: O(n/2 × n) = O(n²).

✅ Time Complexity = O(n²) in the worst case.


🔹 Space Complexity

Each removeRange creates a new string of size O(n).
But you don’t store multiple copies at the same time — only the latest one.
Extra memory aside from the string itself is constant.

✅ Space Complexity = O(n)
*/


fun removeAdjacentDuplicate1(str: String): String {
    var s = str
    var i = 0
    while (i < s.length - 1) {
        if (s[i] == s[i+1])
        {
            s = s.removeRange(i, i+2)
            i = 0
        }
        else {
            i++
        }
    }
    return s
}

// we can solve it using stack more efficiently

fun removeAdjacentDuplicate2(str: String): String {

    var strStack = StringBuilder()

    for (ch in str) {
        if (strStack.isNotEmpty() && strStack.last() == ch) {
            strStack.deleteCharAt(strStack.lastIndex)
        } else {
            strStack.append(ch)
        }
    }
    return strStack.toString()
}

fun removeDuplicate3(str: String) : String{
    var stack = Stack<Char> ()

    for (char in str) {
        if (stack.isNotEmpty() && stack.peek() == char) {
            stack.pop()
        } else {
            stack.push(char)
        }
    }
    return stack.toString()
}