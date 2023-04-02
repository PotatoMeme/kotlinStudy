package com.potatomeme.baekjoon.`2023`.april


//https://www.acmicpc.net/problem/15439

//Vera and Outfits 다국어
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	256MB	4559	4082	3917	89.695%
//문제
//Vera는 N 상의와 N 바지를 소유하고 있습니다. i번째 상의와 i번째 바지는 1 ≤ i ≤ N에 대해 색상 i를 가지며, 여기서 N개의 색상은 모두 서로 다릅니다.
//
//의상은 상의 1개와 바지 1개로 구성됩니다. Vera는 상의와 하의가 같은 색이 아닌 의상을 좋아합니다.
//
//그녀는 얼마나 많은 다른 의상을 좋아합니까?
//
//입력
//입력 형식은 다음과 같습니다.
//
//N
//제약:
//
//1 ≤ N ≤ 2017
//N은 정수
//출력
//Vera가 좋아하는 다양한 의상의 수를 한 줄로 출력합니다.
//
//예제 입력 1
//1
//예제 출력 1
//0
//예제 입력 2
//2
//예제 출력 2
//2
//예제 입력 3
//5
//예제 출력 3
//20


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    readLine().toInt().let {
        print(it * (it - 1))
    }
}

