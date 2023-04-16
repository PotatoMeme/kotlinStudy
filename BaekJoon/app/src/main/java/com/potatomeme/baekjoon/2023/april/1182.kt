package com.potatomeme.baekjoon.`2023`.april

import java.util.StringTokenizer


//https://www.acmicpc.net/problem/1182

//부분수열의 합
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	256 MB	66991	30773	20007	44.095%
//문제
//N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 정수의 개수를 나타내는 N과 정수 S가 주어진다. (1 ≤ N ≤ 20, |S| ≤ 1,000,000) 둘째 줄에 N개의 정수가 빈 칸을 사이에 두고 주어진다. 주어지는 정수의 절댓값은 100,000을 넘지 않는다.
//
//출력
//첫째 줄에 합이 S가 되는 부분수열의 개수를 출력한다.
//
//예제 입력 1
//5 0
//-7 -3 -2 5 8
//예제 출력 1
//1

// 크기가양수
// 적어도 1개는 골라야함함

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val s = st.nextToken().toInt()
    val arr = IntArray(n)
    st = StringTokenizer(readLine())
    repeat(n) { i1 ->
        arr[i1] = st.nextToken().toInt()
    }

    var cnt = 0

    fun solve(idx: Int, sum: Int) {
        if (idx == n) {
            if (sum == s) cnt++
            return
        }
        solve(idx + 1, sum + arr[idx])
        solve(idx + 1, sum)
    }

    solve(0, 0)

    print(if (s == 0) cnt - 1 else cnt)
}

