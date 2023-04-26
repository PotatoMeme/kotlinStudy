package com.potatomeme.programmers.codingtest.years23.april.level2

import java.util.LinkedList
import java.util.Queue


//미로 탈출
//문제 설명
//1 x 1 크기의 칸들로 이루어진 직사각형 격자 형태의 미로에서 탈출하려고 합니다. 각 칸은 통로 또는 벽으로 구성되어 있으며, 벽으로 된 칸은 지나갈 수 없고 통로로 된 칸으로만 이동할 수 있습니다. 통로들 중 한 칸에는 미로를 빠져나가는 문이 있는데, 이 문은 레버를 당겨서만 열 수 있습니다. 레버 또한 통로들 중 한 칸에 있습니다. 따라서, 출발 지점에서 먼저 레버가 있는 칸으로 이동하여 레버를 당긴 후 미로를 빠져나가는 문이 있는 칸으로 이동하면 됩니다. 이때 아직 레버를 당기지 않았더라도 출구가 있는 칸을 지나갈 수 있습니다. 미로에서 한 칸을 이동하는데 1초가 걸린다고 할 때, 최대한 빠르게 미로를 빠져나가는데 걸리는 시간을 구하려 합니다.
//
//미로를 나타낸 문자열 배열 maps가 매개변수로 주어질 때, 미로를 탈출하는데 필요한 최소 시간을 return 하는 solution 함수를 완성해주세요. 만약, 탈출할 수 없다면 -1을 return 해주세요.
//
//제한사항
//5 ≤ maps의 길이 ≤ 100
//5 ≤ maps[i]의 길이 ≤ 100
//maps[i]는 다음 5개의 문자들로만 이루어져 있습니다.
//S : 시작 지점
//E : 출구
//L : 레버
//O : 통로
//X : 벽
//시작 지점과 출구, 레버는 항상 다른 곳에 존재하며 한 개씩만 존재합니다.
//출구는 레버가 당겨지지 않아도 지나갈 수 있으며, 모든 통로, 출구, 레버, 시작점은 여러 번 지나갈 수 있습니다.
//입출력 예
//maps	result
//["SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"]	16
//["LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"]	-1
//입출력 예 설명
//입출력 예 #1
//
//주어진 문자열은 다음과 같은 미로이며
//
//image1
//
//다음과 같이 이동하면 가장 빠른 시간에 탈출할 수 있습니다.
//
//image2
//
//4번 이동하여 레버를 당기고 출구까지 이동하면 총 16초의 시간이 걸립니다. 따라서 16을 반환합니다.
//
//입출력 예 #2
//
//주어진 문자열은 다음과 같은 미로입니다.
//
//image3
//
//시작 지점에서 이동할 수 있는 공간이 없어서 탈출할 수 없습니다. 따라서 -1을 반환합니다.

fun main() {
    println(Solution159993().failSolution1(
        arrayOf(
            "SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"
        )
    ))
    println(Solution159993().failSolution2(
        arrayOf(
            "SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"
        )
    ))
}

class Solution159993() {
    // 2개의 함수를 만들자
    // 1번함수 레버까지 가는 함수
    // 2번함수 출구까지 가는 함수
    // 이에따라 visited는 2개로 만듬

    fun failSolution1(maps: Array<String>): Int {

        val width = maps[0].length
        val length = maps.size

        val visited1 = Array(length) { BooleanArray(width) }//스타트에서 레버까지가는길
        val visited2 = Array(length) { BooleanArray(width) }//레버에서 출구까지 가는 길

        val startPos = maps.findStart()

        var min = Int.MAX_VALUE


        fun dfsE(x: Int, y: Int, depth: Int) {
            if (x !in (0 until width) || y !in (0 until length)) return
            if (maps[y][x] == 'X' || visited2[y][x]) return
            if (maps[y][x] == 'E') {
                if (depth < min) min = depth
            } else {
                visited2[y][x] = true
                dfsE(x + 1, y, depth + 1)
                dfsE(x - 1, y, depth + 1)
                dfsE(x, y + 1, depth + 1)
                dfsE(x, y - 1, depth + 1)
                visited2[y][x] = false
            }
        }

        fun dfsL(x: Int, y: Int, depth: Int) {
            if (x !in (0 until width) || y !in (0 until length)) return
            if (maps[y][x] == 'X' || visited1[y][x]) return
            if (maps[y][x] == 'L') {
                dfsE(x, y, depth)
            } else {
                visited1[y][x] = true
                dfsL(x + 1, y, depth + 1)
                dfsL(x - 1, y, depth + 1)
                dfsL(x, y + 1, depth + 1)
                dfsL(x, y - 1, depth + 1)
                visited1[y][x] = false
            }
        }

        dfsL(startPos.first, startPos.second, 0)

        return if (min == Int.MAX_VALUE) -1 else min
    } // 시간초과
    //테스트 1 〉	통과 (0.75ms, 61.9MB)
    //테스트 2 〉	통과 (1.90ms, 61.4MB)
    //테스트 3 〉	실패 (시간 초과)
    //테스트 4 〉	통과 (0.63ms, 60.9MB)
    //테스트 5 〉	통과 (0.78ms, 59MB)
    //테스트 6 〉	실패 (시간 초과)
    //테스트 7 〉	실패 (시간 초과)
    //테스트 8 〉	실패 (시간 초과)
    //테스트 9 〉	통과 (0.65ms, 60.8MB)
    //테스트 10 〉	통과 (0.66ms, 59.3MB)
    //테스트 11 〉	실패 (시간 초과)
    //테스트 12 〉	실패 (시간 초과)
    //테스트 13 〉	실패 (시간 초과)
    //테스트 14 〉	실패 (시간 초과)
    //테스트 15 〉	실패 (시간 초과)
    //테스트 16 〉	실패 (시간 초과)
    //테스트 17 〉	실패 (시간 초과)
    //테스트 18 〉	실패 (시간 초과)
    //테스트 19 〉	실패 (시간 초과)
    //테스트 20 〉	실패 (시간 초과)
    //테스트 21 〉	실패 (시간 초과)
    //테스트 22 〉	통과 (0.53ms, 62.1MB)
    //테스트 23 〉	통과 (0.52ms, 58.4MB)


