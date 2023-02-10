package com.potatomeme.baekjoon.`2023`.february

import java.util.StringTokenizer


//https://www.acmicpc.net/problem/1904

//구간 합 구하기 4
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	256 MB	63033	26756	20417	40.696%
//문제
//수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다. 둘째 줄에는 N개의 수가 주어진다. 수는 1,000보다 작거나 같은 자연수이다. 셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.
//
//출력
//총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.
//
//제한
//1 ≤ N ≤ 100,000
//1 ≤ M ≤ 100,000
//1 ≤ i ≤ j ≤ N
//예제 입력 1
//5 3
//5 4 3 2 1
//1 3
//2 4
//5 5
//예제 출력 1
//12
//9
//1


// 요지
// 이게 합을 여러번 구하라고 요구하기때문에 매번 for문을 통해 일일이 값을 구하면 time out이 날것임 n크기의 개수로 배열을 설정하고 for문을 돌며 해당 index까지 값을 배열에 저장해놓고 (arr[j] - arr[i])로 출력

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val arr = IntArray(n + 1)
    st = StringTokenizer(readLine())
    for (i in 1..n) {
        arr[i] = arr[i - 1] + st.nextToken().toInt()
    }
    val sb = StringBuilder()
    repeat(m) {
        st = StringTokenizer(readLine())
        sb.append(-arr[st.nextToken().toInt() - 1] + arr[st.nextToken().toInt()]).appendLine()
    }
    print(sb.toString())
}
