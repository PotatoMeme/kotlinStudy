package com.potatomeme.baekjoon.`2023`.july

import java.lang.Math.abs
import java.util.StringTokenizer

//https://www.acmicpc.net/problem/5373

//인구 이동 성공
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	512 MB	58718	23749	13851	37.306%
//문제
//N×N크기의 땅이 있고, 땅은 1×1개의 칸으로 나누어져 있다. 각각의 땅에는 나라가 하나씩 존재하며, r행 c열에 있는 나라에는 A[r][c]명이 살고 있다. 인접한 나라 사이에는 국경선이 존재한다. 모든 나라는 1×1 크기이기 때문에, 모든 국경선은 정사각형 형태이다.
//
//오늘부터 인구 이동이 시작되는 날이다.
//
//인구 이동은 하루 동안 다음과 같이 진행되고, 더 이상 아래 방법에 의해 인구 이동이 없을 때까지 지속된다.
//
//국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 오늘 하루 동안 연다.
//위의 조건에 의해 열어야하는 국경선이 모두 열렸다면, 인구 이동을 시작한다.
//국경선이 열려있어 인접한 칸만을 이용해 이동할 수 있으면, 그 나라를 오늘 하루 동안은 연합이라고 한다.
//연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다. 편의상 소수점은 버린다.
//연합을 해체하고, 모든 국경선을 닫는다.
//각 나라의 인구수가 주어졌을 때, 인구 이동이 며칠 동안 발생하는지 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 N, L, R이 주어진다. (1 ≤ N ≤ 50, 1 ≤ L ≤ R ≤ 100)
//
//둘째 줄부터 N개의 줄에 각 나라의 인구수가 주어진다. r행 c열에 주어지는 정수는 A[r][c]의 값이다. (0 ≤ A[r][c] ≤ 100)
//
//인구 이동이 발생하는 일수가 2,000번 보다 작거나 같은 입력만 주어진다.
//
//출력
//인구 이동이 며칠 동안 발생하는지 첫째 줄에 출력한다.
//
//예제 입력 1
//2 20 50
//50 30
//20 40
//예제 출력 1
//1
//초기 상태는 아래와 같다.
//
//
//
//L = 20, R = 50 이기 때문에, 모든 나라 사이의 국경선이 열린다. (열린 국경선은 점선으로 표시)
//
//
//
//연합은 하나 존재하고, 연합의 인구는 (50 + 30 + 20 + 40) 이다. 연합의 크기가 4이기 때문에, 각 칸의 인구수는 140/4 = 35명이 되어야 한다.
//
//
//
//예제 입력 2
//2 40 50
//50 30
//20 40
//예제 출력 2
//0
//경계를 공유하는 나라의 인구 차이가 모두 L보다 작아서 인구 이동이 발생하지 않는다.
//
//예제 입력 3
//2 20 50
//50 30
//30 40
//예제 출력 3
//1
//초기 상태는 아래와 같다.
//
//
//
//L = 20, R = 50이기 때문에, 아래와 같이 국경선이 열린다.
//
//
//
//인구 수는 합쳐져있는 연합의 인구수는 (50+30+30) / 3 = 36 (소수점 버림)이 되어야 한다.
//
//
//
//예제 입력 4
//3 5 10
//10 15 20
//20 30 25
//40 22 10
//예제 출력 4
//2
//예제 입력 5
//4 10 50
//10 100 20 90
//80 100 60 70
//70 20 30 40
//50 20 100 10
//예제 출력 5
//3


fun main() = with(System.`in`.bufferedReader()) {
    val (n, l, r) = readLine().split(" ").map { it.toInt() }
    val board = Array(n) {
        val st = StringTokenizer(readLine())
        IntArray(n) { st.nextToken().toInt() }
    }
    print(Solution16324(n, l, r, board).day)
    return@with
}


class Solution16324(val n: Int, val l: Int, val r: Int, val board: Array<IntArray>) {
    private var isLinked = Array(n) { Array(n) { BooleanArray(4) } }
    private var visited1 = Array(n) { BooleanArray(n) }
    private var visited2 = Array(n) { BooleanArray(n) }
    var day = 0
    private var linkedCount = 0
    private var toatal = 0
    private var linked = 1
    private val dir = arrayOf(
        arrayOf(0, -1),
        arrayOf(1, 0),
        arrayOf(0, 1),
        arrayOf(-1, 0),
    )

    init {
        while (true) {
            checkLinked()
            if (linkedCount == 0) break
            movePeople()
            day++
            //초기화
            isLinked = Array(n) { Array(n) { BooleanArray(4) } }
            visited1 = Array(n) { BooleanArray(n) }
            visited2 = Array(n) { BooleanArray(n) }
        }
    }

    //국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 오늘 하루 동안 연다.
    private fun checkLinked() {
        linkedCount = 0
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (i != 0 && abs(board[i][j] - board[i - 1][j]) in l..r) {
                    isLinked[i][j][0] = true
                    isLinked[i - 1][j][2] = true
                    linkedCount++
                }
                if (j != 0 && abs(board[i][j] - board[i][j - 1]) in l..r) {
                    isLinked[i][j][3] = true
                    isLinked[i][j - 1][1] = true
                    linkedCount++
                }
            }
        }
    }

    //사람들 이동
    private fun movePeople() {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (!visited1[i][j]) {
                    toatal = 0
                    linked = 1
                    //해당좌표에서 연결된곳을 확인
                    countLinked(j,i)
                    if (linked == 1) continue
                    //연결된곳의 값을 확인
                    setLinked(j,i,toatal/linked)
                }
            }
        }
    }

    private fun setLinked(x: Int, y: Int,num:Int) {
        visited2[y][x] = true
        board[y][x] = num
        for (d in 0 until 4) {
            if (y == 0 && d == 0) continue
            if (x == n - 1 && d == 1) continue
            if (y == n - 1 && d == 2) continue
            if (x == 0 && d == 3) continue
            if (!visited2[y + dir[d][1]][x + dir[d][0]] && isLinked[y][x][d]) {
                setLinked(x + dir[d][0], y + dir[d][1],num)
            }
        }
    }

    private fun countLinked(x: Int, y: Int) {
        visited1[y][x] = true
        toatal += board[y][x]
        for (d in 0 until 4) {
            if (y == 0 && d == 0) continue
            if (x == n - 1 && d == 1) continue
            if (y == n - 1 && d == 2) continue
            if (x == 0 && d == 3) continue
            if (!visited1[y + dir[d][1]][x + dir[d][0]] && isLinked[y][x][d]) {
                linked++
                countLinked(x + dir[d][0], y + dir[d][1])
            }
        }
    }
}

