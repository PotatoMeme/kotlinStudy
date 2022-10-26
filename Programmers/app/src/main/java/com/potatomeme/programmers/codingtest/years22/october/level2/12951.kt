package com.potatomeme.programmers.codingtest.years22.october.level2

// 최댓값과 최솟값
// 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12939?language=kotlin

// 문제 설명
// JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다. 단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다. (첫 번째 입출력 예 참고)
// 문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.
//
// 제한 조건
// s는 길이 1 이상 200 이하인 문자열입니다.
// s는 알파벳과 숫자, 공백문자(" ")로 이루어져 있습니다.
// 숫자는 단어의 첫 문자로만 나옵니다.
// 숫자로만 이루어진 단어는 없습니다.
// 공백문자가 연속해서 나올 수 있습니다.
// 입출력 예
// s	return
// "3people unFollowed me"	"3people Unfollowed Me"
// "for the last week"	"For The Last Week"
// ※ 공지 - 2022년 1월 14일 제한 조건과 테스트 케이스가 추가되었습니다.


class Solution12951 {
    fun mySolution1(s: String): String =
        s.split(" ").map {
            it[0].uppercase() + it.substring(1).lowercase()
        }.reduce {
                total, num -> "$total $num"
        }.let {
            it
        }
    // 런타임 에러


    fun mySolution2(s: String): String =
       s.lowercase().split(' ').joinToString(" ") {
           it.replaceFirstChar {
               it.uppercase()
           }
       }


    fun userSolution1(s: String): String =
        s.toLowerCase().split(" ").map {
            it.capitalize()
        }.joinToString(" ")

    fun userSolution2(s: String): String  {
        var answer = ""
        var ss = s.toLowerCase()
        for(i in 0..ss.length-1) {
            when(i) {
                0 -> {
                    if(s[0].toInt() !in 0..9) answer += ss[i].toTitleCase().toString()
                }
                else -> {
                    if(ss[i-1] == ' ') answer += ss[i].toTitleCase().toString()
                    else answer += ss[i].toString()
                }
            }
        }
        return answer
    }
}

