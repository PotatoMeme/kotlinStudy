package com.potatomeme.baekjoon.`2023`.january

import android.os.Build.VERSION_CODES.N
import java.util.StringTokenizer
//https://www.acmicpc.net/problem/11051

//이항 계수 2
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	256 MB	51078	18928	14900	37.553%
//문제
//자연수
//\(N\)과 정수
//\(K\)가 주어졌을 때 이항 계수
//\(\binom{N}{K}\)를 10,007로 나눈 나머지를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에
//\(N\)과
//\(K\)가 주어진다. (1 ≤
//\(N\) ≤ 1,000, 0 ≤
//\(K\) ≤
//\(N\))
//
//출력
//
//\(\binom{N}{K}\)를 10,007로 나눈 나머지를 출력한다.
//
//예제 입력 1
//5 2
//예제 출력 1
//10

private lateinit var arr : Array<IntArray>

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    arr = Array(n+1){IntArray(k+1)}
    getResultType3(n, k)
    print(arr[n][k])
}



fun getResultType3(a: Int, b: Int) {
    for (i in 0 .. a){
        arr[i][0] = 1
        for (j in 1 .. (if (b > i) i else b)) arr[i][j] = (arr[i-1][j-1] + arr[i-1][j])%10007
    }
}


fun getResultType2(a: Int, b: Int): Int {
    val arr = LongArray(b + 1) { 0 }
    for (i in 0..a) {
        for (j in (if (b > i) i else b) downTo 0 ) {
            arr[j] = if (j == i || j == 0) {
                1
            }else {
                arr[j - 1] + arr[j]
            }
        }
    }
    return (arr[b] % 10007).toInt()
}

fun getResult(a: Int, b: Int): Long {
    return if (b == 1 || a == b) 1 else getResult(a - 1, b - 1) + getResult(a - 1, b)
}// time out
