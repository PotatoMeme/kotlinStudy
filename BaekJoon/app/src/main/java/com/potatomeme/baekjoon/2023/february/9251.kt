package com.potatomeme.baekjoon.`2023`.february


//https://www.acmicpc.net/problem/9251

//LCS
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//0.1 초 (하단 참고)	256 MB	64132	26022	19134	40.204%
//문제
//LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.
//
//예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.
//
//입력
//첫째 줄과 둘째 줄에 두 문자열이 주어진다. 문자열은 알파벳 대문자로만 이루어져 있으며, 최대 1000글자로 이루어져 있다.
//
//출력
//첫째 줄에 입력으로 주어진 두 문자열의 LCS의 길이를 출력한다.
//
//예제 입력 1
//ACAYKP
//CAPCAK
//예제 출력 1
//4

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val s1 = readLine()
    val s2 = readLine()
    val s = Solution9251(s1, s2)
    print(s.result)
}
//try1 시간 왜이리 많이 걸림?
class Solution9251Try1(val s1: String, val s2: String) {
    val arr = Array(s1.length + 1) { Array(s2.length + 1) { 0 } }
    val result
        get() = arr[s1.length][s2.length]

    init {
        for (i in 1..s1.length) {
            for (j in 1..s2.length) {
                if (s1[i - 1] == s2[j - 1]) {
                    arr[i][j] = arr[i - 1][j - 1] + 1
                } else {
                    arr[i][j] = arr[i][j - 1].coerceAtLeast(arr[i - 1][j])
                }
            }
        }
    }
}

//try2
class Solution9251(s1: String, s2: String) {
    val n = s1.length
    val m = s2.length
    val arr = Array(n + 1) { IntArray(m + 1) }
    val result: Int

    init {
        for (i in 1..n) {
            for (j in 1..m) {
                if (s1[i - 1] == s2[j - 1]) {
                    arr[i][j] = arr[i - 1][j - 1] + 1
                } else {
                    arr[i][j] = arr[i][j - 1].coerceAtLeast(arr[i - 1][j])
                }
            }
        }

        result = arr[n][m]
    }
}