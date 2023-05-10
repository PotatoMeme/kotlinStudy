package com.potatomeme.baekjoon.`2023`.may

//https://www.acmicpc.net/problem/10820

//문자열 분석
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	256 MB	28236	11468	9466	41.131%
//문제
//문자열 N개가 주어진다. 이때, 문자열에 포함되어 있는 소문자, 대문자, 숫자, 공백의 개수를 구하는 프로그램을 작성하시오.
//
//각 문자열은 알파벳 소문자, 대문자, 숫자, 공백으로만 이루어져 있다.
//
//입력
//첫째 줄부터 N번째 줄까지 문자열이 주어진다. (1 ≤ N ≤ 100) 문자열의 길이는 100을 넘지 않는다.
//
//출력
//첫째 줄부터 N번째 줄까지 각각의 문자열에 대해서 소문자, 대문자, 숫자, 공백의 개수를 공백으로 구분해 출력한다.
//
//예제 입력 1
//This is String
//SPACE    1    SPACE
// S a M p L e I n P u T
//0L1A2S3T4L5I6N7E8
//예제 출력 1
//10 2 0 2
//0 10 1 8
//5 6 0 16
//0 8 9 0

fun main() = with(System.`in`.bufferedReader()) {
    while (true) {
        val line = readLine() ?: break
        print(buildString {
            var case1 = 0
            var case2 = 0
            var case3 = 0
            var case4 = 0
            line.forEach { char ->
                if (char >= 'a') case1++
                else if (char >= 'A') case2++
                else if (char >= '0') case3++
                else case4++
            }
            append(case1).append(" ")
                .append(case2).append(" ")
                .append(case3).append(" ")
                .appendLine(case4)
        })
    }
}
