package com.potatomeme.programmers.codingtest.years22.november.level0

//등수 매기기
//문제 설명
//영어 점수와 수학 점수의 평균 점수를 기준으로 학생들의 등수를 매기려고 합니다. 영어 점수와 수학 점수를 담은 2차원 정수 배열 score가 주어질 때, 영어 점수와 수학 점수의 평균을 기준으로 매긴 등수를 담은 배열을 return하도록 solution 함수를 완성해주세요.
//
//제한사항
//0 ≤ score[0], score[1] ≤ 100
//1 ≤ score의 길이 ≤ 10
//score의 원소 길이는 2입니다.
//score는 중복된 원소를 갖지 않습니다.
//입출력 예
//score	result
//[[80, 70], [90, 50], [40, 70], [50, 80]]	[1, 2, 4, 3]
//[[80, 70], [70, 80], [30, 50], [90, 100], [100, 90], [100, 100], [10, 30]]	[4, 4, 6, 2, 2, 1, 7]

//입출력 예 설명
//입출력 예 #1
//
//평균은 각각 75, 70, 55, 65 이므로 등수를 매겨 [1, 2, 4, 3]을 return합니다.
//입출력 예 #2
//
//평균은 각각 75, 75, 40, 95, 95, 100, 20 이므로 [4, 4, 6, 2, 2, 1, 7] 을 return합니다.
//공동 2등이 두 명, 공동 4등이 2명 이므로 3등과 5등은 없습니다.

class Solution120882 {
    fun solution(score: Array<IntArray>): List<Int> {
        return score.map { ints ->
            ints[0] + ints[1]
        }.let { list ->
            val sortedScore = list.sortedDescending()
            var result = MutableList(score.size) { 0 }
            var rank = 1
            var save = -1
            sortedScore.forEach { score ->
                println(score)
                if (save != score) {
                    list.forEachIndexed { index, num ->
                        if (score == num) {
                            result[index] = rank
                        }
                    }
                }
                rank++
                save = score
            }
            result
        }
    }// 평균 16ms

    fun user1Solution(score: Array<IntArray>): List<Int> {
        return score.map(IntArray::average)
            .map { score.map(IntArray::average).sortedDescending().indexOf(it) + 1 }
    }// 평균 20ms

    fun user2Solution(score: Array<IntArray>): List<Int> {
        val scoreList = score.map { it.average() }
        return scoreList.map { curScore ->
            scoreList.count { it > curScore } + 1
        }
    }// 평균 18ms

    fun user3Solution(score: Array<IntArray>): IntArray {
        var answer: IntArray = IntArray(score.size){ 1 }
        for(target in 0..score.lastIndex) {
            val targetScore = score[target][0] + score[target][1]
            for(index in 0..score.lastIndex) {
                val thisScore = score[index][0] + score[index][1]
                if(targetScore < thisScore) {
                    answer[target] = answer[target] + 1
                }
            }
        }
        return answer
    }// 평균 14ms
}