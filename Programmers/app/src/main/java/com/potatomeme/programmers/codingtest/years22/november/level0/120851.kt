package com.potatomeme.programmers.codingtest.years22.november.level0

//숨어있는 숫자의 덧셈 (1)
//문제 설명
//문자열 my_string이 매개변수로 주어집니다. my_string안의 모든 자연수들의 합을 return하도록 solution 함수를 완성해주세요.
//
//제한사항
//1 ≤ my_string의 길이 ≤ 1,000
//my_string은 소문자, 대문자 그리고 한자리 자연수로만 구성되어있습니다.
//입출력 예
//my_string	result
//"aAb1B2cC34oOp"	10
//"1a2b3c4d123"	16
//입출력 예 설명
//입출력 예 #1
//
//"aAb1B2cC34oOp"안의 한자리 자연수는 1, 2, 3, 4 입니다. 따라서 1 + 2 + 3 + 4 = 10 을 return합니다.
//입출력 예 #2
//
//"1a2b3c4d123Z"안의 한자리 자연수는 1, 2, 3, 4, 1, 2, 3 입니다. 따라서 1 + 2 + 3 + 4 + 1 + 2 + 3 = 16 을 return합니다.
//유의사항
//연속된 숫자도 각각 한 자리 숫자로 취급합니다.

class Solution120851 {
    val decimal = listOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
    fun solution(my_string: String): Int {
        var result = 0
        my_string.forEach { if (it in decimal) result += it.digitToInt() }
        return result
    }//0.83~2.79ms

    fun solution_try1(my_string: String): Int {
        var result = 0
        my_string.forEach { if (it in '0'..'9') result += it.digitToInt() }
        return result
    }//0.81~0.91ms

    fun solution_try2(my_string: String): Int =
        my_string.filter { it in '0'..'9' }.map { it.digitToInt() }.sum()//6.43~7.57ms

    fun solution_try3(my_string: String): Int =
        my_string.filter { it in '0'..'9' }.map { it.toString().toInt() }.sum()//5.65~6.75ms

    fun user1Solution(my_string: String): Int =
        my_string.filter(Char::isDigit).map { c -> c.toString().toInt() }.sum()//5.74~7.61ms

    fun user2Solution(my_string: String): Int =
        my_string.filter(Char::isDigit)
            .sumOf(Char::digitToInt)//0.91~1.56ms

    fun mySolutionRefact(my_string: String): Int {
        var result = 0
        my_string.forEach { if (it in '0'..'9') result += it.toString().toInt() }
        return result
    }//0.03~0.08ms

}