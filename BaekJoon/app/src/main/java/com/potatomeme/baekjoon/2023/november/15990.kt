package com.potatomeme.baekjoon.`2023`.november

import java.lang.Integer.max

//1, 2, 3 더하기 5
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초 (추가 시간 없음)	512 MB	26593	8985	6298	30.838%
//문제
//정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 3가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다. 단, 같은 수를 두 번 이상 연속해서 사용하면 안 된다.
//
//1+2+1
//1+3
//3+1
//정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 100,000보다 작거나 같다.
//
//출력
//각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 1,000,000,009로 나눈 나머지를 출력한다.
//
//예제 입력 1
//3
//4
//7
//10
//예제 출력 1
//3
//9
//27

fun main() {
    with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        var max = 3
        val wantArray = IntArray(n) {
            val num = readLine().toInt()
            max = max(max, num)
            num
        }
        val checkedArray = Array(3) { IntArray(max + 1) }
        checkedArray[0][1] = 1 // 1
        checkedArray[1][2] = 1 // 2
        checkedArray[0][3] = 1 // 2+1
        checkedArray[1][3] = 1 // 1+2
        checkedArray[2][3] = 1 //3

        for (i in 4..max) {
            checkedArray[0][i] = (checkedArray[1][i - 1] + checkedArray[2][i - 1]) % 1_000_000_009
            checkedArray[1][i] = (checkedArray[0][i - 2] + checkedArray[2][i - 2]) % 1_000_000_009
            checkedArray[2][i] = (checkedArray[0][i - 3] + checkedArray[1][i - 3]) % 1_000_000_009
        }

        print(buildString {
            wantArray.forEach {
                val result =
                    ((checkedArray[0][it] + checkedArray[1][it]) % 1_000_000_009 + checkedArray[2][it]) % 1_000_000_009
                appendLine(result)
            }
        })
    }
}