package com.potatomeme.programmers.codingtest.years23.april.level1


//가장 큰 수
//문제 설명
//0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
//
//예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
//
//0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
//
//제한 사항
//numbers의 길이는 1 이상 100,000 이하입니다.
//numbers의 원소는 0 이상 1,000 이하입니다.
//정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
//입출력 예
//numbers	return
//[6, 10, 2]	"6210"
//[3, 30, 34, 5, 9]	"9534330"
//※ 공지 - 2021년 10월 20일 테스트케이스가 추가되었습니다.

class Solution42746() {
    fun failSolution(numbers: IntArray): String {
        var answer = "0"
        val visited = BooleanArray(numbers.size)
        fun dfs(depth: Int, sb: StringBuilder) {
            if (depth == numbers.size) {
                if (answer < sb.toString()) answer = sb.toString()
                return
            }

            for (i in numbers.indices) {
                if (!visited[i]) {
                    visited[i] = true
                    val start = sb.length
                    dfs(depth + 1, sb.append(numbers[i]))
                    sb.delete(start, sb.length)
                    visited[i] = false
                }
            }
        }
        dfs(0, StringBuilder())
        return answer
    }//time out

    fun solution(numbers: IntArray): String = numbers.map { it.toString() }
        .sortedWith { o1, o2 ->
            when (o1.length) {
                o2.length -> o2.compareTo(o1)
                else -> (o2 + o1).compareTo(o1 + o2)
            }
        }.run {
            println(this.joinToString(" "))
            val sb = StringBuilder()
            if (this[0] == "0") {
                sb.append(0)
            } else {
                this.forEach {
                    sb.append(it)
                }
            }
            return sb.toString()
        }
}
