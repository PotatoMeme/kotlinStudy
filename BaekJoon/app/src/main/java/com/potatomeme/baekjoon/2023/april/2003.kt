package com.potatomeme.baekjoon.`2023`.april

import java.util.StringTokenizer


//https://www.acmicpc.net/problem/2003

//수들의 합 2
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//0.5 초	128 MB	43639	20966	14135	48.265%
//문제
//N개의 수로 된 수열 A[1], A[2], …, A[N] 이 있다. 이 수열의 i번째 수부터 j번째 수까지의 합 A[i] + A[i+1] + … + A[j-1] + A[j]가 M이 되는 경우의 수를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 N(1 ≤ N ≤ 10,000), M(1 ≤ M ≤ 300,000,000)이 주어진다. 다음 줄에는 A[1], A[2], …, A[N]이 공백으로 분리되어 주어진다. 각각의 A[x]는 30,000을 넘지 않는 자연수이다.
//
//출력
//첫째 줄에 경우의 수를 출력한다.
//
//예제 입력 1
//4 2
//1 1 1 1
//예제 출력 1
//3
//예제 입력 2
//10 5
//1 2 3 4 2 5 3 1 1 2
//예제 출력 2
//3

//try1
fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    st = StringTokenizer(readLine())
    val arr = IntArray(n) { st.nextToken().toInt() }
    var cnt = 0
    fun solve(startIdx: Int, endIdx: Int, sum: Int) {
        if (endIdx == n - 1) {
            if (sum <= m) {
                if (sum == m) cnt++
                return
            }
        }
        if (sum == m) {
            cnt++
            solve(startIdx + 1, endIdx, sum - arr[startIdx])
        } else if (sum < m) {
            solve(startIdx, endIdx + 1, sum + arr[endIdx + 1])
        } else {
            solve(startIdx + 1, endIdx, sum - arr[startIdx])
        }
    }
    solve(0, 0, arr[0])
    print(cnt)
}