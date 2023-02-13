package com.potatomeme.baekjoon.`2023`.february


//https://www.acmicpc.net/problem/1904

//01타일
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//0.75 초 (추가 시간 없음)	256 MB	78425	25507	20265	31.807%
//문제
//지원이에게 2진 수열을 가르쳐 주기 위해, 지원이 아버지는 그에게 타일들을 선물해주셨다. 그리고 이 각각의 타일들은 0 또는 1이 쓰여 있는 낱장의 타일들이다.
//
//어느 날 짓궂은 동주가 지원이의 공부를 방해하기 위해 0이 쓰여진 낱장의 타일들을 붙여서 한 쌍으로 이루어진 00 타일들을 만들었다. 결국 현재 1 하나만으로 이루어진 타일 또는 0타일을 두 개 붙인 한 쌍의 00타일들만이 남게 되었다.
//
//그러므로 지원이는 타일로 더 이상 크기가 N인 모든 2진 수열을 만들 수 없게 되었다. 예를 들어, N=1일 때 1만 만들 수 있고, N=2일 때는 00, 11을 만들 수 있다. (01, 10은 만들 수 없게 되었다.) 또한 N=4일 때는 0011, 0000, 1001, 1100, 1111 등 총 5개의 2진 수열을 만들 수 있다.
//
//우리의 목표는 N이 주어졌을 때 지원이가 만들 수 있는 모든 가짓수를 세는 것이다. 단 타일들은 무한히 많은 것으로 가정하자.
//
//입력
//첫 번째 줄에 자연수 N이 주어진다. (1 ≤ N ≤ 1,000,000)
//
//출력
//첫 번째 줄에 지원이가 만들 수 있는 길이가 N인 모든 2진 수열의 개수를 15746으로 나눈 나머지를 출력한다.
//
//예제 입력 1
//4
//예제 출력 1
//5


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    print(Solution1904Type3(n).count)
}

class Solution1904(val n: Int) {
    val arr = BooleanArray(n)
    var count = 0

    init {
        dfs(0)
    }

    fun dfs(depth: Int) {
        if (depth > n - 1) {
            return
        }
        count++
        count %= 15746
        for (i in depth until n - 1) {
            if (!arr[i]) {
                arr[i] = true
                arr[i + 1] = true
                dfs(i + 1)
                arr[i] = false
                arr[i + 1] = false
            }
        }
    }//time out
    //1 1 1 5 8 13 21 34 55
}


class Solution1904Type2() {
    fun dfs(depth: Int): Int {
        return when (depth) {
            1 -> {
                1
            }
            2 -> {
                2
            }
            else -> {
                (dfs(depth - 2) + dfs(depth - 1)) % 15746
            }
        }
    }//time out
}


class Solution1904Type3(n: Int) {
    val count: Int

    init {
        val arr = IntArray(n + 1)
        arr[0] = 1
        arr[1] = 1
        for (i in 2..n) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 15746
        }
        count = arr[n]
    }
}