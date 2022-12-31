package com.potatomeme.baekjoon.`2022`.december

import kotlin.math.min

//https://www.acmicpc.net/problem/1463

//1로 만들기
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//0.15 초 (하단 참고)	128 MB	232082	76545	49030	32.300%
//문제
//정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
//
//X가 3으로 나누어 떨어지면, 3으로 나눈다.
//X가 2로 나누어 떨어지면, 2로 나눈다.
//1을 뺀다.
//정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
//
//입력
//첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.
//
//출력
//첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.
//
//예제 입력 1
//2
//예제 출력 1
//1
//예제 입력 2
//10
//예제 출력 2
//3

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val num = readLine().toInt()
    print(Solution1463().solution(num))
}

class Solution1463 {
    fun solution_try1(num: Int): Int {
        var num = num
        var count = 0
        while (num != 1) {
            if (num % 3 == 0) {
                num /= 3
            } else if (num % 2 == 0) {
                num /= 2
            } else {
                num--
            }
            count++
        }
        return count
    }// 최솟값이 아님
    // 최솟값으로 만드려면 최대한 3으로 나눠야함 그래야많이 줄어들음
    // num%3 == 1 인경우 2로 나눌수 있다고 하더라도 1을 빼 3으로나누자
    // ex)8
    // 기존
    // ->4->2->1
    // new
    // ->7->6->2-> 1

    // ex) 28
    // 기존
    // -> 14 -> 7 -> 6 -> 2 -> 1
    // new
    // -> 27 -> 9 -> 3 -> 1


    fun solution_try2(num: Int): Int {
        var num = num
        var count = 0
        while (num != 1) {
            if (num % 3 == 0) {
                num /= 3
            } else if (num % 2 == 0) {
                num /= 2
            } else {
                num--
            }
            count++
        }
        return count
    }//틀림

    // 다이나믹 프로그래밍을 적용해보자
    // 최소로할수있는 경우를 bottom up알고리즘을 이용하여 마지막에 3가지중 어떤것이 가장작은지 검사
    fun solution(num: Int): Int {
        var intArr = IntArray(num+1)
        intArr[1] = 0
        for (i in 2 .. num){
            intArr[i] = intArr[i-1] + 1
            if (i%2 == 0) intArr[i] = min(intArr[i],intArr[i/2]+1)
            if (i%3 == 0) intArr[i] = min(intArr[i],intArr[i/3]+1)
        }
        return intArr[num]
    }//메모리 : 16548kb	    시간 : 116ms
}