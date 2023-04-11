package com.potatomeme.programmers.codingtest.years23.april.level1

import java.util.*


//리코쳇 로봇
//문제 설명
//리코쳇 로봇이라는 보드게임이 있습니다.
//
//이 보드게임은 격자모양 게임판 위에서 말을 움직이는 게임으로, 시작 위치에서 목표 위치까지 최소 몇 번만에 도달할 수 있는지 말하는 게임입니다.
//
//이 게임에서 말의 움직임은 상, 하, 좌, 우 4방향 중 하나를 선택해서 게임판 위의 장애물이나 맨 끝에 부딪힐 때까지 미끄러져 이동하는 것을 한 번의 이동으로 칩니다.
//
//다음은 보드게임판을 나타낸 예시입니다.
//
//...D..R
//.D.G...
//....D.D
//D....D.
//..D....
//여기서 "."은 빈 공간을, "R"은 로봇의 처음 위치를, "D"는 장애물의 위치를, "G"는 목표지점을 나타냅니다.
//위 예시에서는 "R" 위치에서 아래, 왼쪽, 위, 왼쪽, 아래, 오른쪽, 위 순서로 움직이면 7번 만에 "G" 위치에 멈춰 설 수 있으며, 이것이 최소 움직임 중 하나입니다.
//
//게임판의 상태를 나타내는 문자열 배열 board가 주어졌을 때, 말이 목표위치에 도달하는데 최소 몇 번 이동해야 하는지 return 하는 solution함수를 완성하세요. 만약 목표위치에 도달할 수 없다면 -1을 return 해주세요.
//
//제한 사항
//3 ≤ board의 길이 ≤ 100
//3 ≤ board의 원소의 길이 ≤ 100
//board의 원소의 길이는 모두 동일합니다.
//문자열은 ".", "D", "R", "G"로만 구성되어 있으며 각각 빈 공간, 장애물, 로봇의 처음 위치, 목표 지점을 나타냅니다.
//"R"과 "G"는 한 번씩 등장합니다.
//입출력 예
//board	result
//["...D..R", ".D.G...", "....D.D", "D....D.", "..D...."]	7
//[".D.R", "....", ".G..", "...D"]	-1
//입출력 예 설명
//입출력 예 #1
//
//문제 설명의 예시와 같습니다.
//입출력 예 #2
//
//.D.R
//....
//.G..
//...D
//"R" 위치에 있는 말을 어떻게 움직여도 "G" 에 도달시킬 수 없습니다.
//따라서 -1을 return 합니다.

fun main() {
    print(Solution169199().solution(
        arrayOf("...D..R", ".D.G...", "....D.D", "D....D.", "..D....")
    ))
}


class Solution169199 {
    private lateinit var map: Array<CharArray>
    private lateinit var visited: Array<BooleanArray>

    data class Pos(var x: Int, var y: Int, var depth: Int)

    var dx = intArrayOf(-1, 0, 1, 0)
    var dy = intArrayOf(0, 1, 0, -1)

    private fun getPos(direction: Int, now: Pos): Pos {
        var x = now.x
        var y = now.y
        val ix = dx[direction]
        val iy = dy[direction]
        while (x + ix in map.indices && y + iy in map[0].indices && map[x + ix][y + iy] != 'D') {
            x += ix
            y += iy
        }
        return Pos(x, y, now.depth + 1)
    }

    private fun bfs(start: Pos, goal: Pos): Int {
        val q: Queue<Pos> = LinkedList()
        visited[start.x][start.y] = true
        q.add(start)
        while (!q.isEmpty()) {
            val now: Pos = q.poll()
            val x = now.x
            val y = now.y
            val depth = now.depth
            if (x == goal.x && y == goal.y) return depth
            for (direction in 0..3) {
                val next = getPos(direction, now)
                if (!visited[next.x][next.y]) {
                    visited[next.x][next.y] = true
                    q.add(next)
                }
            }
        }
        return -1
    }

    fun solution(board: Array<String>): Int {
        map = Array(board.size) { CharArray(board[0].length) }
        visited = Array(map.size) { BooleanArray(map[0].size) }
        val start = Pos(0, 0, 0)
        val goal = Pos(0, 0, 0)
        for (i in map.indices) {
            for (j in map[0].indices) {
                map[i][j] = board[i][j]
                if (map[i][j] == 'R') {
                    start.x = i
                    start.y = j
                }
                if (map[i][j] == 'G') {
                    goal.x = i
                    goal.y = j
                }
            }
        }
        return bfs(start = start, goal = goal)
    }
}