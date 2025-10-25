package com.demo.kotlin_dsa_practice.solve_problem.linkedList.easy.singlyLinkedList


/*
data: Int — stores the integer value inside this node.
next: Node? — a nullable reference to the next node in the list. null means end of list.
*/

data class Node(
    var data: Int,
    var next: Node? = null
) {
    override fun toString(): String {
        return if (next != null) {
            "$data <-> ${next.toString()}"
        } else {
            "$data"
        }
    }
}