package com.potatomeme.baekjoon.`2023`.february

import java.util.*
import kotlin.math.min

//https://www.acmicpc.net/problem/2004

//조합 0의 개수
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	128 MB	45501	12791	10560	28.732%
//문제
// 
//$n \choose m$의 끝자리
//$0$의 개수를 출력하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 정수
//$n$,
//$m$ (
//$0 \le m \le n \le 2,000,000,000$,
//$n \ne 0$)이 들어온다.
//
//출력
//첫째 줄에
//$n \choose m$의 끝자리
//$0$의 개수를 출력한다.
//
//예제 입력 1
//25 12
//예제 출력 1
//2

// = ()

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toLong()
    val m = st.nextToken().toLong()

    val count2 = two_power_n(n) - two_power_n(n - m) - two_power_n(m)
    val count5 = five_power_n(n) - five_power_n(n - m) - five_power_n(m)
    print(min(count2,count5))

}

fun two_power_n(num: Long): Long {
    var num = num
    var count = 0L
    while (num >= 2) {
        count += (num / 2)
        num /= 2
    }
    return count
}

fun five_power_n(num: Long): Long {
    var num = num
    var count = 0L
    while (num >= 5) {
        count += (num / 5)
        num /= 5
    }
    return count
}