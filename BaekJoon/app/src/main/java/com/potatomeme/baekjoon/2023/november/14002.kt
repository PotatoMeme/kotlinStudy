package com.potatomeme.baekjoon.`2023`.november

import java.util.StringTokenizer

//가장 긴 증가하는 부분 수열 4 스페셜 저지
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	256 MB	38149	15071	11424	39.263%
//문제
//수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.
//
//예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.
//
//입력
//첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.
//
//둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)
//
//출력
//첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.
//
//둘째 줄에는 가장 긴 증가하는 부분 수열을 출력한다. 그러한 수열이 여러가지인 경우 아무거나 출력한다.
//
//예제 입력 1
//6
//10 20 10 30 20 50
//예제 출력 1
//4
//10 20 30 50

fun main() {
    with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val st = StringTokenizer(readLine())
        val arr = IntArray(n) {
            st.nextToken().toInt()
        }
        val indexArray = IntArray(n) { -1 }
        val maxArray = IntArray(n)

        var index = 0
        var max = 0

        for (i in 1 until n) {
            for (j in i - 1 downTo 0) {
                if (arr[i] > arr[j] && ((maxArray[i] == 0 || maxArray[i] < maxArray[j] + 1) || (maxArray[i] == maxArray[j] + 1 && arr[indexArray[i]] >= arr[j]))) {
                    indexArray[i] = j
                    maxArray[i] = maxArray[j] + 1
                } else if (arr[i] == arr[j]) {
                    if (maxArray[i] <= maxArray[j]) {
                        indexArray[i] = indexArray[j]
                        maxArray[i] = maxArray[j]
                    }
                    break
                }
            }
            if (maxArray[i] > max) {
                max = maxArray[i]
                index = i
            }
        }
        val sb = StringBuilder()
        fun getLine(idx: Int) {
            if (idx == -1) {
                return
            }
            getLine(indexArray[idx])
            sb.append(arr[idx]).append(" ")
        }
        getLine(index)
        print("${max + 1}\n$sb")
    }
}