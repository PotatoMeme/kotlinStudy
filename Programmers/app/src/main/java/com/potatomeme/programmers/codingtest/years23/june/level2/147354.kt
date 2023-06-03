package com.potatomeme.programmers.codingtest.years23.june.level2


//특정 문자열로 끝나는 가장 긴 부분 문자열 찾기
//문제 설명
//문자열 myString과 pat가 주어집니다. myString의 부분 문자열중 pat로 끝나는 가장 긴 부분 문자열을 찾아서 return 하는 solution 함수를 완성해 주세요.
//
//제한사항
//5 ≤ myString ≤ 20
//1 ≤ pat ≤ 5
//pat은 반드시 myString의 부분 문자열로 주어집니다.
//myString과 pat에 등장하는 알파벳은 대문자와 소문자를 구분합니다.
//입출력 예
//myString	pat	result
//"AbCdEFG"	"dE"	"AbCdE"
//"AAAAaaaa"	"a"	"AAAAaaaa"
//입출력 예 설명
//입출력 예 #1
//
//"AbCdEFG"에서 "dE"는 한 번 등장하며 처음부터 해당 위치까지 잘라내면 "AbCdE"가 됩니다. 따라서 이 문자열이 "dE"로 끝나는 가장 긴 문자열이며, "AbCdE"를 return 합니다.
//입출력 예 #2
//
//"AAAAaaaa"에서 "a"는 총 네 번 등장하며 이 중 가장 마지막에 있는 위치까지 잘라내면 "AAAAaaaa"가 됩니다. 따라서 이 문자열이 "a"로 끝나는 가장 긴 문자열이며, "AAAAaaaa"를 return 합니다.

class Solution181872() {
    fun solution(data: Array<IntArray>, col: Int, row_begin: Int, row_end: Int): Int {
        val sortedData = data.sortedWith { p0, p1 ->
            val n = (p0?.get(col-1) ?: 0) - (p1?.get(col-1) ?: 0)
            if (n == 0) {
                return@sortedWith (p1?.get(0) ?: 0) - (p0?.get(0) ?: 0)
            }
            n
        }
        val resultArray = IntArray(row_end - row_begin + 1)
        for (i in row_begin - 1 until row_end) {
            sortedData[i].forEach {
                resultArray[i - row_begin + 1] += it % (i + 1)
            }
        }
        var answer = resultArray[0]
        for (i in 1 until resultArray.size) {
            answer = answer.xor(resultArray[i])
        }

        return answer
    }
}