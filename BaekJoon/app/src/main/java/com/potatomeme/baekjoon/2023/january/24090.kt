package com.potatomeme.baekjoon.`2023`.january

import java.util.Collections.swap

//https://www.acmicpc.net/problem/24090

//알고리즘 수업 - 퀵 정렬 1
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	512 MB	552	99	79	21.467%
//문제
//오늘도 서준이는 퀵 정렬 수업 조교를 하고 있다. 아빠가 수업한 내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.
//
//N개의 서로 다른 양의 정수가 저장된 배열 A가 있다. 퀵 정렬로 배열 A를 오름차순 정렬할 경우 배열 A에 K 번째 교환되는 수를 구해서 우리 서준이를 도와주자.
//
//크기가 N인 배열에 대한 퀵 정렬 의사 코드는 다음과 같다.
//
//quick_sort(A[p..r]) { # A[p..r]을 오름차순 정렬한다.
//    if (p < r) then {
//        q <- partition(A, p, r);  # 분할
//        quick_sort(A, p, q - 1);  # 왼쪽 부분 배열 정렬
//        quick_sort(A, q + 1, r);  # 오른쪽 부분 배열 정렬
//    }
//}
//
//partition(A[], p, r) {
//    x <- A[r];    # 기준원소
//    i <- p - 1;   # i는 x보다 작거나 작은 원소들의 끝지점
//    for j <- p to r - 1  # j는 아직 정해지지 않은 원소들의 시작 지점
//        if (A[j] ≤ x) then A[++i] <-> A[j]; # i값 증가 후 A[i] <-> A[j] 교환
//    if (i + 1 != r) then A[i + 1] <-> A[r]; # i + 1과 r이 서로 다르면 A[i + 1]과 A[r]을 교환
//    return i + 1;
//}
//입력
//첫째 줄에 배열 A의 크기 N(5 ≤ N ≤ 10,000), 교환 횟수 K(1 ≤ K ≤ 108)가 주어진다.
//
//다음 줄에 서로 다른 배열 A의 원소 A1, A2, ..., AN이 주어진다. (1 ≤ Ai ≤ 109)
//
//출력
//K 번째 교환되는 두 개의 수를 작은 수부터 한 줄에 출력한다. 교환 횟수가 K 보다 작으면 -1을 출력한다.
//
//예제 입력 1
//5 1
//2 5 1 4 3
//예제 출력 1
//2 2
//2 5 1 4 3(i=0, j=1, A[1]과 A[1]이 교환됨) -> 2 5 1 4 3(i=1, j=2) -> 2 5 1 4 3(i=1, j=3, A[2]와 A[3]이 교환됨) -> 2 1 5 4 3(i=2, j=4) -> 2 1 5 4 3(i=2, j=5, A[3]과 A[5]가 교환됨) -> 2 1 3 4 5(i=0, j=1) -> 2 1 3 4 5(i=0, j=2, A[1]과 A[2]가 교환됨) -> 1 2 3 4 5(i=3, j=4, A[4]와 A[4]가 교환됨) -> 1 2 3 4 5(i=4, j=5) -> 1 2 3 4 5(최종 상태). 총 5회 교환이 발생하고 첫 번째 교환은 2와 2이다.
//
//예제 입력 2
//5 2
//2 5 1 4 3
//예제 출력 2
//1 5
//총 5회 교환이 발생하고 두 번째 교환은 1과 5이다.
//
//예제 입력 3
//5 10
//2 5 1 4 3
//예제 출력 3
//-1
//교환 횟수 5가 K 보다 작으므로 -1을 출력한다.

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (a, k) = readLine().split(" ").map { it.toInt() }
    val arr = IntArray(a)
    readLine().split(" ").forEachIndexed { index, s ->
        arr[index] = s.toInt()
    }
    val solution = Solution24090(k)
    solution.quick_sort(arr, 0, a-1)
    print(solution.result)
}

class Solution24090(val k: Int) {
    var count = 0
    var result = "-1"

    fun quick_sort(arr: IntArray, p: Int, r: Int) {
        if (p < r) {
            val q = partition(arr, p, r)
            quick_sort(arr, p, q - 1)
            quick_sort(arr, q + 1, r)
        }
    }

    fun partition(arr: IntArray, p: Int, r: Int): Int {
        val x = arr[r]
        var i = p - 1
        for (j in p until r) {
            if (arr[j] <= x) arr.swap(++i, j)
        }
        if (i + 1 != r) arr.swap(i + 1, r)
        return i + 1
    }

    private fun IntArray.swap(i: Int, j: Int) {
        count++
        if (count == k) result = "${this[j]} ${this[i]}"
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }

// 퀵정렬
//    fun solution(arr: IntArray, left: Int, right: Int) {
//        if (left >= right) return
//        val pivot = arr[right]
//        var sortedIndex = left
//        for (i in left until right) {
//            if (arr[i] <= pivot) {
//                arr.swap(i, sortedIndex)
//                println(arr.joinToString(" "))
//                sortedIndex++
//            }
//        }
//        arr.swap(sortedIndex, right)
//        println(arr.joinToString(" "))
//        solution(arr, left, sortedIndex - 1)
//        solution(arr, sortedIndex + 1, right)
//
//    }
//

}