package com.potatomeme.baekjoon.`2023`.november

import java.util.Arrays

//동물원
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	128 MB	32836	16070	12743	47.139%
//문제
//어떤 동물원에 가로로 두칸 세로로 N칸인 아래와 같은 우리가 있다.
//
//
//
//이 동물원에는 사자들이 살고 있는데 사자들을 우리에 가둘 때, 가로로도 세로로도 붙어 있게 배치할 수는 없다. 이 동물원 조련사는 사자들의 배치 문제 때문에 골머리를 앓고 있다.
//
//동물원 조련사의 머리가 아프지 않도록 우리가 2*N 배열에 사자를 배치하는 경우의 수가 몇 가지인지를 알아내는 프로그램을 작성해 주도록 하자. 사자를 한 마리도 배치하지 않는 경우도 하나의 경우의 수로 친다고 가정한다.
//
//입력
//첫째 줄에 우리의 크기 N(1≤N≤100,000)이 주어진다.
//
//출력
//첫째 줄에 사자를 배치하는 경우의 수를 9901로 나눈 나머지를 출력하여라.
//
//예제 입력 1
//4
//예제 출력 1
//41

fun main() {
    with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val dp = Array(n + 1) { IntArray(3) }
        Arrays.fill(dp[1], 1)
        for (i in 2..n) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901
        }
        print((dp[n][0] + dp[n][1] + dp[n][2]) % 9901)
    }
}