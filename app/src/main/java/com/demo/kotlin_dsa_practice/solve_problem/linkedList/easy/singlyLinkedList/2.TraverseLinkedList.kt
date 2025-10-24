package com.demo.kotlin_dsa_practice.solve_problem.linkedList.easy.singlyLinkedList

import com.demo.kotlin_dsa_practice.solve_problem.linkedList.Node

fun main() {
    var arr = intArrayOf(3, 2, 5, 6, 7)
    var head = convert(arr)

    traverse(head)
}

// // TC = O(N)
fun traverse(head : Node?){
    var temp = head
    println(temp)

    while (temp != null) {
        print("${temp.data}  ")
        temp = temp.next
    }
}

fun convert(arr: IntArray): Node? {
    if (arr.isEmpty()) {
        return null
    }

    var head = Node(arr[0])
    var current = head

    for (i in 1 until arr.size) {
        var node = Node(arr[i])
        current.next = node
        current = node
    }

    return head
}
