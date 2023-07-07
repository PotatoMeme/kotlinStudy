package com.potatomeme.programmers.codingtest.years23.july.level0


//문자 리스트를 문자열로 변환하기
//문제 설명
//문자들이 담겨있는 배열 arr가 주어집니다. arr의 원소들을 순서대로 이어 붙인 문자열을 return 하는 solution함수를 작성해 주세요.
//
//제한사항
//1 ≤ arr의 길이 ≤ 200
//arr의 원소는 전부 알파벳 소문자로 이루어진 길이가 1인 문자열입니다.
//입출력 예
//arr	result
//["a","b","c"]	"abc"

class Solution181893() {
    fun solution(arr: IntArray, query: IntArray): IntArray {
        var left = 0
        var right = arr.size - 1
        for (i in query.indices) {
            if (i % 2 == 0) {
                right = query[i] + left
            } else {
                left += query[i]
            }
        }
        return arr.copyOfRange(left, right + 1)
    }
}