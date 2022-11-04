package com.potatomeme.programmers.codingtest.years22.november.level0

//겹치는 선분의 길이
//문제 설명
//빨간색, 초록색, 파란색 선분이 x축 위에 있습니다. 세 선분의 x좌표 시작과 끝이 [[start, end], [start, end], [start, end]] 형태로 들어있는 2차원 배열 lines가 매개변수로 주어질 때, 두 개 이상의 선분이 겹치는 부분의 길이를return 하도록 solution 함수를 완성해보세요.
//
//lines가 [[0, 2], [-3, -1], [-2, 1]]일 때 그림으로 나타내면 다음과 같습니다.
//스크린샷 2022-08-08 오후 5.08.46.png
//
//선분이 두 개 이상 겹친 곳은 [-2, -1], [0, 1]로 2만큼 겹쳐있습니다.
//
//제한사항
//lines의 길이 = 3
//lines의 원소의 길이 = 2
//모든 선분은 길이가 1 이상입니다.
//lines의 원소는 [a, b] 형태이며, a, b는 각각 양 끝점 중 하나입니다.
//-100 ≤ a < b ≤ 100
//입출력 예
//lines	result
//[[0, 1], [2, 5], [3, 9]]	2
//[[-1, 1], [1, 3], [3, 9]]	0
//[[0, 5], [3, 9], [1, 10]]	8
//입출력 예 설명
//입출력 예 #1
//
//초록색과 파란색 선분이 [2, 5], [3, 9]로 [3, 5]만큼 겹쳐있으므로 2를 return 합니다.
//입출력 예 #2
//
//겹친 선분이 없으므로 0을 return 합니다.
//입출력 예 #3
//
//빨간색과 초록색 선분 [3, 5]부분이 겹칩니다.
//빨간색과 파란색 선분 [1, 5]부분이 겹칩니다.
//초록색과 파란색 선분이 [3, 9]부분 겹칩니다.
//따라서 8을 return 합니다.

//

class Solution120876 {
    fun solution_try1(lines: Array<IntArray>): Int {
        val range =
            ((lines[0][0] until lines[0][1]).toList() + (lines[1][0] until lines[1][1]).toList() + (lines[2][0] until lines[2][1]).toList())
        return range.filter { num ->
            range.count { it == num } > 1
        }.distinct().size
    }

    fun solution_try2(lines: Array<IntArray>): Int {
        val list1 = (lines[0][0] until  lines[0][1]).intersect(lines[1][0] until  lines[1][1])
        val list2 = (lines[0][0] until  lines[0][1]).intersect(lines[2][0] until  lines[2][1])
        val list3 = (lines[1][0] until  lines[1][1]).intersect(lines[2][0] until  lines[2][1])
        return list1.union(list2).union(list3).size
    }


}


