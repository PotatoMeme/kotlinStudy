package com.potatomeme.programmers.codingtest.years23.march.level0


//최댓값 만들기 (1)
//문제 설명
//정수 배열 numbers가 매개변수로 주어집니다. numbers의 원소 중 두 개를 곱해 만들 수 있는 최댓값을 return하도록 solution 함수를 완성해주세요.
//
//제한사항
//0 ≤ numbers의 원소 ≤ 10,000
//2 ≤ numbers의 길이 ≤ 100
//입출력 예
//numbers	result
//[1, 2, 3, 4, 5]	20
//[0, 31, 24, 10, 1, 9]	744
//입출력 예 설명
//입출력 예 #1
//
//두 수의 곱중 최댓값은 4 * 5 = 20 입니다.
//입출력 예 #1
//
//두 수의 곱중 최댓값은 31 * 24 = 744 입니다.

class Solution120847() {
    fun solution1(numbers: IntArray): Int {
        val arr = IntArray(10_001) { 0 }
        numbers.forEach { arr[it]++ }
        var answer = 0
        var b = false
        for (i in 10_000 downTo 0) {
            if (arr[i] > 0) {
                if (b) {
                    return answer * i
                } else {
                    if (arr[i] == 1) {
                        answer = i
                        b = true
                    } else {
                        return i*i
                    }
                }

            }
        }
        return answer
    }
}