package com.potatomeme.baekjoon.`2023`.july

import java.lang.StringBuilder
import java.util.StringTokenizer

//https://www.acmicpc.net/problem/5373

//사큐빙 다국어
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	128 MB	13003	5109	3475	38.491%
//문제
//루빅스 큐브는 삼차원 퍼즐이다. 보통 루빅스 큐브는 3×3×3개의 작은 정육면체로 이루어져 있다. 퍼즐을 풀려면 각 면에 있는 아홉 개의 작은 정육면체의 색이 동일해야 한다.
//
//큐브는 각 면을 양방향으로 90도 만큼 돌릴 수 있도록 만들어져 있다. 회전이 마친 이후에는, 다른 면을 돌릴 수 있다. 이렇게 큐브의 서로 다른 면을 돌리다 보면, 색을 섞을 수 있다.
//
//이 문제에서는 루빅스 큐브가 모두 풀린 상태에서 시작한다. 윗 면은 흰색, 아랫 면은 노란색, 앞 면은 빨간색, 뒷 면은 오렌지색, 왼쪽 면은 초록색, 오른쪽 면은 파란색이다.
//
//루빅스 큐브를 돌린 방법이 순서대로 주어진다. 이때, 모두 돌린 다음에 가장 윗 면의 색상을 구하는 프로그램을 작성하시오.
//
//
//
//위의 그림은 루빅스 큐브를 푼 그림이다. 왼쪽 면은 시계방향으로 조금 돌려져 있는 상태이다.
//
//입력
//첫째 줄에 테스트 케이스의 개수가 주어진다. 테스트 케이스는 최대 100개이다. 각 테스트 케이스는 다음과 같이 구성되어져 있다.
//
//첫째 줄에 큐브를 돌린 횟수 n이 주어진다. (1 ≤ n ≤ 1000)
//둘째 줄에는 큐브를 돌린 방법이 주어진다. 각 방법은 공백으로 구분되어져 있으며, 첫 번째 문자는 돌린 면이다. U: 윗 면, D: 아랫 면, F: 앞 면, B: 뒷 면, L: 왼쪽 면, R: 오른쪽 면이다. 두 번째 문자는 돌린 방향이다. +인 경우에는 시계 방향 (그 면을 바라봤을 때가 기준), -인 경우에는 반시계 방향이다.
//출력
//각 테스트 케이스에 대해서 큐브를 모두 돌린 후의 윗 면의 색상을 출력한다. 첫 번째 줄에는 뒷 면과 접하는 칸의 색을 출력하고, 두 번째, 세 번째 줄은 순서대로 출력하면 된다. 흰색은 w, 노란색은 y, 빨간색은 r, 오렌지색은 o, 초록색은 g, 파란색은 b.
//
//예제 입력 1
//4
//1
//L-
//2
//F+ B+
//4
//U- D- L+ R+
//10
//L- U- L+ U- L- U- U- L+ U+ U+
//예제 출력 1
//rww
//rww
//rww
//bbb
//www
//ggg
//gwg
//owr
//bwb
//gwo
//www
//rww


//123
//456
//789

//좌
//741
//852
//963

//우
//369
//258
//147

//   3
// 1 2 4 5
//   6

// 왼쪽(1) :초록
// 앞(2) : 빨강
// 위(3) : 흰
// 오른쪽(4) : 파랑
// 뒤(5) : 주황
// 아래(6) : 노랑


fun main() = with(System.`in`.bufferedReader()) {
    val testCase = readLine().toInt()
    val orderArr: Array<Array<Pair<Char, Boolean>>> = Array(testCase) {
        val n = readLine().toInt()
        val st = StringTokenizer(readLine())
        Array(n) {
            val order = st.nextToken()
            Pair(order[0], order[1] == '+')
        }
    }
    print(Solution5373(orderArr).result.toString())
}


class Solution5373(orderArr: Array<Array<Pair<Char, Boolean>>>) {
    private val cube = Array(6) { idx ->
        Array(3) { IntArray(3) { idx } }
    }

    val result = StringBuilder()

    private val colorArr = arrayOf('g', 'r', 'w', 'b', 'o', 'y')
    private val orderSideMap = mapOf(
        'L' to 0,
        'F' to 1,
        'U' to 2,
        'R' to 3,
        'B' to 4,
        'D' to 5,
    )

