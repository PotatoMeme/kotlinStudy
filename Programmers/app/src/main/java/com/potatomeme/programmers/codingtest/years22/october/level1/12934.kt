package com.potatomeme.programmers.codingtest.years22.october.level1

import kotlin.math.pow
import kotlin.math.sqrt

// 정수 제곱근 판별
// 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12934?language=kotlin

// 문제 설명
// 임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
// n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.
//
// 제한 사항
// n은 1이상, 50000000000000 이하인 양의 정수입니다.
// 입출력 예
// n	return
// 121	144
// 3	-1
// 입출력 예 설명
// 입출력 예#1
// 121은 양의 정수 11의 제곱이므로, (11+1)를 제곱한 144를 리턴합니다.
//
// 입출력 예#2
// 3은 양의 정수의 제곱이 아니므로, -1을 리턴합니다.

class Solution12934 {
    fun mySolution1(n: Long): Long {
        val num = sqrt(n.toDouble())
        return if ((num - num.toInt()) > 0) {
            -1L
        } else {
            (num + 1).pow(2).toLong()
        }
    }


    fun userSolution1(n: Int): Long {
        val temp = Math.sqrt(n.toDouble())

        return if (temp == Math.floor(temp))
            Math.pow(temp + 1, 2.0).toLong()
        else
            -1
    }
}