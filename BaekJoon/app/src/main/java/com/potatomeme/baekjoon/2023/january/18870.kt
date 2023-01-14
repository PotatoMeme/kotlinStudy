package com.potatomeme.baekjoon.`2023`.january

import java.util.StringTokenizer

//https://www.acmicpc.net/problem/18870

//좌표 압축
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	512 MB	53365	22407	17117	39.855%
//문제
//수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.
//
//Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표의 개수와 같아야 한다.
//
//X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.
//
//입력
//첫째 줄에 N이 주어진다.
//
//둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다.
//
//출력
//첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력한다.
//
//제한
//1 ≤ N ≤ 1,000,000
//-109 ≤ Xi ≤ 109
//예제 입력 1
//5
//2 4 -10 4 -9
//예제 출력 1
//2 3 0 3 1
//예제 입력 2
//6
//1000 999 1000 999 1000 999
//예제 출력 2
//1 0 1 0 1 0

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val num = readLine().toInt()
    val st = StringTokenizer(readLine())

    val arr = IntArray(num)
    repeat(num){arr[it] = st.nextToken().toInt()}

    val sorted = arr.toSortedSet().toIntArray()

    val sb = StringBuilder()
    for (i in arr.indices){
        val rank = sorted.binarySearch(arr[i], 0, sorted.size)
        sb.append(rank).append(" ")
    }
    print(sb.toString())
}
class Solution18870(){
    fun try1(num:Int,st:StringTokenizer){
        val arr: Array<Pair<Int, Int>> = Array(num) { Pair(0, 0) }

        repeat(num) {
            arr[it] =
                Pair(it, st.nextToken().toInt())
        }

        val sb = StringBuilder()
        val arr_result = IntArray(num)
        var count = 0

        var sec = 0
        arr.sortedWith(compareBy { it.second }).forEachIndexed { index, pair ->
            if (index > 0) {
                if (sec != pair.second) {
                    count++
                }
            }
            sec = pair.second
            arr_result[pair.first] = count
        }

        arr_result.forEach { sb.append(it).append(" ") }

        print(sb.toString())
    }
}