    private val rotaeLineType = arrayOf(
        arrayOf(Pair(0, 0), Pair(0, 1), Pair(0, 2)),//윗 라인 // 1,2,3
        arrayOf(Pair(0, 2), Pair(1, 2), Pair(2, 2)),//오른쪽 라인 // 3,6,9
        arrayOf(Pair(2, 2), Pair(2, 1), Pair(2, 0)),//아래 라인 // 9,8,7
        arrayOf(Pair(2, 0), Pair(1, 0), Pair(0, 0)),//왼쪽 라인 // 7,4,1
    )

    private val sideSpaces = arrayOf(
        intArrayOf(2, 1, 5, 4),//left,0
        intArrayOf(2, 3, 5, 0),//front,1
        intArrayOf(4, 3, 1, 0),//up,2
        intArrayOf(2, 4, 5, 1),//right,3
        intArrayOf(2, 0, 5, 3),//back,4
        intArrayOf(1, 3, 4, 0),//down,5
    )

    private val lineSpaces = arrayOf(
        intArrayOf(3, 3, 3, 3),//left,0
        intArrayOf(2, 2, 0, 2),//front,1
        intArrayOf(2, 3, 0, 1),//up,2
        intArrayOf(1, 1, 1, 1),//right,3
        intArrayOf(0, 0, 2, 0),//back,4
        intArrayOf(2, 1, 0, 3),//down,5
    )

    init {
        orderArr.forEach { orders ->
            for (i in 0 until 6) {
                for (j in 0 until 3) {
                    for (k in 0 until 3) {
                        cube[i][j][k] = i
                    }
                }
            }
            orders.forEach { order ->
                rotate(orderSideMap[order.first]!!, order.second)

            }
            printUpSide()
        }
    }

    private fun printUpSide() {
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                result.append(colorArr[cube[2][i][j]])
            }
            result.appendLine()
        }
    }

    private fun rotate(side: Int, isClockwise: Boolean) {
        if (isClockwise){
            val arr = IntArray(3){ idx ->
                val pair = rotaeLineType[lineSpaces[side][3]][idx]
                cube[sideSpaces[side][3]][pair.first][pair.second]
            }
            for (i in 3 downTo 1){
                rotaeLineType[lineSpaces[side][i]].forEachIndexed { index, pair ->
                    val nextPair =  rotaeLineType[lineSpaces[side][i-1]][index]
                    cube[sideSpaces[side][i]][pair.first][pair.second] = cube[sideSpaces[side][i-1]][nextPair.first][nextPair.second]
                }
            }
            rotaeLineType[lineSpaces[side][0]].forEachIndexed { index, pair ->
                cube[sideSpaces[side][0]][pair.first][pair.second] = arr[index]
            }

            val board = arrayOf(
                arrayOf(cube[side][2][0],cube[side][1][0],cube[side][0][0]),
                arrayOf(cube[side][2][1],cube[side][1][1],cube[side][0][1]),
                arrayOf(cube[side][2][2],cube[side][1][2],cube[side][0][2]),
            )
            for (i in 0 until 3){
                for (j in 0 until 3){
                    cube[side][i][j] = board[i][j]
                }
            }
        }else{
            val arr =  IntArray(3){ idx ->
                val pair = rotaeLineType[lineSpaces[side][0]][idx]
                cube[sideSpaces[side][0]][pair.first][pair.second]
            }
            for (i in 0 until  3){
                rotaeLineType[lineSpaces[side][i]].forEachIndexed { index, pair ->
                    val nextPair =  rotaeLineType[lineSpaces[side][i+1]][index]
                    cube[sideSpaces[side][i]][pair.first][pair.second] = cube[sideSpaces[side][i+1]][nextPair.first][nextPair.second]
                }

            }
            rotaeLineType[lineSpaces[side][3]].forEachIndexed { index, pair ->
                cube[sideSpaces[side][3]][pair.first][pair.second] = arr[index]
            }

            val board = arrayOf(
                arrayOf(cube[side][0][2],cube[side][1][2],cube[side][2][2]),
                arrayOf(cube[side][0][1],cube[side][1][1],cube[side][2][1]),
                arrayOf(cube[side][0][0],cube[side][1][0],cube[side][2][0]),
            )
            for (i in 0 until 3){
                for (j in 0 until 3){
                    cube[side][i][j] = board[i][j]
                }
            }
        }
    }
}
