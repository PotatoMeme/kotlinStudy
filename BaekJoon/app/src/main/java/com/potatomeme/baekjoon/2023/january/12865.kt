package com.potatomeme.baekjoon.`2023`.january

import kotlin.math.max

//https://www.acmicpc.net/problem/12865

//평범한 배낭
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	512 MB	85308	31454	20410	35.292%
//문제
//이 문제는 아주 평범한 배낭에 관한 문제이다.
//
//한 달 후면 국가의 부름을 받게 되는 준서는 여행을 가려고 한다. 세상과의 단절을 슬퍼하며 최대한 즐기기 위한 여행이기 때문에, 가지고 다닐 배낭 또한 최대한 가치 있게 싸려고 한다.
//
//준서가 여행에 필요하다고 생각하는 N개의 물건이 있다. 각 물건은 무게 W와 가치 V를 가지는데, 해당 물건을 배낭에 넣어서 가면 준서가 V만큼 즐길 수 있다. 아직 행군을 해본 적이 없는 준서는 최대 K만큼의 무게만을 넣을 수 있는 배낭만 들고 다닐 수 있다. 준서가 최대한 즐거운 여행을 하기 위해 배낭에 넣을 수 있는 물건들의 가치의 최댓값을 알려주자.
//
//입력
//첫 줄에 물품의 수 N(1 ≤ N ≤ 100)과 준서가 버틸 수 있는 무게 K(1 ≤ K ≤ 100,000)가 주어진다. 두 번째 줄부터 N개의 줄에 거쳐 각 물건의 무게 W(1 ≤ W ≤ 100,000)와 해당 물건의 가치 V(0 ≤ V ≤ 1,000)가 주어진다.
//
//입력으로 주어지는 모든 수는 정수이다.
//
//출력
//한 줄에 배낭에 넣을 수 있는 물건들의 가치합의 최댓값을 출력한다.
//
//예제 입력 1
//4 7
//6 13
//4 8
//3 6
//5 12
//예제 출력 1
//14

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { Pair(0, 0) }
    repeat(n) { i ->
        val (w, v) = readLine().split(" ").map { it.toInt() }
        arr[i] = Pair(w, v)
    }
    //val solution = Solution12865_try1(n, k, arr)
    //val solution = Solution12865_try2(n, k, arr)
    //val solution = Solution12865_try3(n, k, arr)
    val solution = Solution12865_try4(n, k, arr)
    print(solution.max)
}

//try1 use DFS
class Solution12865_try1(val n: Int, private val k: Int, private val arr: Array<Pair<Int, Int>>) {
    val visited: BooleanArray = BooleanArray(n)
    var max = Int.MIN_VALUE

    init {
        dfs(0, 0)
    }

    fun dfs(totalWeight: Int, totalValue: Int) {
        for (i in 0 until n) {
            if (!visited[i]) {
                val save = totalWeight + arr[i].first
                if (save > k) {
                    if (max < totalValue) max = totalValue
                } else {
                    visited[i] = true
                    dfs(save, totalValue + arr[i].second)
                    visited[i] = false
                }
            }
        }
    }//시간 초과
}

//try2 use Dynamic Programming,Top-Down
class Solution12865_try2(val n: Int, private val k: Int, private val arr: Array<Pair<Int, Int>>) {
    private val valueArr = Array(n) { IntArray(k + 1) { -1 } }
    var max: Int

    init {
        max = knapsack(n - 1, k)
    }

    private fun knapsack(index: Int, kg: Int): Int {
        if (index < 0) return 0
        if (valueArr[index][kg] < 0) {
            if (arr[index].first > kg) {
                valueArr[index][kg] = knapsack(index - 1, kg)
            } else {
                valueArr[index][kg] =
                    max(
                        knapsack(index - 1, kg),
                        knapsack(index - 1, kg - arr[index].first) + arr[index].second
                    )
            }
        }
        return valueArr[index][kg]
    }
}

//try3 use Dynamic Programming,Bottom-Up
class Solution12865_try3(val n: Int, private val k: Int, private val arr: Array<Pair<Int, Int>>) {
    private val valueArr = Array(n + 1) { IntArray(k + 1) { 0 } }
    val max: Int
        get() = valueArr[n][k]

    init {
        knapsack()
    }

    private fun knapsack() {
        for (i in 1..n) {
            for (j in 1..k) {
                valueArr[i][j] = if (arr[i - 1].first > j) {
                    valueArr[i - 1][j]
                } else {
                    max(
                        valueArr[i - 1][j],
                        valueArr[i - 1][j - arr[i - 1].first] + arr[i - 1].second
                    )
                }
            }
        }
    }
}

//try4 use Dynamic Programming,Bottom-Up
class Solution12865_try4(val n: Int, private val k: Int, private val arr: Array<Pair<Int, Int>>) {
    private val valueArr = IntArray(k + 1) { 0 }
    val max: Int
        get() = valueArr[k]

    init {
        knapsack()
    }

    private fun knapsack() {
        for (i in 1..n) {
            for (j in k downTo arr[i-1].first) {
                valueArr[j] = max(
                    valueArr[j],
                    valueArr[j - arr[i - 1].first] + arr[i - 1].second
                )
            }
        }
    }
}