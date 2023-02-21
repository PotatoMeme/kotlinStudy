package com.potatomeme.baekjoon.`2023`.february

import java.util.StringTokenizer


//https://www.acmicpc.net/problem/10812

//공 바꾸기
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	256 MB	3626	2995	2794	84.462%
//문제
//도현이는 바구니를 총 N개 가지고 있고, 각각의 바구니에는 1번부터 N번까지 번호가 매겨져 있다. 바구니에는 공이 1개씩 들어있고, 처음에는 바구니에 적혀있는 번호와 같은 번호가 적힌 공이 들어있다.
//
//도현이는 앞으로 M번 공을 바꾸려고 한다. 도현이는 공을 바꿀 바구니 2개를 선택하고, 두 바구니에 들어있는 공을 서로 교환한다.
//
//공을 어떻게 바꿀지가 주어졌을 때, M번 공을 바꾼 이후에 각 바구니에 어떤 공이 들어있는지 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 N (1 ≤ N ≤ 100)과 M (1 ≤ M ≤ 100)이 주어진다.
//
//둘째 줄부터 M개의 줄에 걸쳐서 공을 교환할 방법이 주어진다. 각 방법은 두 정수 i j로 이루어져 있으며, i번 바구니와 j번 바구니에 들어있는 공을 교환한다는 뜻이다. (1 ≤ i ≤ j ≤ N)
//
//도현이는 입력으로 주어진 순서대로 공을 교환한다.
//
//출력
//1번 바구니부터 N번 바구니에 들어있는 공의 번호를 공백으로 구분해 출력한다.
//
//예제 입력 1
//5 4
//1 2
//3 4
//1 4
//2 2
//예제 출력 1
//3 1 4 2 5


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val arr = IntArray(n + 1) { it }
    repeat(m) {
        val ij = StringTokenizer(readLine())
        val i = ij.nextToken().toInt()
        val j = ij.nextToken().toInt()
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }
    val sb = StringBuilder().apply {
        for (i in 1..n) {
            append(arr[i])
            append(" ")
        }
    }
    print(sb.toString())
}

