package com.demo.kotlin_dsa_practice.stack

import java.util.Stack

fun main() {
    var s = "abbaca"  //ca
    var index = removeDuplicate3(s)
    println(index)
}


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