package com.example.myapplication

import kotlin.math.min

class Solution {
    fun solution1(X: String, Y: String): String {
        val yList = Y.map { it.digitToInt() }.toMutableList()
        return X.map { it.digitToInt() }.filter {
            yList.remove(it)
        }.sortedDescending().joinToString("")
            .let { if (it == "") "-1" else it.toInt().toString() }
    } // 실패 (런타임 에러)

    fun usersSolution(X: String, Y: String): String {
        var answer = ""

        for (ch in (9 downTo 0).toList().map { it.toString() }) {
            answer += ch
                .repeat(
                    min(
                        X.count {
                            it.toString() == ch
                        }, Y.count {
                            it.toString() == ch
                        }
                    ))
        }
        if (answer.isEmpty()) answer = "-1"
        else if (answer.toList().distinct() == listOf('0')) answer = "0"

        return answer
    }
}