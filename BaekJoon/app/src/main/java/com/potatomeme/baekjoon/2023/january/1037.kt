package com.potatomeme.baekjoon.`2023`.january

import java.util.StringTokenizer

//https://www.acmicpc.net/problem/1037

//약수 성공
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	512 MB	50740	27632	23982	54.713%
//문제
//양수 A가 N의 진짜 약수가 되려면, N이 A의 배수이고, A가 1과 N이 아니어야 한다. 어떤 수 N의 진짜 약수가 모두 주어질 때, N을 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 N의 진짜 약수의 개수가 주어진다. 이 개수는 50보다 작거나 같은 자연수이다. 둘째 줄에는 N의 진짜 약수가 주어진다. 1,000,000보다 작거나 같고, 2보다 크거나 같은 자연수이고, 중복되지 않는다.
//
//출력
//첫째 줄에 N을 출력한다. N은 항상 32비트 부호있는 정수로 표현할 수 있다.
//
//예제 입력 1
//2
//4 2
//예제 출력 1
//8
//예제 입력 2
//1
//2
//예제 출력 2
//4
//예제 입력 3
//6
//3 4 2 12 6 8
//예제 출력 3
//24
//예제 입력 4
//14
//14 26456 2 28 13228 3307 7 23149 8 6614 46298 56 4 92596
//예제 출력 4
//185192

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val num = readLine().toInt()
    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE
    val st = StringTokenizer(readLine())
    repeat(num) {
        val x = st.nextToken().toInt()
        if (min > x) min = x
        if (max < x) max = x
    }
    print(min * max)
}
