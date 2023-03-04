package com.potatomeme.baekjoon.`2023`.march

import android.os.Build.VERSION_CODES.N
import java.lang.Integer.min


//https://www.acmicpc.net/problem/1300

//K번째 수
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	128 MB	31290	11318	8328	37.463%
//문제
//세준이는 크기가 N×N인 배열 A를 만들었다. 배열에 들어있는 수 A[i][j] = i×j 이다. 이 수를 일차원 배열 B에 넣으면 B의 크기는 N×N이 된다. B를 오름차순 정렬했을 때, B[k]를 구해보자.
//
//배열 A와 B의 인덱스는 1부터 시작한다.
//
//입력
//첫째 줄에 배열의 크기 N이 주어진다. N은 105보다 작거나 같은 자연수이다. 둘째 줄에 k가 주어진다. k는 min(109, N2)보다 작거나 같은 자연수이다.
//
//출력
//B[k]를 출력한다.
//
//예제 입력 1
//3
//7
//예제 출력 1
//6


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val k = readLine().toLong()

    var lo = 1L;
    var hi = k

    while (lo < hi) {
        val mid = (lo + hi) / 2
        var count = 0L

        for (i in 1..n) {
            count += min((mid / i).toInt(), n)
        }

        if (k <= count) {
            hi = mid;
        } else {
            lo = mid + 1;
        }
    }

    print(lo)
}