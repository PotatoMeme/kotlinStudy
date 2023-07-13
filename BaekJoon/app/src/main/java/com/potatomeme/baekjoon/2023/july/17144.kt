package com.potatomeme.baekjoon.`2023`.july

import java.util.StringTokenizer

//https://www.acmicpc.net/problem/17144

//미세먼지 안녕!
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	512 MB	32501	17882	11990	54.241%
//문제
//미세먼지를 제거하기 위해 구사과는 공기청정기를 설치하려고 한다. 공기청정기의 성능을 테스트하기 위해 구사과는 집을 크기가 R×C인 격자판으로 나타냈고, 1×1 크기의 칸으로 나눴다. 구사과는 뛰어난 코딩 실력을 이용해 각 칸 (r, c)에 있는 미세먼지의 양을 실시간으로 모니터링하는 시스템을 개발했다. (r, c)는 r행 c열을 의미한다.
//
//
//
//공기청정기는 항상 1번 열에 설치되어 있고, 크기는 두 행을 차지한다. 공기청정기가 설치되어 있지 않은 칸에는 미세먼지가 있고, (r, c)에 있는 미세먼지의 양은 Ar,c이다.
//
//1초 동안 아래 적힌 일이 순서대로 일어난다.
//
//미세먼지가 확산된다. 확산은 미세먼지가 있는 모든 칸에서 동시에 일어난다.
//(r, c)에 있는 미세먼지는 인접한 네 방향으로 확산된다.
//인접한 방향에 공기청정기가 있거나, 칸이 없으면 그 방향으로는 확산이 일어나지 않는다.
//확산되는 양은 Ar,c/5이고 소수점은 버린다.
//(r, c)에 남은 미세먼지의 양은 Ar,c - (Ar,c/5)×(확산된 방향의 개수) 이다.
//공기청정기가 작동한다.
//공기청정기에서는 바람이 나온다.
//위쪽 공기청정기의 바람은 반시계방향으로 순환하고, 아래쪽 공기청정기의 바람은 시계방향으로 순환한다.
//바람이 불면 미세먼지가 바람의 방향대로 모두 한 칸씩 이동한다.
//공기청정기에서 부는 바람은 미세먼지가 없는 바람이고, 공기청정기로 들어간 미세먼지는 모두 정화된다.
//다음은 확산의 예시이다.
//
//
//
//왼쪽과 위쪽에 칸이 없기 때문에, 두 방향으로만 확산이 일어났다.
//
//
//
//인접한 네 방향으로 모두 확산이 일어난다.
//
//
//
//공기청정기가 있는 칸으로는 확산이 일어나지 않는다.
//
//공기청정기의 바람은 다음과 같은 방향으로 순환한다.
//
//
//
//방의 정보가 주어졌을 때, T초가 지난 후 구사과의 방에 남아있는 미세먼지의 양을 구해보자.
//
//입력
//첫째 줄에 R, C, T (6 ≤ R, C ≤ 50, 1 ≤ T ≤ 1,000) 가 주어진다.
//
//둘째 줄부터 R개의 줄에 Ar,c (-1 ≤ Ar,c ≤ 1,000)가 주어진다. 공기청정기가 설치된 곳은 Ar,c가 -1이고, 나머지 값은 미세먼지의 양이다. -1은 2번 위아래로 붙어져 있고, 가장 윗 행, 아랫 행과 두 칸이상 떨어져 있다.
//
//출력
//첫째 줄에 T초가 지난 후 구사과 방에 남아있는 미세먼지의 양을 출력한다.
//
//예제 입력 1
//7 8 1
//0 0 0 0 0 0 0 9
//0 0 0 0 3 0 0 8
//-1 0 5 0 0 0 22 0
//-1 8 0 0 0 0 0 0
//0 0 0 0 0 10 43 0
//0 0 5 0 15 0 0 0
//0 0 40 0 0 0 20 0
//예제 출력 1
//188
//미세먼지의 확산이 일어나면 다음과 같은 상태가 된다.
//
//
//
//공기청정기가 작동한 이후 상태는 아래와 같다.
//
//
//
//예제 입력 2
//7 8 2
//0 0 0 0 0 0 0 9
//0 0 0 0 3 0 0 8
//-1 0 5 0 0 0 22 0
//-1 8 0 0 0 0 0 0
//0 0 0 0 0 10 43 0
//0 0 5 0 15 0 0 0
//0 0 40 0 0 0 20 0
//예제 출력 2
//188
//예제 입력 3
//7 8 3
//0 0 0 0 0 0 0 9
//0 0 0 0 3 0 0 8
//-1 0 5 0 0 0 22 0
//-1 8 0 0 0 0 0 0
//0 0 0 0 0 10 43 0
//0 0 5 0 15 0 0 0
//0 0 40 0 0 0 20 0
//예제 출력 3
//186
//예제 입력 4
//7 8 4
//0 0 0 0 0 0 0 9
//0 0 0 0 3 0 0 8
//-1 0 5 0 0 0 22 0
//-1 8 0 0 0 0 0 0
//0 0 0 0 0 10 43 0
//0 0 5 0 15 0 0 0
//0 0 40 0 0 0 20 0
//예제 출력 4
//178
//예제 입력 5
//7 8 5
//0 0 0 0 0 0 0 9
//0 0 0 0 3 0 0 8
//-1 0 5 0 0 0 22 0
//-1 8 0 0 0 0 0 0
//0 0 0 0 0 10 43 0
//0 0 5 0 15 0 0 0
//0 0 40 0 0 0 20 0
//예제 출력 5
//172
//예제 입력 6
//7 8 20
//0 0 0 0 0 0 0 9
//0 0 0 0 3 0 0 8
//-1 0 5 0 0 0 22 0
//-1 8 0 0 0 0 0 0
//0 0 0 0 0 10 43 0
//0 0 5 0 15 0 0 0
//0 0 40 0 0 0 20 0
//예제 출력 6
//71
//예제 입력 7
//7 8 30
//0 0 0 0 0 0 0 9
//0 0 0 0 3 0 0 8
//-1 0 5 0 0 0 22 0
//-1 8 0 0 0 0 0 0
//0 0 0 0 0 10 43 0
//0 0 5 0 15 0 0 0
//0 0 40 0 0 0 20 0
//예제 출력 7
//52
//예제 입력 8
//7 8 50
//0 0 0 0 0 0 0 9
//0 0 0 0 3 0 0 8
//-1 0 5 0 0 0 22 0
//-1 8 0 0 0 0 0 0
//0 0 0 0 0 10 43 0
//0 0 5 0 15 0 0 0
//0 0 40 0 0 0 20 0
//예제 출력 8
//46