    /**
    위함수를 최적화
     */

    private val dx = intArrayOf(1, -1, 0, 0)
    private val dy = intArrayOf(0, 0, -1, 1)

    fun failSolution2(maps: Array<String>): Int {

        val width = maps[0].length
        val length = maps.size

        val visited1 = Array(length) { BooleanArray(width) }//스타트에서 레버까지가는길
        val visited2 = Array(length) { BooleanArray(width) }//레버에서 출구까지 가는 길

        val startPos = maps.findStart()

        var min = Int.MAX_VALUE

        fun inRange(x: Int, y: Int) = (x in 0 until width && y in 0 until length)

        fun dfsE(x: Int, y: Int, depth: Int) {
            if (maps[y][x] == 'E') {
                if (depth < min) min = depth
            } else {
                visited2[y][x] = true
                for (i in 0 until 4) {
                    val nx = x + dx[i]
                    val ny = y + dy[i]
                    if (inRange(nx, ny) && maps[ny][nx] != 'X' && !visited2[ny][nx]) {
                        dfsE(nx, ny, depth + 1)
                    }
                }
                visited2[y][x] = false
            }
        }

        fun dfsL(x: Int, y: Int, depth: Int) {
            if (maps[y][x] == 'L') {
                dfsE(x, y, depth)
            } else {
                visited1[y][x] = true
                for (i in 0 until 4) {
                    val nx = x + dx[i]
                    val ny = y + dy[i]
                    if (inRange(nx, ny) && maps[ny][nx] != 'X' && !visited1[ny][nx]) {
                        dfsL(nx, ny, depth + 1)
                    }
                }
                visited1[y][x] = false
            }
        }

        dfsL(startPos.first, startPos.second, 0)

        return if (min == Int.MAX_VALUE) -1 else min
    }
    //테스트 1 〉	통과 (0.65ms, 59.4MB)
    //테스트 2 〉	통과 (1.35ms, 61MB)
    //테스트 3 〉	실패 (시간 초과)
    //테스트 4 〉	통과 (0.93ms, 60.1MB)
    //테스트 5 〉	통과 (0.81ms, 60.5MB)
    //테스트 6 〉	실패 (시간 초과)
    //테스트 7 〉	실패 (시간 초과)
    //테스트 8 〉	실패 (시간 초과)
    //테스트 9 〉	통과 (0.80ms, 59.8MB)
    //테스트 10 〉	통과 (0.70ms, 61.8MB)
    //테스트 11 〉	실패 (시간 초과)
    //테스트 12 〉	실패 (시간 초과)
    //테스트 13 〉	실패 (시간 초과)
    //테스트 14 〉	실패 (시간 초과)
    //테스트 15 〉	실패 (시간 초과)
    //테스트 16 〉	실패 (시간 초과)
    //테스트 17 〉	실패 (시간 초과)
    //테스트 18 〉	실패 (시간 초과)
    //테스트 19 〉	실패 (시간 초과)
    //테스트 20 〉	실패 (시간 초과)
    //테스트 21 〉	실패 (시간 초과)
    //테스트 22 〉	통과 (0.62ms, 59.8MB)
    //테스트 23 〉	통과 (0.67ms, 62MB)

    private fun Array<String>.findStart(): Pair<Int, Int> {
        this.forEachIndexed { index1, s ->
            s.forEachIndexed { index2, c ->
                if (c == 'S') return Pair(index2, index1)
            }
        }
        return Pair(0, 0)
    }

    /**
     * dfs는 느려서 안됨 bfs로 풀어보자
     * */
    fun solution(maps: Array<String>): Int {
        val width = maps[0].length
        val length = maps.size

        fun inRange(x: Int, y: Int) = (x in 0 until width && y in 0 until length)

        fun bfs(startPos: Triple<Int, Int, Int>, c: Char): Triple<Int, Int, Int> {
            val queue: Queue<Triple<Int, Int, Int>> = LinkedList()
            queue.add(startPos)
            val visited = Array(length) { BooleanArray(width) }
            visited[startPos.second][startPos.first] = true

            while (!queue.isEmpty()) {
                val now = queue.poll()
                if (maps[now.second][now.first] == c) {
                    return now
                }
                for (i in 0 until 4) {
                    val nx = now.first + dx[i]
                    val ny = now.second + dy[i]
                    if (inRange(nx, ny) && maps[ny][nx] != 'X' && !visited[ny][nx]) {
                        visited[ny][nx] = true
                        queue.add(Triple(nx, ny, now.third + 1))
                    }
                }

            }
            return Triple(0, 0, -1)
        }

        val toL = bfs(maps.findPosWithTriple('S'), 'L')
        if (toL.third == -1) return -1
        val toE = bfs(toL, 'E')
        return if (toE.third == -1) -1 else toE.third
    }

    private fun Array<String>.findPosWithTriple(c: Char): Triple<Int, Int, Int> {
        this.forEachIndexed { index1, s ->
            s.forEachIndexed { index2, char ->
                if (c == char) return Triple(index2, index1, 0)
            }
        }
        return Triple(0, 0, 0)
    }
}