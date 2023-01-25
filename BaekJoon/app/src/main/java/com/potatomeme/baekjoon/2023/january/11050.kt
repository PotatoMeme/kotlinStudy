package com.potatomeme.baekjoon.`2023`.january

import java.util.StringTokenizer

//https://www.acmicpc.net/problem/11050

//이항 계수 1 성공
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	256 MB	44357	28682	24759	64.552%
//문제
//자연수
//\(N\)과 정수
//\(K\)가 주어졌을 때 이항 계수
//\(\binom{N}{K}\)를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에
//\(N\)과
//\(K\)가 주어진다. (1 ≤
//\(N\) ≤ 10, 0 ≤
//\(K\) ≤
//\(N\))
//
//출력
//
//\(\binom{N}{K}\)를 출력한다.
//
//예제 입력 1
//5 2
//예제 출력 1
//10

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    print(binomialCoefficient(n,k))
}

fun binomialCoefficient(n: Int, k: Int): Int {
    return factorial(n) / (factorial(k) * factorial(n - k))
}

fun factorial(a: Int): Int {
    var result = 1
    for (i in 2..a) result *= i
    return result
}