package com.potatomeme.baekjoon.`2023`.february


//https://www.acmicpc.net/problem/2750

//수 정렬하기 성공
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	128 MB	158761	90373	62679	58.006%
//문제
//N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
//
//출력
//첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
//
//예제 입력 1
//5
//5
//2
//3
//4
//1
//예제 출력 1
//1
//2
//3
//4
//5


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val arr = BooleanArray(2001)
    repeat(readLine().toInt()) {
        arr[readLine().toInt() + 1000] = true
    }
    val sb = StringBuilder()
    for (i in 0..2000) {
        if (arr[i]) sb.appendLine(i - 1000)
    }
    print(sb.toString())
}