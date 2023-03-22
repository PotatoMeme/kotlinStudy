package com.potatomeme.programmers.codingtest.years23.march.level2

import kotlin.math.sqrt


//소수 찾기
//문제 설명
//한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
//
//각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
//
//제한사항
//numbers는 길이 1 이상 7 이하인 문자열입니다.
//numbers는 0~9까지 숫자만으로 이루어져 있습니다.
//"013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
//입출력 예
//numbers	return
//"17"	3
//"011"	2
//입출력 예 설명
//예제 #1
//[1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.
//
//예제 #2
//[0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
//
//11과 011은 같은 숫자로 취급합니다.
fun main() {
    println(Solution42839().solution("17"))
}


class Solution42839() {


    // 1안
    // 해당 문자열로 만들수있는 숫자들의 리스트
    // 최대 9_999_999
    // 최대개수 2^7-1

    fun solution(numbers: String): Int {
        val numbers_arr = numbers.toCharArray()
        val size = numbers_arr.size
        val visited = BooleanArray(size)
        val set = mutableSetOf<Int>()
        var max = Int.MIN_VALUE

        fun solve(depth: Int, str: StringBuilder) {
            val num = str.toString().toInt()
            set.add(num)
            if (max < num) max = num
            if (depth == size) return

            for (i in 0 until size) {
                if (!visited[i]) {
                    visited[i] = true
                    str.append(numbers_arr[i])
                    solve(depth + 1, str)
                    visited[i] = false
                    str.deleteCharAt(str.length - 1)
                }
            }
        }

        for (i in 0 until size){
            visited[i] = true
            solve(1, StringBuilder("${numbers_arr[i]}"))
            visited[i] = false
        }


        val arr = BooleanArray(max + 1)
        arr[0] = true
        arr[1] = true

        for (i in 2..sqrt(max.toDouble()).toInt()) {
            if (!arr[i]) {
                for (j in i + i..max step i) {
                    arr[j] = true
                }
            }
        }

        var answer = 0

        set.forEach {
            if (!arr[it]) answer++
        }

        return answer
    }
}