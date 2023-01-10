package com.potatomeme.baekjoon.`2023`.january

//https://www.acmicpc.net/problem/23969

//알고리즘 수업 - 버블 정렬 2
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	512 MB	472	242	227	55.366%
//문제
//오늘도 서준이는 버블 정렬 수업 조교를 하고 있다. 아빠가 수업한 내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.
//
//N개의 서로 다른 양의 정수가 저장된 배열 A가 있다. 버블 정렬로 배열 A를 오름차순 정렬할 경우 K 번 교환이 발생한 직후의 배열 A를 출력해 보자.
//
//크기가 N인 배열에 대한 버블 정렬 의사 코드는 다음과 같다.
//
//bubble_sort(A[1..N]) { # A[1..N]을 오름차순 정렬한다.
//    for last <- N downto 2
//        for i <- 1 to last - 1
//            if (A[i] > A[i + 1]) then A[i] <-> A[i + 1]  # 원소 교환
//}
//입력
//첫째 줄에 배열 A의 크기 N(5 ≤ N ≤ 10,000), 교환 횟수 K(1 ≤ K ≤ N2)가 주어진다.
//
//다음 줄에 서로 다른 배열 A의 원소 A1, A2, ..., AN이 주어진다. (1 ≤ Ai ≤ 109)
//
//출력
//K 번 교환이 발생한 직후의 배열 A를 한 줄에 출력한다. 교환 횟수가 K 보다 작으면 -1을 출력한다.
//
//예제 입력 1
//6 10
//4 6 5 1 3 2
//예제 출력 1
//1 3 2 4 5 6
//4 6 5 1 3 2 -> 4 5 6 1 3 2 -> 4 5 1 6 3 2 -> 4 5 1 3 6 2 -> 4 5 1 3 2 6 -> 4 1 5 3 2 6 -> 4 1 3 5 2 6 -> 4 1 3 2 5 6 -> 1 4 3 2 5 6 -> 1 3 4 2 5 6 -> 1 3 2 4 5 6 -> 1 2 3 4 5 6. 총 11회 교환이 발생하고 열 번째 교환 직후 배열 A의 모습은 1 3 2 4 5 6이다.
//
//예제 입력 2
//6 12
//4 6 5 1 3 2
//예제 출력 2
//-1
//교환 횟수 11이 K 보다 작으므로 -1을 출력한다.

fun main() = with(System.`in`.bufferedReader()) {
    val (n,k) = readLine().split(" ").map { it.toInt() }
    val arr = IntArray(n)
    readLine().split(" ").forEachIndexed { index, s ->
        arr[index] = s.toInt()
    }
    print(Solution23969().solution(n,k,arr))
}

class Solution23969() {
    fun solution(n:Int,k:Int,arr:IntArray) : String{
        var count = 0
        for (i in 0 until n-1){
            for (j in 1 until n-i){
                if (arr[j-1] > arr[j]){
                    count++
                    val temp = arr[j-1]
                    arr[j-1] = arr[j]
                    arr[j] = temp
                    if (count == k) return arr.joinToString(" ")
                }
            }
        }
        return "-1"
    }
}