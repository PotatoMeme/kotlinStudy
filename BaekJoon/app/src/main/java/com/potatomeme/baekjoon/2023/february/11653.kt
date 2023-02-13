package com.potatomeme.baekjoon.`2023`.february


//https://www.acmicpc.net/problem/11653

//소인수분해 성공
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	256 MB	82028	44058	34224	52.299%
//문제
//정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 정수 N (1 ≤ N ≤ 10,000,000)이 주어진다.
//
//출력
//N의 소인수분해 결과를 한 줄에 하나씩 오름차순으로 출력한다. N이 1인 경우 아무것도 출력하지 않는다.
//
//예제 입력 1
//72
//예제 출력 1
//2
//2
//2
//3
//3
//예제 입력 2
//3
//예제 출력 2
//3
//예제 입력 3
//6
//예제 출력 3
//2
//3
//예제 입력 4
//2
//예제 출력 4
//2
//예제 입력 5
//9991
//예제 출력 5
//97
//103

val sb = StringBuilder()
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    solve11653(n,2)
    if (sb.isNotEmpty()){
        print(sb.toString())
    }
}

fun solve11653(n: Int,i:Int) {
    if (n == 1) return
    if (n%i == 0){
        sb.appendLine(i)
        solve11653(n/i,i)
    }else{
        solve11653(n,i+1)
    }
}

