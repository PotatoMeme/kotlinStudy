package com.potatomeme.baekjoon.`2023`.may

import java.util.Stack
import java.util.StringTokenizer


//https://www.acmicpc.net/problem/9093

//
//GCD 합 다국어
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	128 MB	32007	12874	10532	41.078%
//문제
//양의 정수 n개가 주어졌을 때, 가능한 모든 쌍의 GCD의 합을 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 테스트 케이스의 개수 t (1 ≤ t ≤ 100)이 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있다. 각 테스트 케이스는 수의 개수 n (1 < n ≤ 100)가 주어지고, 다음에는 n개의 수가 주어진다. 입력으로 주어지는 수는 1,000,000을 넘지 않는다.
//
//출력
//각 테스트 케이스마다 가능한 모든 쌍의 GCD의 합을 출력한다.
//
//예제 입력 1
//3
//4 10 20 30 40
//3 7 5 12
//3 125 15 25
//예제 출력 1
//70
//3
//35

fun main() = with(System.`in`.bufferedReader()) {
    fun gcd(a:Int,b:Int):Int = if (b == 0) a else gcd(b,a%b)
    val sb = StringBuilder()
    repeat(readLine().toInt()){
        val st =StringTokenizer(readLine())
        val n = st.nextToken().toInt()
        val arr =IntArray(n){ st.nextToken().toInt() }
        var sum = 0L
        for (i in 0 until n -1){
            for (j in i+1 until n){
                sum += gcd(arr[i],arr[j])
            }
        }
        sb.appendLine(sum)
    }
    print(sb.toString())
}


