package com.potatomeme.baekjoon.`2023`.november

import java.util.StringTokenizer

//합분해
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	128 MB	42860	19251	14190	43.453%
//문제
//0부터 N까지의 정수 K개를 더해서 그 합이 N이 되는 경우의 수를 구하는 프로그램을 작성하시오.
//
//덧셈의 순서가 바뀐 경우는 다른 경우로 센다(1+2와 2+1은 서로 다른 경우). 또한 한 개의 수를 여러 번 쓸 수도 있다.
//
//입력
//첫째 줄에 두 정수 N(1 ≤ N ≤ 200), K(1 ≤ K ≤ 200)가 주어진다.
//
//출력
//첫째 줄에 답을 1,000,000,000으로 나눈 나머지를 출력한다.
//
//예제 입력 1
//20 2
//예제 출력 1
//21
//예제 입력 2
//6 4
//예제 출력 2
//84

fun main() {
    with(System.`in`.bufferedReader()) {
        val (n, k) = readLine().split(" ").map { it.toInt() }
        val dp = Array(k+1){IntArray(n+1)}

        for (i in 0..n) dp[1][i] = 1

        for (i in 2..k){
            for (j in 0..n){
                for (m in 0..j){
                    dp[i][j] += dp[i-1][j - m]
                    dp[i][j] %= 1_000_000_000
                }
            }
        }

        print(dp[k][n])
    }
}