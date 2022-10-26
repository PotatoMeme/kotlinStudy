package com.potatomeme.programmers.codingtest.years22.october.level1

import kotlin.math.sqrt

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

class Solution1228 {
    fun mySolution1(n: Int): Int {
        var answer = 0
        for (i in 1..n) {
            if (n % i == 0) answer += i
        }
        return answer
    }

    fun userSolution1(n: Int): Int = (1..n).filter { n % it == 0 }.sum()

    fun userSolution2(n: Int): Int =
        if (n <= 1) n else n + IntArray(n / 2) { it + 1 }.filter { n % it == 0 }
            .reduce { total, num -> total + num }
}