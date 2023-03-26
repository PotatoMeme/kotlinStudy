package com.potatomeme.baekjoon.`2023`.march

import java.util.StringTokenizer


//https://www.acmicpc.net/problem/10101

//삼각형과 세 변 다국어
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	128 MB	7571	3811	3481	52.687%
//문제
//삼각형의 세 변의 길이가 주어질 때 변의 길이에 따라 다음과 같이 정의한다.
//
//Equilateral :  세 변의 길이가 모두 같은 경우
//Isosceles : 두 변의 길이만 같은 경우
//Scalene : 세 변의 길이가 모두 다른 경우
//단 주어진 세 변의 길이가 삼각형의 조건을 만족하지 못하는 경우에는 "Invalid" 를 출력한다. 예를 들어 6, 3, 2가 이 경우에 해당한다. 가장 긴 변의 길이보다 나머지 두 변의 길이의 합이 길지 않으면 삼각형의 조건을 만족하지 못한다.
//
//세 변의 길이가 주어질 때 위 정의에 따른 결과를 출력하시오.
//
//입력
//각 줄에는 1,000을 넘지 않는 양의 정수 3개가 입력된다. 마지막 줄은 0 0 0이며 이 줄은 계산하지 않는다.
//
//출력
//각 입력에 맞는 결과 (Equilateral, Isosceles, Scalene, Invalid) 를 출력하시오.
//
//예제 입력 1
//7 7 7
//6 5 4
//3 2 5
//6 2 6
//0 0 0
//예제 출력 1
//Equilateral
//Scalene
//Invalid
//Isosceles

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    while (true) {
        val st = StringTokenizer(readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val c = st.nextToken().toInt()
        if (a == 0 && b == 0 && c == 0) break
        if (a == b && b == c) {
            sb.appendLine("Equilateral")
        } else if (a + b <= c || b + c <= a || a + c <= b) {
            sb.appendLine("Invalid")
        } else if (a == b || b == c || a == c) {
            sb.appendLine("Isosceles")
        } else {
            sb.appendLine("Scalene")
        }
    }
    println(sb.toString())
}