package com.potatomeme.baekjoon.`2023`.june

import android.os.Build
import androidx.annotation.RequiresApi
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Collections
import java.util.PriorityQueue
import java.util.Stack

//https://www.acmicpc.net/problem/1655

//가운데를 말해요
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//0.1 초 (하단 참고)	128 MB	53063	15476	11602	30.312%
//문제
//백준이는 동생에게 "가운데를 말해요" 게임을 가르쳐주고 있다. 백준이가 정수를 하나씩 외칠때마다 동생은 지금까지 백준이가 말한 수 중에서 중간값을 말해야 한다. 만약, 그동안 백준이가 외친 수의 개수가 짝수개라면 중간에 있는 두 수 중에서 작은 수를 말해야 한다.
//
//예를 들어 백준이가 동생에게 1, 5, 2, 10, -99, 7, 5를 순서대로 외쳤다고 하면, 동생은 1, 1, 2, 2, 2, 2, 5를 차례대로 말해야 한다. 백준이가 외치는 수가 주어졌을 때, 동생이 말해야 하는 수를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에는 백준이가 외치는 정수의 개수 N이 주어진다. N은 1보다 크거나 같고, 100,000보다 작거나 같은 자연수이다. 그 다음 N줄에 걸쳐서 백준이가 외치는 정수가 차례대로 주어진다. 정수는 -10,000보다 크거나 같고, 10,000보다 작거나 같다.
//
//출력
//한 줄에 하나씩 N줄에 걸쳐 백준이의 동생이 말해야 하는 수를 순서대로 출력한다.
//
//예제 입력 1
//7
//1
//5
//2
//10
//-99
//7
//5
//예제 출력 1
//1
//1
//2
//2
//2
//2
//5


@RequiresApi(Build.VERSION_CODES.N)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val maxHeap = PriorityQueue<Int>(Collections.reverseOrder())
    val minHeap = PriorityQueue<Int>()

    print(buildString {
        repeat(readLine().toInt()) {
            val cur = readLine().toInt()
            if (maxHeap.size == minHeap.size) {
                maxHeap.offer(cur)
            } else {
                minHeap.offer(cur)
            }
            if (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
                if (minHeap.peek() < maxHeap.peek()) {
                    val tmp = minHeap.poll()
                    minHeap.offer(maxHeap.poll())
                    maxHeap.offer(tmp)
                }
            }
            appendLine(maxHeap.peek())
        }
    })
    // time Out
    /*print(buildString {
        repeat(readLine().toInt()) {
            input(readLine().toInt())
            appendLine(getMiddle())
        }
    })*/
}

val firstStack: Stack<Int> = Stack()
val secondStack: Stack<Int> = Stack()

fun checkFirstStack(num: Int) {
    if (firstStack.isEmpty()) {
        firstStack.add(num)
        return
    }
    val div = firstStack.peek()
    if (num <= div) {
        firstStack.add(num)
    } else {
        secondStack.add(firstStack.pop())
        checkFirstStack(num)
    }
}

fun checkSecondStack(num: Int) {
    if (secondStack.isEmpty()) {
        secondStack.add(num)
        return
    }
    val div = secondStack.peek()
    if (num >= div) {
        secondStack.add(num)
    } else {
        firstStack.add(secondStack.pop())
        checkSecondStack(num)
    }
}

fun input(num: Int) {
    if (firstStack.isEmpty() && secondStack.isEmpty()) {
        firstStack.add(num)
    } else if (firstStack.isEmpty()) {
        checkSecondStack(num)
    } else if (secondStack.isEmpty()) {
        checkFirstStack(num)
    } else {
        val div1 = firstStack.peek()
        val div2 = secondStack.peek()
        if (num > div1) {
            checkFirstStack(num)
        } else if (num < div2) {
            checkSecondStack(num)
        } else {
            firstStack.add(num)
        }
    }
}

fun getMiddle(): Int {
    val totalSize = firstStack.size + secondStack.size
    val middleIdx = totalSize / 2 + 1
    if (firstStack.size > middleIdx) {
        repeat(firstStack.size - middleIdx) {
            secondStack.add(firstStack.pop())
        }
    } else {
        repeat(middleIdx - firstStack.size) {
            firstStack.add(secondStack.pop())
        }
    }
    return firstStack.peek()
}