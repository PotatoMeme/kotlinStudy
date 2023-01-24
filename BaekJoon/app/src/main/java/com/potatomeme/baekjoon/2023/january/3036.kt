package com.potatomeme.baekjoon.`2023`.january

import java.util.StringTokenizer

//https://www.acmicpc.net/problem/3036

//링 다국어
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	128 MB	14379	10833	9903	76.744%
//문제
//상근이는 창고에서 링 N개를 발견했다. 상근이는 각각의 링이 앞에 있는 링과 뒤에 있는 링과 접하도록 바닥에 내려놓았다.
//
//
//
//상근이는 첫 번째 링을 돌리기 시작했고, 나머지 링도 같이 돌아간다는 사실을 발견했다. 나머지 링은 첫 번째 링 보다 빠르게 돌아가기도 했고, 느리게 돌아가기도 했다. 이렇게 링을 돌리다 보니 첫 번째 링을 한 바퀴 돌리면, 나머지 링은 몇 바퀴 도는지 궁금해졌다.
//
//링의 반지름이 주어진다. 이때, 첫 번째 링을 한 바퀴 돌리면, 나머지 링은 몇 바퀴 돌아가는지 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 링의 개수 N이 주어진다. (3 ≤ N ≤ 100)
//
//다음 줄에는 링의 반지름이 상근이가 바닥에 놓은 순서대로 주어진다. 반지름은 1과 1000를 포함하는 사이의 자연수이다.
//
//출력
//출력은 총 N-1줄을 해야 한다. 첫 번째 링을 제외한 각각의 링에 대해서, 첫 번째 링을 한 바퀴 돌리면 그 링은 몇 바퀴 도는지 기약 분수 형태 A/B로 출력한다.
//
//예제 입력 1
//3
//8 4 2
//예제 출력 1
//2/1
//4/1
//예제 입력 2
//4
//12 3 8 4
//예제 출력 2
//4/1
//3/2
//3/1
//예제 입력 3
//4
//300 1 1 300
//예제 출력 3
//300/1
//300/1
//1/1

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val num = readLine().toInt()

    val st = StringTokenizer(readLine())
    val first = st.nextToken().toInt()
    val sb = StringBuilder()
    repeat(num - 1) {
        val second = st.nextToken().toInt()
        val div = if (first > second) gcd(first, second) else gcd(second, first)
        sb.append(first / div).append('/').append(second / div).appendLine()
    }
    print(sb.toString())
}

fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
}


