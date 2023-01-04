package com.potatomeme.baekjoon.`2023`.january

import java.lang.Math.max

//https://www.acmicpc.net/problem/1932

//정수 삼각형
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	128 MB	72017	40982	30845	58.989%
//문제
//        7
//      3   8
//    8   1   0
//  2   7   4   4
//4   5   2   6   5
//위 그림은 크기가 5인 정수 삼각형의 한 모습이다.
//
//맨 위층 7부터 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때, 이제까지 선택된 수의 합이 최대가 되는 경로를 구하는 프로그램을 작성하라. 아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택할 수 있다.
//
//삼각형의 크기는 1 이상 500 이하이다. 삼각형을 이루고 있는 각 수는 모두 정수이며, 범위는 0 이상 9999 이하이다.
//
//입력
//첫째 줄에 삼각형의 크기 n(1 ≤ n ≤ 500)이 주어지고, 둘째 줄부터 n+1번째 줄까지 정수 삼각형이 주어진다.
//
//출력
//첫째 줄에 합이 최대가 되는 경로에 있는 수의 합을 출력한다.
//
//예제 입력 1
//5
//7
//3 8
//8 1 0
//2 7 4 4
//4 5 2 6 5
//예제 출력 1
//30
//253

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val num = readLine().toInt()
    val inputArr = Array(num){IntArray(num) }
    repeat(num){
        val line = readLine().split(" ")
        for ((index,value) in line.withIndex()){
            inputArr[it][index] = value.toInt()
        }
    }
    val solution = Solution1932_topdown(num,inputArr)
    print(solution.result)

}

class Solution1932(val num: Int, inputArr: Array<IntArray>) {
    val results = Array(num){IntArray(num)}
    val result
        get() = results[0][0]
    init {
        repeat(num){ results[num-1][it] = inputArr[num-1][it]}
        for (i in num-2 downTo 0){
            for (j in 0 .. i){
                results[i][j] = max(results[i+1][j],results[i+1][j+1])+inputArr[i][j]
            }
        }
    }
}

class Solution1932_topdown(val num: Int,val inputArr: Array<IntArray>) {
    val results = Array(num){IntArray(num){-1} }
    var result : Int

    init {
        repeat(num){ results[num-1][it] = inputArr[num-1][it]}
        result = find(0,0)
    }

    fun find(depth:Int,index:Int) : Int{
        if (results[depth][index] < 0){
            results[depth][index] = max(find(depth+1,index),find(depth+1,index+1)) + inputArr[depth][index]
        }
        return results[depth][index]
    }
}