package com.potatomeme.baekjoon.`2023`.february

import java.util.StringTokenizer


//https://www.acmicpc.net/problem/11054

//가장 긴 바이토닉 부분 수열
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	256 MB	41852	21379	16726	50.776%
//문제
//수열 S가 어떤 수 Sk를 기준으로 S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN을 만족한다면, 그 수열을 바이토닉 수열이라고 한다.
//
//예를 들어, {10, 20, 30, 25, 20}과 {10, 20, 30, 40}, {50, 40, 25, 10} 은 바이토닉 수열이지만,  {1, 2, 3, 2, 1, 2, 3, 2, 1}과 {10, 20, 30, 40, 20, 30} 은 바이토닉 수열이 아니다.
//
//수열 A가 주어졌을 때, 그 수열의 부분 수열 중 바이토닉 수열이면서 가장 긴 수열의 길이를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 수열 A의 크기 N이 주어지고, 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ N ≤ 1,000, 1 ≤ Ai ≤ 1,000)
//
//출력
//첫째 줄에 수열 A의 부분 수열 중에서 가장 긴 바이토닉 수열의 길이를 출력한다.
//
//예제 입력 1
//10
//1 5 2 1 4 3 4 5 2 1
//예제 출력 1
//7


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = IntArray(n)
    val st = StringTokenizer(readLine())
    repeat(n) { arr[it] = st.nextToken().toInt() }
    print(Solution11054(n, arr).max)
}

//try1
class Solution11054Try1(val n: Int, val arr: IntArray) {
    var max = 0

    init {
        for (i in arr.indices) {
            solve(1, i, true)
        }
    }

    fun solve(depth: Int, index: Int, up: Boolean) {
        if (max < depth) max = depth

        for (i in index until n) {
            if (up) {
                if (arr[index] < arr[i]) {
                    solve(depth + 1, i, up)
                } else if (arr[index] > arr[i]) {
                    solve(depth + 1, i, false)
                }
            } else if (arr[index] > arr[i]) {
                solve(depth + 1, i, up)
            }
        }
    }
}//time out

//try2
class Solution11054(n: Int, arr: IntArray) {
    var dp = Array(2) { IntArray(n) { 1 } }
    var max = 0

    init {
        for (i in 1 until n) {
            for (j in 0 until i) {
                if (arr[i] > arr[j]) {
                    dp[0][i] = dp[0][i].coerceAtLeast(dp[0][j] + 1)
                }
            }
        }
        for (i in n - 2 downTo 0) {
            for (j in n - 1 downTo i + 1) {
                if (arr[i] > arr[j]) {
                    dp[1][i] = dp[1][i].coerceAtLeast(dp[1][j] + 1)
                }
            }
        }
        repeat(n) {
            max = max.coerceAtLeast(dp[0][it] + dp[1][it] - 1)
        }
    }
}