fun main() = with(System.`in`.bufferedReader()) {
    val (r, c, t) = readLine().split(" ").map { it.toInt() }

    var maschineY = 0
    val board = Array(r) { idx ->
        val st = StringTokenizer(readLine())
        IntArray(c) {
            val n = st.nextToken().toInt()
            if (n == -1) {
                maschineY = idx
                0
            } else n
        }
    }
    print(Solution17144(r, c, t, board, maschineY).count)
    return@with
}

class Solution17144(
    private val r: Int,
    private val c: Int,
    t: Int,
    private val board: Array<IntArray>,
    maschineY: Int,
) {
    data class Pos(val x: Int, val y: Int)

    private val topOfMaschinePosY = maschineY - 1
    private val bottomOfMaschinePosY = maschineY
    private val dir = arrayOf(
        Pos(0, -1),//북
        Pos(1, 0),//동
        Pos(0, 1),//남
        Pos(-1, 0),//서
    )
    var count = 0
    private val tempBoard = Array(r){IntArray(c)}

    init {
        var isEmpty = false
        for (i in 0 until t) {
            if (dustDiffusion()) {
                mashineRunning()
            } else {
                isEmpty = true
            }
        }
        count = if (isEmpty) 0 else countDust()
    }

    private fun dustDiffusion(): Boolean {
        var dustIsIn = false
        for (i in 0 until r) {
            for (j in 0 until c) {
                if (board[i][j] != 0) {
                    dustIsIn = true
                    val diffusion = board[i][j] / 5
                    if (diffusion < 0) {
                        tempBoard[i][j] += board[i][j]
                    } else {
                        var count = 0
                        for (direction in dir) {
                            if (j + direction.x !in 0 until c || i + direction.y !in 0 until r) continue
                            if (j + direction.x == 0 && (i + direction.y == topOfMaschinePosY ||i + direction.y == bottomOfMaschinePosY)) continue
                            count++
                            tempBoard[i + direction.y][j + direction.x] += diffusion
                        }
                        tempBoard[i][j] += board[i][j] - diffusion * count
                    }
                }
            }
        }
        return if (dustIsIn){
            for (i in 0 until r) {
                for (j in 0 until c) {
                    board[i][j] = tempBoard[i][j]
                    tempBoard[i][j] = 0
                }
            }
            true
        }else false
    }

    private fun mashineRunning(){
        //top
        var currentX = 0
        var currentY = topOfMaschinePosY
        var dirIdx = 0
        while (true){
            if (currentX+dir[dirIdx].x !in 0 until c || currentY+dir[dirIdx].y !in 0 until r ) dirIdx++
            if (currentX == c - 1 && currentY == topOfMaschinePosY) dirIdx++
            board[currentY][currentX] = board[currentY+dir[dirIdx].y][currentX+dir[dirIdx].x]
            currentX += dir[dirIdx].x
            currentY += dir[dirIdx].y
            if (currentX == 1 && currentY == topOfMaschinePosY) break
        }
        board[currentY][currentX] = 0
        board[topOfMaschinePosY][0] = 0

        //bottom
        currentX = 0
        currentY = bottomOfMaschinePosY
        dirIdx = 2
        while (true){
            if (currentX+dir[dirIdx].x !in 0 until c || currentY+dir[dirIdx].y !in 0 until r ) dirIdx--
            if (currentX == c - 1 && currentY == bottomOfMaschinePosY) dirIdx = 3

            board[currentY][currentX] = board[currentY+dir[dirIdx].y][currentX+dir[dirIdx].x]
            currentX += dir[dirIdx].x
            currentY += dir[dirIdx].y
            if (currentX == 1 && currentY == bottomOfMaschinePosY) break
        }
        board[currentY][currentX] = 0
        board[bottomOfMaschinePosY][0] = 0
    }

    private fun countDust(): Int {
        var result = 0
        for (i in 0 until r) {
            for (j in 0 until c) {
                result += board[i][j]
            }
        }
        return result
    }
}