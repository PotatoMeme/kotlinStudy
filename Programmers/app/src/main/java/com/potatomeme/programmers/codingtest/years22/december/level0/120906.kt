package com.potatomeme.programmers.codingtest.years22.december.level0

//자릿수 더하기
//문제 설명
//정수 n이 매개변수로 주어질 때 n의 각 자리 숫자의 합을 return하도록 solution 함수를 완성해주세요
//
//제한사항
//0 ≤ n ≤ 1,000,000
//입출력 예
//n	result
//1234	10
//930211	16
//입출력 예 설명
//입출력 예 #1
//
//1 + 2 + 3 + 4 = 10을 return합니다.
//입출력 예 #2
//
//9 + 3 + 0 + 2 + 1 + 1 = 16을 return합니다.

class Solution120906 {
    fun solution(n: Int): Int {
        var answer = 0
        var saveN = n
        while (saveN > 0) {
            answer += saveN % 10
            saveN /= 10
        }
        return answer
    }//0.01 ~ 0.02ms

    fun solution_try(n: Int)
        = n.toString().map { it.digitToInt() }.reduce { acc, i -> acc + i }
    //0.88 ~ 2.71ms
}