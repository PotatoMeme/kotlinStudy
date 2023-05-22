package com.potatomeme.programmers.codingtest.years23.may.level3

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*
import kotlin.math.abs
import kotlin.math.min


//가장 긴 팰린드롬
//문제 설명
//앞뒤를 뒤집어도 똑같은 문자열을 팰린드롬(palindrome)이라고 합니다.
//문자열 s가 주어질 때, s의 부분문자열(Substring)중 가장 긴 팰린드롬의 길이를 return 하는 solution 함수를 완성해 주세요.
//
//예를들면, 문자열 s가 "abcdcba"이면 7을 return하고 "abacde"이면 3을 return합니다.
//
//제한사항
//문자열 s의 길이 : 2,500 이하의 자연수
//문자열 s는 알파벳 소문자로만 구성
//입출력 예
//s	answer
//"abcdcba"	7
//"abacde"	3
//입출력 예 설명
//입출력 예 #1
//4번째자리 'd'를 기준으로 문자열 s 전체가 팰린드롬이 되므로 7을 return합니다.
//
//입출력 예 #2
//2번째자리 'b'를 기준으로 "aba"가 팰린드롬이 되므로 3을 return합니다.

fun main() {
    println(Solution12904().solution("abcdcba"))
}

class Solution12904() {
    private val lStack: Stack<Char> = Stack()
    private val rStack: Stack<Char> = Stack()

    private var max = 1

    fun solution(s: String): Int {
        checkPalindrome(0, s)
        return max
    }

    private fun checkPalindrome(idx: Int, s: String) {
        if (idx >= s.length) return
        checkBack(idx, s, 0) // 중간이 짝수
        checkBack(idx + 1, s, 1) // 중간이 홀수
        lStack.push(s[idx])
        checkPalindrome(idx + 1, s)
    }

    private fun checkBack(idx: Int, s: String, cnt: Int) {
        if (lStack.isEmpty() || idx >= s.length || lStack.peek() != s[idx]) {
            if (max < cnt) max = cnt
            refreshStack()
            return
        }
        rStack.push(lStack.pop())
        checkBack(idx + 1, s, cnt + 2)
    }

    private fun refreshStack() {
        while (!rStack.isEmpty()) {
            lStack.push(rStack.pop())
        }
    }
}