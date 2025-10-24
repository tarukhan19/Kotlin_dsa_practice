package com.demo.kotlin_dsa_practice.solve_problem.linkedList.easy.singlyLinkedList

import com.demo.kotlin_dsa_practice.solve_problem.linkedList.Node

fun main() {
    var arr = intArrayOf(1, 3, 4, 5, 6, 8)
    var node = convertLl(arr)
    println(node)

    var isFind = isNodeAvailable(node, 16)
    println(isFind)
}

// TC = O(N)
fun isNodeAvailable(head: Node?, elem: Int): Boolean {
    var current  = head

    while (current != null) {
        if (current.data == elem) return true
        current = current.next
    }

    return false
}

fun convertLl(arr: IntArray): Node {
    var head = Node(arr[0])
    var current = head

    for (i in 1 until arr.size) {
        var node = Node(arr[i])
        current.next = node
        current = node
    }

    return head
}
