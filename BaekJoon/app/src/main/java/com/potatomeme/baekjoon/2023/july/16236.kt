package com.potatomeme.baekjoon.`2023`.july

import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

//https://www.acmicpc.net/problem/2671

//아기 상어
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	512 MB	59904	27657	16623	42.699%
//문제
//N×N 크기의 공간에 물고기 M마리와 아기 상어 1마리가 있다. 공간은 1×1 크기의 정사각형 칸으로 나누어져 있다. 한 칸에는 물고기가 최대 1마리 존재한다.
//
//아기 상어와 물고기는 모두 크기를 가지고 있고, 이 크기는 자연수이다. 가장 처음에 아기 상어의 크기는 2이고, 아기 상어는 1초에 상하좌우로 인접한 한 칸씩 이동한다.
//
//아기 상어는 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없고, 나머지 칸은 모두 지나갈 수 있다. 아기 상어는 자신의 크기보다 작은 물고기만 먹을 수 있다. 따라서, 크기가 같은 물고기는 먹을 수 없지만, 그 물고기가 있는 칸은 지나갈 수 있다.
//
//아기 상어가 어디로 이동할지 결정하는 방법은 아래와 같다.
//
//더 이상 먹을 수 있는 물고기가 공간에 없다면 아기 상어는 엄마 상어에게 도움을 요청한다.
//먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다.
//먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다.
//거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최솟값이다.
//거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
//아기 상어의 이동은 1초 걸리고, 물고기를 먹는데 걸리는 시간은 없다고 가정한다. 즉, 아기 상어가 먹을 수 있는 물고기가 있는 칸으로 이동했다면, 이동과 동시에 물고기를 먹는다. 물고기를 먹으면, 그 칸은 빈 칸이 된다.
//
//아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가한다. 예를 들어, 크기가 2인 아기 상어는 물고기를 2마리 먹으면 크기가 3이 된다.
//
//공간의 상태가 주어졌을 때, 아기 상어가 몇 초 동안 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는지 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 공간의 크기 N(2 ≤ N ≤ 20)이 주어진다.
//
//둘째 줄부터 N개의 줄에 공간의 상태가 주어진다. 공간의 상태는 0, 1, 2, 3, 4, 5, 6, 9로 이루어져 있고, 아래와 같은 의미를 가진다.
//
//0: 빈 칸
//1, 2, 3, 4, 5, 6: 칸에 있는 물고기의 크기
//9: 아기 상어의 위치
//아기 상어는 공간에 한 마리 있다.
//
//출력
//첫째 줄에 아기 상어가 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는 시간을 출력한다.
//
//예제 입력 1
//3
//0 0 0
//0 0 0
//0 9 0
//예제 출력 1
//0
//예제 입력 2
//3
//0 0 1
//0 0 0
//0 9 0
//예제 출력 2
//3
//예제 입력 3
//4
//4 3 2 1
//0 0 0 0
//0 0 9 0
//1 2 3 4
//예제 출력 3
//14
//예제 입력 4
//6
//5 4 3 2 3 4
//4 3 2 3 4 5
//3 2 9 5 6 6
//2 1 2 3 4 5
//3 2 1 6 5 4
//6 6 6 6 6 6
//예제 출력 4
//60
//예제 입력 5
//6
//6 0 6 0 6 1
//0 0 0 0 0 2
//2 3 4 5 6 6
//0 0 0 0 0 2
//0 2 0 0 0 0
//3 9 3 0 0 1
//예제 출력 5
//48
//예제 입력 6
//6
//1 1 1 1 1 1
//2 2 6 2 2 3
//2 2 5 2 2 3
//2 2 2 4 6 3
//0 0 0 0 0 6
//0 0 0 0 0 9
//예제 출력 6
//39


fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var sharkPosX = 0
    var sharkPosY = 0
    val board = Array(n) { idx1 ->
        val st = StringTokenizer(readLine())
        IntArray(n) { idx2 ->
            val num = st.nextToken().toInt()
            if (num == 9) {
                sharkPosX = idx2
                sharkPosY = idx1
                0
            }else{
                num
            }
        }
    }

    print(Solution16236(n, board, sharkPosX, sharkPosY).distance)
    return@with
}

class Solution16236(val n: Int, val board: Array<IntArray>, sharkPosX: Int, sharkPosY: Int) {
    data class Pos(val x: Int, val y: Int)

    private var sharkSize = 2
    private var sharkEatCount = 0
    private var currentX = sharkPosX
    private var currentY = sharkPosY
    var distance = 0
        private set

    private val dir = arrayOf(
        //arrayOf(x,y)
        arrayOf(0, -1),//북
        arrayOf(1, 0),//동
        arrayOf(0, 1),//남
        arrayOf(-1, 0),//서
    )

    init {
        playGame()
    }

    private fun playGame() {
        //println("$currentX,$currentY")
        while (true) {
            if (findNearOne(currentX, currentY)) {
                board[currentY][currentX] = 0
                sharkEatCount++
                if (sharkSize == sharkEatCount) {
                    sharkSize++
                    sharkEatCount = 0
                }
                //println(distance)
                //println("$currentX,$currentY")
            } else {
                break
            }
        }
    }

    //bfs로 해당 위치에서 가장 가까운 곳이 있는지 찾기
    private fun findNearOne(x: Int, y: Int): Boolean {
        val visited = Array(n) { BooleanArray(n) }
        // Pair(pos,depth)
        val q: Queue<Pair<Pos, Int>> = LinkedList()
        visited[y][x] = true
        q.add(Pair(Pos(x, y), 0))

        var selected = false
        var saveDepth = 0
        var selectedPosX = 0
        var selectedPosY = 0

        //bfs 탐색시작 , q가 비어있다면 더이상 갈수있는곳이 없는 상태를 의미
        while (q.isNotEmpty()) {
            val (pos, depth) = q.poll()
            //만 갈수있는곳을 찾은 상태에서 현재 depth의 값이 saveDepth랑 같아지는경우 멈춤
            if (selected && depth == saveDepth) {
                currentX = selectedPosX
                currentY = selectedPosY
                distance += saveDepth
                return true
            }
            //4방향 탐색
            for (direction in dir) {
                val dirX = pos.x + direction[0]
                val dirY = pos.y + direction[1]
                //범위가 맞는지 확인
                if (dirX !in 0 until n || dirY !in 0 until n) continue
                //해당 지역을 방문했는지 확인
                if (visited[dirY][dirX]) continue
                visited[dirY][dirX] = true
                if (board[dirY][dirX] == 0 || sharkSize == board[dirY][dirX]) {
                    q.add(Pair(Pos(dirX, dirY), depth + 1))
                } else if (sharkSize > board[dirY][dirX]) {
                    if (selected) {
                        if (selectedPosY > dirY) {
                            selectedPosX = dirX
                            selectedPosY = dirY
                        } else if (selectedPosY == dirY && selectedPosX > dirX) {
                            selectedPosX = dirX
                            selectedPosY = dirY
                        }
                    } else {
                        selectedPosX = dirX
                        selectedPosY = dirY
                        saveDepth = depth + 1
                        selected = true
                    }
                }
            }
        }
        return if (selected) {
            currentX = selectedPosX
            currentY = selectedPosY
            distance += saveDepth
            true
        } else {
            false
        }
    }
}



