package com.potatomeme.programmers.codingtest.years23.feb.level0

import kotlin.math.abs

//최댓값 만들기 (2)
//문제 설명
//정수 배열 numbers가 매개변수로 주어집니다. numbers의 원소 중 두 개를 곱해 만들 수 있는 최댓값을 return하도록 solution 함수를 완성해주세요.
//
//제한사항
//-10,000 ≤ numbers의 원소 ≤ 10,000
//2 ≤ numbers 의 길이 ≤ 100
//입출력 예
//numbers	result
//[1, 2, -3, 4, -5]	15
//[0, -31, 24, 10, 1, 9]	240
//[10, 20, 30, 5, 5, 20, 5]	600
//입출력 예 설명
//입출력 예 #1
//
//두 수의 곱중 최댓값은 -3 * -5 = 15 입니다.
//입출력 예 #2
//
//두 수의 곱중 최댓값은 10 * 24 = 240 입니다.
//입출력 예 #3
//
//두 수의 곱중 최댓값은 20 * 30 = 600 입니다.

class Solution120862() {
    //try1
    fun solution1(numbers: IntArray): Int {
        var max = Int.MIN_VALUE
        for (i in 0 until numbers.size - 1) {
            for (j in i + 1 until numbers.size) {
                max = max.coerceAtLeast(numbers[i] * numbers[j])
            }
        }
        return max
    }

    //try2
    fun solution2(numbers: IntArray): Int {
        val arr = numbers.sorted()
        return (arr[0] * arr[1]).coerceAtLeast(arr[arr.size - 1] * arr[arr.size - 2])
    }
}