package com.potatomeme.programmers.codingtest.years23.march.level2

import kotlin.math.pow

//2개 이하로 다른 비트
//문제 설명
//양의 정수 x에 대한 함수 f(x)를 다음과 같이 정의합니다.
//
//x보다 크고 x와 비트가 1~2개 다른 수들 중에서 제일 작은 수
//예를 들어,
//
//f(2) = 3 입니다. 다음 표와 같이 2보다 큰 수들 중에서 비트가 다른 지점이 2개 이하이면서 제일 작은 수가 3이기 때문입니다.
//수	비트	다른 비트의 개수
//2	000...0010
//3	000...0011	1
//f(7) = 11 입니다. 다음 표와 같이 7보다 큰 수들 중에서 비트가 다른 지점이 2개 이하이면서 제일 작은 수가 11이기 때문입니다.
//수	비트	다른 비트의 개수
//7	000...0111
//8	000...1000	4
//9	000...1001	3
//10	000...1010	3
//11	000...1011	2
//정수들이 담긴 배열 numbers가 매개변수로 주어집니다. numbers의 모든 수들에 대하여 각 수의 f 값을 배열에 차례대로 담아 return 하도록 solution 함수를 완성해주세요.
//
//제한사항
//1 ≤ numbers의 길이 ≤ 100,000
//0 ≤ numbers의 모든 수 ≤ 1015
//입출력 예
//numbers	result
//[2,7]	[3,11]
//입출력 예 설명
//입출력 예 #1
//
//문제 예시와 같습니다.

fun main() {
    println(Solution77885().solution(longArrayOf(2, 7)).joinToString(" "))
}


class Solution77885() {

    // 1안
    // x+1의 x의 2진수를 비교하여 diff 를 구함
    // diff 가 1 ~ 2인경우 해당값(x+1)을 리턴
    // diff 가 2이상인경우 2진수의 1의 자리수부터 비교를 하여 같을 경우 넘기고 다를경우 같게만들어 diff 를 1씩줄여 결과적으로 diff 를 2로 만들었을때의 값을 리턴

    fun solution(numbers: LongArray) = LongArray(numbers.size) { i ->
        solve(numbers[i])
    }

    private fun solve(l: Long): Long {
        var base1: String = java.lang.Long.toBinaryString(l)
        var base2: String = java.lang.Long.toBinaryString(l + 1)
        if (base1.length != base2.length) base1 = buildString { append(0).append(base1) }

        var diff = 0L
        base2.forEachIndexed { index, c ->
            if (base1[index] != c) diff++
        }
        if (diff < 3) {
            return l + 1
        } else {
            val base2_arr = base2.toCharArray()
            var i = base2.length - 1
            while (true) {
                if (base1[i] == base2_arr[i]) continue
                base2_arr[i] = base1[i]
                i--
                diff--
                if (diff < 3) {
                    return convertBinaryToDecimal(base2_arr.joinToString(""))
                }
            }
        }
    }

    private fun convertBinaryToDecimal(str: String): Long {
        var value = 0L
        str.forEachIndexed { index, c ->
            if (c == '1') value += (2.0).pow(str.length - index - 1).toLong()
        }
        return value
    }
}