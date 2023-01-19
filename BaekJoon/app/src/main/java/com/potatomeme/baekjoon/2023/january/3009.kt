package com.potatomeme.baekjoon.`2023`.january

import java.util.StringTokenizer

//https://www.acmicpc.net/problem/3009

//네 번째 점 성공다국어
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	128 MB	38530	27886	24922	73.352%
//문제
//세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾는 프로그램을 작성하시오.
//
//입력
//세 점의 좌표가 한 줄에 하나씩 주어진다. 좌표는 1보다 크거나 같고, 1000보다 작거나 같은 정수이다.
//
//출력
//직사각형의 네 번째 점의 좌표를 출력한다.
//
//예제 입력 1
//5 5
//5 7
//7 5
//예제 출력 1
//7 7
//예제 입력 2
//30 20
//10 10
//10 20
//예제 출력 2
//30 10

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val x = IntArray(3)
    val y = IntArray(3)
    repeat(3){
        val st  = StringTokenizer(readLine())
        x[it] = st.nextToken().toInt()
        y[it] = st.nextToken().toInt()
    }

    val sb = StringBuilder()
    sb.append(if (x[0] == x[1]) x[2] else if (x[1] == x[2]) x[0] else x[1])
        .append(" ")
        .append(if (y[0] == y[1]) y[2] else if (y[1] == y[2]) y[0] else y[1])
    print(sb.toString())
}