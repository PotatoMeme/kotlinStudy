package com.potatomeme.baekjoon.`2023`.june

import java.util.LinkedList
import java.util.Queue

//https://www.acmicpc.net/problem/13460

//구슬 탈출 2
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	512 MB	79021	23746	13321	27.576%
//문제
//스타트링크에서 판매하는 어린이용 장난감 중에서 가장 인기가 많은 제품은 구슬 탈출이다. 구슬 탈출은 직사각형 보드에 빨간 구슬과 파란 구슬을 하나씩 넣은 다음, 빨간 구슬을 구멍을 통해 빼내는 게임이다.
//
//보드의 세로 크기는 N, 가로 크기는 M이고, 편의상 1×1크기의 칸으로 나누어져 있다. 가장 바깥 행과 열은 모두 막혀져 있고, 보드에는 구멍이 하나 있다. 빨간 구슬과 파란 구슬의 크기는 보드에서 1×1크기의 칸을 가득 채우는 사이즈이고, 각각 하나씩 들어가 있다. 게임의 목표는 빨간 구슬을 구멍을 통해서 빼내는 것이다. 이때, 파란 구슬이 구멍에 들어가면 안 된다.
//
//이때, 구슬을 손으로 건드릴 수는 없고, 중력을 이용해서 이리 저리 굴려야 한다. 왼쪽으로 기울이기, 오른쪽으로 기울이기, 위쪽으로 기울이기, 아래쪽으로 기울이기와 같은 네 가지 동작이 가능하다.
//
//각각의 동작에서 공은 동시에 움직인다. 빨간 구슬이 구멍에 빠지면 성공이지만, 파란 구슬이 구멍에 빠지면 실패이다. 빨간 구슬과 파란 구슬이 동시에 구멍에 빠져도 실패이다. 빨간 구슬과 파란 구슬은 동시에 같은 칸에 있을 수 없다. 또, 빨간 구슬과 파란 구슬의 크기는 한 칸을 모두 차지한다. 기울이는 동작을 그만하는 것은 더 이상 구슬이 움직이지 않을 때 까지이다.
//
//보드의 상태가 주어졌을 때, 최소 몇 번 만에 빨간 구슬을 구멍을 통해 빼낼 수 있는지 구하는 프로그램을 작성하시오.
//
//입력
//첫 번째 줄에는 보드의 세로, 가로 크기를 의미하는 두 정수 N, M (3 ≤ N, M ≤ 10)이 주어진다. 다음 N개의 줄에 보드의 모양을 나타내는 길이 M의 문자열이 주어진다. 이 문자열은 '.', '#', 'O', 'R', 'B' 로 이루어져 있다. '.'은 빈 칸을 의미하고, '#'은 공이 이동할 수 없는 장애물 또는 벽을 의미하며, 'O'는 구멍의 위치를 의미한다. 'R'은 빨간 구슬의 위치, 'B'는 파란 구슬의 위치이다.
//
//입력되는 모든 보드의 가장자리에는 모두 '#'이 있다. 구멍의 개수는 한 개 이며, 빨간 구슬과 파란 구슬은 항상 1개가 주어진다.
//
//출력
//최소 몇 번 만에 빨간 구슬을 구멍을 통해 빼낼 수 있는지 출력한다. 만약, 10번 이하로 움직여서 빨간 구슬을 구멍을 통해 빼낼 수 없으면 -1을 출력한다.
//
//예제 입력 1
//5 5
//#####
//#..B#
//#.#.#
//#RO.#
//#####
//예제 출력 1
//1
//예제 입력 2
//7 7
//#######
//#...RB#
//#.#####
//#.....#
//#####.#
//#O....#
//#######
//예제 출력 2
//5
//예제 입력 3
//7 7
//#######
//#..R#B#
//#.#####
//#.....#
//#####.#
//#O....#
//#######
//예제 출력 3
//5
//예제 입력 4
//10 10
//##########
//#R#...##B#
//#...#.##.#
//#####.##.#
//#......#.#
//#.######.#
//#.#....#.#
//#.#.#.#..#
//#...#.O#.#
//##########
//예제 출력 4
//-1
//예제 입력 5
//3 7
//#######
//#R.O.B#
//#######
//예제 출력 5
//1
//예제 입력 6
//10 10
//##########
//#R#...##B#
//#...#.##.#
//#####.##.#
//#......#.#
//#.######.#
//#.#....#.#
//#.#.##...#
//#O..#....#
//##########
//예제 출력 6
//7
//예제 입력 7
//3 10
//##########
//#.O....RB#
//##########
//예제 출력 7
//-1


fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(' ').map { it.toInt() }
    var rx = 0
    var ry = 0
    var bx = 0
    var by = 0
    val board = Array(n) { i1 ->
        val line = readLine()
        CharArray(m) { i2 ->
            if (line[i2] == 'R') {
                rx = i2
                ry = i1
                '.'
            } else if (line[i2] == 'B') {
                bx = i2
                by = i1
                '.'
            } else {
                line[i2]
            }

        }
    }
    print(Solution13460(n, m, board, rx, ry, bx, by).result)
}

class Solution13460(
    n: Int,
    m: Int,
    private val board: Array<CharArray>,
    rx: Int,
    ry: Int,
    bx: Int,
    by: Int,
) {
    var result: Int = -1
    private val visited = Array(m) { Array(n) { Array(m) { BooleanArray(n) } } }
    private val firsState = State(Pos(rx, ry), Pos(bx, by), 0)
    private val dir = arrayOf(
        //intArrayOf(x,y),
        intArrayOf(0, 1),//북
        intArrayOf(1, 0),//동
        intArrayOf(0, -1),//남
        intArrayOf(-1, 0),//서
    )

    init {
        visited[rx][ry][bx][by] = true
        bfs()
    }

    private fun bfs() {
        val q: Queue<State> = LinkedList()
        q.add(firsState)
        while (q.isNotEmpty()) {
            val currentState = q.poll()!!
            if (currentState.depth > 9) return
            subLoop@ for (dirIdx in 0..3) { // {0,북}, {1,동}, {2,남}, {3,서}
                var rx: Int = currentState.rPos.x
                var ry: Int = currentState.rPos.y
                var bx: Int = currentState.bPos.x
                var by: Int = currentState.bPos.y

                val order = when (dirIdx) {
                    0 -> ry > by
                    1 -> rx > bx
                    2 ->  ry < by
                    else -> rx < bx
                }

                var rLimit = true
                var bLimit = true

                // 공의 이동 로직
                if (order) {
                    while (rLimit || bLimit) {
                        if (rLimit) {
                            when (board[ry + dir[dirIdx][1]][rx + dir[dirIdx][0]]) {
                                '.' -> {
                                    rx += dir[dirIdx][0]
                                    ry += dir[dirIdx][1]
                                }

                                '#' -> {
                                    rLimit = false
                                }

                                'O' -> {
                                    rx += dir[dirIdx][0]
                                    ry += dir[dirIdx][1]
                                    rLimit = false
                                }
                            }
                        }
                        if (bLimit) {
                            when (board[by + dir[dirIdx][1]][bx + dir[dirIdx][0]]) {
                                '.' -> {
                                    bx += dir[dirIdx][0]
                                    by += dir[dirIdx][1]
                                    if (rx == bx && ry == by) {
                                        bx -= dir[dirIdx][0]
                                        by -= dir[dirIdx][1]
                                        bLimit = false
                                    }
                                }

                                '#' -> {
                                    bLimit = false
                                }

                                'O' -> {
                                    continue@subLoop
                                }
                            }
                        }
                    }
                } else {
                    while (rLimit || bLimit) {
                        if (bLimit) {
                            when (board[by + dir[dirIdx][1]][bx + dir[dirIdx][0]]) {
                                '.' -> {
                                    bx += dir[dirIdx][0]
                                    by += dir[dirIdx][1]
                                }

                                '#' -> {
                                    bLimit = false
                                }

                                'O' -> {
                                    bx += dir[dirIdx][0]
                                    by += dir[dirIdx][1]
                                    continue@subLoop
                                }
                            }
                        }
                        if (rLimit) {
                            when (board[ry + dir[dirIdx][1]][rx + dir[dirIdx][0]]) {
                                '.' -> {
                                    rx += dir[dirIdx][0]
                                    ry += dir[dirIdx][1]
                                    if (rx == bx && ry == by) {
                                        rx -= dir[dirIdx][0]
                                        ry -= dir[dirIdx][1]
                                        rLimit = false
                                    }
                                }

                                '#' -> {
                                    rLimit = false
                                }

                                'O' -> {
                                    rx += dir[dirIdx][0]
                                    ry += dir[dirIdx][1]
                                    rLimit = false
                                }
                            }
                        }
                    }
                }

                if (board[ry][rx] == 'O') {
                    result = currentState.depth + 1
                    return
                }

                //해당좌표를 간적이 없는경우
                if (!visited[rx][ry][bx][by]) {
                    visited[rx][ry][bx][by] = true
                    q.add(
                        State(
                            Pos(rx, ry),
                            Pos(bx, by),
                            currentState.depth + 1
                        )
                    )
                }
            }
        }
    }

    data class State(val rPos: Pos, val bPos: Pos, val depth: Int)
    data class Pos(val x: Int, val y: Int)
}