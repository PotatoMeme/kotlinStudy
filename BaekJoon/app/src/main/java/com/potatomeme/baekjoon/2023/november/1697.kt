package com.potatomeme.baekjoon.`2023`.november

import java.util.LinkedList
import java.util.Queue

//숨바꼭질 다국어
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	128 MB	226290	65895	41647	25.568%
//문제
//수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
//
//수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
//
//입력
//첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.
//
//출력
//수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
//
//예제 입력 1
//5 17
//예제 출력 1
//4

fun main() {
    with(System.`in`.bufferedReader()) {
        val (n, k) = readLine().split(" ").map { it.toInt() }
        val bfsQueue: Queue<Int> = LinkedList()
        bfsQueue.add(n)
        val depthArr = IntArray(100_001)
        depthArr[n] = 0
        val checked = BooleanArray(100_001)

        while (bfsQueue.isNotEmpty()) {
            val currentValue = bfsQueue.poll()!!
            if (currentValue == k) {
                print(depthArr[currentValue])
                break
            }

            val nextValue1 = currentValue + 1
            if (nextValue1 < 100_001 && !checked[nextValue1]) {
                checked[nextValue1] = true
                depthArr[nextValue1] = depthArr[currentValue] + 1
                bfsQueue.add(nextValue1)
            }

            val nextValue2 = currentValue * 2
            if (nextValue2 < 100_001 && !checked[nextValue2]) {
                checked[nextValue2] = true
                depthArr[nextValue2] = depthArr[currentValue] + 1
                bfsQueue.add(nextValue2)
            }

            val nextValue3 = currentValue - 1
            if (nextValue3 >= 0 && !checked[nextValue3]) {
                checked[nextValue3] = true
                depthArr[nextValue3] = depthArr[currentValue] + 1
                bfsQueue.add(nextValue3)
            }
        }
    }
}