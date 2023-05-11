package com.potatomeme.baekjoon.`2023`.may

import android.os.Build.VERSION_CODES.N


//https://www.acmicpc.net/problem/9093

//2진수 8진수
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	128 MB	29022	11387	9358	40.911%
//문제
//2진수가 주어졌을 때, 8진수로 변환하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 2진수가 주어진다. 주어지는 수의 길이는 1,000,000을 넘지 않는다.
//
//출력
//첫째 줄에 주어진 수를 8진수로 변환하여 출력한다.
//
//예제 입력 1
//11001100
//예제 출력 1
//314

fun main() = with(System.`in`.bufferedReader()) {
    val line = readLine()
    val sb = StringBuilder()
    if (line.length % 3 == 1) sb.append(line[0])
    if (line.length % 3 == 2) sb.append((line[0] - '0') * 2 + (line[1] - '0'))
    for (i in line.length % 3 until line.length step 3) {
        sb.append((line[i] - '0') * 4 + (line[i + 1] - '0') * 2 + (line[i + 2] - '0'))
    }
    print(sb.toString())
}


