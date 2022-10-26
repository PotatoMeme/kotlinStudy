package com.potatomeme.programmers.codingtest.years22.october.level1

// 약수의 합
// 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12928

// 문제 설명
// 정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.
//
// 제한 사항
// n은 0 이상 3000이하인 정수입니다.
// 입출력 예
// n	return
// 12	28
// 5	6
// 입출력 예 설명
// 입출력 예 #1
// 12의 약수는 1, 2, 3, 4, 6, 12입니다. 이를 모두 더하면 28입니다.
//
// 입출력 예 #2
// 5의 약수는 1, 5입니다. 이를 모두 더하면 6입니다.

class Solution12928 {
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