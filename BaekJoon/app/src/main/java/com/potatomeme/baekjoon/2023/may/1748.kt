package com.potatomeme.baekjoon.`2023`.may

import java.util.StringTokenizer


//https://www.acmicpc.net/problem/1748

//
//수 이어 쓰기 1 다국어
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//0.15 초 (하단 참고)	128 MB	24676	11327	9343	48.598%
//문제
//1부터 N까지의 수를 이어서 쓰면 다음과 같이 새로운 하나의 수를 얻을 수 있다.
//
//1234567891011121314151617181920212223...
//
//이렇게 만들어진 새로운 수는 몇 자리 수일까? 이 수의 자릿수를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 N(1 ≤ N ≤ 100,000,000)이 주어진다.
//
//출력
//첫째 줄에 새로운 수의 자릿수를 출력한다.
//
//예제 입력 1
//5
//예제 출력 1
//5
//예제 입력 2
//15
//예제 출력 2
//21
//예제 입력 3
//120
//예제 출력 3
//252


fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    var base = 10 // 첫 base 이후 10씩 곱해줌
    var cnt = 0 // 계산한 수들을 카운트
    var ans = 0 // 총합
    var i = 1 // 몇번째인지 알려주는 변수,depth
    while (true) {
        if (n < base) {
            ans += i++ * (n - cnt)
            break
        } else {
            ans += i++ * (base - cnt - 1)
            cnt = base - 1
        }
        base *= 10
    }
    print(ans)
}

