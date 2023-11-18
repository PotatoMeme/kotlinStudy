package com.potatomeme.baekjoon.`2023`.november

import java.util.StringTokenizer
import kotlin.math.max
import kotlin.system.exitProcess

//카드 구매하기
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	256 MB	48368	29703	22347	61.297%
//문제
//요즘 민규네 동네에서는 스타트링크에서 만든 PS카드를 모으는 것이 유행이다.
//
//PS카드는 PS(Problem Solving)분야에서 유명한 사람들의 아이디와 얼굴이 적혀있는 카드이다. 각각의 카드에는 등급을 나타내는 색이 칠해져 있고, 다음과 같이 8가지가 있다.
//
//전설카드
//레드카드
//오렌지카드
//퍼플카드
//블루카드
//청록카드
//그린카드
//그레이카드
//카드는 카드팩의 형태로만 구매할 수 있고, 카드팩의 종류는 카드 1개가 포함된 카드팩, 카드 2개가 포함된 카드팩, ... 카드 N개가 포함된 카드팩과 같이 총 N가지가 존재한다.
//
//민규는 카드의 개수가 적은 팩이더라도 가격이 비싸면 높은 등급의 카드가 많이 들어있을 것이라는 미신을 믿고 있다. 따라서, 민규는 돈을 최대한 많이 지불해서 카드 N개 구매하려고 한다. 카드가 i개 포함된 카드팩의 가격은 Pi원이다.
//
//예를 들어, 카드팩이 총 4가지 종류가 있고, P1 = 1, P2 = 5, P3 = 6, P4 = 7인 경우에 민규가 카드 4개를 갖기 위해 지불해야 하는 금액의 최댓값은 10원이다. 2개 들어있는 카드팩을 2번 사면 된다.
//
//P1 = 5, P2 = 2, P3 = 8, P4 = 10인 경우에는 카드가 1개 들어있는 카드팩을 4번 사면 20원이고, 이 경우가 민규가 지불해야 하는 금액의 최댓값이다.
//
//마지막으로, P1 = 3, P2 = 5, P3 = 15, P4 = 16인 경우에는 3개 들어있는 카드팩과 1개 들어있는 카드팩을 구매해 18원을 지불하는 것이 최댓값이다.
//
//카드 팩의 가격이 주어졌을 때, N개의 카드를 구매하기 위해 민규가 지불해야 하는 금액의 최댓값을 구하는 프로그램을 작성하시오. N개보다 많은 개수의 카드를 산 다음, 나머지 카드를 버려서 N개를 만드는 것은 불가능하다. 즉, 구매한 카드팩에 포함되어 있는 카드 개수의 합은 N과 같아야 한다.
//
//입력
//첫째 줄에 민규가 구매하려고 하는 카드의 개수 N이 주어진다. (1 ≤ N ≤ 1,000)
//
//둘째 줄에는 Pi가 P1부터 PN까지 순서대로 주어진다. (1 ≤ Pi ≤ 10,000)
//
//출력
//첫째 줄에 민규가 카드 N개를 갖기 위해 지불해야 하는 금액의 최댓값을 출력한다.
//
//예제 입력 1
//4
//1 5 6 7
//예제 출력 1
//10
//예제 입력 2
//5
//10 9 8 7 6
//예제 출력 2
//50
//예제 입력 3
//10
//1 1 2 3 5 8 13 21 34 55
//예제 출력 3
//55
//예제 입력 4
//10
//5 10 11 12 13 30 35 40 45 47
//예제 출력 4
//50
//예제 입력 5
//4
//5 2 8 10
//예제 출력 5
//20
//예제 입력 6
//4
//3 5 15 16
//예제 출력 6
//18


fun main() {
    with(System.`in`.bufferedReader()) {
        // (1 ≤ N ≤ 1,000) (1 ≤ Pi ≤ 10,000)
        // max = 10_000_000 Int를 넘지 않음
        // test1,가정1
        // dfs 모든 가정 구하기,가능은 하지만 time out 예상
        /*val n = readLine().toInt()
        val st = StringTokenizer(readLine())
        val arr1 = IntArray(n) {
            st.nextToken().toInt()
        }
        var max = 0
        fun dfs(remain: Int, total: Int) {
            if (remain == 0) {
                if (max < total) max = total
                return
            }
            for (i in 0 until remain) {
                dfs(remain - (i + 1), total + arr1[i])
            }
        }
        dfs(n,0)
        print(max)*///time out

        // test2, 가정2 개당 가격이 최대로 높을걸로 모두 구하고 나머지에 또 반복
        /*val n = readLine().toInt()
        val st = StringTokenizer(readLine())
        val arr1 = IntArray(n) {
            st.nextToken().toInt()
        }
        val arr2 = arr1.mapIndexed { index, i ->
            Pair(index, i / (index+1).toDouble())
        }.sortedByDescending { it.second }
        val checked = BooleanArray(n)

        fun solve(remain: Int, total: Int): Int {
            if (remain == 0) {
                return total
            }
            for ((index, _) in arr2) {
                if (!checked[index] && index <= remain) {
                    checked[index] = true
                    val a = remain / (index + 1)
                    return solve(remain % (index + 1), total + arr1[index] * a)
                }
                checked[index] = true
            }
            return 0
        }
        print(solve(n, 0))*///30퍼 실패
        // test3, 가정3 dp 로 해서 다구해보자
        val n = readLine().toInt()
        val st = StringTokenizer(readLine())
        val arr = IntArray(n) {
            st.nextToken().toInt()
        }
        val dp = IntArray(n)
        for (i in 0 until n) {
            dp[i] = arr[i]
            for (j in 0 until i) {
                dp[i] = max(dp[i], dp[j] + dp[i - j - 1])
            }
        }
        print(dp[n - 1])
    }
}