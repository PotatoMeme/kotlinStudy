package com.potatomeme.programmers.codingtest.years23.march.level2


//두 큐 합 같게 만들기
//문제 설명
//길이가 같은 두 개의 큐가 주어집니다. 하나의 큐를 골라 원소를 추출(pop)하고, 추출된 원소를 다른 큐에 집어넣는(insert) 작업을 통해 각 큐의 원소 합이 같도록 만들려고 합니다. 이때 필요한 작업의 최소 횟수를 구하고자 합니다. 한 번의 pop과 한 번의 insert를 합쳐서 작업을 1회 수행한 것으로 간주합니다.
//
//큐는 먼저 집어넣은 원소가 먼저 나오는 구조입니다. 이 문제에서는 큐를 배열로 표현하며, 원소가 배열 앞쪽에 있을수록 먼저 집어넣은 원소임을 의미합니다. 즉, pop을 하면 배열의 첫 번째 원소가 추출되며, insert를 하면 배열의 끝에 원소가 추가됩니다. 예를 들어 큐 [1, 2, 3, 4]가 주어졌을 때, pop을 하면 맨 앞에 있는 원소 1이 추출되어 [2, 3, 4]가 되며, 이어서 5를 insert하면 [2, 3, 4, 5]가 됩니다.
//
//다음은 두 큐를 나타내는 예시입니다.
//
//queue1 = [3, 2, 7, 2]
//queue2 = [4, 6, 5, 1]
//두 큐에 담긴 모든 원소의 합은 30입니다. 따라서, 각 큐의 합을 15로 만들어야 합니다. 예를 들어, 다음과 같이 2가지 방법이 있습니다.
//
//queue2의 4, 6, 5를 순서대로 추출하여 queue1에 추가한 뒤, queue1의 3, 2, 7, 2를 순서대로 추출하여 queue2에 추가합니다. 그 결과 queue1은 [4, 6, 5], queue2는 [1, 3, 2, 7, 2]가 되며, 각 큐의 원소 합은 15로 같습니다. 이 방법은 작업을 7번 수행합니다.
//queue1에서 3을 추출하여 queue2에 추가합니다. 그리고 queue2에서 4를 추출하여 queue1에 추가합니다. 그 결과 queue1은 [2, 7, 2, 4], queue2는 [6, 5, 1, 3]가 되며, 각 큐의 원소 합은 15로 같습니다. 이 방법은 작업을 2번만 수행하며, 이보다 적은 횟수로 목표를 달성할 수 없습니다.
//따라서 각 큐의 원소 합을 같게 만들기 위해 필요한 작업의 최소 횟수는 2입니다.
//
//길이가 같은 두 개의 큐를 나타내는 정수 배열 queue1, queue2가 매개변수로 주어집니다. 각 큐의 원소 합을 같게 만들기 위해 필요한 작업의 최소 횟수를 return 하도록 solution 함수를 완성해주세요. 단, 어떤 방법으로도 각 큐의 원소 합을 같게 만들 수 없는 경우, -1을 return 해주세요.
//
//제한사항
//1 ≤ queue1의 길이 = queue2의 길이 ≤ 300,000
//1 ≤ queue1의 원소, queue2의 원소 ≤ 109
//주의: 언어에 따라 합 계산 과정 중 산술 오버플로우 발생 가능성이 있으므로 long type 고려가 필요합니다.
//입출력 예
//queue1	queue2	result
//[3, 2, 7, 2]	[4, 6, 5, 1]	2
//[1, 2, 1, 2]	[1, 10, 1, 2]	7
//[1, 1]	[1, 5]	-1
//입출력 예 설명
//입출력 예 #1
//
//문제 예시와 같습니다.
//
//입출력 예 #2
//
//두 큐에 담긴 모든 원소의 합은 20입니다. 따라서, 각 큐의 합을 10으로 만들어야 합니다. queue2에서 1, 10을 순서대로 추출하여 queue1에 추가하고, queue1에서 1, 2, 1, 2와 1(queue2으로부터 받은 원소)을 순서대로 추출하여 queue2에 추가합니다. 그 결과 queue1은 [10], queue2는 [1, 2, 1, 2, 1, 2, 1]가 되며, 각 큐의 원소 합은 10으로 같습니다. 이때 작업 횟수는 7회이며, 이보다 적은 횟수로 목표를 달성하는 방법은 없습니다. 따라서 7를 return 합니다.
//
//입출력 예 #3
//
//어떤 방법을 쓰더라도 각 큐의 원소 합을 같게 만들 수 없습니다. 따라서 -1을 return 합니다.


fun main() {
    println(Solution118667().solution(intArrayOf(1, 1), intArrayOf(1, 5)))
}

class Solution118667() {

    // 1안
    // 큐 사용하지않고 풀어보기
    // 총합구하기 해당값이 홀수일경우 -1을 리턴
    // queue1 + queue2 + queue1 + queue2 구조에서
    // idx1 과 idx2를 가지고
    // idx1 과 idx2 범위의 sum 값 queue1 과 queue2의 총합의 절반 보다클경우 idx1.inc() 작을경우 idx2.inc() 같다면 cnt 값을 리턴
    // 만약 idx2의 값이 queue1.size * 2 + queue2.size * 2 - 1 과 같아질 경우 -1을 리턴
    // idx1의 값이 idx2의 값보다 커진경우 -1을 리턴
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        var sum: Long = queue1.sum().toLong()
        val totalSum: Long = sum + queue2.sum()
        if (totalSum % 2 == 1L) return -1
        val halfSum = totalSum / 2

        var idx1 = 0
        var idx2 = queue1.size - 1

        val grade1 = queue1.size
        val grade2 = grade1 + queue2.size
        val grade3 = grade2 + queue1.size
        val grade4 = grade3 + queue2.size


        var cnt = 0

        while (true) {
            if (sum < halfSum) {
                idx2++
                if (idx2 < grade2) {
                    sum += queue2[idx2 - grade1]
                } else if (idx2 < grade3) {
                    sum += queue1[idx2 - grade2]
                } else if (idx2 < grade4) {
                    sum += queue2[idx2 - grade3]
                } else {
                    cnt = -1
                    break
                }
                cnt++
            } else if (sum > halfSum) {
                if (idx1 < grade1) {
                    sum -= queue1[idx1]
                } else if (idx1 < grade2) {
                    sum -= queue2[idx1 - grade1]
                } else if (idx1 < grade3) {
                    sum -= queue1[idx1 - grade2]
                } else if (idx1 < grade4) {
                    sum -= queue2[idx1 - grade3]
                }
                idx1++
                cnt++
            } else {
                break
            }
        }
        return cnt
    }
}