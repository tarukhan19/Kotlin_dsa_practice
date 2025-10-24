package com.demo.kotlin_dsa_practice.solve_problem.linkedList.easy.singlyLinkedList

import com.demo.kotlin_dsa_practice.solve_problem.linkedList.Node

fun main() {
    var arr = intArrayOf(2, 3, 4, 5, 6)
    var head = convertArrToLl(arr)
    println(head)
    println(countHead(head))
}

fun convertArrToLl(arr: IntArray) : Node {

    var head = Node(arr[0])
    var current = head

    for (i in 1 until arr.size) {
        var node = Node(arr[i])
        current.next = node
        current = node
    }

    return head
}

// TC = O(N)
fun countHead(head : Node?) : Int {
    var count  = 0
    var current = head

    while (current != null) {
        count++
        current = current.next
    }
    return count
}

