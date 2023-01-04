package com.potatomeme.baekjoon.`2023`.january

import android.os.Build.VERSION_CODES.N
import java.nio.file.Files.find
import kotlin.math.max

//https://www.acmicpc.net/problem/1003

//가장 긴 증가하는 부분 수열
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	256 MB	123351	48615	32021	37.374%
//문제
//수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.
//
//예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.
//
//입력
//첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.
//
//둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)
//
//출력
//첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.
//
//예제 입력 1
//6
//10 20 10 30 20 50
//예제 출력 1
//4

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val num = readLine().toInt()
    val list = readLine().split(" ").map { it.toInt() }
    val solution = Solution11053_topdown(num,list)
    print(solution.result)
}

class Solution11053(num: Int, list: List<Int>) {
    val arr = IntArray(num)
    val result
        get() = arr.max()
    init {
        arr[0] = 1
        for (i in 1 until  num){
            var max = 0
            for (j in i-1 downTo 0){
                if (list[i] > list[j]){
                    if (max < arr[j]) max = arr[j]
                }
            }
            arr[i] = max + 1
        }
    }
}

class Solution11053_topdown(val num: Int,val list: List<Int>) {
    val arr = IntArray(num)
    val result
        get() = arr.max()
    init {
        arr[0] = 1
        find(num-1)
    }

    fun find(index :Int) :Int{
        if (arr[index] == 0){
            for (i in index downTo 0 ){
                if (list[i] < list[index]){
                    arr[index] = max(arr[index],find(i))
                }
            }
            arr[index] += 1
        }
        return arr[index]
    }
}