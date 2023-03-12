package com.potatomeme.baekjoon.`2023`.march

import java.util.StringTokenizer


//https://www.acmicpc.net/problem/2110

//가장 긴 증가하는 부분 수열 2 실패
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	512 MB	36482	14806	10311	41.496%
//문제
//수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.
//
//예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.
//
//입력
//첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다.
//
//둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000,000)
//
//출력
//첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.
//
//예제 입력 1
//6
//10 20 10 30 20 50
//예제 출력 1
//4


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val seq = IntArray(n)
    val lis = IntArray(n)
    val st = StringTokenizer(readLine())
    repeat(n) {
        seq[it] = st.nextToken().toInt()
    }
    lis[0] = seq[0]
    var lis_size = 1
    for (i in 1 until n) {
        val key = seq[i]
        if (lis[lis_size - 1] < key) {
            lis_size++
            lis[lis_size - 1] = key
        } else {
            var lo = 0
            var hi = lis_size
            while (lo < hi) {
                val mid = lo + hi ushr 1
                if (lis[mid] < key) {
                    lo = mid + 1
                } else {
                    hi = mid
                }
            }
            lis[lo] = key
        }
    }
    print(lis_size)
}