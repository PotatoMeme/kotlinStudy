package com.potatomeme.programmers.codingtest.years23.april.level1


//피로도
//두 원 사이의 정수 쌍
//문제 설명
//x축과 y축으로 이루어진 2차원 직교 좌표계에 중심이 원점인 서로 다른 크기의 원이 두 개 주어집니다. 반지름을 나타내는 두 정수 r1, r2가 매개변수로 주어질 때, 두 원 사이의 공간에 x좌표와 y좌표가 모두 정수인 점의 개수를 return하도록 solution 함수를 완성해주세요.
//※ 각 원 위의 점도 포함하여 셉니다.
//
//제한 사항
//1 ≤ r1 < r2 ≤ 1,000,000
//입출력 예
//r1	r2	result
//2	3	20
//입출력 예 설명
//입출력 예 설명.png
//그림과 같이 정수 쌍으로 이루어진 점은 총 20개 입니다.

class Solution181187() {

    //1안
    //피타고라스
    fun solution1(r1: Int, r2: Int): Long {
        var answer: Long = 0
        var mid: Long = 0
        val r1Pow = r1.toLong() * r1
        val r2Pow = r2.toLong() * r2
        for (i in 0L..r2) {
            for (j in 0L..i) {
                if (i * i + j * j in r1Pow..r2Pow) {
                    if (i == j) mid++ else answer++
                }
            }
        }
        return (answer * 2 + mid - (r2 - r1 + 1)) * 4
    }//time out

    //2안 원 - 원
    var lineCnt: Int = 0
    fun solution(r1: Int, r2: Int): Long =
        (countToR(r2.toLong()) - countToR(r1.toLong()) + lineCnt - 1) * 4

    private fun countToR(r: Long): Long {
        lineCnt = 0
        var cnt = 0L
        val pow = r * r
        var beforeJ = r
        for (i in 0..r) {//x
            j@ for (j in beforeJ downTo 0) {//y
                val n = i * i + j * j
                if (n <= pow) {
                    if (n == pow) lineCnt++
                    cnt += j
                    beforeJ = j
                    break@j
                }
            }
        }
        println(cnt)
        return cnt
    }
}