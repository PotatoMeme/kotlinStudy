package com.potatomeme.baekjoon.`2023`.march


//https://www.acmicpc.net/problem/17103

//골드바흐 파티션
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//0.5 초	512 MB	9615	3941	2913	39.338%
//문제
//골드바흐의 추측: 2보다 큰 짝수는 두 소수의 합으로 나타낼 수 있다.
//짝수 N을 두 소수의 합으로 나타내는 표현을 골드바흐 파티션이라고 한다. 짝수 N이 주어졌을 때, 골드바흐 파티션의 개수를 구해보자. 두 소수의 순서만 다른 것은 같은 파티션이다.
//
//입력
//첫째 줄에 테스트 케이스의 개수 T (1 ≤ T ≤ 100)가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 N은 짝수이고, 2 < N ≤ 1,000,000을 만족한다.
//
//출력
//각각의 테스트 케이스마다 골드바흐 파티션의 수를 출력한다.
//
//예제 입력 1
//5
//6
//8
//10
//12
//100
//예제 출력 1
//1
//1
//2
//1
//6

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val arr = BooleanArray(1_000_001)
    for (i in 2..1_000) {
        if (arr[i]) continue
        for (j in i + i..1_000_000 step i) {
            arr[j] = true
        }
    }
    fun solve(n: Int): Int {
        var count = 0
        for (i in 2..n / 2) {
            if (arr[i] || arr[n - i]) continue
            count++
        }
        return count
    }
    print(StringBuilder().apply {
        repeat(readLine().toInt()) {
            appendLine(solve(readLine().toInt()))
        }
    })
}