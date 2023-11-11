package com.potatomeme.baekjoon.`2023`.november

import java.util.StringTokenizer

//N과 M (5)
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	512 MB	32242	23608	18962	72.688%
//문제
//N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. N개의 자연수는 모두 다른 수이다.
//
//N개의 자연수 중에서 M개를 고른 수열
//입력
//첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
//
//둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.
//
//출력
//한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
//
//수열은 사전 순으로 증가하는 순서로 출력해야 한다.
//
//예제 입력 1
//3 1
//4 5 2
//예제 출력 1
//2
//4
//5
//예제 입력 2
//4 2
//9 8 7 1
//예제 출력 2
//1 7
//1 8
//1 9
//7 1
//7 8
//7 9
//8 1
//8 7
//8 9
//9 1
//9 7
//9 8
//예제 입력 3
//4 4
//1231 1232 1233 1234
//예제 출력 3
//1231 1232 1233 1234
//1231 1232 1234 1233
//1231 1233 1232 1234
//1231 1233 1234 1232
//1231 1234 1232 1233
//1231 1234 1233 1232
//1232 1231 1233 1234
//1232 1231 1234 1233
//1232 1233 1231 1234
//1232 1233 1234 1231
//1232 1234 1231 1233
//1232 1234 1233 1231
//1233 1231 1232 1234
//1233 1231 1234 1232
//1233 1232 1231 1234
//1233 1232 1234 1231
//1233 1234 1231 1232
//1233 1234 1232 1231
//1234 1231 1232 1233
//1234 1231 1233 1232
//1234 1232 1231 1233
//1234 1232 1233 1231
//1234 1233 1231 1232
//1234 1233 1232 1231

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val st = StringTokenizer(readLine())
    val arr = IntArray(n) {
        st.nextToken().toInt()
    }.sorted()
    val checked = BooleanArray(n)
    val sb = StringBuilder()
    val saveSb = StringBuilder()
    fun dfs(depth: Int) {
        if (depth == m) {
            sb.appendLine(saveSb.toString())
            return
        }
        for (i in arr.indices) {
            if (!checked[i]) {
                checked[i] = true
                val start = saveSb.length
                saveSb.append(" ").append(arr[i])
                dfs(depth + 1)
                saveSb.deleteRange(start,saveSb.length)
                checked[i] = false
            }
        }
    }
    for (i in arr.indices){
        checked[i] = true
        saveSb.append(arr[i])
        dfs(1)
        saveSb.clear()
        checked[i] = false
    }

    print(sb.toString())
}