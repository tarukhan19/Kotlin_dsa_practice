package com.demo.kotlin_dsa_practice.solve_problem.linkedList.easy.singlyLinkedList

fun main() {
    var arr = intArrayOf(2, 3, 4, 5, 7)
    var node = convertArrToLL(arr)
    println(node)
    println(findTail(node))
}


fun convertArrToLL(arr: IntArray): Node {
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
fun findTail(node: Node?): Node? {
    var current = node
    while (current?.next != null) {
        current = current.next
    }
    return current
}
