package com.potatomeme.programmers

import java.util.*


fun main() {
    println(listOf("a","b","c").joinToString (""))
    println(solution(arrayOf("19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2")).joinToString(" "))
}

fun solution(quiz: Array<String>): Array<String> {
    val answer: Array<String> = Array(quiz.size) { "" }
    quiz.forEachIndexed { index, s ->
        val st = StringTokenizer(s)
        var sum = st.nextToken().toInt()
        if (st.nextToken().equals("-")) {
            sum -= st.nextToken().toInt()
        } else {
            sum += st.nextToken().toInt()
        }
        st.nextToken()
        if (sum == st.nextToken().toInt()) {
            answer[index] = "O"
        } else {
            answer[index] = "X"
        }
    }
    return answer
}