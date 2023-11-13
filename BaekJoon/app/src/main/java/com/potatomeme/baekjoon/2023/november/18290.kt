package com.potatomeme.baekjoon.`2023`.november

import java.util.StringTokenizer

//NM과 K (1)
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	512 MB	8322	2445	1469	25.963%
//문제
//크기가 N×M인 격자판의 각 칸에 정수가 하나씩 들어있다. 이 격자판에서 칸 K개를 선택할 것이고, 선택한 칸에 들어있는 수를 모두 더한 값의 최댓값을 구하려고 한다. 단, 선택한 두 칸이 인접하면 안된다. r행 c열에 있는 칸을 (r, c)라고 했을 때, (r-1, c), (r+1, c), (r, c-1), (r, c+1)에 있는 칸이 인접한 칸이다.
//
//입력
//첫째 줄에 N, M, K가 주어진다. 둘째 줄부터 N개의 줄에 격자판에 들어있는 수가 주어진다.
//
//출력
//선택한 칸에 들어있는 수를 모두 더한 값의 최댓값을 출력한다.
//
//제한
//1 ≤ N, M ≤ 10
//1 ≤ K ≤ min(4, N×M)
//격자판에 들어있는 수는 -10,000보다 크거나 같고, 10,000보다 작거나 같은 정수이다.
//항상 K개의 칸을 선택할 수 있는 경우만 입력으로 주어진다.
//예제 입력 1
//1 1 1
//1
//예제 출력 1
//1
//예제 입력 2
//2 2 2
//1 2
//3 4
//예제 출력 2
//5
//예제 입력 3
//2 2 2
//5 4
//4 5
//예제 출력 3
//10
//예제 입력 4
//5 5 3
//1 9 8 -2 0
//-1 9 8 -3 0
//-5 1 9 -1 0
//0 0 0 9 8
//9 9 9 0 0
//예제 출력 4
//27

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, k) = readLine().split(" ").map { it.toInt() }
    val board = Array(n) {
        val st = StringTokenizer(readLine())
        IntArray(m) {
            st.nextToken().toInt()
        }
    }
    val boardChecked = Array(n) { BooleanArray(m) }

    var max = Int.MIN_VALUE

    val nMinusOne = n - 1
    val mMinusOne = m - 1
    fun dfs(depth: Int, sum: Int, beforeI: Int, beforeJ: Int) {
        if (depth == k) {
            if (sum >= max) max = sum
            return
        }
        for (j in beforeJ + 2 until m) {
            if (!boardChecked[beforeI][j]
                && (beforeI == 0 || !boardChecked[beforeI - 1][j])
                && (beforeI == nMinusOne || !boardChecked[beforeI + 1][j])
                && (j == 0 || !boardChecked[beforeI][j - 1])
                && (j == mMinusOne || !boardChecked[beforeI][j + 1])
            ) {
                boardChecked[beforeI][j] = true
                dfs(depth + 1, sum + board[beforeI][j], beforeI, j)
                boardChecked[beforeI][j] = false
            }
        }

        for (i in beforeI + 1 until n) {
            for (j in 0 until m) {
                if (!boardChecked[i][j]
                    && (i == 0 || !boardChecked[i - 1][j])
                    && (i == nMinusOne || !boardChecked[i + 1][j])
                    && (j == 0 || !boardChecked[i][j - 1])
                    && (j == mMinusOne || !boardChecked[i][j + 1])
                ) {
                    boardChecked[i][j] = true
                    dfs(depth + 1, sum + board[i][j], i, j)
                    boardChecked[i][j] = false
                }
            }
        }
    }
    dfs(0, 0, 0,-2)
    print(max)
}