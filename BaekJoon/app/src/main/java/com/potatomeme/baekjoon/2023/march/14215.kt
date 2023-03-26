package com.potatomeme.baekjoon.`2023`.march

import java.util.StringTokenizer


//https://www.acmicpc.net/problem/14215

//세 막대
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	512 MB	1588	1213	1126	76.339%
//문제
//영선이는 길이가 a, b, c인 세 막대를 가지고 있고, 각 막대의 길이를 마음대로 줄일 수 있다.
//
//영선이는 세 막대를 이용해서 아래 조건을 만족하는 삼각형을 만들려고 한다.
//
//각 막대의 길이는 양의 정수이다
//세 막대를 이용해서 넓이가 양수인 삼각형을 만들 수 있어야 한다.
//삼각형의 둘레를 최대로 해야 한다.
//a, b, c가 주어졌을 때, 만들 수 있는 가장 큰 둘레를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 a, b, c (1 ≤ a, b, c ≤ 100)가 주어진다.
//
//출력
//첫째 줄에 만들 수 있는 가장 큰 삼각형의 둘레를 출력한다.
//
//예제 입력 1
//1 2 3
//예제 출력 1
//5
//예제 입력 2
//2 2 2
//예제 출력 2
//6
//예제 입력 3
//1 100 1
//예제 출력 3
//3
//예제 입력 4
//41 64 16
//예제 출력 4
//113

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
//    val arr = IntArray(3)
//    repeat(3){
//        arr[it] = st.nextToken().toInt()
//    }
//    arr.sort()
//    if (arr[0] + arr[1] <= arr[2]){
//        arr[2] = arr[0] + arr[1] - 1
//    }
//    print(arr.sum())
    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()
    val c = st.nextToken().toInt()
    when (maxOf(a, b, c)) {
        a -> {
            if (b + c <= a) {
                print(b + c + b + c - 1)
            } else {
                print(a + b + c)
            }
        }
        b -> {
            if (a + c <= b) {
                print(a + c + a + c - 1)
            } else {
                print(a + b + c)
            }
        }
        c -> {
            if (a + b <= c) {
                print(a + b + a + b - 1)
            } else {
                print(a + b + c)
            }
        }
    }
}