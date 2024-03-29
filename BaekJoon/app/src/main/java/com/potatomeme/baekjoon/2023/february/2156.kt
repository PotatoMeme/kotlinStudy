package com.potatomeme.baekjoon.`2023`.february

import kotlin.math.max


//https://www.acmicpc.net/problem/1904

//포도주 시식
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	128 MB	114926	39094	28191	32.575%
//문제
//효주는 포도주 시식회에 갔다. 그 곳에 갔더니, 테이블 위에 다양한 포도주가 들어있는 포도주 잔이 일렬로 놓여 있었다. 효주는 포도주 시식을 하려고 하는데, 여기에는 다음과 같은 두 가지 규칙이 있다.
//
//포도주 잔을 선택하면 그 잔에 들어있는 포도주는 모두 마셔야 하고, 마신 후에는 원래 위치에 다시 놓아야 한다.
//연속으로 놓여 있는 3잔을 모두 마실 수는 없다.
//효주는 될 수 있는 대로 많은 양의 포도주를 맛보기 위해서 어떤 포도주 잔을 선택해야 할지 고민하고 있다. 1부터 n까지의 번호가 붙어 있는 n개의 포도주 잔이 순서대로 테이블 위에 놓여 있고, 각 포도주 잔에 들어있는 포도주의 양이 주어졌을 때, 효주를 도와 가장 많은 양의 포도주를 마실 수 있도록 하는 프로그램을 작성하시오.
//
//예를 들어 6개의 포도주 잔이 있고, 각각의 잔에 순서대로 6, 10, 13, 9, 8, 1 만큼의 포도주가 들어 있을 때, 첫 번째, 두 번째, 네 번째, 다섯 번째 포도주 잔을 선택하면 총 포도주 양이 33으로 최대로 마실 수 있다.
//
//입력
//첫째 줄에 포도주 잔의 개수 n이 주어진다. (1 ≤ n ≤ 10,000) 둘째 줄부터 n+1번째 줄까지 포도주 잔에 들어있는 포도주의 양이 순서대로 주어진다. 포도주의 양은 1,000 이하의 음이 아닌 정수이다.
//
//출력
//첫째 줄에 최대로 마실 수 있는 포도주의 양을 출력한다.
//
//예제 입력 1
//6
//6
//10
//13
//9
//8
//1
//예제 출력 1
//33


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = IntArray(n)
    repeat(n) { arr[it] = readLine().toInt() }
    val s = Solution2156Try2(n, arr)
    print(s.result)
}

//try1
class Solution2156Try1(n: Int, arr: IntArray) {
    val dp: Array<IntArray> = Array(3) { IntArray(n) { 0 } }
    val result: Int

    init {
        if (n == 1) {
            result = arr[0]
        } else {
            dp[0][0] = arr[0]
            for (i in 1 until n) {
                dp[0][i] = dp[2][i - 1] + arr[i]
                dp[1][i] = dp[0][i - 1] + arr[i]
                //틀렸을때
                //dp[2][i] = max(dp[0][i-1],dp[1][i-1])////경우의 수가 3인데 2가지만 생각함
                dp[2][i] = maxOf(dp[0][i - 1], dp[1][i - 1], dp[2][i - 1])
            }
            result = maxOf(dp[0][n - 1], dp[1][n - 1], dp[2][n - 1])
        }
    }
}//틀림 -> 고침

//try2
class Solution2156Try2(n: Int, arr: IntArray) {
    val dp = IntArray(n)
    val result: Int

    init {
        dp[0] = arr[0]
        if (n > 1) {
            dp[1] = dp[0] + arr[1]
            if (n > 2) {
                //틀렸을때
                //dp[2] = max((dp[0] + arr[2]), dp[1]) //경우의 수가 3인데 2가지만 생각함
                dp[2] = maxOf((arr[0] + arr[2]), dp[1], (arr[0] + arr[1]))
                if (n > 3) {
                    for (i in 3 until n) {
                        dp[i] = maxOf(dp[i - 1],
                            (dp[i - 2] + arr[i]),
                            (dp[i - 3] + (arr[i - 1] + arr[i])))
                    }
                }
            }
        }

        result = dp[n - 1]
    }
}//틀림 -> 고침
