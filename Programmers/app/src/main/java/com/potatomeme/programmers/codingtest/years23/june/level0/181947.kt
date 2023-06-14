package com.potatomeme.programmers.codingtest.years23.june.level0

import java.util.StringTokenizer


//덧셈식 출력하기
//문제 설명
//두 정수 a, b가 주어질 때 다음과 같은 형태의 계산식을 출력하는 코드를 작성해 보세요.
//
//a + b = c
//제한사항
//1 ≤ a, b ≤ 100
//입출력 예
//입력 #1
//
//4 5
//출력 #1
//
//4 + 5 = 9

fun main(){
    Solution181947().solution(readLine()!!)
}

class Solution181947() {
    fun solution(str: String) {
        val st =StringTokenizer(str)
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        print(buildString {
            append(a).append(" + ").append(b).append(" = ").append(a + b)
        })
    }
}