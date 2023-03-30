package com.potatomeme.baekjoon.`2023`.march

import java.util.StringTokenizer

//https://www.acmicpc.net/problem/2745

//진법 변환
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	128 MB	15539	8755	7337	56.678%
//문제
//B진법 수 N이 주어진다. 이 수를 10진법으로 바꿔 출력하는 프로그램을 작성하시오.
//
//10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.
//
//A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35
//
//입력
//첫째 줄에 N과 B가 주어진다. (2 ≤ B ≤ 36)
//
//B진법 수 N을 10진법으로 바꾸면, 항상 10억보다 작거나 같다.
//
//출력
//첫째 줄에 B진법 수 N을 10진법으로 출력한다.
//
//예제 입력 1
//ZZZZZ 36
//예제 출력 1
//60466175


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val str = st.nextToken()
    val n = st.nextToken().toInt()
    var num = 0
    var now = 1
    str.reversed().forEachIndexed { index, c ->
        if (index != 0) now *= n
        when (c) {
            in '0'..'9' -> num += (c - '0') * now
            in 'A'..'Z' -> num += (c - 'A' + 10) * now
        }
    }
    println(num)
}