package com.potatomeme.baekjoon.`2023`.march

import java.util.*


//https://www.acmicpc.net/problem/1735

//분수 합
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	128 MB	16728	7756	6517	48.242%
//문제
//분수 A/B는 분자가 A, 분모가 B인 분수를 의미한다. A와 B는 모두 자연수라고 하자.
//
//두 분수의 합 또한 분수로 표현할 수 있다. 두 분수가 주어졌을 때, 그 합을 기약분수의 형태로 구하는 프로그램을 작성하시오. 기약분수란 더 이상 약분되지 않는 분수를 의미한다.
//
//입력
//첫째 줄과 둘째 줄에, 각 분수의 분자와 분모를 뜻하는 두 개의 자연수가 순서대로 주어진다. 입력되는 네 자연수는 모두 30,000 이하이다.
//
//출력
//첫째 줄에 구하고자 하는 기약분수의 분자와 분모를 뜻하는 두 개의 자연수를 빈 칸을 사이에 두고 순서대로 출력한다.
//
//예제 입력 1
//2 7
//3 5
//예제 출력 1
//31 35


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    fun gcd(n1: Int, n2: Int): Int = if (n2 == 0) n1 else gcd(n2, n1 % n2)
    val n1: Int
    val n2: Int
    StringTokenizer(readLine()).run {
        n1 = nextToken().toInt()
        n2 = nextToken().toInt()
    }

    val n3: Int
    val n4: Int
    StringTokenizer(readLine()).run {
        n3 = nextToken().toInt()
        n4 = nextToken().toInt()
    }

    print(gcd(n2, n4).let {
        val top = n1 * (n4 / it) + n3 * (n2 / it)
        val bot = n2 * n4 / it
        val gcd = gcd(top, bot)
        StringBuilder().append(top / gcd).append(" ").append(bot / gcd)
    })
}