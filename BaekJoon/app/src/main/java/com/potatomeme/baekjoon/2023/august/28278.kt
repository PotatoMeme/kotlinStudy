package com.potatomeme.baekjoon.`2023`.august

import java.lang.StringBuilder
import java.util.Stack

//https://www.acmicpc.net/problem/28278

//스택 2
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	1024 MB	4569	1941	1630	43.455%
//문제
//정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
//
//명령은 총 다섯 가지이다.
//
//1 X: 정수 X를 스택에 넣는다. (1 ≤ X ≤ 100,000)
//2: 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
//3: 스택에 들어있는 정수의 개수를 출력한다.
//4: 스택이 비어있으면 1, 아니면 0을 출력한다.
//5: 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다.
//입력
//첫째 줄에 명령의 수 N이 주어진다. (1 ≤ N ≤ 1,000,000)
//
//둘째 줄부터 N개 줄에 명령이 하나씩 주어진다.
//
//출력을 요구하는 명령은 하나 이상 주어진다.
//
//출력
//출력을 요구하는 명령이 주어질 때마다 명령의 결과를 한 줄에 하나씩 출력한다.
//
//예제 입력 1
//9
//4
//1 3
//1 5
//3
//2
//5
//2
//2
//5
//예제 출력 1
//1
//2
//5
//3
//3
//-1
//-1
//출처
//문제를 만든 사람: kiwiyou
//문제를 검수한 사람: sorohue, ufshg, wapas, wider93, yup0927
//알고리즘 분류
//자료 구조
//스택

fun main() = with(System.`in`.bufferedReader()) {
    val num = readLine().toInt()
    val stack = Stack<Int>()
    val result = StringBuilder()
    repeat(num) {
        val line = readLine()
        when (line[0]) {
            '1' -> {
                val x = line.split(" ")[1].toInt()
                stack.add(x)
            }

            '2' -> {
                if (stack.isEmpty()) result.appendLine(-1)
                else result.appendLine(stack.pop())
            }

            '3' -> {
                result.appendLine(stack.size)
            }

            '4' -> {
                if (stack.isEmpty()) result.appendLine(1)
                else result.appendLine(0)
            }

            '5' -> {
                if (stack.isEmpty()) result.appendLine(-1)
                else result.appendLine(stack.peek())
            }
        }
    }
    print(result.toString())
}