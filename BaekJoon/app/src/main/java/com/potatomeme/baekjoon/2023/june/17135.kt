package com.potatomeme.baekjoon.`2023`.june

import java.lang.Integer.max
import java.lang.Integer.min
import java.lang.Math.abs
import java.util.StringTokenizer

//https://www.acmicpc.net/problem/17135

//캐슬 디펜스
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	512 MB	29023	10689	6445	32.429%
//문제
//캐슬 디펜스는 성을 향해 몰려오는 적을 잡는 턴 방식의 게임이다. 게임이 진행되는 곳은 크기가 N×M인 격자판으로 나타낼 수 있다. 격자판은 1×1 크기의 칸으로 나누어져 있고, 각 칸에 포함된 적의 수는 최대 하나이다. 격자판의 N번행의 바로 아래(N+1번 행)의 모든 칸에는 성이 있다.
//
//성을 적에게서 지키기 위해 궁수 3명을 배치하려고 한다. 궁수는 성이 있는 칸에 배치할 수 있고, 하나의 칸에는 최대 1명의 궁수만 있을 수 있다. 각각의 턴마다 궁수는 적 하나를 공격할 수 있고, 모든 궁수는 동시에 공격한다. 궁수가 공격하는 적은 거리가 D이하인 적 중에서 가장 가까운 적이고, 그러한 적이 여럿일 경우에는 가장 왼쪽에 있는 적을 공격한다. 같은 적이 여러 궁수에게 공격당할 수 있다. 공격받은 적은 게임에서 제외된다. 궁수의 공격이 끝나면, 적이 이동한다. 적은 아래로 한 칸 이동하며, 성이 있는 칸으로 이동한 경우에는 게임에서 제외된다. 모든 적이 격자판에서 제외되면 게임이 끝난다.
//
//게임 설명에서 보다시피 궁수를 배치한 이후의 게임 진행은 정해져있다. 따라서, 이 게임은 궁수의 위치가 중요하다. 격자판의 상태가 주어졌을 때, 궁수의 공격으로 제거할 수 있는 적의 최대 수를 계산해보자.
//
//격자판의 두 위치 (r1, c1), (r2, c2)의 거리는 |r1-r2| + |c1-c2|이다.
//
//입력
//첫째 줄에 격자판 행의 수 N, 열의 수 M, 궁수의 공격 거리 제한 D가 주어진다. 둘째 줄부터 N개의 줄에는 격자판의 상태가 주어진다. 0은 빈 칸, 1은 적이 있는 칸이다.
//
//출력
//첫째 줄에 궁수의 공격으로 제거할 수 있는 적의 최대 수를 출력한다.
//
//제한
//3 ≤ N, M ≤ 15
//1 ≤ D ≤ 10
//예제 입력 1
//5 5 1
//0 0 0 0 0
//0 0 0 0 0
//0 0 0 0 0
//0 0 0 0 0
//1 1 1 1 1
//예제 출력 1
//3
//예제 입력 2
//5 5 1
//0 0 0 0 0
//0 0 0 0 0
//0 0 0 0 0
//1 1 1 1 1
//0 0 0 0 0
//예제 출력 2
//3
//예제 입력 3
//5 5 2
//0 0 0 0 0
//0 0 0 0 0
//0 0 0 0 0
//1 1 1 1 1
//0 0 0 0 0
//예제 출력 3
//5
//예제 입력 4
//5 5 5
//1 1 1 1 1
//1 1 1 1 1
//1 1 1 1 1
//1 1 1 1 1
//1 1 1 1 1
//예제 출력 4
//15
//예제 입력 5
//6 5 1
//1 0 1 0 1
//0 1 0 1 0
//1 1 0 0 0
//0 0 0 1 1
//1 1 0 1 1
//0 0 1 0 0
//예제 출력 5
//9
//예제 입력 6
//6 5 2
//1 0 1 0 1
//0 1 0 1 0
//1 1 0 0 0
//0 0 0 1 1
//1 1 0 1 1
//0 0 1 0 0
//예제 출력 6
//14


fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, d) = readLine().split(" ").map { it.toInt() }
    val pos = Array(n + 1) { BooleanArray(m) }
    var maxEnemyDistance = n
    var enemyDitact = false
    repeat(n) { i1 ->
        val st = StringTokenizer(readLine())
        repeat(m) { i2 ->
            if (st.nextToken()[0] == '1') {
                if (!enemyDitact) {
                    enemyDitact = true
                    maxEnemyDistance = n - i1
                }
                pos[i1][i2] = true
            }
        }
    }
    print(Solution17135(n, m, d, pos, maxEnemyDistance).max)
}

class Solution17135(
    private  val n: Int,
    private  val m: Int,
    private  val d: Int,
    private val pos: Array<BooleanArray>,
    private val maxEnemyDistance: Int,
) {
    var max = Int.MIN_VALUE

    private var currentCount: Int = 0
    private var currnetPos: List<BooleanArray> = List(1) { BooleanArray(1) }

    init {
        step1(0, 0)
    }

    /** 3개의 좌표 (궁수위치 정하기) 정하기 */
    private fun step1(beforeIdx: Int, depth: Int) {
        if (depth == 3) {
            currentCount = 0
            currnetPos = pos.map { it.clone() }
            solve()
            return
        }
        for (i in beforeIdx until m) {
            pos[n][i] = true
            step1(i + 1, depth + 1)
            pos[n][i] = false
        }
    }

    /** step2 ~ 3까지 maxEnemyDistance번 반복 */
    private fun solve() {
        repeat(maxEnemyDistance) {
            step2(0)
            step3()
        }
        if (currentCount > max) max = currentCount
    }


    /** 궁수의 사격 */
    private fun step2(idx: Int) {
        if (idx == m) return
        if (currnetPos[n][idx]) {
            var x = 0
            var y = 0
            var min = d + 1
            for (i in max(idx - d + 1, 0) until min(idx + d, m)) {
                for (j in max(n - (d - abs(idx - i)), 0) until n) {
                    if (currnetPos[j][i]) {
                        val currentDistance = abs(idx - i) + n - j
                        if (currentDistance < min) {
                            min = currentDistance
                            x = i
                            y = j
                        }
                    }
                }
            }
            step2(idx + 1)
            if (min != d + 1 && currnetPos[y][x]) {
                currnetPos[y][x] = false
                currentCount++
            }
        } else {
            step2(idx + 1)
        }
    }

    /** 적들의 이동 */
    private fun step3() {
        for (i in 0 until m) {
            if (currnetPos[n - 1][i] && currnetPos[n][i]) {
                currnetPos[n][i] = false
            }
            currnetPos[n - 1][i] = false
        }
        for (i in n - 2 downTo 0) {
            for (j in 0 until m) {
                currnetPos[i + 1][j] = currnetPos[i][j]
                currnetPos[i][j] = false
            }
        }
    }
}