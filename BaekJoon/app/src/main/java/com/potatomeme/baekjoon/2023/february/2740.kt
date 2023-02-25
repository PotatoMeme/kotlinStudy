package com.potatomeme.baekjoon.`2023`.february

import java.util.*


//https://www.acmicpc.net/problem/2740

//행렬 곱셈
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	128 MB	14017	9525	8259	69.363%
//문제
//N*M크기의 행렬 A와 M*K크기의 행렬 B가 주어졌을 때, 두 행렬을 곱하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 행렬 A의 크기 N 과 M이 주어진다. 둘째 줄부터 N개의 줄에 행렬 A의 원소 M개가 순서대로 주어진다. 그 다음 줄에는 행렬 B의 크기 M과 K가 주어진다. 이어서 M개의 줄에 행렬 B의 원소 K개가 차례대로 주어진다. N과 M, 그리고 K는 100보다 작거나 같고, 행렬의 원소는 절댓값이 100보다 작거나 같은 정수이다.
//
//출력
//첫째 줄부터 N개의 줄에 행렬 A와 B를 곱한 행렬을 출력한다. 행렬의 각 원소는 공백으로 구분한다.
//
//예제 입력 1
//3 2
//1 2
//3 4
//5 6
//2 3
//-1 -2 0
//0 0 3
//예제 출력 1
//-1 -2 6
//-3 -6 12
//-5 -10 18

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val st1 = StringTokenizer(readLine())
    val n = st1.nextToken().toInt()
    val m = st1.nextToken().toInt()

    val arr1 = Array(n) { IntArray(m) }
    repeat(n) { i1 ->
        val st = StringTokenizer(readLine())
        repeat(m) { i2 ->
            arr1[i1][i2] = st.nextToken().toInt()
        }
    }

    val st2 = StringTokenizer(readLine())
    st2.nextToken().toInt()
    val k = st2.nextToken().toInt()
    val arr2 = Array(m) { IntArray(k) }
    repeat(m) { i1 ->
        val st = StringTokenizer(readLine())
        repeat(k) { i2 ->
            arr2[i1][i2] = st.nextToken().toInt()
        }
    }

    val sb = StringBuilder()
    for (i in 0 until n) {
        for (j in 0 until k) {
            var sum = 0
            for (k in 0 until m) {
                sum += arr1[i][k] * arr2[k][j]
            }
            sb.append(sum).append(' ')
        }
        sb.appendLine()
    }

    print(sb.toString())
}