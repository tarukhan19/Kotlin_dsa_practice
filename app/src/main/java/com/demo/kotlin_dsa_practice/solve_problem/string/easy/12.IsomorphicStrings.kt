package com.demo.kotlin_dsa_practice.solve_problem.string.easy

fun main() {
    var s = "foo"
    var t = "bar"

    var isIsomorphic = checkIsomorphicOptimize(s, t)
    println(isIsomorphic)

}
/*
Time Complexity (worst case): O(n)

Space Complexity (worst case): O(n)
 */
fun checkIsomorphic(s: String, t: String): Boolean {
    if (s.length != t.length) {
        return false
    }

    var maps = mutableMapOf<Char, Char>()
    var mapt = mutableMapOf<Char, Char>()

    for (i in s.indices) {
        var c1 = s[i]
        var c2 = t[i]

        // forward mapping s -> t
        println(maps.containsKey(c1))
        if (maps.containsKey(c1)) {
            if (maps[c1] != c2) return false
        } else {
            maps[c1] = c2
        }

        println()

        println(mapt.containsKey(c2))
        // backward mapping t -> s
        if (mapt.containsKey(c2)) {
            if (mapt[c2] != c1) return false
        } else {
            mapt[c2] = c1
        }

    }
    return true

}

fun checkIsomorphicOptimize(s: String, t: String): Boolean {

    var lastSeenS = IntArray(256) { -1 }
    var lastSeenT = IntArray(256) { -1 }

    for (i in s.indices){
        var c1 = s[i].code
        var c2 = t[i].code

        if (lastSeenS[c1] != lastSeenT[c2]) {return false}

        lastSeenS[c1] = i
        lastSeenT[c2] = i
    }

    return true
}

