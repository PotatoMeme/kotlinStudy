package com.potatomeme.programmers.codingtest.years23.april.level1

import java.util.PriorityQueue


//노이의 탑
//문제 설명
//하노이 탑(Tower of Hanoi)은 퍼즐의 일종입니다. 세 개의 기둥과 이 기동에 꽂을 수 있는 크기가 다양한 원판들이 있고, 퍼즐을 시작하기 전에는 한 기둥에 원판들이 작은 것이 위에 있도록 순서대로 쌓여 있습니다. 게임의 목적은 다음 두 가지 조건을 만족시키면서, 한 기둥에 꽂힌 원판들을 그 순서 그대로 다른 기둥으로 옮겨서 다시 쌓는 것입니다.
//
//한 번에 하나의 원판만 옮길 수 있습니다.
//큰 원판이 작은 원판 위에 있어서는 안됩니다.
//하노이 탑의 세 개의 기둥을 왼쪽 부터 1번, 2번, 3번이라고 하겠습니다. 1번에는 n개의 원판이 있고 이 n개의 원판을 3번 원판으로 최소 횟수로 옮기려고 합니다.
//
//1번 기둥에 있는 원판의 개수 n이 매개변수로 주어질 때, n개의 원판을 3번 원판으로 최소로 옮기는 방법을 return하는 solution를 완성해주세요.
//
//제한사항
//n은 15이하의 자연수 입니다.
//입출력 예
//n	result
//2	[ [1,2], [1,3], [2,3] ]
//입출력 예 설명
//입출력 예 #1
//다음과 같이 옮길 수 있습니다.
//
//Imgur
//Imgur
//Imgur
//Imgur

class Solution12946() {
    //1안
    fun solution1(n: Int): Array<IntArray> {
        return hanoi1(n, 1, 2, 3)
    }

    private fun hanoi1(depth: Int, base: Int, sub: Int, main: Int): Array<IntArray> =
        if (depth == 1) {
            arrayOf(intArrayOf(base, main))
        } else {
            hanoi1(depth - 1, base, main, sub) + arrayOf(intArrayOf(base, main)) + hanoi1(depth - 1, sub, base, main)
        }

    //2안
    private val ans = mutableListOf<IntArray>()

    fun solution2(n: Int): MutableList<IntArray> {
        hanoi2(n, 1, 2, 3)
        return ans
    }

    private fun hanoi2(depth: Int, base: Int, sub: Int, main: Int) {
        if (depth == 1) {
            ans.add(intArrayOf(base, main))
        } else {
            hanoi2(depth - 1, base, main, sub)
            ans.add(intArrayOf(base, main))
            hanoi2(depth - 1, sub, base, main)
        }
    }
}
