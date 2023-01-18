package com.potatomeme.baekjoon.`2023`.january

import java.util.StringTokenizer

//https://www.acmicpc.net/problem/1764

//듣보잡
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	256 MB	67734	28448	21786	40.377%
//문제
//김진영이 듣도 못한 사람의 명단과, 보도 못한 사람의 명단이 주어질 때, 듣도 보도 못한 사람의 명단을 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 듣도 못한 사람의 수 N, 보도 못한 사람의 수 M이 주어진다. 이어서 둘째 줄부터 N개의 줄에 걸쳐 듣도 못한 사람의 이름과, N+2째 줄부터 보도 못한 사람의 이름이 순서대로 주어진다. 이름은 띄어쓰기 없이 알파벳 소문자로만 이루어지며, 그 길이는 20 이하이다. N, M은 500,000 이하의 자연수이다.
//
//듣도 못한 사람의 명단에는 중복되는 이름이 없으며, 보도 못한 사람의 명단도 마찬가지이다.
//
//출력
//듣보잡의 수와 그 명단을 사전순으로 출력한다.
//
//예제 입력 1
//3 4
//ohhenrie
//charlie
//baesangwook
//obama
//baesangwook
//ohhenrie
//clinton
//예제 출력 1
//2
//baesangwook
//ohhenrie

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())

    val set = mutableSetOf<String>()
    repeat(st.nextToken().toInt()){
        set.add(readLine())
    }
    val list = mutableListOf<String>()
    repeat(st.nextToken().toInt()){
        val line = readLine()
        if (line in set) list.add(line)
    }
    val sb = StringBuilder()
    sb.append(list.size).appendLine()
    list.sorted().forEach { sb.append(it).appendLine() }
    print(sb.toString())
}
