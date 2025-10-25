package com.demo.kotlin_dsa_practice.solve_problem.linkedList.easy.singlyLinkedList

/*
Linked List is a linear data structure that can be visualized as a chain with different nodes connected,
where each node represents a different element. The difference between arrays and linked lists is that,
unlike arrays, the elements are not stored at a contiguous location.

A linked list is a data structure containing two crucial pieces of information, the first being the data
and the other being the pointer to the next element.

The ‘head’ is the first node, and the ‘tail’ is the last node in a linked list.

A singly linked list (SLL) is a linear data structure where elements, called nodes, are connected in one direction only.
Each node has two parts:
Data – stores the actual value (e.g., integer, string, object).
Next – a reference (or pointer) to the next node in the list. The last node points to null.


| Step  | i   | newNode = Node(arr[i]) | current.next = newNode | current becomes | Linked List Now                   |
|-------|-----|--------------------------|--------------------------|-----------------|-----------------------------------|
| Start |  -  | -                       | -                       | current = 1     | 1 -> null                         |
| 1     | 1   | Node(3)                 | 1.next = 3              | current = 3     | 1 -> 3 -> null                    |
| 2     | 2   | Node(4)                 | 3.next = 4              | current = 4     | 1 -> 3 -> 4 -> null               |
| 3     | 3   | Node(5)                 | 4.next = 5              | current = 5     | 1 -> 3 -> 4 -> 5 -> null          |
| 4     | 4   | Node(6)                 | 5.next = 6              | current = 6     | 1 -> 3 -> 4 -> 5 -> 6 -> null     |

 */
fun main() {
    var arr = intArrayOf(1, 3, 4, 5, 6)
    var head = arrToLinkedList(arr)
    println(head)
}

/*
Converts the array into a singly linked list and returns the head node (or null for empty arrays).
 */
fun arrToLinkedList(arr: IntArray): Node? {
    if (arr.isEmpty()) {
        return null
    }
    /*
    Create the first node with the first array element and call it head.
    current is a pointer used to append new nodes; it initially points to head.
    */
    var head = Node(arr[0])
    var current = head

    /*
    For each element:

    Create a new Node holding that element.
    Link it to the list by setting current.next = newNode.
    Move current forward to newNode so future nodes get appended after it.
     */
    for (i in 1 until arr.size) {
        var newNode = Node(arr[i]) // Create a new node
        current.next = newNode // Link current node to new node / Attach new node to the chain
        current = newNode // Move 'current' to the new node / Move current pointer forward to continue building
    }
    return head
}
