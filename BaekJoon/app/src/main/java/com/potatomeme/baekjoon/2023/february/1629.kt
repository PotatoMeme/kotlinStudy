package com.potatomeme.baekjoon.`2023`.february

import java.util.StringTokenizer


//https://www.acmicpc.net/problem/1629

//곱셈
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//0.5 초 (추가 시간 없음)	128 MB	85803	23480	17212	26.395%
//문제
//자연수 A를 B번 곱한 수를 알고 싶다. 단 구하려는 수가 매우 커질 수 있으므로 이를 C로 나눈 나머지를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 A, B, C가 빈 칸을 사이에 두고 순서대로 주어진다. A, B, C는 모두 2,147,483,647 이하의 자연수이다.
//
//출력
//첫째 줄에 A를 B번 곱한 수를 C로 나눈 나머지를 출력한다.
//
//예제 입력 1
//10 11 12
//예제 출력 1
//4


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val a = st.nextToken().toLong()
    val b = st.nextToken().toLong()
    val c = st.nextToken().toLong()
    fun solve(x: Long, y: Long): Long {
        if (y == 1L) return x % c
        val temp = solve(x, y / 2)
        if (y % 2 == 1L) {
            return (temp * temp % c) * x % c
        }
        return temp * temp % c
    }
    print(solve(a, b))
}

