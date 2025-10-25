package com.demo.kotlin_dsa_practice.solve_problem.linkedList.easy.singlyLinkedList

/*
https://www.youtube.com/watch?v=VaECK03Dz-g&t=928s
 */
fun main() {
    var arr = intArrayOf(1, 2, 4, 6, 7, 9)
    var head: Node? = conArrToLl(arr)
    println(head)

    head = deleteAnyNodeByValue(head, 9)
    println(head)
}

fun conArrToLl(arr: IntArray): Node {
    var head = Node(arr[0])
    var current = head

    for (i in 1 until arr.size) {
        var node = Node(arr[i])
        current.next = node
        current = node
    }
    return head
}

// if head need to be deleted
fun deleteHead(head: Node?): Node? {
    if (head == null) {
        return head
    }
    return head.next
}

// if tail need to be deleted
fun deleteTail(head: Node?): Node? {
    if (head == null || head.next == null) {
        return null
    }

    var temp = head
    while (temp?.next?.next != null) {
        temp = temp.next
    }
    temp?.next = null
    return head
}

//if position is given as k to delete
fun deleteAnyNodeByPosition(head: Node?, k: Int): Node? {
    var temp = head

    if (temp == null) {
        return null
    }

    if (k == 1) {
        return temp.next
    }

    var prev: Node? = null
    var count = 0
    while (temp != null) {
        count++
        if (count == k) {
            prev?.next = prev.next?.next
            return head
        }

        prev = temp
        temp = temp.next
    }

    return head
}

//if elem is given to delete
fun deleteAnyNodeByValue(head: Node?, elem: Int): Node? {
    var temp = head
    if (head == null) {
        return null
    }

    if (head.data == elem) {
        return head.next
    }

    var prev: Node? = null
    while (temp != null) {
        if (temp.data == elem) {
            prev?.next = prev.next?.next
            return head
        }
        prev = temp
        temp = temp.next
    }

    return head
}
