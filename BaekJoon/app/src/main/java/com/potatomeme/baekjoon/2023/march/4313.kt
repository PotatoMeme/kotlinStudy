package com.potatomeme.baekjoon.`2023`.march

import java.util.*
import kotlin.math.sqrt


//https://www.acmicpc.net/problem/4134

//다음 소수 다국어
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	128 MB	3890	1050	758	27.130%
//문제
//정수 n(0 ≤ n ≤ 4*109)가 주어졌을 때, n보다 크거나 같은 소수 중 가장 작은 소수 찾는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다.
//
//출력
//각각의 테스트 케이스에 대해서 n보다 크거나 같은 소수 중 가장 작은 소수를 한 줄에 하나씩 출력한다.
//
//예제 입력 1
//3
//6
//20
//100
//예제 출력 1
//7
//23
//101


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    fun solve(n: Long): Long {
        for (i in 2..sqrt(n.toDouble()).toInt() + 1) {
            if (n % i == 0L) return solve(n + 1)
        }
        return n
    }

    print(StringBuilder().apply {
        repeat(readLine().toInt()) {
            val num = readLine().toLong()
            appendLine(if (num < 3) 2 else solve(num))
        }
    })
}