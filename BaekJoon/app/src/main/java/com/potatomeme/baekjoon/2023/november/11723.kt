package com.potatomeme.baekjoon.`2023`.november

import java.util.StringTokenizer

//집합 언어 제한
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1.5 초	4 MB (하단 참고)	93602	27975	20506	29.217%
//문제
//비어있는 공집합 S가 주어졌을 때, 아래 연산을 수행하는 프로그램을 작성하시오.
//
//add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
//remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
//check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
//toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
//all: S를 {1, 2, ..., 20} 으로 바꾼다.
//empty: S를 공집합으로 바꾼다.
//입력
//첫째 줄에 수행해야 하는 연산의 수 M (1 ≤ M ≤ 3,000,000)이 주어진다.
//
//둘째 줄부터 M개의 줄에 수행해야 하는 연산이 한 줄에 하나씩 주어진다.
//
//출력
//check 연산이 주어질때마다, 결과를 출력한다.
//
//예제 입력 1
//26
//add 1
//add 2
//check 1
//check 2
//check 3
//remove 2
//check 1
//check 2
//toggle 3
//check 1
//check 2
//check 3
//check 4
//all
//check 10
//check 20
//toggle 10
//remove 20
//check 10
//check 20
//empty
//check 1
//toggle 1
//check 1
//toggle 1
//check 1
//예제 출력 1
//1
//1
//0
//1
//0
//1
//0
//1
//0
//1
//1
//0
//0
//0
//1
//0

fun main() {
    with(System.`in`.bufferedReader()) {
        val m = readLine().toInt()

        val arr = BooleanArray(21)
        val sb = StringBuilder()
        repeat(m) {
            val st = StringTokenizer(readLine())
            val function = st.nextToken().toString()
            when (function.length) {
                3 -> {//add, all
                    if (function[2] == 'd') {//add
                        arr[st.nextToken().toInt()] = true
                    } else {//all
                        for (i in arr.indices) arr[i] = true
                    }
                }

                5 -> {//check, empty
                    if (function[0] == 'c') {//check
                        if (arr[st.nextToken().toInt()]) sb.appendLine(1) else sb.appendLine(0)
                    } else {//empty
                        for (i in arr.indices) arr[i] = false
                    }
                }

                6 -> {//remove, toggle
                    if (function[0] == 'r') {//remove
                        arr[st.nextToken().toInt()] = false
                    } else {//toggle
                        val idx = st.nextToken().toInt()
                        arr[idx] = !arr[idx]
                    }
                }
            }
        }
        print(sb.toString())
    }
}