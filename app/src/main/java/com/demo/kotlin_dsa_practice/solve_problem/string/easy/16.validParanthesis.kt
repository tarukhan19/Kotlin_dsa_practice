package com.demo.kotlin_dsa_practice.solve_problem.string.easy

import java.util.Stack
fun main() {
    var str = "()[{}"
    var result = isValid(str)
    println(result)
}
fun isValid(s: String): Boolean {
    val stack = Stack<Char>();
    for (c in s.toCharArray()) {

        if (c == '(')
            stack.push(')')
        else if (c == '{')
            stack.push('}')
        else if (c == '[')
            stack.push(']')
        else if (stack.isEmpty() || stack.pop() != c) {
            return false
        }

    }
    return stack.isEmpty()

}