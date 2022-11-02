package com.potatomeme.programmers.codingtest.years22.november.level0

// 외계어 사전
//문제 설명
//PROGRAMMERS-962 행성에 불시착한 우주비행사 머쓱이는 외계행성의 언어를 공부하려고 합니다. 알파벳이 담긴 배열 spell과 외계어 사전 dic이 매개변수로 주어집니다. spell에 담긴 알파벳을 한번씩만 모두 사용한 단어가 dic에 존재한다면 1, 존재하지 않는다면 2를 return하도록 solution 함수를 완성해주세요.
//
//제한사항
//spell과 dic의 원소는 알파벳 소문자로만 이루어져있습니다.
//2 ≤ spell의 크기 ≤ 10
//spell의 원소의 길이는 1입니다.
//1 ≤ dic의 크기 ≤ 10
//1 ≤ dic의 원소의 길이 ≤ 10
//spell의 원소를 모두 사용해 단어를 만들어야 합니다.
//spell의 원소를 모두 사용해 만들 수 있는 단어는 dic에 두 개 이상 존재하지 않습니다.
//dic과 spell 모두 중복된 원소를 갖지 않습니다.

// case1
// 될수있는 문자열을 다만들어 놓고 그값들이 있는지 확인
// 최대연산 10! * 10

// case2
// 각 문자열에 count를 하여 그값이 1이 맞는지 확인
// 최대 연산 10*10*10

// case2가 연산이 더 적어보임

class Solution120869 {
    fun solution(spell: Array<String>, dic: Array<String>): Int {
        dic.forEach { dic_str ->
            if (dic_str.length == spell.size) {
                if (spell.filter { spell_char ->
                        dic_str.count {
                            it == spell_char.single()
                        } == 1
                    }.size == spell.size) return 1
            }
        }
        return 2
    }

    fun user1Solution(spell: Array<String>, dic: Array<String>) =
        if (dic.map { it.toList().sorted().joinToString("") }
                .contains(spell.sortedArray().joinToString(""))) 1 else 2

    fun user2solution(spell: Array<String>, dic: Array<String>): Int = if (
        dic.any { word ->
            spell.all { alphabet ->
                word.contains(alphabet)
            }
        }
    ) {
        1
    } else {
        2
    }
}


