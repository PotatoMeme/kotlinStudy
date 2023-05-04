package com.potatomeme.baekjoon.`2023`.may

import java.util.StringTokenizer


//https://www.acmicpc.net/problem/11401

//
//이항 계수 3
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	256 MB	23486	8596	6276	40.303%
//문제
//자연수
//\(N\)과 정수
//\(K\)가 주어졌을 때 이항 계수
//\(\binom{N}{K}\)를 1,000,000,007로 나눈 나머지를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에
//\(N\)과
//\(K\)가 주어진다. (1 ≤
//\(N\) ≤ 4,000,000, 0 ≤
//\(K\) ≤
//\(N\))
//
//출력
//
//\(\binom{N}{K}\)를 1,000,000,007로 나눈 나머지를 출력한다.
//
//예제 입력 1
//5 2
//예제 출력 1
//10


fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toLong()
    val k = st.nextToken().toLong()

    val p = 1_000_000_007L

    fun factorial(now: Long): Long {
        return if (now < 2) return 1 else now * factorial(now - 1) % p
    }

    fun pow(num: Long, pow: Long): Long {
        if (pow == 1L) return num % p
        val temp = pow(num, pow / 2)
        return if (pow % 2 == 1L) {
            (temp * temp % p) * num % p
        } else {
            temp * temp % p
        }
    }

    val top = factorial(n)
    val bottom = factorial(k) * factorial(n - k) % p
    val ans = top * pow(bottom, p - 2) % p
    print(ans)
}

