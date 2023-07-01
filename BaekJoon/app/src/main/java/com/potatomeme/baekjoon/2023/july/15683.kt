package com.potatomeme.baekjoon.`2023`.july

import java.util.StringTokenizer

//https://www.acmicpc.net/problem/2671

//감시
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	512 MB	42341	19937	12020	43.877%
//문제
//스타트링크의 사무실은 1×1크기의 정사각형으로 나누어져 있는 N×M 크기의 직사각형으로 나타낼 수 있다. 사무실에는 총 K개의 CCTV가 설치되어져 있는데, CCTV는 5가지 종류가 있다. 각 CCTV가 감시할 수 있는 방법은 다음과 같다.
//
//
//1번	2번	3번	4번	5번
//1번 CCTV는 한 쪽 방향만 감시할 수 있다. 2번과 3번은 두 방향을 감시할 수 있는데, 2번은 감시하는 방향이 서로 반대방향이어야 하고, 3번은 직각 방향이어야 한다. 4번은 세 방향, 5번은 네 방향을 감시할 수 있다.
//
//CCTV는 감시할 수 있는 방향에 있는 칸 전체를 감시할 수 있다. 사무실에는 벽이 있는데, CCTV는 벽을 통과할 수 없다. CCTV가 감시할 수 없는 영역은 사각지대라고 한다.
//
//CCTV는 회전시킬 수 있는데, 회전은 항상 90도 방향으로 해야 하며, 감시하려고 하는 방향이 가로 또는 세로 방향이어야 한다.
//
//0 0 0 0 0 0
//0 0 0 0 0 0
//0 0 1 0 6 0
//0 0 0 0 0 0
//지도에서 0은 빈 칸, 6은 벽, 1~5는 CCTV의 번호이다. 위의 예시에서 1번의 방향에 따라 감시할 수 있는 영역을 '#'로 나타내면 아래와 같다.
//
//0 0 0 0 0 0
//0 0 0 0 0 0
//0 0 1 # 6 0
//0 0 0 0 0 0
//0 0 0 0 0 0
//0 0 0 0 0 0
//# # 1 0 6 0
//0 0 0 0 0 0
//0 0 # 0 0 0
//0 0 # 0 0 0
//0 0 1 0 6 0
//0 0 0 0 0 0
//0 0 0 0 0 0
//0 0 0 0 0 0
//0 0 1 0 6 0
//0 0 # 0 0 0
//→	←	↑	↓
//CCTV는 벽을 통과할 수 없기 때문에, 1번이 → 방향을 감시하고 있을 때는 6의 오른쪽에 있는 칸을 감시할 수 없다.
//
//0 0 0 0 0 0
//0 2 0 0 0 0
//0 0 0 0 6 0
//0 6 0 0 2 0
//0 0 0 0 0 0
//0 0 0 0 0 5
//위의 예시에서 감시할 수 있는 방향을 알아보면 아래와 같다.
//
//0 0 0 0 0 #
//# 2 # # # #
//0 0 0 0 6 #
//0 6 # # 2 #
//0 0 0 0 0 #
//# # # # # 5
//0 0 0 0 0 #
//# 2 # # # #
//0 0 0 0 6 #
//0 6 0 0 2 #
//0 0 0 0 # #
//# # # # # 5
//0 # 0 0 0 #
//0 2 0 0 0 #
//0 # 0 0 6 #
//0 6 # # 2 #
//0 0 0 0 0 #
//# # # # # 5
//0 # 0 0 0 #
//0 2 0 0 0 #
//0 # 0 0 6 #
//0 6 0 0 2 #
//0 0 0 0 # #
//# # # # # 5
//왼쪽 상단 2: ↔, 오른쪽 하단 2: ↔	왼쪽 상단 2: ↔, 오른쪽 하단 2: ↕	왼쪽 상단 2: ↕, 오른쪽 하단 2: ↔	왼쪽 상단 2: ↕, 오른쪽 하단 2: ↕
//CCTV는 CCTV를 통과할 수 있다. 아래 예시를 보자.
//
//0 0 2 0 3
//0 6 0 0 0
//0 0 6 6 0
//0 0 0 0 0
//위와 같은 경우에 2의 방향이 ↕ 3의 방향이 ←와 ↓인 경우 감시받는 영역은 다음과 같다.
//
//# # 2 # 3
//0 6 # 0 #
//0 0 6 6 #
//0 0 0 0 #
//사무실의 크기와 상태, 그리고 CCTV의 정보가 주어졌을 때, CCTV의 방향을 적절히 정해서, 사각 지대의 최소 크기를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 사무실의 세로 크기 N과 가로 크기 M이 주어진다. (1 ≤ N, M ≤ 8)
//
//둘째 줄부터 N개의 줄에는 사무실 각 칸의 정보가 주어진다. 0은 빈 칸, 6은 벽, 1~5는 CCTV를 나타내고, 문제에서 설명한 CCTV의 종류이다.
//
//CCTV의 최대 개수는 8개를 넘지 않는다.
//
//출력
//첫째 줄에 사각 지대의 최소 크기를 출력한다.
//
//예제 입력 1
//4 6
//0 0 0 0 0 0
//0 0 0 0 0 0
//0 0 1 0 6 0
//0 0 0 0 0 0
//예제 출력 1
//20
//예제 입력 2
//6 6
//0 0 0 0 0 0
//0 2 0 0 0 0
//0 0 0 0 6 0
//0 6 0 0 2 0
//0 0 0 0 0 0
//0 0 0 0 0 5
//예제 출력 2
//15
//예제 입력 3
//6 6
//1 0 0 0 0 0
//0 1 0 0 0 0
//0 0 1 0 0 0
//0 0 0 1 0 0
//0 0 0 0 1 0
//0 0 0 0 0 1
//예제 출력 3
//6
//예제 입력 4
//6 6
//1 0 0 0 0 0
//0 1 0 0 0 0
//0 0 1 5 0 0
//0 0 5 1 0 0
//0 0 0 0 1 0
//0 0 0 0 0 1
//예제 출력 4
//2
//예제 입력 5
//1 7
//0 1 2 3 4 5 6
//예제 출력 5
//0
//예제 입력 6
//3 7
//4 0 0 0 0 0 0
//0 0 0 2 0 0 0
//0 0 0 0 0 0 4
//예제 출력 6
//0


fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val cameraPosList = mutableListOf<Pair<Int, Int>>()
    val board = Array(n) { idx1 ->
        val st = StringTokenizer(readLine())
        IntArray(m) { idx2 ->
            val n = st.nextToken().toInt()
            if (n != 0 && n != 6) cameraPosList.add(Pair(idx1, idx2))
            n
        }
    }
    print(Solution15683(n, m, board, cameraPosList).min)
    return@with
}

class Solution15683(
    private val n: Int,
    private val m: Int,
    private val board: Array<IntArray>,
    private val cameraPosList: List<Pair<Int, Int>>,
) {

    private val dir = arrayOf(
        intArrayOf(0, -1),//위
        intArrayOf(0, 1),//아래
        intArrayOf(1, 0),//우측
        intArrayOf(-1, 0),//좌측
    )
    private val caseArray: Array<Array<Array<Boolean>>> = arrayOf(
        arrayOf(),
        arrayOf(
            arrayOf(true, false, false, false),
            arrayOf(false, true, false, false),
            arrayOf(false, false, true, false),
            arrayOf(false, false, false, true)
        ),//1번 카메라
        arrayOf(arrayOf(true, true, false, false), arrayOf(false, false, true, true)),//2번 카메라
        arrayOf(
            arrayOf(true, false, true, false),
            arrayOf(true, false, false, true),
            arrayOf(false, true, true, false),
            arrayOf(false, true, false, true)
        ),//3번 카메라
        arrayOf(
            arrayOf(true, true, true, false),
            arrayOf(true, true, false, true),
            arrayOf(true, false, true, true),
            arrayOf(false, true, true, true)
        ),//4번 카메라
        arrayOf(arrayOf(true, true, true, true)),//5번 카메라
    )
    private var seeBoard = List(n) { BooleanArray(m) }
    var min = Int.MAX_VALUE
    private val maxDepth = cameraPosList.size

    init {
        simulation(0)
    }


    private fun simulation(depth: Int) {
        if (depth == maxDepth) {
            val simulationResult = checkMin()
            //println(simulationResult)
            if (min > simulationResult) min = simulationResult
            return
        }
        val i = cameraPosList[depth].first
        val j = cameraPosList[depth].second


        for (case in caseArray[board[i][j]]){
            val copySeeBoard = seeBoard.map { it.clone() }
            for (caseIdx in 0 until 4){
                if (case[caseIdx]){
                    var currentI = i
                    var currentJ = j
                    caseLoop@while (true){
                        currentI += dir[caseIdx][1]
                        if(currentI !in 0 until n) break@caseLoop
                        currentJ += dir[caseIdx][0]
                        if(currentJ !in 0 until m) break@caseLoop
                        if (board[currentI][currentJ] == 6) break@caseLoop
                        seeBoard[currentI][currentJ] = true
                    }
                }
            }
            simulation(depth+1)
            seeBoard = copySeeBoard
        }
    }

    // 사각 지대의 개수
    private fun checkMin(): Int {
        var count = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                //print(if(seeBoard[i][j])1 else 0)
                if (!seeBoard[i][j] && board[i][j] == 0) count++
            }
            //println()
        }
        return count
    }
}