package com.potatomeme.baekjoon.`2023`.february

//https://www.acmicpc.net/problem/10872

//팩토리얼 성공
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	256 MB	142560	75153	61514	52.923%
//문제
//0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 정수 N(0 ≤ N ≤ 12)이 주어진다.
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


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    print(solve10872(readLine().toInt()))
}

fun solve10872(i: Int): Int {
    if (i < 2) return 1
    return i * solve10872(i - 1)
}