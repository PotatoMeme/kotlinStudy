package com.example.myapplication.level1

// 소수 만들기
//문제 설명
//주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다. 숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.
//
//제한사항
//nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.
//nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.
//입출력 예
//nums	result
//[1,2,3,4]	1
//[1,2,7,6,4]	4
//입출력 예 설명
//입출력 예 #1
//[1,2,4]를 이용해서 7을 만들 수 있습니다.
//
//입출력 예 #2
//[1,2,4]를 이용해서 7을 만들 수 있습니다.
//[1,4,6]을 이용해서 11을 만들 수 있습니다.
//[2,4,7]을 이용해서 13을 만들 수 있습니다.
//[4,6,7]을 이용해서 17을 만들 수 있습니다.

// nums의 각 원소는 1 이상 1,000 이하의 자연수
// 3개를 더해 소수를 만드는 경우

// 짝수 2 홀수 1
// 홀수 3
// 만드어지는 수의 최대 크기 1000+999+998 == 3000 - 3 == 2997

// case1
// 경우들을 다구하여 리스트에 넣고 set하여 중복을 제거


class Solution12977 {
    private val primes = BooleanArray(2998)

    init {
        for (i in 2..55) {
            if (primes[i]) continue
            for (j in i + i..2997 step i) {
                primes[j] = true
            }
        }
    }

    fun solution(nums: IntArray): Int {
        var count = 0
        for (i in 0 until nums.size - 2) {
            for (j in i + 1 until nums.size - 1) {
                for (k in j + 1 until nums.size) {
                    if (!primes[nums[i] + nums[j] + nums[k]]) count++
                }
            }
        }
        return count
    }
}