package com.potatomeme.programmers.codingtest.years23.march.level0


//짝수는 싫어요
//문제 설명
//정수 n이 매개변수로 주어질 때, n 이하의 홀수가 오름차순으로 담긴 배열을 return하도록 solution 함수를 완성해주세요.
//
//제한사항
//1 ≤ n ≤ 100
//입출력 예
//n	result
//10	[1, 3, 5, 7, 9]
//15	[1, 3, 5, 7, 9, 11, 13, 15]
//입출력 예 설명
//입출력 #1
//
//10 이하의 홀수가 담긴 배열 [1, 3, 5, 7, 9]를 return합니다.
//입출력 #1
//
//15 이하의 홀수가 담긴 배열 [1, 3, 5, 7, 9, 11, 13, 15]를 return합니다.

class Solution120813() {
    fun solution(n: Int) = (1..n step 2).toList()
}