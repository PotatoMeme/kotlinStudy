package com.potatomeme.programmers.codingtest.years23.april.level0


//카운트 다운
//문제 설명
//정수 start와 end가 주어질 때, start에서 end까지 1씩 감소하는 수들을 차례로 담은 리스트를 return하도록 solution 함수를 완성해주세요.
//
//제한사항
//0 ≤ end ≤ start ≤ 50
//입출력 예
//start	end	result
//10	3	[10, 9, 8, 7, 6, 5, 4, 3]
//입출력 예 설명
//입출력 예 #1
//
//10부터 3까지 1씩 감소하는 수를 담은 리스트는 [10, 9, 8, 7, 6, 5, 4, 3]입니다.

class Solution181899() {
    fun solution(start: Int, end: Int) = (start downTo end).toList()
}

