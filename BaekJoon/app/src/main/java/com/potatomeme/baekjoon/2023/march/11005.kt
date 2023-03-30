package com.potatomeme.baekjoon.`2023`.march

import java.util.*
import kotlin.math.sqrt


//https://www.acmicpc.net/problem/11005

//진법 변환 2
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//0.5 초 (추가 시간 없음)	256 MB	15681	8060	6652	51.876%
//문제
//10진법 수 N이 주어진다. 이 수를 B진법으로 바꿔 출력하는 프로그램을 작성하시오.
//
//10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.
//
//A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35
//
//입력
//첫째 줄에 N과 B가 주어진다. (2 ≤ B ≤ 36) N은 10억보다 작거나 같은 자연수이다.
//
//출력
//첫째 줄에 10진법 수 N을 B진법으로 출력한다.
//
//예제 입력 1
//60466175 36
//예제 출력 1
//ZZZZZ


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    var num = st.nextToken().toInt()
    val n = st.nextToken().toInt()
    if (num == 1 ) return print(num)
    var now = 1L
    var i = 1
    while (true){
        i++
        now *= n
        if (num < now){
            now /= n
            i -= 1
            break
        }
    }

    println(buildString {
        repeat(i){
            when(val a = num/now){
                in 0 .. 9 -> append(a)
                else -> append('A'+((a-10).toInt()))
            }
            num %= now.toInt()
            now /= n
        }
    })
}