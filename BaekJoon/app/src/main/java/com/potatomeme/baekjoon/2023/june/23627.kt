package com.potatomeme.baekjoon.`2023`.june


//https://www.acmicpc.net/problem/23627

//driip
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//0.5 초	16 MB	967	601	550	65.554%
//문제
//드립이는 "driip"으로 끝나는 문자열은 모두 귀엽다고 생각한다.
//
//다음 문자열들은 드립이가 귀엽다고 생각하는 문자열들의 예시이다. "dogdriip", "catdriip", "driip"
//
//다음 문자열들은 드립이가 귀엽다고 생각하지 않는 문자열들의 예시이다. "dogdrip", "driipcat", "driiiiip"
//
//문자열이 주어지면, 드립이가 주어진 문자열을 귀엽다고 생각하는지 판단하는 프로그램을 작성하자.
//
//입력
//첫째 줄에 문자열 S(1 ≤ |S| ≤ 1,000)가 주어진다. 주어지는 문자열은 영문 소문자로만 이루어져 있다.
//
//출력
//드립이가 생각하기에 주어진 문자열이 귀여우면 "cute", 그렇지 않으면 "not cute"를 출력한다. (따옴표 제외)
//
//예제 입력 1
//dogdriip
//예제 출력 1
//cute
//예제 입력 2
//goricon
//예제 출력 2
//not cute
//예제 입력 3
//h
//예제 출력 3
//not cute

fun main() = with(System.`in`.bufferedReader()) {
    val line = readLine()
    //print(if (line.endsWith("driip")) "cute" else "not cute")
    print(if (line.matches("^.*driip$".toRegex())) "cute" else "not cute")
}

