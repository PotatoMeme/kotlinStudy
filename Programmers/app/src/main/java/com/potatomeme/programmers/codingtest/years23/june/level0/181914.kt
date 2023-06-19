package com.potatomeme.programmers.codingtest.years23.june.level0

import java.math.BigDecimal


//9로 나눈 나머지
//문제 설명
//음이 아닌 정수를 9로 나눈 나머지는 그 정수의 각 자리 숫자의 합을 9로 나눈 나머지와 같은 것이 알려져 있습니다.
//이 사실을 이용하여 음이 아닌 정수가 문자열 number로 주어질 때, 이 정수를 9로 나눈 나머지를 return 하는 solution 함수를 작성해주세요.
//
//제한사항
//1 ≤ number의 길이 ≤ 100,000
//number의 원소는 숫자로만 이루어져 있습니다.
//number는 정수 0이 아니라면 숫자 '0'으로 시작하지 않습니다.
//입출력 예
//number	result
//"123"	6
//"78720646226947352489"	2
//입출력 예 설명
//입출력 예 #1
//
//예제 1번의 number는 123으로 각 자리 숫자의 합은 6입니다. 6을 9로 나눈 나머지는 6이고, 실제로 123 = 9 × 13 + 6입니다. 따라서 6을 return 합니다.
//입출력 예 #2
//
//예제 2번의 number는 78720646226947352489으로 각자리 숫자의 합은 101입니다. 101을 9로 나눈 나머지는 2이고, 실제로 78720646226947352489 = 9 × 8746738469660816943 + 2입니다. 따라서 2를 return 합니다.

class Solution181914() {
    //just solve
    fun solution(number: String): Int {
        return number.toBigDecimal().remainder(BigDecimal(9)).toInt()
    }

    //  10^n*an + 10^(n-1) * a(n-1) + ... + 10*a1 + a0
    //  => (( 99...99 * an + 99...99 * a(n-1) + ... + 9a1 ) + (an + a(n-1) + ... + a1 + a0))%9 == an + a(n-1) + ... + a1 + a0
    fun solution2(number: String): Int {
        return number.fold(0){ total,char ->
            total + (char - '0')
        } % 9
    }
}