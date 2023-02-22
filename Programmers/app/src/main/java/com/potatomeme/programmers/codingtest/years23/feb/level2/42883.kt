package com.potatomeme.programmers.codingtest.years23.feb.level2


//큰 수 만들기
//문제 설명
//어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
//
//예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.
//
//문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.
//
//제한 조건
//number는 2자리 이상, 1,000,000자리 이하인 숫자입니다.
//k는 1 이상 number의 자릿수 미만인 자연수입니다.
//입출력 예
//number	k	return
//"1924"	2	"94"
//"1231234"	3	"3234"
//"4177252841"	4	"775841"

class Solution42883() {

    fun solution1(number: String, k: Int): String {
        var max = "0"
        val number_len = number.length
        val max_depth = number.length - k
        val sb = StringBuilder()
        fun solve(depth: Int, idx: Int) {
            if (depth == max_depth) {
                if (max < sb.toString()) {
                    max = sb.toString()
                }
                return
            }
            if (idx == number_len) {
                return
            }
            for (i in idx until number_len) {
                sb.append(number[i])
                solve(depth + 1, i + 1)
                sb.deleteCharAt(sb.length - 1)
            }
        }
        solve(0, 0)
        return max
    }//time out,Rumtime error

    fun solution2(number: String, k: Int): String {
        val sb = StringBuilder()
        var index = 0
        var max : Int
        for (i in 0 until number.length - k) {
            max = 0
            for (j in index..k + i) {
                if (max < number[j] - '0') {
                    max = number[j] - '0'
                    index = j + 1
                }
            }
            sb.append(max)
        }
        return sb.toString()
    }
}

