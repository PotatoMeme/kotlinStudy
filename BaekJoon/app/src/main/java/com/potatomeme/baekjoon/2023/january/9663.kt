package com.potatomeme.baekjoon.`2023`.january

import kotlin.math.absoluteValue

//https://www.acmicpc.net/problem/9663

//N과 M (2)
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	512 MB	51269	38279	27751	74.191%
//문제
//자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
//
//1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
//고른 수열은 오름차순이어야 한다.
//입력
//첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
//
//출력
//한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
//
//수열은 사전 순으로 증가하는 순서로 출력해야 한다.
//
//예제 입력 1
//3 1
//예제 출력 1
//1
//2
//3
//예제 입력 2
//4 2
//예제 출력 2
//1 2
//1 3
//1 4
//2 3
//2 4
//3 4
//예제 입력 3
//4 4
//예제 출력 3
//1 2 3 4

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val num = readLine().toInt()
    val solution = Solution9663_try2(num)
    print(solution.count)
}
// try1 use DFS
class Solution9663_try1(val n: Int) {
    var count = 0
    init {
        var visited = Array(n) { BooleanArray(n) { false } }
        dfs(visited, 0)
    }
    fun dfs(visited: Array<BooleanArray>, depth: Int) {
        if (depth == n) {
            count++
            return
        }
        for (i in 0 until n) {
            if (!visited[depth][i]) {
                val saveVisited = Array(n) { BooleanArray(n) }
                repeat(n) { j ->
                    var arr = BooleanArray(n)
                    repeat(n) { k ->
                        arr[k] = visited[j][k]
                    }
                    saveVisited[j] = arr
                }//깊은 복사가 안됨
                for (j in 0 until n - depth) {
                    saveVisited[depth + j][i] = true
                    if (i + j < n) saveVisited[depth + j][i + j] = true
                    if (i - j >= 0) saveVisited[depth + j][i - j] = true
                }
                dfs(saveVisited, depth + 1)
            }
        }
    }//메모리 초과
}

// try2 use DFS
class Solution9663_try2(val n: Int) {
    var count = 0
    val visited = IntArray(n)
    init {
        dfs( 0)
    }
    fun dfs(depth: Int) {
        if (depth == n) {
            count++
            return
        }
        for (i in 0 until n) {
            visited[depth] = i
            if (isOk(depth)) dfs(depth+1)
        }
    }
    fun isOk(depth: Int):Boolean{
        for (i in 0 until depth){
            if (visited[depth] == visited[i]) return false
            if ((depth-i).absoluteValue == (visited[depth] -visited[i]).absoluteValue) return false
        }
        return true
    }
}