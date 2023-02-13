package com.potatomeme.baekjoon.`2023`.february

//https://www.acmicpc.net/problem/1427

//소트인사이드 성공
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	128 MB	71256	45927	38357	64.812%
//문제
//배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
//
//입력
//첫째 줄에 정렬하려고 하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.
//
//출력
//첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.
//
//예제 입력 1
//2143
//예제 출력 1
//4321
//예제 입력 2
//999998999
//예제 출력 2
//999999998
//예제 입력 3
//61423
//예제 출력 3
//64321
//예제 입력 4
//500613009
//예제 출력 4
//965310000


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val str = readLine()
    val arr = IntArray(10){0}
    str.forEach { arr[it.digitToInt()]++  }
    val sb = StringBuilder()
    for (i in 9 downTo 0){
        if (arr[i] == 0) continue
        repeat(arr[i]){
            sb.append(i)
        }
    }
    print(sb.toString())
}