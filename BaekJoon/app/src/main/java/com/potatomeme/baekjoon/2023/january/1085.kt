package com.potatomeme.baekjoon.`2023`.january

import java.util.StringTokenizer

//https://www.acmicpc.net/problem/1085

//직사각형에서 탈출 성공
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	128 MB	71505	45262	39880	63.439%
//문제
//한수는 지금 (x, y)에 있다. 직사각형은 각 변이 좌표축에 평행하고, 왼쪽 아래 꼭짓점은 (0, 0), 오른쪽 위 꼭짓점은 (w, h)에 있다. 직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 x, y, w, h가 주어진다.
//
//출력
//첫째 줄에 문제의 정답을 출력한다.
//
//제한
//1 ≤ w, h ≤ 1,000
//1 ≤ x ≤ w-1
//1 ≤ y ≤ h-1
//x, y, w, h는 정수
//예제 입력 1
//6 2 10 3
//예제 출력 1
//1
//예제 입력 2
//1 1 5 5
//예제 출력 2
//1
//예제 입력 3
//653 375 1000 1000
//예제 출력 3
//347
//예제 입력 4
//161 181 762 375
//예제 출력 4
//161

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val x = st.nextToken().toInt()
    val y = st.nextToken().toInt()
    val w = st.nextToken().toInt()
    val h = st.nextToken().toInt()
    print(minOf(x,y,w-x,h-y))
}
