package com.potatomeme.baekjoon.`2023`.january

import kotlin.math.min

//https://www.acmicpc.net/problem/1149

//RGB거리
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//0.5 초 (추가 시간 없음)	128 MB	89029	47275	35281	52.487%
//문제
//RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.
//
//집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.
//
//1번 집의 색은 2번 집의 색과 같지 않아야 한다.
//N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
//i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
//입력
//첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다. 집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.
//
//출력
//첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.
//
//예제 입력 1
//3
//26 40 83
//49 60 57
//13 89 99
//예제 출력 1
//96
//예제 입력 2
//3
//1 100 100
//100 1 100
//100 100 1
//예제 출력 2
//3
//예제 입력 3
//3
//1 100 100
//100 100 100
//1 100 100
//예제 출력 3
//102
//예제 입력 4
//6
//30 19 5
//64 77 64
//15 19 97
//4 71 57
//90 86 84
//93 32 91
//예제 출력 4
//208
//예제 입력 5
//8
//71 39 44
//32 83 55
//51 37 63
//89 29 100
//83 58 11
//65 13 15
//47 25 29
//60 66 19
//예제 출력 5
//253

import kotlin.math.min

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val num = readLine().toInt()
    val reds = IntArray(num)
    val greens = IntArray(num)
    val blues = IntArray(num)
    repeat(num) {
        val line = readLine().split(" ")
        reds[it] = line[0].toInt()
        greens[it] = line[1].toInt()
        blues[it] = line[2].toInt()
    }
    val solution = Solution1149(num, reds, greens, blues)
    print(solution.result)
}

class Solution1149(val num:Int,val reds:IntArray,val greens:IntArray,val blues:IntArray) {
    val arr = Array(num){IntArray(3)}

    var result :Int

    init {
        arr[0][0] = reds[0]
        arr[0][1] = greens[0]
        arr[0][2] = blues[0]
        //bottom up
//        for (i in 1 until  num){
//            arr[i][0] = min(arr[i-1][1],arr[i-1][2]) + reds[i]
//            arr[i][1] = min(arr[i-1][0],arr[i-1][2]) + greens[i]
//            arr[i][2] = min(arr[i-1][0],arr[i-1][1]) + blues[i]
//        }
//        result = minOf(arr[num-1][0],arr[num-1][1],arr[num-1][2])

        result = minOf(paint(num -1,0),paint(num -1,1),paint(num -1,2))
    }

    //Top down
    fun paint(index :Int,color:Int) : Int{
        if (arr[index][color] == 0){
            when(color){
                0 -> arr[index][0] = min(paint(index-1,1),paint(index-1,2)) + reds[index]
                1 -> arr[index][1] = min(paint(index-1,0),paint(index-1,2)) + greens[index]
                2 -> arr[index][2] = min(paint(index-1,0),paint(index-1,1)) + blues[index]
            }
        }
        return arr[index][color]
    }

}