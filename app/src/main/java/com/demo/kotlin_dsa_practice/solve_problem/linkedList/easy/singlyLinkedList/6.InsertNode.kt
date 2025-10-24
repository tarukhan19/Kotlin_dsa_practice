package com.demo.kotlin_dsa_practice.solve_problem.linkedList.easy.singlyLinkedList

import com.demo.kotlin_dsa_practice.solve_problem.linkedList.Node

fun main() {
    var arr = intArrayOf(2, 3, 4, 6, 7, 9)
    var head: Node? = arrToLL(arr)

    head = insertBeforeValue(head, 100, null)
    println(head)
}

fun arrToLL(arr: IntArray): Node {
    var head = Node(arr[0])
    var current = head

    for (i in 1 until arr.size) {
        var node = Node(arr[i])
        current.next = node
        current = node
    }

    return head
}

fun insertAtBeginning(head: Node?, newData: Int): Node {
    val newNode = Node(newData, head)
    return newNode
}

fun insertAtEnd(head: Node?, newData: Int): Node? {
    if (head == null) {
        return Node(newData)
    }
    var temp = head

    while (temp?.next != null) {
        temp = temp.next
    }

    temp?.next = Node(newData)
    return head
}

fun insertAtPosition(head: Node?, newData: Int, pos: Int): Node? {
    if (head == null || pos == 1) {
        return Node(newData, head)
    }

    var count = 0
    var temp = head

    while (temp != null) {
        count++

        if (count == pos - 1) {
            var node = Node(newData)
            node.next = temp.next
            temp.next = node
            break

        }
        temp = temp.next
    }

    return head
}

fun insertBeforeValue(head: Node?, elem: Int, beforeVal: Int?): Node? {
    if (beforeVal == head?.data) {
        return Node(elem, head)
    }

    var temp = head
    while (temp != null) {
        if (temp.next?.data == beforeVal) {
            var node = Node(elem)
            node.next = temp.next
            temp.next = node
            break
        }
        temp = temp.next
    }
    return head
}