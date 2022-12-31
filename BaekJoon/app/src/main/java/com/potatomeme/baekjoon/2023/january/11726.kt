package com.potatomeme.baekjoon.`2023`.january

//https://www.acmicpc.net/problem/11726

//2×n 타일링
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	256 MB	128541	48935	36107	35.926%
//문제
//2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
//
//아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.
//
//
//
//입력
//첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)
//
//출력
//첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
//
//예제 입력 1
//2
//예제 출력 1
//2
//예제 입력 2
//9
//예제 출력 2
//55

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val num = readLine().toInt()
    print(Solution11726().solution(num))
}

class Solution11726 {
    fun solution(number: Int): Int {
        if (number < 3) return number
        var arr = IntArray(number+1)
        arr[1] = 1
        arr[2] = 2
        for (i in 3 .. number) arr[i] = (arr[i-1] + arr[i-2])%10007
        return arr[number]
    }//12312kb	96ms
}