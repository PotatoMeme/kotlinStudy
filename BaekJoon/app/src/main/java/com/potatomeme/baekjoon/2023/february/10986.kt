package com.potatomeme.baekjoon.`2023`.february

import java.util.StringTokenizer


//https://www.acmicpc.net/problem/10986

//나머지 합
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	256 MB	22109	6494	4756	27.863%
//문제
//수 N개 A1, A2, ..., AN이 주어진다. 이때, 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 구하는 프로그램을 작성하시오.
//
//즉, Ai + ... + Aj (i ≤ j) 의 합이 M으로 나누어 떨어지는 (i, j) 쌍의 개수를 구해야 한다.
//
//입력
//첫째 줄에 N과 M이 주어진다. (1 ≤ N ≤ 106, 2 ≤ M ≤ 103)
//
//둘째 줄에 N개의 수 A1, A2, ..., AN이 주어진다. (0 ≤ Ai ≤ 109)
//
//출력
//첫째 줄에 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 출력한다.
//
//예제 입력 1
//5 3
//1 2 3 1 2
//예제 출력 1
//7


// (나머지1 + 나머지2)나머지 = (원본1+원본2)나머지

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    st = StringTokenizer(readLine())
    val arr1 = LongArray(n + 1) { 0 }
    val arr2 = LongArray(m) { 0 }
    var cnt = 0L
    for (i in 1..n) {
        val num = st.nextToken().toInt()
        arr1[i] = (arr1[i - 1] + num) % m
        if (arr1[i] == 0L) cnt++
        arr2[arr1[i].toInt()]++
    }
    for (i in 0 until m) {
        if (arr2[i] > 1) {
            cnt += arr2[i] * (arr2[i] - 1) / 2
        }
    }

    print(cnt)
}
