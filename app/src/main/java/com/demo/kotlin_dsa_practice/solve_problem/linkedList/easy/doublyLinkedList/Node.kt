package com.demo.kotlin_dsa_practice.solve_problem.linkedList.easy.doublyLinkedList

data class Node(
    var data : Int,
    var next : Node? = null,
    var back : Node? = null
) {
    override fun toString(): String {
        return if (next != null) {
            "$data -> ${next.toString()}"
        } else {
            "$data"
        }
    }
}
