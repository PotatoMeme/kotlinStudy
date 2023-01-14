package com.potatomeme.baekjoon.`2023`.january

import java.util.StringTokenizer

//https://www.acmicpc.net/problem/11650

//좌표 정렬하기
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	256 MB	98334	46581	36061	47.916%
//문제
//2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.
//
//출력
//첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
//
//예제 입력 1
//5
//3 4
//1 1
//1 -1
//2 2
//3 3
//예제 출력 1
//1 -1
//1 1
//2 2
//3 3
//3 4

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val num = readLine().toInt()
    val arr: Array<Pair<Int, Int>> = Array(num) { Pair(0, 0) }

    repeat(num) {
        val st = StringTokenizer(readLine())
        arr[it] =
            Pair(st.nextToken().toInt(), st.nextToken().toInt())
    }
    val sb = StringBuilder()
    arr.sortedWith(compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second })
        .forEach { sb.append(it.first).append(" ").append(it.second).appendLine() }

    print(sb.toString())
}

class Solution11650() {
    fun try1(num: Int): String {
        val arr = Array(200001) { BooleanArray(200001) }
        repeat(num) {
            val st = StringTokenizer(readLine())
            arr[st.nextToken().toInt() - 100000][st.nextToken().toInt() - 100000] = true
        }
        var count = num
        var i = 0
        var j = 0
        val sb = StringBuilder()
        while (count > 0) {
            if (arr[i][j++]) sb.append(i - 100000).append(" ").append(j - 100000).appendLine()
            if (j == 200001) {
                i++
                j = 0
            }
        }
        return sb.toString()
    }//.OutOfMemoryError
}