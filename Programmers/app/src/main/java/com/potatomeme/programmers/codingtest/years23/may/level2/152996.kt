package com.potatomeme.programmers.codingtest.years23.may.level2


//시소 짝꿍
//문제 설명
//어느 공원 놀이터에는 시소가 하나 설치되어 있습니다. 이 시소는 중심으로부터 2(m), 3(m), 4(m) 거리의 지점에 좌석이 하나씩 있습니다.
//이 시소를 두 명이 마주 보고 탄다고 할 때, 시소가 평형인 상태에서 각각에 의해 시소에 걸리는 토크의 크기가 서로 상쇄되어 완전한 균형을 이룰 수 있다면 그 두 사람을 시소 짝꿍이라고 합니다. 즉, 탑승한 사람의 무게와 시소 축과 좌석 간의 거리의 곱이 양쪽 다 같다면 시소 짝꿍이라고 할 수 있습니다.
//사람들의 몸무게 목록 weights이 주어질 때, 시소 짝꿍이 몇 쌍 존재하는지 구하여 return 하도록 solution 함수를 완성해주세요.
//
//제한 사항
//2 ≤ weights의 길이 ≤ 100,000
//100 ≤ weights[i] ≤ 1,000
//몸무게 단위는 N(뉴턴)으로 주어집니다.
//몸무게는 모두 정수입니다.
//입출력 예
//weights	result
//[100,180,360,100,270]	4
//입출력 예 설명
//{100, 100} 은 서로 같은 거리에 마주보고 앉으면 균형을 이룹니다.
//{180, 360} 은 각각 4(m), 2(m) 거리에 마주보고 앉으면 균형을 이룹니다.
//{180, 270} 은 각각 3(m), 2(m) 거리에 마주보고 앉으면 균형을 이룹니다.
//{270, 360} 은 각각 4(m), 3(m) 거리에 마주보고 앉으면 균형을 이룹니다.

fun main() {
    println(Solution152996().solution(intArrayOf(100, 180, 360, 100, 270)))
}

class Solution152996 {

    fun solution(weights: IntArray): Long {
        val sortedWeight = weights.sorted()
        var cnt: Long = 0
        var tempCnt = 0
        for (i in 0 until sortedWeight.lastIndex) {
            if (i != 0 && sortedWeight[i - 1] == sortedWeight[i]) {
                cnt += --tempCnt
                continue
            }
            tempCnt = 0
            j@ for (j in i + 1 until sortedWeight.size) {
                if (sortedWeight[i] * 2 < sortedWeight[j]) break@j
                if (isRight(sortedWeight[i], sortedWeight[j])) tempCnt++
            }
            cnt += tempCnt
        }
        return cnt
    } // time out 해결

    fun solution2(weights: IntArray): Long {
        val weightMap: MutableMap<Int, Int> = mutableMapOf()
        weights.forEach { weightMap[it] = (weightMap[it] ?: 0) + 1 }
        val weightList = weightMap.toList().sortedBy { it.first }

        var cnt: Long = 0
        for (i in 0 until weightList.lastIndex) {
            var tempCnt = 0L
            j@ for (j in i + 1 until weightList.size) {
                // 2배보다 커지는 경우 내부 반복문 종료
                if (weightList[i].first * 2 < weightList[j].first) break@j
                if (isRight(weightList[i].first, weightList[j].first)) { // 시소 조건에 맞는 경우
                    tempCnt += weightList[j].second
                }
            }
            //cnt += (subCnt+0) + (subCnt+1) + ... + (subCnt+(n - 1))
            //cnt += subCnt * n + (n-1)*n/2
            val n: Long = weightList[i].second.toLong()
            cnt += tempCnt * n + (n - 1) * n / 2
        }
        return cnt
    }//map 으로 풀기기
    // 2 ~ 15 실패

    // * n1 > n2
    private fun isRight(n1: Int, n2: Int): Boolean {
        if (n1 == n2) return true // 2 2
        if (n1 % 2 == 0 && n1 * 3 == n2 * 2) return true // 2 3
        if (n1 * 2 == n2) return true // 2 4
        if (n1 % 3 == 0 && n1 * 4 == n2 * 3) return true // 3 4
        return false
    }
}