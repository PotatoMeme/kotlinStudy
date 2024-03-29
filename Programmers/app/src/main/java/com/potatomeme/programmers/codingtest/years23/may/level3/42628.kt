package com.potatomeme.programmers.codingtest.years23.may.level3

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*
import kotlin.math.abs
import kotlin.math.min


//N-Queen
//문제 설명
//가로, 세로 길이가 n인 정사각형으로된 체스판이 있습니다. 체스판 위의 n개의 퀸이 서로를 공격할 수 없도록 배치하고 싶습니다.
//
//예를 들어서 n이 4인경우 다음과 같이 퀸을 배치하면 n개의 퀸은 서로를 한번에 공격 할 수 없습니다.
//
//Imgur
//Imgur
//
//체스판의 가로 세로의 세로의 길이 n이 매개변수로 주어질 때, n개의 퀸이 조건에 만족 하도록 배치할 수 있는 방법의 수를 return하는 solution함수를 완성해주세요.
//
//제한사항
//퀸(Queen)은 가로, 세로, 대각선으로 이동할 수 있습니다.
//n은 12이하의 자연수 입니다.
//입출력 예
//n	result
//4	2
//입출력 예 설명
//입출력 예 #1
//문제의 예시와 같습니다.

class Solution42628() {
    @RequiresApi(Build.VERSION_CODES.N)
    fun solution(operations: Array<String>): IntArray {
        val answer = intArrayOf(0, 0)
        val maxQue = PriorityQueue<Int>(Collections.reverseOrder())
        val minQue = PriorityQueue<Int>()
        operations.forEach { str ->
            if (str[0] == 'I') { // input
                val n = str.substring(2).toInt()
                maxQue.add(n)
                minQue.add(n)
            } else if (str[2] == '1') {
                minQue.remove(maxQue.poll())
            } else {
                maxQue.remove(minQue.poll())
            }
        }
        if(!maxQue.isEmpty()) {
            answer[0] = maxQue.poll()
            answer[1] = minQue.poll()
        }
        return answer
    }
}