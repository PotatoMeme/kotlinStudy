package com.potatomeme.baekjoon.`2023`.april


//https://www.acmicpc.net/problem/27433

//팩토리얼 2
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	1024 MB	2190	1320	1209	63.067%
//문제
//0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 정수 N(0 ≤ N ≤ 20)이 주어진다.
//
//출력
//첫째 줄에 N!을 출력한다.
//
//예제 입력 1
//10
//예제 출력 1
//3628800
//예제 입력 2
//0
//예제 출력 2
//1


fun main() = with(System.`in`.bufferedReader()) {
    fun solve(i: Long): Long = if (i < 2) 1 else i * solve(i - 1)
    print(solve(readLine().toLong()))
}

