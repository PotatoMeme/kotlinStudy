package com.potatomeme.baekjoon.`2023`.march

import java.util.StringTokenizer
import kotlin.math.abs


//https://www.acmicpc.net/problem/1072

//두 용액 스페셜 저지
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초 (추가 시간 없음)	128 MB	40743	12604	9100	30.256%
//문제
//KOI 부설 과학연구소에서는 많은 종류의 산성 용액과 알칼리성 용액을 보유하고 있다. 각 용액에는 그 용액의 특성을 나타내는 하나의 정수가 주어져있다. 산성 용액의 특성값은 1부터 1,000,000,000까지의 양의 정수로 나타내고, 알칼리성 용액의 특성값은 -1부터 -1,000,000,000까지의 음의 정수로 나타낸다.
//
//같은 양의 두 용액을 혼합한 용액의 특성값은 혼합에 사용된 각 용액의 특성값의 합으로 정의한다. 이 연구소에서는 같은 양의 두 용액을 혼합하여 특성값이 0에 가장 가까운 용액을 만들려고 한다.
//
//예를 들어, 주어진 용액들의 특성값이 [-2, 4, -99, -1, 98]인 경우에는 특성값이 -99인 용액과 특성값이 98인 용액을 혼합하면 특성값이 -1인 용액을 만들 수 있고, 이 용액이 특성값이 0에 가장 가까운 용액이다. 참고로, 두 종류의 알칼리성 용액만으로나 혹은 두 종류의 산성 용액만으로 특성값이 0에 가장 가까운 혼합 용액을 만드는 경우도 존재할 수 있다.
//
//산성 용액과 알칼리성 용액의 특성값이 주어졌을 때, 이 중 두 개의 서로 다른 용액을 혼합하여 특성값이 0에 가장 가까운 용액을 만들어내는 두 용액을 찾는 프로그램을 작성하시오.
//
//입력
//첫째 줄에는 전체 용액의 수 N이 입력된다. N은 2 이상 100,000 이하이다. 둘째 줄에는 용액의 특성값을 나타내는 N개의 정수가 빈칸을 사이에 두고 주어진다. 이 수들은 모두 -1,000,000,000 이상 1,000,000,000 이하이다. N개의 용액들의 특성값은 모두 다르고, 산성 용액만으로나 알칼리성 용액만으로 입력이 주어지는 경우도 있을 수 있다.
//
//출력
//첫째 줄에 특성값이 0에 가장 가까운 용액을 만들어내는 두 용액의 특성값을 출력한다. 출력해야 하는 두 용액은 특성값의 오름차순으로 출력한다. 특성값이 0에 가장 가까운 용액을 만들어내는 경우가 두 개 이상일 경우에는 그 중 아무것이나 하나를 출력한다.
//
//예제 입력 1
//5
//-2 4 -99 -1 98
//예제 출력 1
//-99 98

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = IntArray(n).apply {
        val st = StringTokenizer(readLine())
        repeat(n) { set(it, st.nextToken().toInt()) }
    }.sorted()

    var ans = Int.MAX_VALUE
    var ans1 = 0
    var ans2 = 0

    fun solve(lo: Int, hi: Int, target: Int): Int {
        var min = Int.MAX_VALUE
        var lo = lo
        var hi = hi
        var answer = 0
        while (lo < hi) {
            val mid = (lo + hi) / 2
            if (abs(arr[mid] + target) < min) {
                min = abs(arr[mid] + target)
                answer = arr[mid]
            }

            if (arr[mid] + target < 0) {
                lo = mid + 1
            } else if (arr[mid] + target > 0) {
                hi = mid
            } else {
                return arr[mid]
            }
        }
        return answer
    }

    for (i in 0 until n - 1) {
        val tmp = solve(i + 1, n, arr[i])
        val sum = abs(arr[i] + tmp)
        if (ans > sum) {
            ans = sum
            ans1 = arr[i]
            ans2 = tmp
        }
    }

    print(buildString { append(ans1).append(" ").append(ans2) })
}