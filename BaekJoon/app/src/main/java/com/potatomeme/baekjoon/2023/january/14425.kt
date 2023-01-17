package com.potatomeme.baekjoon.`2023`.january

import java.util.StringTokenizer

//https://www.acmicpc.net/problem/14425

//문자열 집합
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초 (하단 참고)	1536 MB	25535	13767	10339	53.799%
//문제
//총 N개의 문자열로 이루어진 집합 S가 주어진다.
//
//입력으로 주어지는 M개의 문자열 중에서 집합 S에 포함되어 있는 것이 총 몇 개인지 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 문자열의 개수 N과 M (1 ≤ N ≤ 10,000, 1 ≤ M ≤ 10,000)이 주어진다.
//
//다음 N개의 줄에는 집합 S에 포함되어 있는 문자열들이 주어진다.
//
//다음 M개의 줄에는 검사해야 하는 문자열들이 주어진다.
//
//입력으로 주어지는 문자열은 알파벳 소문자로만 이루어져 있으며, 길이는 500을 넘지 않는다. 집합 S에 같은 문자열이 여러 번 주어지는 경우는 없다.
//
//출력
//첫째 줄에 M개의 문자열 중에 총 몇 개가 집합 S에 포함되어 있는지 출력한다.
//
//예제 입력 1
//5 11
//baekjoononlinejudge
//startlink
//codeplus
//sundaycoding
//codingsh
//baekjoon
//codeplus
//codeminus
//startlink
//starlink
//sundaycoding
//codingsh
//codinghs
//sondaycoding
//startrink
//icerink
//예제 출력 1
//4

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val map = mutableMapOf<String,Boolean>()
    repeat(st.nextToken().toInt()){
        map[readLine()] = true
    }
    var count = 0
    repeat(st.nextToken().toInt()){
        if (map[readLine()] == true) count++
    }
    print(count++)
}
