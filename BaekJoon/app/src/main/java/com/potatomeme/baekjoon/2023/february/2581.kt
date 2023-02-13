package com.potatomeme.baekjoon.`2023`.february


//https://www.acmicpc.net/problem/2581

//소수 성공
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	128 MB	114926	44993	37952	38.998%
//문제
//자연수 M과 N이 주어질 때 M이상 N이하의 자연수 중 소수인 것을 모두 골라 이들 소수의 합과 최솟값을 찾는 프로그램을 작성하시오.
//
//예를 들어 M=60, N=100인 경우 60이상 100이하의 자연수 중 소수는 61, 67, 71, 73, 79, 83, 89, 97 총 8개가 있으므로, 이들 소수의 합은 620이고, 최솟값은 61이 된다.
//
//입력
//입력의 첫째 줄에 M이, 둘째 줄에 N이 주어진다.
//
//M과 N은 10,000이하의 자연수이며, M은 N보다 작거나 같다.
//
//출력
//M이상 N이하의 자연수 중 소수인 것을 모두 찾아 첫째 줄에 그 합을, 둘째 줄에 그 중 최솟값을 출력한다.
//
//단, M이상 N이하의 자연수 중 소수가 없을 경우는 첫째 줄에 -1을 출력한다.
//
//예제 입력 1
//60
//100
//예제 출력 1
//620
//61
//예제 입력 2
//64
//65
//예제 출력 2
//-1


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    print(solve2581(readLine().toInt(), readLine().toInt()))
}

fun solve2581(m: Int, n: Int): String {
    val arr = BooleanArray(n + 1)
    arr[1] = true
    for (i in 2..n) {
        if (arr[i]) continue
        for (j in i + i..n step i) {
            arr[j] = true
        }
    }
    var sum = 0
    var min = Int.MAX_VALUE
    for (i in m..n) {
        if (!arr[i]){
            sum += i
            min = min.coerceAtMost(i)
        }
    }
    return if (sum == 0) "-1" else "$sum\n$min"
}

