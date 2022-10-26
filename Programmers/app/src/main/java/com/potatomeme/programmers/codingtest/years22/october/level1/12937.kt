package com.potatomeme.programmers.codingtest.years22.october.level1

import android.icu.lang.UCharacter.GraphemeClusterBreak.T


// 짝수와 홀수
// 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12937?language=kotlin

// 문제 설명
// 정수 num이 짝수일 경우 "Even"을 반환하고 홀수인 경우 "Odd"를 반환하는 함수, solution을 완성해주세요.
//
// 제한 조건
// num은 int 범위의 정수입니다.
// 0은 짝수입니다.
// 입출력 예
// num	return
// 3	"Odd"
// 4	"Even"

class Solution12937 {
    fun mySolution1(num: Int): String = if(num % 2 == 0) "Even" else "Odd"


    fun mySolution2(num: Int): String = when (num % 2) {
        0 -> "Even"
        1 -> "Odd"
        else -> {
            throw ExceptionInInitializerError("Error")
        }
    }

    fun userSolution1(num: Int): String  = if (num.and(1) == 0) "Even" else "Odd"
}