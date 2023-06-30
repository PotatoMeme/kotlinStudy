package com.potatomeme.baekjoon.`2023`.june

import java.util.StringTokenizer

//https://www.acmicpc.net/problem/14891

//톱니바퀴
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	512 MB	32898	17859	13086	54.586%
//문제
//총 8개의 톱니를 가지고 있는 톱니바퀴 4개가 아래 그림과 같이 일렬로 놓여져 있다. 또, 톱니는 N극 또는 S극 중 하나를 나타내고 있다. 톱니바퀴에는 번호가 매겨져 있는데, 가장 왼쪽 톱니바퀴가 1번, 그 오른쪽은 2번, 그 오른쪽은 3번, 가장 오른쪽 톱니바퀴는 4번이다.
//
//
//
//이때, 톱니바퀴를 총 K번 회전시키려고 한다. 톱니바퀴의 회전은 한 칸을 기준으로 한다. 회전은 시계 방향과 반시계 방향이 있고, 아래 그림과 같이 회전한다.
//
//
//
//
//
//톱니바퀴를 회전시키려면, 회전시킬 톱니바퀴와 회전시킬 방향을 결정해야 한다. 톱니바퀴가 회전할 때, 서로 맞닿은 극에 따라서 옆에 있는 톱니바퀴를 회전시킬 수도 있고, 회전시키지 않을 수도 있다. 톱니바퀴 A를 회전할 때, 그 옆에 있는 톱니바퀴 B와 서로 맞닿은 톱니의 극이 다르다면, B는 A가 회전한 방향과 반대방향으로 회전하게 된다. 예를 들어, 아래와 같은 경우를 살펴보자.
//
//
//
//두 톱니바퀴의 맞닿은 부분은 초록색 점선으로 묶여있는 부분이다. 여기서, 3번 톱니바퀴를 반시계 방향으로 회전했다면, 4번 톱니바퀴는 시계 방향으로 회전하게 된다. 2번 톱니바퀴는 맞닿은 부분이 S극으로 서로 같기 때문에, 회전하지 않게 되고, 1번 톱니바퀴는 2번이 회전하지 않았기 때문에, 회전하지 않게 된다. 따라서, 아래 그림과 같은 모양을 만들게 된다.
//
//
//
//위와 같은 상태에서 1번 톱니바퀴를 시계 방향으로 회전시키면, 2번 톱니바퀴가 반시계 방향으로 회전하게 되고, 2번이 회전하기 때문에, 3번도 동시에 시계 방향으로 회전하게 된다. 4번은 3번이 회전하지만, 맞닿은 극이 같기 때문에 회전하지 않는다. 따라서, 아래와 같은 상태가 된다.
//
//
//
//톱니바퀴의 초기 상태와 톱니바퀴를 회전시킨 방법이 주어졌을 때, 최종 톱니바퀴의 상태를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 1번 톱니바퀴의 상태, 둘째 줄에 2번 톱니바퀴의 상태, 셋째 줄에 3번 톱니바퀴의 상태, 넷째 줄에 4번 톱니바퀴의 상태가 주어진다. 상태는 8개의 정수로 이루어져 있고, 12시방향부터 시계방향 순서대로 주어진다. N극은 0, S극은 1로 나타나있다.
//
//다섯째 줄에는 회전 횟수 K(1 ≤ K ≤ 100)가 주어진다. 다음 K개 줄에는 회전시킨 방법이 순서대로 주어진다. 각 방법은 두 개의 정수로 이루어져 있고, 첫 번째 정수는 회전시킨 톱니바퀴의 번호, 두 번째 정수는 방향이다. 방향이 1인 경우는 시계 방향이고, -1인 경우는 반시계 방향이다.
//
//출력
//총 K번 회전시킨 이후에 네 톱니바퀴의 점수의 합을 출력한다. 점수란 다음과 같이 계산한다.
//
//1번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 1점
//2번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 2점
//3번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 4점
//4번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 8점


fun main() = with(System.`in`.bufferedReader()) {
    val arr = Array(4) {
        val line = readLine()
        BooleanArray(8) { idx -> line[idx] == '1' }
    }
    val orderCount = readLine().toInt()
    val orders = Array(orderCount) {
        val st = StringTokenizer(readLine())
        Pair(st.nextToken().toInt(), st.nextToken()[0] == '1')
    }
    print(Solution14891(arr, orders).getResult())
    return@with
}

class Solution14891(val arr: Array<BooleanArray>, orders: Array<Pair<Int, Boolean>>) {
    private val gearStatus = IntArray(4) //각 gear의 12시의 idx

    init {
        for (order in orders) {
            play(order)
        }
    }

    fun getResult(): Int {
        return (if (arr[0][gearStatus[0]]) 1 else 0) + (if (arr[1][gearStatus[1]]) 2 else 0) + (if (arr[2][gearStatus[2]]) 4 else 0) + (if (arr[3][gearStatus[3]]) 8 else 0)
    }

    private fun play(order: Pair<Int, Boolean>) {
        val gearIdx = order.first - 1
        val spin = order.second
        if (gearIdx != 3 && getGearRight(gearIdx) != getGearLeft(gearIdx + 1)) toSpinRight(gearIdx + 1, spin)
        if (gearIdx != 0 && getGearLeft(gearIdx) != getGearRight(gearIdx - 1)) toSpinLeft(gearIdx - 1, spin)
        if (spin) spinRight(gearIdx) else spinLeft(gearIdx)
    }

    //왼쪽에서 회전을 받음
    private fun toSpinLeft(gearIdx: Int, spin: Boolean) {
        if (gearIdx != 0 && getGearLeft(gearIdx) != getGearRight(gearIdx - 1)) toSpinLeft(gearIdx -1,!spin)
        if (!spin) spinRight(gearIdx) else spinLeft(gearIdx)
    }

    //오른쪽에서 회전을 받음
    private fun toSpinRight(gearIdx: Int, spin: Boolean) {
        if (gearIdx != 3 && getGearRight(gearIdx) != getGearLeft(gearIdx + 1)) toSpinRight(gearIdx + 1,!spin)
        if (!spin) spinRight(gearIdx) else spinLeft(gearIdx)

    }

    //해당기어를 오른쪽(시계방향)으로 회전
    private fun spinRight(idx: Int) {
        gearStatus[idx] = if (gearStatus[idx] == 0) 7 else gearStatus[idx] - 1
    }

    //해당기어를 왼쪽(반 시계방향)으로 회전
    private fun spinLeft(idx: Int) {
        gearStatus[idx] = if (gearStatus[idx] == 7) 0 else gearStatus[idx] + 1
    }


    private fun getGearLeft(idx: Int): Boolean {
        return arr[idx][(gearStatus[idx] + 6) % 8]
    }

    private fun getGearRight(idx: Int): Boolean {
        return arr[idx][(gearStatus[idx] + 2) % 8]
    }
}