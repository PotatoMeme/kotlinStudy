package com.potatomeme.programmers.codingtest.years23.may.level2

import kotlin.math.pow


//마법의 엘리베이터
//문제 설명
//마법의 세계에 사는 민수는 아주 높은 탑에 살고 있습니다. 탑이 너무 높아서 걸어 다니기 힘든 민수는 마법의 엘리베이터를 만들었습니다. 마법의 엘리베이터의 버튼은 특별합니다. 마법의 엘리베이터에는 -1, +1, -10, +10, -100, +100 등과 같이 절댓값이 10c (c ≥ 0 인 정수) 형태인 정수들이 적힌 버튼이 있습니다. 마법의 엘리베이터의 버튼을 누르면 현재 층 수에 버튼에 적혀 있는 값을 더한 층으로 이동하게 됩니다. 단, 엘리베이터가 위치해 있는 층과 버튼의 값을 더한 결과가 0보다 작으면 엘리베이터는 움직이지 않습니다. 민수의 세계에서는 0층이 가장 아래층이며 엘리베이터는 현재 민수가 있는 층에 있습니다.
//
//마법의 엘리베이터를 움직이기 위해서 버튼 한 번당 마법의 돌 한 개를 사용하게 됩니다.예를 들어, 16층에 있는 민수가 0층으로 가려면 -1이 적힌 버튼을 6번, -10이 적힌 버튼을 1번 눌러 마법의 돌 7개를 소모하여 0층으로 갈 수 있습니다. 하지만, +1이 적힌 버튼을 4번, -10이 적힌 버튼 2번을 누르면 마법의 돌 6개를 소모하여 0층으로 갈 수 있습니다.
//
//마법의 돌을 아끼기 위해 민수는 항상 최소한의 버튼을 눌러서 이동하려고 합니다. 민수가 어떤 층에서 엘리베이터를 타고 0층으로 내려가는데 필요한 마법의 돌의 최소 개수를 알고 싶습니다. 민수와 마법의 엘리베이터가 있는 층을 나타내는 정수 storey 가 주어졌을 때, 0층으로 가기 위해 필요한 마법의 돌의 최소값을 return 하도록 solution 함수를 완성하세요.
//
//제한사항
//1 ≤ storey ≤ 100,000,000
//입출력 예
//storey	result
//16	6
//2554	16
//입출력 예 설명
//입출력 예 #1
//
//문제 예시와 같습니다.
//입출력 예 #2
//
//-1, +100이 적힌 버튼을 4번, +10이 적힌 버튼을 5번, -1000이 적힌 버튼을 3번 누르면 0층에 도착 할 수 있습니다. 그러므로 16을 return 합니다.

class Solution148653 {
    fun solution(storey: Int): Int {
        val storeyArr = "0$storey".map { it - '0' }
        val maxDepth = storeyArr.size

        var min: Int = Int.MAX_VALUE
        fun dfs(depth: Int, total: Int, cnt: Int, now: Int) {
            if (depth == maxDepth) {
                if (total == storey && cnt < min) min = cnt
                return
            }
            if (total <= storey) {
                val n1 = storeyArr[depth] // 0 ~ 9
                dfs(depth + 1, total + n1 * now, cnt + n1, now / 10)
                val n2 = storeyArr[depth] + 1 // 1 ~ 10
                if (n2 < 10) dfs(depth + 1, total + n2 * now, cnt + n2, now / 10)
            } else {
                val n1 = 10 - storeyArr[depth] // 1 ~ 10
                if (n1 < 10) dfs(depth + 1, total - n1 * now, cnt + n1, now / 10)
                val n2 = 10 - (storeyArr[depth] + 1) // 0 ~ 9
                dfs(depth + 1, total - n2 * now, cnt + n2, now / 10)
            }
        }
        dfs(0, 0, 0, 10.0.pow(maxDepth.toDouble() - 1.0).toInt())

        return min
    }// dfs로 풀기 풀리긴 하지만 수학으로 접근하면 더빨리 풀릴듯

    fun solution2(storey: Int) = solve(0, storey)
    fun solve(cnt: Int, before: Int): Int {
        if (before == 0) return cnt
        val ext = before % 10
        var after = before / 10
        return solve(cnt + if (ext == 5) {
            if (after % 10 >= 5) {
                after++
                10 - ext
            } else {
                ext
            }
        } else if (ext > 5) {
            after++
            10 - ext
        } else {
            ext
        }, after)
    }
}