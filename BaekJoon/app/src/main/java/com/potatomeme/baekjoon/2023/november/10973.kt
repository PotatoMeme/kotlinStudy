package com.potatomeme.baekjoon.`2023`.november

import java.util.StringTokenizer
import kotlin.system.exitProcess

//이전 순열
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	256 MB	14302	8109	6744	59.466%
//문제
//1부터 N까지의 수로 이루어진 순열이 있다. 이때, 사전순으로 바로 이전에 오는 순열을 구하는 프로그램을 작성하시오.
//
//사전 순으로 가장 앞서는 순열은 오름차순으로 이루어진 순열이고, 가장 마지막에 오는 순열은 내림차순으로 이루어진 순열이다.
//
//N = 3인 경우에 사전순으로 순열을 나열하면 다음과 같다.
//
//1, 2, 3
//1, 3, 2
//2, 1, 3
//2, 3, 1
//3, 1, 2
//3, 2, 1
//입력
//첫째 줄에 N(1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄에 순열이 주어진다.
//
//출력
//첫째 줄에 입력으로 주어진 순열의 이전에 오는 순열을 출력한다. 만약, 사전순으로 가장 처음에 오는 순열인 경우에는 -1을 출력한다.
//
//예제 입력 1
//4
//1 2 3 4
//예제 출력 1
//-1
//예제 입력 2
//5
//5 4 3 2 1
//예제 출력 2
//5 4 3 1 2


fun main() {
    with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val st = StringTokenizer(readLine())
        val arr = IntArray(n) { st.nextToken().toInt() }
        val checkedArr = BooleanArray(n + 1)
        fun dfsSecond(depth: Int) {
            if (depth == n) {
                print(arr.joinToString(" "))
                exitProcess(0)
            }
            for (i in n downTo 1) {
                if (checkedArr[i]) {
                    checkedArr[i] = false
                    arr[depth] = i
                    dfsSecond(depth + 1)
                    checkedArr[i] = true
                }
            }
        }

        fun dfsFirst(depth: Int) {
            if (depth == n) {
                return
            }
            dfsFirst(depth + 1)
            checkedArr[arr[depth]] = true
            for (i in arr[depth] - 1 downTo 1) {
                if (checkedArr[i]) {
                    checkedArr[i] = false
                    arr[depth] = i
                    dfsSecond(depth + 1)
                    checkedArr[i] = true
                }
            }
        }
        dfsFirst(0)
        print(-1)
    }
}