package com.potatomeme.baekjoon.`2023`.april


import java.util.StringTokenizer


//https://www.acmicpc.net/problem/10819

//차이를 최대로
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	256 MB	25642	16615	12823	65.380%
//문제
//N개의 정수로 이루어진 배열 A가 주어진다. 이때, 배열에 들어있는 정수의 순서를 적절히 바꿔서 다음 식의 최댓값을 구하는 프로그램을 작성하시오.
//
//|A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|
//
//입력
//첫째 줄에 N (3 ≤ N ≤ 8)이 주어진다. 둘째 줄에는 배열 A에 들어있는 정수가 주어진다. 배열에 들어있는 정수는 -100보다 크거나 같고, 100보다 작거나 같다.
//
//출력
//첫째 줄에 배열에 들어있는 수의 순서를 적절히 바꿔서 얻을 수 있는 식의 최댓값을 출력한다.
//
//예제 입력 1
//6
//20 1 15 8 4 10
//예제 출력 1
//62


fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val arr = IntArray(n) { st.nextToken().toInt() }
    val visited = BooleanArray(n)
    var maxSum = 0
    fun solve(depth: Int, before: Int, sum: Int) {
        if (depth == n - 1) {
            if (sum > maxSum) maxSum = sum
            return
        }
        for (i in 0 until n) {
            if (!visited[i]) {
                visited[i] = true
                solve(depth + 1, arr[i], sum + kotlin.math.abs(before - arr[i]))
                visited[i] = false
            }
        }
    }
    for (i in 0 until n) {
        visited[i] = true
        solve(0, arr[i], 0)
        visited[i] = false
    }
    print(maxSum)
}


