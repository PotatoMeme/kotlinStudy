package com.potatomeme.baekjoon.`2023`.january

//https://www.acmicpc.net/problem/2751

//수 정렬하기 2
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	256 MB	234004	67658	47066	30.527%
//문제
//N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
//
//출력
//첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
//
//예제 입력 1
//5
//5
//4
//3
//2
//1
//예제 출력 1
//1
//2
//3
//4
//5

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
//    val arr = IntArray(n)
//    repeat(n){arr[it]= readLine().toInt()}
//    print(arr.sorted().joinToString("\n"))

    val checked = BooleanArray(2000001)
    repeat(n) { checked[readLine().toInt()+1000000] = true }
    val sb = StringBuilder()
    checked.forEachIndexed { index, b -> if (b) sb.append(index-1000000).appendLine() }
    print(sb.toString())
}
