package com.potatomeme.programmers.codingtest.years22.october.level2

// 최댓값과 최솟값
// 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12939?language=kotlin

// 문제 설명
//자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
//
//제한 조건
//n은 10,000,000,000이하인 자연수입니다.
//입출력 예
//n	return
//12345	[5,4,3,2,1]



class Solution12939 {
    fun mySolution1(s: String): String {
        val list = s.split(" ").map { it.toInt() }
        //return "${list.min()} ${list.max()}" // 왜 min하고 max를 unresolved reference라는거야;;
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE
        list.forEach {
            if (it < min) min = it
            if (it > max) max = it
        }
        return "${min} ${max}"
    }


    fun userSolution1(s: String): String =
        s.split(" ").map { it.toInt() }.let { "${it.min()} ${it.max()}" }

}

