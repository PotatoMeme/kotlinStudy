package com.potatomeme.programmers.codingtest.years22.october.level1

// 자릿수 더하기
// 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12931?language=kotlin

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

class Solution12931 {
    fun mySolution1(n: Int): Int {
        var answer = 0
        n.toString().forEach {
            answer += it.digitToInt()
        }
        return answer
    }

    fun mySolution2(n: Int): Int = if (n >= 10) n % 10 + mySolution2(n / 10) else n

    fun userSolution1(n: Int): Int {
        var input = n
        var answer = 0

        while (input != 0) {
            answer += input % 10
            input /= 10
        }

        return answer
    }

    fun userSolution2(n: Int): Int = n.toString().toSingleDigitList().sum()

    fun String.toSingleDigitList() = map {
        "$it".toIntOrNull()
    }.filterNotNull()
}


