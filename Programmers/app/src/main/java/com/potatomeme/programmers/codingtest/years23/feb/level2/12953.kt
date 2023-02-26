package com.potatomeme.programmers.codingtest.years23.feb.level2


//N개의 최소공배수
//문제 설명
//두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다. 예를 들어 2와 7의 최소공배수는 14가 됩니다. 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다. n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.
//
//제한 사항
//arr은 길이 1이상, 15이하인 배열입니다.
//arr의 원소는 100 이하인 자연수입니다.
//입출력 예
//arr	result
//[2,6,8,14]	168
//[1,2,3]	6

class Solution12953() {
    fun solution(arr: IntArray): Long {
        fun solve(a: Int, b: Int): Long {
            if (b - a == 1) return arr[a] * arr[b] / gcd(arr[a].toLong(),arr[b].toLong())
            if (b == a) return arr[a].toLong()

            return if ((b - a) % 2 == 1) {
                val mid = (b - a + 1) / 2
                val x = solve(a, b - mid)
                val y = solve(a + mid, b)
                x * y / gcd(x, y)
            } else {
                val x = solve(a, b - 1)
                x * arr[b] / gcd(x, arr[b].toLong())
            }
        }
        return solve(0,arr.size-1)
    }


    fun gcd(a: Long, b: Long): Long = if (b == 0L) a else gcd(b, a % b)
}