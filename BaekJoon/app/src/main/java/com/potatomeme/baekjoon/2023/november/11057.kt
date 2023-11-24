package com.potatomeme.baekjoon.`2023`.november

import java.util.Arrays

//오르막 수
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	256 MB	51470	25222	19555	47.784%
//문제
//오르막 수는 수의 자리가 오름차순을 이루는 수를 말한다. 이때, 인접한 수가 같아도 오름차순으로 친다.
//
//예를 들어, 2234와 3678, 11119는 오르막 수이지만, 2232, 3676, 91111은 오르막 수가 아니다.
//
//수의 길이 N이 주어졌을 때, 오르막 수의 개수를 구하는 프로그램을 작성하시오. 수는 0으로 시작할 수 있다.
//
//입력
//첫째 줄에 N (1 ≤ N ≤ 1,000)이 주어진다.
//
//출력
//첫째 줄에 길이가 N인 오르막 수의 개수를 10,007로 나눈 나머지를 출력한다.
//
//예제 입력 1
//1
//예제 출력 1
//10
//예제 입력 2
//2
//예제 출력 2
//55
//예제 입력 3
//3
//예제 출력 3
//220

fun main() {
    with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val dp = Array(n + 1) { IntArray(10) }
        Arrays.fill(dp[0], 1)
        var save: Int
        for (i in 1..n) {
            dp[i][0] = 1
            save = 1
            for (j in 1..9) {
                save += dp[i - 1][j]
                if (save >= 10_007) save %= 10_007
                dp[i][j] = save
            }
        }
        print(dp[n][9])
    }
}