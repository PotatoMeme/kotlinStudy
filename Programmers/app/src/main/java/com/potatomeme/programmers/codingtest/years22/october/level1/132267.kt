package com.example.myapplication

class Solution132267 {
    fun solution(a: Int, b: Int, n: Int): Int {
        var answer: Int = n / a * b
        return answer + (answer + n % a).let {
            if (it < a) 0 else solution(a, b, it)
        }
    }
}