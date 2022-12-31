package com.potatomeme.baekjoon.`2022`.december

import java.lang.Integer.min

//https://www.acmicpc.net/problem/9095

//1, 2, 3 더하기 다국어
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초 (추가 시간 없음)	512 MB	91395	59901	40742	63.909%
//문제
//정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.
//
//1+1+1+1
//1+1+2
//1+2+1
//2+1+1
//2+2
//1+3
//3+1
//정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 11보다 작다.
//
//출력
//각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 출력한다.
//
//예제 입력 1
//3
//4 1,1,1,1  1,3   1,1,2  2,2
//7
//10
//예제 출력 1
//7
//44
//274

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val num = readLine().toInt()
    val solution9095 = Solution9095()
    repeat(num) { println(solution9095.solution(readLine().toInt())) }
}

class Solution9095 {
    var intArr = IntArray(12) { 0 }
    var lastPos = 1

    init {
        intArr[1] = 1
        intArr[2] = 2
        intArr[3] = 4
        lastPos = 3
    }
    // try1 use Dynamic Programming
    fun solution(number: Int): Int {
        if (number <= lastPos) return intArr[number]
        for (i in lastPos+1..number)
            intArr[i] = intArr[i - 1] + intArr[i-2] + intArr[i-3]
        lastPos = number
        return intArr[number]
    }//메모리 : 12180kb	    시간 : 88ms
}