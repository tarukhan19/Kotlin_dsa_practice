package com.demo.kotlin_dsa_practice.solve_problem.string.easy

fun main() {
    var str = arrayOf<String>("i am   khan", "i am not an developer", "Hello world","")

    var count = countWords(str)
    println(count)

}
/*
TC -O(n*m)
SC - O(n)
 */

fun countWords(sentences: Array<String>): MutableList<Int> {
    var result = mutableListOf<Int>()

    for (sentence in sentences) {
        println(sentence)

        var count = 0
        var inWord = false

        for (i in 0 until sentence.length) {
            if (sentence[i] != ' ') {
                if (!inWord){
                    count++ // start of a new word
                    inWord = true
                }
            } else {
                inWord = false
            }
        }
        result.add(count)

    }

    return result
}

