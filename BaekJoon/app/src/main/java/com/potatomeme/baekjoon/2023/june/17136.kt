package com.potatomeme.baekjoon.`2023`.june

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

//https://www.acmicpc.net/problem/17136

//색종이 붙이기
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	512 MB	23301	8973	4963	34.865%
//문제
//<그림 1>과 같이 정사각형 모양을 한 다섯 종류의 색종이가 있다. 색종이의 크기는 1×1, 2×2, 3×3, 4×4, 5×5로 총 다섯 종류가 있으며, 각 종류의 색종이는 5개씩 가지고 있다.
//
//
//
//<그림 1>
//
//색종이를 크기가 10×10인 종이 위에 붙이려고 한다. 종이는 1×1 크기의 칸으로 나누어져 있으며, 각각의 칸에는 0 또는 1이 적혀 있다. 1이 적힌 칸은 모두 색종이로 덮여져야 한다. 색종이를 붙일 때는 종이의 경계 밖으로 나가서는 안되고, 겹쳐도 안 된다. 또, 칸의 경계와 일치하게 붙여야 한다. 0이 적힌 칸에는 색종이가 있으면 안 된다.
//
//종이가 주어졌을 때, 1이 적힌 모든 칸을 붙이는데 필요한 색종이의 최소 개수를 구해보자.
//
//입력
//총 10개의 줄에 종이의 각 칸에 적힌 수가 주어진다.
//
//출력
//모든 1을 덮는데 필요한 색종이의 최소 개수를 출력한다. 1을 모두 덮는 것이 불가능한 경우에는 -1을 출력한다.
//
//예제 입력 1
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//예제 출력 1
//0
//예제 입력 2
//0 0 0 0 0 0 0 0 0 0
//0 1 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 1 0 0 0 0 0
//0 0 0 0 0 1 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 1 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//예제 출력 2
//4
//예제 입력 3
//0 0 0 0 0 0 0 0 0 0
//0 1 1 0 0 0 0 0 0 0
//0 0 1 0 0 0 0 0 0 0
//0 0 0 0 1 1 0 0 0 0
//0 0 0 0 1 1 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 1 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//예제 출력 3
//5
//예제 입력 4
//0 0 0 0 0 0 0 0 0 0
//0 1 1 0 0 0 0 0 0 0
//0 0 1 0 0 0 0 0 0 0
//0 0 0 0 1 1 0 0 0 0
//0 0 0 0 0 1 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 1 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//예제 출력 4
//-1
//예제 입력 5
//0 0 0 0 0 0 0 0 0 0
//0 1 1 0 0 0 0 0 0 0
//0 1 1 1 0 0 0 0 0 0
//0 0 1 1 1 1 1 0 0 0
//0 0 0 1 1 1 1 0 0 0
//0 0 0 0 1 1 1 0 0 0
//0 0 1 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//예제 출력 5
//7
//예제 입력 6
//1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1
//예제 출력 6
//4
//예제 입력 7
//0 0 0 0 0 0 0 0 0 0
//0 1 1 1 1 1 0 0 0 0
//0 1 1 1 1 1 0 0 0 0
//0 0 1 1 1 1 0 0 0 0
//0 0 1 1 1 1 0 0 0 0
//0 1 1 1 1 1 1 1 1 1
//0 1 1 1 0 1 1 1 1 1
//0 1 1 1 0 1 1 1 1 1
//0 0 0 0 0 1 1 1 1 1
//0 0 0 0 0 1 1 1 1 1
//예제 출력 7
//6
//예제 입력 8
//0 0 0 0 0 0 0 0 0 0
//1 1 1 1 1 0 0 0 0 0
//1 1 1 1 1 0 1 1 1 1
//1 1 1 1 1 0 1 1 1 1
//1 1 1 1 1 0 1 1 1 1
//1 1 1 1 1 0 1 1 1 1
//0 0 0 0 0 0 0 0 0 0
//0 1 1 1 0 1 1 0 0 0
//0 1 1 1 0 1 1 0 0 0
//0 1 1 1 0 0 0 0 0 1
//예제 출력 8
//5


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val arr = Array(10) {
        val st = StringTokenizer(readLine())
        BooleanArray(10) { st.nextToken()[0] == '1' }
    }
    print(Solution17136(arr).min)
}

