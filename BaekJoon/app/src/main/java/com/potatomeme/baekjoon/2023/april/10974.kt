package com.potatomeme.baekjoon.`2023`.april


//https://www.acmicpc.net/problem/4779

//모든 순열
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	256 MB	25321	16004	12190	63.956%
//문제
//N이 주어졌을 때, 1부터 N까지의 수로 이루어진 순열을 사전순으로 출력하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 N(1 ≤ N ≤ 8)이 주어진다.
//
//출력
//첫째 줄부터 N!개의 줄에 걸쳐서 모든 순열을 사전순으로 출력한다.
//
//예제 입력 1
//3
//예제 출력 1
//1 2 3
//1 3 2
//2 1 3
//2 3 1
//3 1 2
//3 2 1

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val visited = BooleanArray(n + 1)
    val ans = StringBuilder()
    val sb = StringBuilder()

    fun solve(depth: Int) {
        if (depth == n) {
            ans.appendLine(sb)
            return
        }
        for (i in 1..n) {
            if (!visited[i]) {
                visited[i] = true
                sb.append(i).append(" ")
                solve(depth + 1)
                visited[i] = false
                sb.delete(sb.length - 2, sb.length)
            }
        }
    }

    solve(0)

    print(ans.toString())
}
