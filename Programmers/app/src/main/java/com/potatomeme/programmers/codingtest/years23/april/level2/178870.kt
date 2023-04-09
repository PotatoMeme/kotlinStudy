package com.potatomeme.programmers.codingtest.years23.april.level1


//연속된 부분 수열의 합
//문제 설명
//비내림차순으로 정렬된 수열이 주어질 때, 다음 조건을 만족하는 부분 수열을 찾으려고 합니다.
//
//기존 수열에서 임의의 두 인덱스의 원소와 그 사이의 원소를 모두 포함하는 부분 수열이어야 합니다.
//부분 수열의 합은 k입니다.
//합이 k인 부분 수열이 여러 개인 경우 길이가 짧은 수열을 찾습니다.
//길이가 짧은 수열이 여러 개인 경우 앞쪽(시작 인덱스가 작은)에 나오는 수열을 찾습니다.
//수열을 나타내는 정수 배열 sequence와 부분 수열의 합을 나타내는 정수 k가 매개변수로 주어질 때, 위 조건을 만족하는 부분 수열의 시작 인덱스와 마지막 인덱스를 배열에 담아 return 하는 solution 함수를 완성해주세요. 이때 수열의 인덱스는 0부터 시작합니다.
//
//제한사항
//5 ≤ sequence의 길이 ≤ 1,000,000
//1 ≤ sequence의 원소 ≤ 1,000
//sequence는 비내림차순으로 정렬되어 있습니다.
//5 ≤ k ≤ 1,000,000,000
//k는 항상 sequence의 부분 수열로 만들 수 있는 값입니다.
//입출력 예
//sequence	k	result
//[1, 2, 3, 4, 5]	7	[2, 3]
//[1, 1, 1, 2, 3, 4, 5]	5	[6, 6]
//[2, 2, 2, 2, 2]	6	[0, 2]
//입출력 예 설명
//입출력 예 #1
//
//[1, 2, 3, 4, 5]에서 합이 7인 연속된 부분 수열은 [3, 4]뿐이므로 해당 수열의 시작 인덱스인 2와 마지막 인덱스 3을 배열에 담아 [2, 3]을 반환합니다.
//
//입출력 예 #2
//
//[1, 1, 1, 2, 3, 4, 5]에서 합이 5인 연속된 부분 수열은 [1, 1, 1, 2], [2, 3], [5]가 있습니다. 이 중 [5]의 길이가 제일 짧으므로 해당 수열의 시작 인덱스와 마지막 인덱스를 담은 [6, 6]을 반환합니다.
//
//입출력 예 #3
//
//[2, 2, 2, 2, 2]에서 합이 6인 연속된 부분 수열은 [2, 2, 2]로 3가지 경우가 있는데, 길이가 짧은 수열이 여러 개인 경우 앞쪽에 나온 수열을 찾으므로 [0, 2]를 반환합니다.

fun main(){
    Solution178870().solution(intArrayOf(1, 1, 1, 2, 3, 4, 5),5)
}

class Solution178870() {

    //1안
    fun solution(sequence: IntArray, k: Int): IntArray {
        var sum = sequence[0]
        var fIdx = 0
        var lIdx = 0
        var flLen = Int.MAX_VALUE

        val answer = IntArray(2) { 0 }
        while (true){
            if (sum == k && flLen > (lIdx - fIdx)) {
                flLen = lIdx - fIdx
                answer[0] = fIdx
                answer[1] = lIdx
            }

            if (sum > k) {
                sum -= sequence[fIdx++]
            } else  {
                lIdx++
                if (lIdx == sequence.size) break
                sum += sequence[lIdx]
            }
        }

        println(answer.joinToString (" "))
        return answer
    }


}