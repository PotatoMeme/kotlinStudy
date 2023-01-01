package com.potatomeme.baekjoon.`2023`.january

//https://www.acmicpc.net/problem/15650

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
    val num = readLine().split(" ")
    val solution = Solution15650(num[0].toInt(), num[1].toInt())
    print(solution.sb.toString())
}

class Solution15650(val n: Int, val m: Int) {
    // try1 use DFS
    val sb = StringBuilder()
    val arr = IntArray(m)// 경로가담길 공간
    var visited = BooleanArray(n)// 해당값이 들어갔는지 확인할 공간

    init {
        //dfs_type1(0)
        dfs_type2(0, 0)
        //dfs(n, m, 0)
    }

    fun dfs(N: Int, M: Int, depth: Int) {
        if (depth == M) {
            for (i in arr) {
                sb.append("$i ")
            }
            sb.append("\n")
            return
        }

        for (i in 0 until N) {
            if (!visited[i]) {
                visited[i] = true
                arr[depth] = i + 1
                dfs(N, M, depth + 1)
                visited[i] = false
            }
        }
    }//14236kb 112ms

    fun dfs_type1(depth: Int) {
        if (depth == m) {
            for (i in arr) {
                sb.append("$i ")
            }
            sb.append("\n")
            return
        }

        for (i in 0 until n) {
            if (!visited[i]) {
                if (depth > 0) if (arr[depth - 1] > i + 1) continue
                visited[i] = true
                arr[depth] = i + 1
                dfs_type1(depth + 1)
                visited[i] = false
            }
        }
    }//14256kb 112ms

    fun dfs_type2(index: Int, depth: Int) {
        if (depth == m) {
            for (i in arr) {
                sb.append("$i ")
            }
            sb.append("\n")
            return
        }

        for (i in index until n) {
            arr[depth] = i + 1
            dfs_type2(i + 1, depth + 1)
        }
    }//14396kb	108ms
}