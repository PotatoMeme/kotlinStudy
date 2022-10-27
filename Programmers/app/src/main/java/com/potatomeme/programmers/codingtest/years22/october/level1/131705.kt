package com.example.myapplication

class Solution131705 {
    fun solution(number: IntArray): Int {
        var answer: Int = 0
        for (a in 0 until number.size - 2) {
            for (b in a + 1 until number.size - 1) {
                for (c in b + 1 until number.size) {
                    if (number.get(a) + number.get(b) + number.get(c) == 0) answer++
                }
            }
        }
        return answer
    }
}