package com.potatomeme.baekjoon.`2023`.january

//https://www.acmicpc.net/problem/24052

//알고리즘 수업 - 삽입 정렬 2
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	512 MB	280	172	150	66.667%
//문제
//오늘도 서준이는 삽입 정렬 수업 조교를 하고 있다. 아빠가 수업한 내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.
//
//N개의 서로 다른 양의 정수가 저장된 배열 A가 있다. 삽입 정렬로 배열 A를 오름차순 정렬할 경우 배열 A의 원소가 K 번 변경된 직후의 배열 A를 출력해 보자.
//
//크기가 N인 배열에 대한 삽입 정렬 의사 코드는 다음과 같다.
//
//insertion_sort(A[1..N]) { # A[1..N]을 오름차순 정렬한다.
//    for i <- 2 to N {
//        loc = i - 1;
//        newItem = A[i];
//
//        # 이 지점에서 A[1..i-1]은 이미 정렬되어 있는 상태
//        while (1 <= loc and newItem < A[loc]) {
//            A[loc + 1] <- A[loc];
//            loc--;
//        }
//        if (loc + 1 != i) then A[loc + 1] = newItem;
//    }
//}
//입력
//첫째 줄에 배열 A의 크기 N(5 ≤ N ≤ 10,000), 변경 횟수 K(1 ≤ K ≤ N2)가 주어진다.
//
//다음 줄에 서로 다른 배열 A의 원소 A1, A2, ..., AN이 주어진다. (1 ≤ Ai ≤ 109)
//
//출력
//K 번 변경이 발생한 직후의 배열 A를 한 줄에 출력한다. 변경 횟수가 K 보다 작으면 -1을 출력한다.
//
//예제 입력 1
//5 7
//4 5 1 3 2
//예제 출력 1
//1 3 4 5 5
//4 5 1 3 2 -> 4 5 5 3 2 -> 4 4 5 3 2 -> 1 4 5 3 2 -> 1 4 5 5 2 -> 1 4 4 5 2 -> 1 3 4 5 2 -> 1 3 4 5 5 -> 1 3 4 4 5 -> 1 3 3 4 5 -> 1 2 3 4 5. 총 10회 변경이 발생하고 일곱 번째 변경 직후 배열 A이 모습은 1 3 4 5 5이다.
//
//예제 입력 2
//5 11
//4 5 1 3 2
//예제 출력 2
//-1
//변경 횟수 10이 K 보다 작으므로 -1을 출력한다.

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (a, k) = readLine().split(" ").map { it.toInt() }
    val arr = IntArray(a)
    readLine().split(" ").forEachIndexed { index, s ->
        arr[index] = s.toInt()
    }
    print(Solution24052().solution(a, k, arr))
}

class Solution24052 {
    fun solution(a: Int, k: Int, arr: IntArray): String {
        var count = 0
        for (i in 1 until a) {
            val temp = arr[i]
            var index = i - 1
            while (index >= 0 && arr[index] > temp) {
                count++
                arr[index + 1] = arr[index]
                if (count == k) return "${arr.joinToString(" ")}"
                index--
            }

            if (i != index+1){
                count++
                arr[index+1] = temp
                if (count == k) return "${arr.joinToString(" ")}"
            }

        }
        return "-1"
    }
}