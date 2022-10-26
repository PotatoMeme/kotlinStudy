package com.potatomeme.programmers.codingtest.years22.october

// 숫자 비교하기
// 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120807?language=kotlin

// 문제 설명
// 정수 num1과 num2가 매개변수로 주어집니다. 두 수가 같으면 1 다르면 -1을 retrun하도록 solution 함수를 완성해주세요.
//
// 제한사항
// 0 ≤ num1 ≤ 10,000
// 0 ≤ num2 ≤ 10,000
// 입출력 예
// num1	num2	result
// 2	3	-1
// 11	11	1
// 7	99	-1
// 입출력 예 설명
// 입출력 예 설명 #1
//
// num1이 2이고 num2가 3이므로 다릅니다. 따라서 -1을 return합니다.
// 입출력 예 설명 #2
//
// num1이 11이고 num2가 11이므로 같습니다. 따라서 1을 return합니다.
// 입출력 예 설명 #3
//
// num1이 7이고 num2가 99이므로 다릅니다. 따라서 -1을 return합니다.

class Solution120807 {
    fun mySolution(num1: Int, num2: Int) = if(num1 == num2){
        1
    }else{
        -1
    }

    fun userSolution1(num1: Int, num2: Int) = if(num1 == num2) 1 else -1
    fun userSolution2(num1: Int, num2: Int) = when(num1 == num2){
        true -> 1
        false -> -1
    }
}