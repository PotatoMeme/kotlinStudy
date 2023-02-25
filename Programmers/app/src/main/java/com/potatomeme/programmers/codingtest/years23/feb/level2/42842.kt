package com.potatomeme.programmers.codingtest.years23.feb.level2


//카펫
//문제 설명
//Leo는 카펫을 사러 갔다가 아래 그림과 같이 중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.
//
//carpet.png
//
//Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 전체 카펫의 크기는 기억하지 못했습니다.
//
//Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.
//
//제한사항
//갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
//노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.
//카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
//입출력 예
//brown	yellow	return
//10	2	[4, 3]
//8	1	[3, 3]
//24	24	[8, 6]
//출처
//
//※ 공지 - 2020년 2월 3일 테스트케이스가 추가되었습니다.
//※ 공지 - 2020년 5월 11일 웹접근성을 고려하여 빨간색을 노란색으로 수정하였습니다.

class Solution42842() {
    // a: 가로  b : 세로
    // * a>=b
    // * a,b>=3(중앙이 노랑)
    // 테두리 한줄은 갈색
    // a*b == brown+yellow
    // brown == 2a + 2b -4
    // brown+yellow <= 2005000
    fun solution(brown: Int, yellow: Int): IntArray {
        var total = brown + yellow
        val list = mutableListOf<Int>()
        var i = 2
        while (true) {
            if (total == 1) {
                break
            }
            if (total % i == 0) {
                total /= i
                list.add(i)
            } else {
                i++
            }
        }

        var answer = IntArray(2)

        fun solve(idx: Int, a: Int, b: Int) {
            if (idx == list.size) {
                if (a >= b && brown == 2 * a + 2 * b - 4) {
                    answer[0] = a
                    answer[1] = b
                }
                return
            }
            solve(idx + 1, a * list[idx], b)
            solve(idx + 1, a, b * list[idx])
        }

        solve(0, 1, 1)

        return answer
    }
}