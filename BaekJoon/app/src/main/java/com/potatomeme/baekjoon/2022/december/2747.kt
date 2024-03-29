package com.potatomeme.baekjoon.`2022`.december

//https://www.acmicpc.net/problem/2747

//피보나치 수
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초 (추가 시간 없음)	128 MB	59568	28116	23052	48.634%
//문제
//피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.
//
//이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.
//
//n=17일때 까지 피보나치 수를 써보면 다음과 같다.
//
//0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
//
//n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 n이 주어진다. n은 45보다 작거나 같은 자연수이다.
//
//출력
//첫째 줄에 n번째 피보나치 수를 출력한다.
//
//예제 입력 1
//10
//예제 출력 1
//55

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val num = readLine().toInt()
    print(Solution2747().solution(num))
}

class Solution2747 {
    // try1
    // 시간초과 인자값은 45이하의 자연수이기때문에 값을 미리지정하자
    fun solution_try1(number: Int): Int = when (number) {
        0 -> 0
        1, 2 -> 1
        else -> solution(number - 2) + solution(number - 1)
    }//이경우 중복이 많음

    val arr = IntArray(46)

    init {
        arr[0] = 0
        arr[1] = 1
        for (i in 2..45) arr[i] = arr[i - 1] + arr[i - 2]
    }

    fun solution(number: Int) = arr[number]
}