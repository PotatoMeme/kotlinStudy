package com.potatomeme.programmers.codingtest.years22.november.level1

//핸드폰 번호 가리기
//문제 설명
//프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다.
//전화번호가 문자열 phone_number로 주어졌을 때, 전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수, solution을 완성해주세요.
//
//제한 조건
//phone_number는 길이 4 이상, 20이하인 문자열입니다.
//입출력 예
//phone_number	return
//"01033334444"	"*******4444"
//"027778888"	"*****8888"

class Solution12948 {
    fun solution(phone_number: String): String {
        var answer = StringBuilder()
        for (i in phone_number.indices) {
            if (phone_number.length - i > 4) {
                answer.append('*')
            } else {
                answer.append(phone_number[i])
            }
        }
        return answer.toString()
    }// 평균 0.05 ms

    fun solution_try1(phone_number: String): String =
        phone_number.replace("""^[0-9]{${phone_number.length - 4}}""".toRegex(),
            "*".repeat(phone_number.length - 4))
    // 평균 16 ms


    fun user1Solution(phone_number: String) =
        "${"".padStart(phone_number.length - 4, '*')}${phone_number.takeLast(4)}"
    // 평균 10 ms
}