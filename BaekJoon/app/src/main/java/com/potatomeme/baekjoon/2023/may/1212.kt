package com.potatomeme.baekjoon.`2023`.may



//https://www.acmicpc.net/problem/1212

//8진수 2진수
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	256 MB	40949	13752	11379	35.793%
//문제
//8진수가 주어졌을 때, 2진수로 변환하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 8진수가 주어진다. 주어지는 수의 길이는 333,334을 넘지 않는다.
//
//출력
//첫째 줄에 주어진 수를 2진수로 변환하여 출력한다. 수가 0인 경우를 제외하고는 반드시 1로 시작해야 한다.
//
//예제 입력 1
//314
//예제 출력 1
//11001100

fun main() = with(System.`in`.bufferedReader()) {
    val arr1 = arrayOf("0", "1", "10", "11", "100", "101", "110", "111")
    val arr2 = arrayOf("000", "001", "010", "011", "100", "101", "110", "111")
    val str = buildString {
        val line = readLine()
        append(arr1[line[0] - '0'])
        for (i in 1 .. line.lastIndex){
            append(arr2[line[i] - '0'])
        }
    }
    print(str)
}


