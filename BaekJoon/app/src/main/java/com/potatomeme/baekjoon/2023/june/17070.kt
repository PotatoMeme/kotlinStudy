package com.potatomeme.baekjoon.`2023`.june


import java.util.StringTokenizer

//https://www.acmicpc.net/problem/5698

//파이프 옮기기 1
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초 (추가 시간 없음)	512 MB	31800	14890	10222	45.771%
//문제
//유현이가 새 집으로 이사했다. 새 집의 크기는 N×N의 격자판으로 나타낼 수 있고, 1×1크기의 정사각형 칸으로 나누어져 있다. 각각의 칸은 (r, c)로 나타낼 수 있다. 여기서 r은 행의 번호, c는 열의 번호이고, 행과 열의 번호는 1부터 시작한다. 각각의 칸은 빈 칸이거나 벽이다.
//
//오늘은 집 수리를 위해서 파이프 하나를 옮기려고 한다. 파이프는 아래와 같은 형태이고, 2개의 연속된 칸을 차지하는 크기이다.
//
//
//
//파이프는 회전시킬 수 있으며, 아래와 같이 3가지 방향이 가능하다.
//
//
//
//파이프는 매우 무겁기 때문에, 유현이는 파이프를 밀어서 이동시키려고 한다. 벽에는 새로운 벽지를 발랐기 때문에, 파이프가 벽을 긁으면 안 된다. 즉, 파이프는 항상 빈 칸만 차지해야 한다.
//
//파이프를 밀 수 있는 방향은 총 3가지가 있으며, →, ↘, ↓ 방향이다. 파이프는 밀면서 회전시킬 수 있다. 회전은 45도만 회전시킬 수 있으며, 미는 방향은 오른쪽, 아래, 또는 오른쪽 아래 대각선 방향이어야 한다.
//
//파이프가 가로로 놓여진 경우에 가능한 이동 방법은 총 2가지, 세로로 놓여진 경우에는 2가지, 대각선 방향으로 놓여진 경우에는 3가지가 있다.
//
//아래 그림은 파이프가 놓여진 방향에 따라서 이동할 수 있는 방법을 모두 나타낸 것이고, 꼭 빈 칸이어야 하는 곳은 색으로 표시되어져 있다.
//
//
//
//가로
//
//
//
//세로
//
//
//
//대각선
//
//가장 처음에 파이프는 (1, 1)와 (1, 2)를 차지하고 있고, 방향은 가로이다. 파이프의 한쪽 끝을 (N, N)로 이동시키는 방법의 개수를 구해보자.
//
//입력
//첫째 줄에 집의 크기 N(3 ≤ N ≤ 16)이 주어진다. 둘째 줄부터 N개의 줄에는 집의 상태가 주어진다. 빈 칸은 0, 벽은 1로 주어진다. (1, 1)과 (1, 2)는 항상 빈 칸이다.
//
//출력
//첫째 줄에 파이프의 한쪽 끝을 (N, N)으로 이동시키는 방법의 수를 출력한다. 이동시킬 수 없는 경우에는 0을 출력한다. 방법의 수는 항상 1,000,000보다 작거나 같다.
//
//예제 입력 1
//3
//0 0 0
//0 0 0
//0 0 0
//예제 출력 1
//1
//예제 입력 2
//4
//0 0 0 0
//0 0 0 0
//0 0 0 0
//0 0 0 0
//예제 출력 2
//3
//예제 입력 3
//5
//0 0 1 0 0
//0 0 0 0 0
//0 0 0 0 0
//0 0 0 0 0
//0 0 0 0 0
//예제 출력 3
//0
//예제 입력 4
//6
//0 0 0 0 0 0
//0 1 0 0 0 0
//0 0 0 0 0 0
//0 0 0 0 0 0
//0 0 0 0 0 0
//0 0 0 0 0 0
//예제 출력 4
//13


fun main() = with(System.`in`.bufferedReader()) {
    /**        Just Solve     */
    //print(Solution17070Type1().totalCnt)

    // 부분합
    val n = readLine().toInt()
    val arr = Array(n) {
        val st = StringTokenizer(readLine())
        BooleanArray(n) { st.nextToken()[0] == '1' }
    }
    val dp = Array(n) { Array(n) { IntArray(3) } }
    dp[0][1][0] = 1

    for (i in 0 until n) {
        for (j in 2 until n) {
            if (arr[i][j]) continue
            dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2]
            if (i == 0) continue
            dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2]
            if (arr[i - 1][j] || arr[i][j - 1]) continue
            dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2]
        }
    }

    print(dp[n - 1][n - 1][0] + dp[n - 1][n - 1][1] + dp[n - 1][n - 1][2])
}

class Solution17070Type1() {
    val arr: Array<BooleanArray>
    var totalCnt = 0
    val max: Int

    init {
        val n = readLine()!!.toInt()
        arr = Array(n) { BooleanArray(n) }
        max = n - 1
        repeat(n) { i1 ->
            val st = StringTokenizer(readLine())
            repeat(n) { i2 ->
                if (st.nextToken()[0] == '1') arr[i1][i2] = true
            }
        }
        pipeType1(1, 0)
    }

    private fun pipeType1(x: Int, y: Int) {
        if (x == max) {
            if (y == max) totalCnt++
            return
        }
        if (arr[y][x + 1]) return
        pipeType1(x + 1, y)
        if (y == max || arr[y + 1][x] || arr[y + 1][x + 1]) return
        pipeType3(x + 1, y + 1)
    }

    private fun pipeType2(x: Int, y: Int) {
        if (y == max) {
            if (x == max) totalCnt++
            return
        }
        if (arr[y + 1][x]) return
        pipeType2(x, y + 1)
        if (x == max || arr[y][x + 1] || arr[y + 1][x + 1]) return
        pipeType3(x + 1, y + 1)
    }

    private fun pipeType3(x: Int, y: Int) {
        if (x == max && y == max) {
            totalCnt++
            return
        }
        var checkPipeType1 = false
        var checkPipeType2 = false
        if (x < max && !arr[y][x + 1]) {
            checkPipeType1 = true
            pipeType1(x + 1, y)
        }
        if (y < max && !arr[y + 1][x]) {
            checkPipeType2 = true
            pipeType2(x, y + 1)
        }
        if (checkPipeType1 && checkPipeType2 && !arr[y + 1][x + 1]) pipeType3(x + 1, y + 1)
    }
}

