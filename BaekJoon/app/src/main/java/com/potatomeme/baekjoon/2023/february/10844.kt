package com.potatomeme.baekjoon.`2023`.february

import android.os.Build.VERSION_CODES.N


//https://www.acmicpc.net/problem/10844

//쉬운 계단 수
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	256 MB	119671	37937	27450	29.944%
//문제
//45656이란 수를 보자.
//
//이 수는 인접한 모든 자리의 차이가 1이다. 이런 수를 계단 수라고 한다.
//
//N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구해보자. 0으로 시작하는 수는 계단수가 아니다.
//
//입력
//첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 100보다 작거나 같은 자연수이다.
//
//출력
//첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력한다.
//
//예제 입력 1
//1
//예제 출력 1
//9
//예제 입력 2
//2
//예제 출력 2
//17


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    print(Solution10844Type2(n).count)
}

class Solution10844(val n: Int) {
    var count = 0

    init {
        for (i in 1..9) {
            dfs(1, i)
        }
    }

    private fun dfs(depth: Int, value: Int) {
        if (depth == n) {
            count++
            return
        }

        if (value < 9) {
            dfs(depth + 1, value + 1)
        }
        if (value > 0) {
            dfs(depth + 1, value - 1)
        }
    }//time out
}

class Solution10844Type2(val n: Int) {
    var arr = Array(n + 1) { Array<Long>(10) { 0 } }
    val MOD: Long = 1000000000
    var count: Long = 0

    init {
        for (i in 0..9) {
            arr[1][i] = 1L
        }
        for (i in 1..9) {
            count += recur(n, i)
        }
        count %= MOD
    }

    fun recur(digit: Int, value: Int): Long {

        if (digit == 1) {
            return arr[digit][value]
        }

        if (arr[digit][value] == 0L) {
            when (value) {
                0 -> {
                    arr[digit][value] = recur(digit - 1, 1)
                }
                9 -> {
                    arr[digit][value] = recur(digit - 1, 8)
                }
                else -> {
                    arr[digit][value] = recur(digit - 1, value - 1) + recur(digit - 1, value + 1)
                }
            }
        }
        return arr[digit][value] % MOD
    }
}


