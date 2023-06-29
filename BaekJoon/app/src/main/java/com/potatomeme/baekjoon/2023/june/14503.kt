package com.potatomeme.baekjoon.`2023`.june

import java.util.StringTokenizer

//https://www.acmicpc.net/problem/14503

//로봇 청소기
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	512 MB	52495	28562	19245	53.730%
//문제
//로봇 청소기와 방의 상태가 주어졌을 때, 청소하는 영역의 개수를 구하는 프로그램을 작성하시오.
//
//로봇 청소기가 있는 방은
//$N \times M$ 크기의 직사각형으로 나타낼 수 있으며,
//$1 \times 1$ 크기의 정사각형 칸으로 나누어져 있다. 각각의 칸은 벽 또는 빈 칸이다. 청소기는 바라보는 방향이 있으며, 이 방향은 동, 서, 남, 북 중 하나이다. 방의 각 칸은 좌표
//$(r, c)$로 나타낼 수 있고, 가장 북쪽 줄의 가장 서쪽 칸의 좌표가
//$(0, 0)$, 가장 남쪽 줄의 가장 동쪽 칸의 좌표가
//$(N-1, M-1)$이다. 즉, 좌표
//$(r, c)$는 북쪽에서
//$(r+1)$번째에 있는 줄의 서쪽에서
//$(c+1)$번째 칸을 가리킨다. 처음에 빈 칸은 전부 청소되지 않은 상태이다.
//
//로봇 청소기는 다음과 같이 작동한다.
//
//현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
//현재 칸의 주변
//$4$칸 중 청소되지 않은 빈 칸이 없는 경우,
//바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
//바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
//현재 칸의 주변
//$4$칸 중 청소되지 않은 빈 칸이 있는 경우,
//반시계 방향으로
//$90^\circ$ 회전한다.
//바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
//1번으로 돌아간다.
//입력
//첫째 줄에 방의 크기
//$N$과
//$M$이 입력된다.
//$(3 \le N, M \le 50)$  둘째 줄에 처음에 로봇 청소기가 있는 칸의 좌표
//$(r, c)$와 처음에 로봇 청소기가 바라보는 방향
//$d$가 입력된다.
//$d$가
//$0$인 경우 북쪽,
//$1$인 경우 동쪽,
//$2$인 경우 남쪽,
//$3$인 경우 서쪽을 바라보고 있는 것이다.
//
//셋째 줄부터
//$N$개의 줄에 각 장소의 상태를 나타내는
//$N \times M$개의 값이 한 줄에
//$M$개씩 입력된다.
//$i$번째 줄의
//$j$번째 값은 칸
//$(i, j)$의 상태를 나타내며, 이 값이
//$0$인 경우
//$(i, j)$가 청소되지 않은 빈 칸이고,
//$1$인 경우
//$(i, j)$에 벽이 있는 것이다. 방의 가장 북쪽, 가장 남쪽, 가장 서쪽, 가장 동쪽 줄 중 하나 이상에 위치한 모든 칸에는 벽이 있다. 로봇 청소기가 있는 칸은 항상 빈 칸이다.
//
//출력
//로봇 청소기가 작동을 시작한 후 작동을 멈출 때까지 청소하는 칸의 개수를 출력한다.
//
//예제 입력 1
//3 3
//1 1 0
//1 1 1
//1 0 1
//1 1 1
//예제 출력 1
//1
//예제 입력 2
//11 10
//7 4 0
//1 1 1 1 1 1 1 1 1 1
//1 0 0 0 0 0 0 0 0 1
//1 0 0 0 1 1 1 1 0 1
//1 0 0 1 1 0 0 0 0 1
//1 0 1 1 0 0 0 0 0 1
//1 0 0 0 0 0 0 0 0 1
//1 0 0 0 0 0 0 1 0 1
//1 0 0 0 0 0 1 1 0 1
//1 0 0 0 0 0 1 1 0 1
//1 0 0 0 0 0 0 0 0 1
//1 1 1 1 1 1 1 1 1 1
//예제 출력 2
//57


fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val (r, c, d) = readLine().split(" ").map { it.toInt() }
    val board = Array(n) {
        val st = StringTokenizer(readLine())
        IntArray(m) { st.nextToken()[0] - '0' }
    }
    print(Solution14503(n, m, r, c, d, board).cleanCount)
}

class Solution14503(
    private val n: Int, private val m: Int, r: Int, c: Int, d: Int,
    private val board: Array<IntArray>,
) {

    // 0인 경우 북쪽,
    // 1인 경우 동쪽,
    // 2인 경우 남쪽,
    // 3인 경우 서쪽
    private val dir = arrayOf(
        //intArrayOf(x,y),
        intArrayOf(0, -1),
        intArrayOf(1, 0),
        intArrayOf(0, 1),
        intArrayOf(-1, 0),
    )

    var cleanCount = 0
        private set

    init {
        board[r][c] = 2
        cleanCount++
        play(d, currentX =  c, currentY =  r)
    }

    private fun play(currentDir: Int, currentX: Int, currentY: Int) {
        //step3
        var direction = currentDir
        for (i in 0 until 4 ) {
            direction--
            if (direction < 0) direction = 3
            if (board[currentY + dir[direction][1]][currentX + dir[direction][0]] == 0) {
                board[currentY + dir[direction][1]][currentX + dir[direction][0]] = 2
                cleanCount++
                play(direction, currentX + dir[direction][0], currentY + dir[direction][1])
                return
            }
        }
        //step2
        if (board[currentY + dir[(currentDir + 2) % 4][1]][currentX + dir[(currentDir + 2) % 4][0]] == 1) return
        play(
            currentDir,
            currentX + dir[(currentDir + 2) % 4][0],
            currentY + dir[(currentDir + 2) % 4][1]
        )
    }
}