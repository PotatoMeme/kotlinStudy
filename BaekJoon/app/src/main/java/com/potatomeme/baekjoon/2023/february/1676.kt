package com.potatomeme.baekjoon.`2023`.february

//https://www.acmicpc.net/problem/1676

//팩토리얼 0의 개수 성공
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	128 MB	56470	27195	22479	47.911%
//문제
//N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 N이 주어진다. (0 ≤ N ≤ 500)
//
//출력
//첫째 줄에 구한 0의 개수를 출력한다.
//
//예제 입력 1
//10
//예제 출력 1
//2
//예제 입력 2
//3
//예제 출력 2
//0


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var cnt2 = 0
    var cnt5 = 0

    for (i in 1..n) {
        var tmp = i
        while (tmp % 2 == 0) {
            tmp /= 2
            cnt2++
        }
        while (tmp % 5 == 0) {
            tmp /= 5
            cnt5++
        }
    }
    print(cnt5.coerceAtMost(cnt2))
}


