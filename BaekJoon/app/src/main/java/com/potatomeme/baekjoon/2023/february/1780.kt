package com.potatomeme.baekjoon.`2023`.february

import java.util.StringTokenizer


//https://www.acmicpc.net/problem/1780

//종이의 개수
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	256 MB	36285	21591	16193	58.685%
//문제
//N×N크기의 행렬로 표현되는 종이가 있다. 종이의 각 칸에는 -1, 0, 1 중 하나가 저장되어 있다. 우리는 이 행렬을 다음과 같은 규칙에 따라 적절한 크기로 자르려고 한다.
//
//만약 종이가 모두 같은 수로 되어 있다면 이 종이를 그대로 사용한다.
//(1)이 아닌 경우에는 종이를 같은 크기의 종이 9개로 자르고, 각각의 잘린 종이에 대해서 (1)의 과정을 반복한다.
//이와 같이 종이를 잘랐을 때, -1로만 채워진 종이의 개수, 0으로만 채워진 종이의 개수, 1로만 채워진 종이의 개수를 구해내는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 N(1 ≤ N ≤ 37, N은 3k 꼴)이 주어진다. 다음 N개의 줄에는 N개의 정수로 행렬이 주어진다.
//
//출력
//첫째 줄에 -1로만 채워진 종이의 개수를, 둘째 줄에 0으로만 채워진 종이의 개수를, 셋째 줄에 1로만 채워진 종이의 개수를 출력한다.
//
//예제 입력 1
//9
//0 0 0 1 1 1 -1 -1 -1
//0 0 0 1 1 1 -1 -1 -1
//0 0 0 1 1 1 -1 -1 -1
//1 1 1 0 0 0 0 0 0
//1 1 1 0 0 0 0 0 0
//1 1 1 0 0 0 0 0 0
//0 1 -1 0 1 -1 0 1 -1
//0 -1 1 0 1 -1 0 1 -1
//0 1 -1 1 0 -1 0 1 -1
//예제 출력 1
//10
//12
//11


enum class RGB { RED, GREEN, BLUE }

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = Array(n) { Array(n) { RGB.RED } }
    repeat(n) { i1 ->
        val st = StringTokenizer(readLine())
        repeat(n) { i2 ->
            when (st.nextToken().toInt()) {
                -1 -> arr[i1][i2] = RGB.RED
                0 -> arr[i1][i2] = RGB.GREEN
                1 -> arr[i1][i2] = RGB.BLUE
            }
        }
    }

    var red_cnt = 0
    var green_cnt = 0
    var blue_cnt = 0
    fun solve(x1: Int, y1: Int, x2: Int, y2: Int) {
        if (x1 == x2 && y1 == y2) {
            when (arr[x1][y1]) {
                RGB.RED -> red_cnt++
                RGB.GREEN -> green_cnt++
                RGB.BLUE -> blue_cnt++
            }
            return
        }
        for (i in x1..x2) {
            for (j in y1 until y2) {
                if (arr[i][j] != arr[i][j + 1]) {
                    val slice = (x2 - x1 + 1) / 3
                    solve(x1, y1, x2 - 2 * slice, y2 - 2 * slice)
                    solve(x1 + slice, y1, x2 - 1 * slice, y2 - 2 * slice)
                    solve(x1 + 2 * slice, y1, x2, y2 - 2 * slice)
                    solve(x1, y1 + slice, x2 - 2 * slice, y2 - slice)
                    solve(x1 + slice, y1 + slice, x2 - 1 * slice, y2 - slice)
                    solve(x1 + 2 * slice, y1 + slice, x2, y2 - slice)
                    solve(x1, y1 + 2 * slice, x2 - 2 * slice, y2)
                    solve(x1 + slice, y1 + 2 * slice, x2 - 1 * slice, y2)
                    solve(x1 + 2 * slice, y1 + 2 * slice, x2, y2)
                    return
                }
            }
        }
        for (i in x1 until x2) {
            if (arr[i][y1] != arr[i + 1][y1]) {
                val slice = (x2 - x1 + 1) / 3
                solve(x1, y1, x2 - 2 * slice, y2 - 2 * slice)
                solve(x1 + slice, y1, x2 - 1 * slice, y2 - 2 * slice)
                solve(x1 + 2 * slice, y1, x2, y2 - 2 * slice)
                solve(x1, y1 + slice, x2 - 2 * slice, y2 - slice)
                solve(x1 + slice, y1 + slice, x2 - 1 * slice, y2 - slice)
                solve(x1 + 2 * slice, y1 + slice, x2, y2 - slice)
                solve(x1, y1 + 2 * slice, x2 - 2 * slice, y2)
                solve(x1 + slice, y1 + 2 * slice, x2 - 1 * slice, y2)
                solve(x1 + 2 * slice, y1 + 2 * slice, x2, y2)
                return
            }
        }
        when (arr[x1][y1]) {
            RGB.RED -> red_cnt++
            RGB.GREEN -> green_cnt++
            RGB.BLUE -> blue_cnt++
        }
    }
    solve(0, 0, n - 1, n - 1)
    print("$red_cnt\n$green_cnt\n$blue_cnt")
}

