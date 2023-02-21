package com.potatomeme.baekjoon.`2023`.february

import java.util.StringTokenizer


//https://www.acmicpc.net/problem/10812

//바구니 순서 바꾸기
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	256 MB	1340	1079	993	82.270%
//문제
//도현이는 바구니를 총 N개 가지고 있고, 각각의 바구니에는 1번부터 N번까지 번호가 순서대로 적혀져 있다. 바구니는 일렬로 놓여져 있고, 가장 왼쪽 바구니를 1번째 바구니, 그 다음 바구니를 2번째 바구니, ..., 가장 오른쪽 바구니를 N번째 바구니라고 부른다.
//
//도현이는 앞으로 M번 바구니의 순서를 회전시키려고 만들려고 한다. 도현이는 바구니의 순서를 회전시킬 때, 순서를 회전시킬 범위를 정하고, 그 범위 안에서 기준이 될 바구니를 선택한다. 도현이가 선택한 바구니의 범위가 begin, end이고, 기준이 되는 바구니를 mid라고 했을 때, begin, begin+1, ..., mid-1, mid, mid+1, ..., end-1, end 순서로 되어있는 바구니의 순서를 mid, mid+1, ..., end-1, end, begin, begin+1, ..., mid-1로 바꾸게 된다.
//
//바구니의 순서를 어떻게 회전시킬지 주어졌을 때, M번 바구니의 순서를 회전시킨 다음, 바구니에 적혀있는 번호를 가장 왼쪽 바구니부터 출력하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 N (1 ≤ N ≤ 100)과 M (1 ≤ M ≤ 100)이 주어진다.
//
//둘째 줄부터 M개의 줄에는 바구니의 순서를 바꾸는 만드는 방법이 주어진다. 방법은 i, j, k로 나타내고, 왼쪽으로부터 i번째 바구니부터 j번째 바구니의 순서를 회전시키는데, 그 때 기준 바구니는 k번째 바구니라는 뜻이다. (1 ≤ i ≤ k ≤ j ≤ N)
//
//도현이는 입력으로 주어진 순서대로 바구니의 순서를 회전시킨다.
//
//출력
//모든 순서를 회전시킨 다음에, 가장 왼쪽에 있는 바구니부터 바구니에 적혀있는 순서를 공백으로 구분해 출력한다.
//
//예제 입력 1
//10 5
//1 6 4
//3 9 8
//2 10 5
//1 3 3
//2 6 2
//예제 출력 1
//1 4 6 2 3 7 10 5 8 9

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val arr = IntArray(n + 1) { it }
    repeat(m) {
        val ijk = StringTokenizer(readLine())
        val i = ijk.nextToken().toInt()
        val j = ijk.nextToken().toInt()
        val k = ijk.nextToken().toInt()
        val sub = IntArray(j-i+1)

        for (t in 0 .. j-k) {
            sub[t] = arr[k + t]
        }
        var t = j-k+1
        for (o in i until k){
            sub[t++] = arr[o]
        }
        t = 0
        for (o in i .. j){
            arr[o] = sub[t++]
        }
    }
    val sb = StringBuilder().apply {
        for (i in 1..n) {
            append(arr[i])
            append(" ")
        }
    }
    print(sb.toString())
}

