package com.potatomeme.programmers.codingtest.years23.march.level2

import java.util.*
import kotlin.math.min


//교점에 별 만들기
//문제 설명
//Ax + By + C = 0으로 표현할 수 있는 n개의 직선이 주어질 때, 이 직선의 교점 중 정수 좌표에 별을 그리려 합니다.
//
//예를 들어, 다음과 같은 직선 5개를
//
//2x - y + 4 = 0
//-2x - y + 4 = 0
//-y + 1 = 0
//5x - 8y - 12 = 0
//5x + 8y + 12 = 0
//좌표 평면 위에 그리면 아래 그림과 같습니다.
//
//RisingStarGraphBox.jpg
//
//이때, 모든 교점의 좌표는 (4, 1), (4, -4), (-4, -4), (-4, 1), (0, 4), (1.5, 1.0), (2.1, -0.19), (0, -1.5), (-2.1, -0.19), (-1.5, 1.0)입니다. 이 중 정수로만 표현되는 좌표는 (4, 1), (4, -4), (-4, -4), (-4, 1), (0, 4)입니다.
//
//만약 정수로 표현되는 교점에 별을 그리면 다음과 같습니다.
//
//RisingStarGraphStar.jpg
//
//위의 그림을 문자열로 나타낼 때, 별이 그려진 부분은 *, 빈 공간(격자선이 교차하는 지점)은 .으로 표현하면 다음과 같습니다.
//
//"..........."
//".....*....."
//"..........."
//"..........."
//".*.......*."
//"..........."
//"..........."
//"..........."
//"..........."
//".*.......*."
//"..........."
//이때 격자판은 무한히 넓으니 모든 별을 포함하는 최소한의 크기만 나타내면 됩니다.
//
//따라서 정답은
//
//"....*...."
//"........."
//"........."
//"*.......*"
//"........."
//"........."
//"........."
//"........."
//"*.......*"
//입니다.
//
//직선 A, B, C에 대한 정보가 담긴 배열 line이 매개변수로 주어집니다. 이때 모든 별을 포함하는 최소 사각형을 return 하도록 solution 함수를 완성해주세요.
//
//제한사항
//line의 세로(행) 길이는 2 이상 1,000 이하인 자연수입니다.
//line의 가로(열) 길이는 3입니다.
//line의 각 원소는 [A, B, C] 형태입니다.
//A, B, C는 -100,000 이상 100,000 이하인 정수입니다.
//무수히 많은 교점이 생기는 직선 쌍은 주어지지 않습니다.
//A = 0이면서 B = 0인 경우는 주어지지 않습니다.
//정답은 1,000 * 1,000 크기 이내에서 표현됩니다.
//별이 한 개 이상 그려지는 입력만 주어집니다.
//입출력 예
//line	result
//[[2, -1, 4], [-2, -1, 4], [0, -1, 1], [5, -8, -12], [5, 8, 12]]	["....*....", ".........", ".........", "*.......*", ".........", ".........", ".........", ".........", "*.......*"]
//[[0, 1, -1], [1, 0, -1], [1, 0, 1]]	["*.*"]
//[[1, -1, 0], [2, -1, 0]]	["*"]
//[[1, -1, 0], [2, -1, 0], [4, -1, 0]]	["*"]
//입출력 예 설명
//입출력 예 #1
//
//문제 예시와 같습니다.
//
//입출력 예 #2
//
//직선 y = 1, x = 1, x = -1는 다음과 같습니다.
//RisingStarGraphTC2.png
//
//(-1, 1), (1, 1) 에서 교점이 발생합니다.
//
//따라서 정답은
//
//"*.*"
//입니다.
//
//입출력 예 #3
//
//직선 y = x, y = 2x는 다음과 같습니다.
//
//RisingStarGraphTC3.png
//
//(0, 0) 에서 교점이 발생합니다.
//
//따라서 정답은
//
//"*"
//입니다.
//
//입출력 예 #4
//
//직선 y = x, y = 2x, y = 4x는 다음과 같습니다.
//
//RisingStarGraphTC4.png
//
//(0, 0) 에서 교점이 발생합니다.
//
//따라서 정답은
//
//"*"
//입니다.
//
//참고 사항
//Ax + By + E = 0
//Cx + Dy + F = 0
//두 직선의 교점이 유일하게 존재할 경우, 그 교점은 다음과 같습니다.
//
//RisingStarExpression.png
//
//또, AD - BC = 0인 경우 두 직선은 평행 또는 일치합니다.

fun main() {
    Solution87377().solution(
        arrayOf(
            intArrayOf(2, -1, 4),
            intArrayOf(-2, -1, 4),
            intArrayOf(0, -1, 1),
            intArrayOf(5, -8, -12),
            intArrayOf(5, 8, 12)
        )
    ).forEach { println(it) }
}


class Solution87377() {


    // ax + by + c = 0
    // dx + ey + f = 0

    //1 y가 1이되게 만든다
    // (a/b)x + y + (c/b) = 0
    // (d/e)x + y + (f/e) = 0
    // (a/b) == (d/e),일진선상에 놓임
    // a*e != d*b
    // x = (c*e-f*b) /(b*e)  /(a*e-d*b) * (b*e) = (c*e-f*b) /(a*e-d*b)

    // 2 x가 1이 되게 만든다
    // a*e != d*b
    // y = (c*d-f*a) /(b*d-e*a)

    // 문제에서는 최소한의 범위로 위치를 구해야하기 때문에 min_x,min_y,max_x,max_y를 구해야합니다.

    fun solution(line: Array<IntArray>): Array<String> {

        val mutableList = mutableListOf<Pair<Long, Long>>()

        var min_x = Long.MAX_VALUE
        var min_y = Long.MAX_VALUE
        var max_x = Long.MIN_VALUE
        var max_y = Long.MIN_VALUE

        for (i in 0 until line.size - 1) {
            for (j in i + 1 until line.size) {
                val m = line[i][0].toLong() * line[j][1] - line[i][1].toLong() * line[j][0]
                if (m != 0L) {//2직선이 평행하지 않을때
                    val x = line[i][2].toLong() * line[j][1] - line[j][2].toLong() * line[i][1]
                    val y = line[i][2].toLong() * line[j][0] - line[j][2].toLong() * line[i][0]
                    if (x % m != 0L || y % m != 0L) continue
                    mutableList.add(Pair(x / m, y / m))
                    val _x = mutableList.last().first
                    val _y = mutableList.last().second
                    if (min_x > _x) min_x = _x
                    if (max_x < _x) max_x = _x
                    if (min_y > _y) min_y = _y
                    if (max_y < _y) max_y = _y
                }
            }
        }

        val x_len = (max_x - min_x + 1).toInt()
        val y_len = (max_y - min_y + 1).toInt()

        val arr = Array(y_len) { BooleanArray(x_len) }
        mutableList.forEach { arr[(it.second - min_y).toInt()][(it.first - min_x).toInt()] = true }

        return Array(y_len) { i1 ->
            buildString {
                arr[y_len - i1 - 1].reversedArray().forEach { i2 ->
                    append(if (i2) '*' else '.')
                }
            }
        }
    }
}