class Solution17136(private val pos: Array<BooleanArray>) {
    var min = -1
    private val countArr = IntArray(5) { 0 }
    private val tile2PlusPos = arrayOf(
        //arrayOf(x,y)
        arrayOf(1, 0), arrayOf(1, 1), arrayOf(0, 1)
    )
    private val tile3PlusPos = arrayOf(
        //arrayOf(x,y)
        arrayOf(2, 0), arrayOf(2, 1), arrayOf(2, 2), arrayOf(1, 2), arrayOf(0, 2)
    )
    private val tile4PlusPos = arrayOf(
        //arrayOf(x,y)
        arrayOf(3, 0),
        arrayOf(3, 1),
        arrayOf(3, 2),
        arrayOf(3, 3),
        arrayOf(2, 3),
        arrayOf(1, 3),
        arrayOf(0, 3)
    )
    private val tile5PlusPos = arrayOf(
        //arrayOf(x,y)
        arrayOf(4, 0),
        arrayOf(4, 1),
        arrayOf(4, 2),
        arrayOf(4, 3),
        arrayOf(4, 4),
        arrayOf(3, 4),
        arrayOf(2, 4),
        arrayOf(1, 4),
        arrayOf(0, 4)
    )

    init {
        checkPos(0, 0, 0)
    }

    private fun checkPos(x: Int, y: Int, totalCount: Int) {
        if (countArr.any { it > 5 } || (min != -1 && totalCount >= min)) return
        if (x == 10 && y == 9) {
            min = totalCount
            return
        }
        var currentX = x
        var currentY = y
        if (currentX == 10) {
            currentX = 0
            currentY++
        }

        if (pos[currentY][currentX]) {
            pos[currentY][currentX] = false
            countArr[0]++
            checkPos(currentX + 1, currentY, totalCount + 1)
            countArr[0]--
            if (currentX < 9 && currentY < 9 && tile2PlusPos.all { ints -> pos[currentY + ints[1]][currentX + ints[0]] }) {
                tile2PlusPos.forEach { ints -> pos[currentY + ints[1]][currentX + ints[0]] = false }
                countArr[1]++
                checkPos(currentX + 2, currentY, totalCount + 1)
                countArr[1]--
                if (currentX < 8 && currentY < 8 && tile3PlusPos.all { ints -> pos[currentY + ints[1]][currentX + ints[0]] }) {
                    tile3PlusPos.forEach { ints ->
                        pos[currentY + ints[1]][currentX + ints[0]] = false
                    }
                    countArr[2]++
                    checkPos(currentX + 3, currentY, totalCount + 1)
                    countArr[2]--
                    if (currentX < 7 && currentY < 7 && tile4PlusPos.all { ints -> pos[currentY + ints[1]][currentX + ints[0]] }) {
                        tile4PlusPos.forEach { ints ->
                            pos[currentY + ints[1]][currentX + ints[0]] = false
                        }
                        countArr[3]++
                        checkPos(currentX + 4, currentY, totalCount + 1)
                        countArr[3]--
                        if (currentX < 6 && currentY < 6 && tile5PlusPos.all { ints -> pos[currentY + ints[1]][currentX + ints[0]] }) {
                            tile5PlusPos.forEach { ints ->
                                pos[currentY + ints[1]][currentX + ints[0]] = false
                            }
                            countArr[4]++
                            checkPos(currentX + 5, currentY, totalCount + 1)
                            countArr[4]--
                            tile5PlusPos.forEach { ints ->
                                pos[currentY + ints[1]][currentX + ints[0]] = true
                            }
                        }
                        tile4PlusPos.forEach { ints ->
                            pos[currentY + ints[1]][currentX + ints[0]] = true
                        }
                    }
                    tile3PlusPos.forEach { ints ->
                        pos[currentY + ints[1]][currentX + ints[0]] = true
                    }
                }
                tile2PlusPos.forEach { ints -> pos[currentY + ints[1]][currentX + ints[0]] = true }
            }
            pos[currentY][currentX] = true
        } else {
            checkPos(currentX + 1, currentY, totalCount)
        }
    }
}