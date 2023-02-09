package com.potatomeme.baekjoon.`2023`.february

import java.util.StringTokenizer
import kotlin.math.max

//https://www.acmicpc.net/problem/2565

//전깃줄
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	128 MB	29143	13707	11025	46.764%
//문제
//두 전봇대 A와 B 사이에 하나 둘씩 전깃줄을 추가하다 보니 전깃줄이 서로 교차하는 경우가 발생하였다. 합선의 위험이 있어 이들 중 몇 개의 전깃줄을 없애 전깃줄이 교차하지 않도록 만들려고 한다.
//
//예를 들어, < 그림 1 >과 같이 전깃줄이 연결되어 있는 경우 A의 1번 위치와 B의 8번 위치를 잇는 전깃줄, A의 3번 위치와 B의 9번 위치를 잇는 전깃줄, A의 4번 위치와 B의 1번 위치를 잇는 전깃줄을 없애면 남아있는 모든 전깃줄이 서로 교차하지 않게 된다.
//
//
//
//< 그림 1 >
//
//전깃줄이 전봇대에 연결되는 위치는 전봇대 위에서부터 차례대로 번호가 매겨진다. 전깃줄의 개수와 전깃줄들이 두 전봇대에 연결되는 위치의 번호가 주어질 때, 남아있는 모든 전깃줄이 서로 교차하지 않게 하기 위해 없애야 하는 전깃줄의 최소 개수를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에는 두 전봇대 사이의 전깃줄의 개수가 주어진다. 전깃줄의 개수는 100 이하의 자연수이다. 둘째 줄부터 한 줄에 하나씩 전깃줄이 A전봇대와 연결되는 위치의 번호와 B전봇대와 연결되는 위치의 번호가 차례로 주어진다. 위치의 번호는 500 이하의 자연수이고, 같은 위치에 두 개 이상의 전깃줄이 연결될 수 없다.
//
//출력
//첫째 줄에 남아있는 모든 전깃줄이 서로 교차하지 않게 하기 위해 없애야 하는 전깃줄의 최소 개수를 출력한다.
//
//예제 입력 1
//8
//1 8
//3 9
//2 2
//4 1
//6 4
//10 10
//9 7
//7 6
//예제 출력 1
//3


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = IntArray(501) { 0 }
    repeat(n) {
        val st = StringTokenizer(readLine())
        arr[st.nextToken().toInt()] = st.nextToken().toInt()
    }
    print(Solution2565(n, arr).result)
}

// 겹치는 개수를 카운트
// 가장 높은 카우트를 가지고 있는것을 없앰(같은경우 재일 위에 있는 것을 삭제)
//Try1
class Solution2565Try1(val arr: IntArray) {
    var count = 0

    init {
        countAll()
    }

    fun countAll() {
        val dp = IntArray(501) { 0 }
        for (i in 2..500) {
            if (arr[i] == 0) continue
            for (j in 1 until i) {
                if (arr[j] == 0) continue
                if (arr[i] < arr[j]) {
                    dp[i]++
                    dp[j]++
                }
            }
        }
        var max = 0
        var max_index = 0
        for (i in 1..500) {
            if (max < dp[i]) {
                max = dp[i]
                max_index = i
            }
        }
        if (max == 0) return
        count++
        arr[max_index] = 0
        countAll()
    }
}

//Try2
class Solution2565Try2(val arr: IntArray) {
    var countMin = Int.MAX_VALUE
    var dp = IntArray(501) { 0 }

    init {
        solve(0)
    }

    fun solve(depth: Int) {
        countCross()
        if (!dp.any { it > 0 }) {
            countMin = countMin.coerceAtMost(depth)
            return
        }
        for (i in 1..500) {
            if (dp[i] == 0) continue
            val temp = arr[i]
            val _dp = dp.clone()
            arr[i] = 0
            solve(depth + 1)
            dp = _dp
            arr[i] = temp
        }
    }

    fun countCross() {
        dp = IntArray(501) { 0 }
        for (i in 2..500) {
            if (arr[i] == 0) continue
            for (j in 1 until i) {
                if (arr[j] == 0) continue
                if (arr[i] < arr[j]) {
                    dp[i]++
                    dp[j]++
                }
            }
        }
    }
}//메모리 초과

//Try3 use lis
class Solution2565(n: Int, arr: IntArray) {
    val lis = IntArray(100) { -1 }
    val result: Int

    init {
        for (i in 1..500) {
            if (arr[i] == 0) continue
            LIS(arr[i])
        }
        result = n - lis.getMax()
    }

    fun LIS(num: Int) {
        lis.forEachIndexed { index, i ->
            if (i == -1) {
                lis[index] = num
                return
            } else if (i == num) {
                return
            } else if (i > num) {
                lis[index] = num
                return
            }
        }
    }

    fun IntArray.getMax(): Int {
        this.forEachIndexed { index, i ->
            if (i == -1) return index
        }
        return 100
    }
}