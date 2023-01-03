package com.potatomeme.baekjoon.`2023`.january

import java.lang.Math.max

//https://www.acmicpc.net/problem/1535

//안녕
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	128 MB	7295	3690	2751	52.610%
//문제
//세준이는 성형수술을 한 후에 병원에 너무 오래 입원해 있었다. 이제 세준이가 병원에 입원한 동안 자기를 생각해준 사람들에게 감사하다고 말할 차례이다.
//
//세준이를 생각해준 사람은 총 N명이 있다. 사람의 번호는 1번부터 N번까지 있다. 세준이가 i번 사람에게 인사를 하면 L[i]만큼의 체력을 잃고, J[i]만큼의 기쁨을 얻는다. 세준이는 각각의 사람에게 최대 1번만 말할 수 있다.
//
//세준이의 목표는 주어진 체력내에서 최대한의 기쁨을 느끼는 것이다. 세준이의 체력은 100이고, 기쁨은 0이다. 만약 세준이의 체력이 0이나 음수가 되면, 죽어서 아무런 기쁨을 못 느낀 것이 된다. 세준이가 얻을 수 있는 최대 기쁨을 출력하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 사람의 수 N(≤ 20)이 들어온다. 둘째 줄에는 각각의 사람에게 인사를 할 때, 잃는 체력이 1번 사람부터 순서대로 들어오고, 셋째 줄에는 각각의 사람에게 인사를 할 때, 얻는 기쁨이 1번 사람부터 순서대로 들어온다. 체력과 기쁨은 100보다 작거나 같은 자연수 또는 0이다.
//
//출력
//첫째 줄에 세준이가 얻을 수 있는 최대 기쁨을 출력한다.
//
//예제 입력 1
//3
//1 21 79
//20 30 25
//예제 출력 1
//50
//예제 입력 2
//1
//100
//20
//예제 출력 2
//0
//예제 입력 3
//8
//100 15 1 2 3 4 6 5
//49 40 1 2 3 4 5 4
//예제 출력 3
//59
//예제 입력 4
//4
//100 50 20 13
//20 30 40 50
//예제 출력 4
//120
//예제 입력 5
//8
//100 26 13 17 24 33 100 99
//34 56 21 1 24 34 100 99
//예제 출력 5
//135
//예제 입력 6
//12
//1 1 1 1 1 1 1 1 1 1 1 1
//100 100 100 100 100 100 100 100 100 100 100 100
//예제 출력 6
//1200
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val num = readLine().toInt()
    val decrease = readLine().split(" ").map { it.toInt() }
    val happy = readLine().split(" ").map { it.toInt() }
    val solution = Solution1535_try3(num, decrease, happy)
    print(solution.max)
}

class Solution1535_try1(val num: Int, val decreaseArr: List<Int>, val happyArr: List<Int>) {
    val valueArr = Array(num) { IntArray(100) { -1 } }
    var max = 0

    init {
        max = visit(index = num - 1, health = 99)
    }

    fun visit(index: Int, health: Int): Int {
        if (index < 0) return 0
        if (valueArr[index][health] < 0) {
            if (decreaseArr[index] > health) {
                valueArr[index][health] = visit(index - 1, health)
            } else {
                valueArr[index][health] = max(
                    visit(index - 1, health),
                    visit(index - 1, health - decreaseArr[index]) + happyArr[index]
                )
            }
        }
        return valueArr[index][health]
    }
}

class Solution1535_try2(val num: Int, val decreaseArr: List<Int>, val happyArr: List<Int>) {
    val valueArr = Array(num + 1) { IntArray(100)  }
    val max
        get() = valueArr[num][99]

    init {
        visit()
    }

    fun visit() {
        for (i in 1..num) {
            for (j in 1..99) {
                valueArr[i][j] = if (decreaseArr[i-1] > j) {
                    valueArr[i - 1][j]
                } else {
                    kotlin.math.max(
                        valueArr[i - 1][j],
                        valueArr[i - 1][j - decreaseArr[i - 1]] + happyArr[i - 1]
                    )
                }
            }
        }
    }
}

class Solution1535_try3(val num: Int, val decreaseArr: List<Int>, val happyArr: List<Int>) {
    val valueArr = IntArray(100)
    val max
        get() = valueArr[99]

    init {
        visit()
    }

    fun visit() {
        for (i in 1..num) {
            for (j in 99 downTo decreaseArr[i-1]) {
                valueArr[j] = kotlin.math.max(
                    valueArr[j],
                    valueArr[j - decreaseArr[i - 1]] + happyArr[i - 1]
                )
            }
        }
    }
}