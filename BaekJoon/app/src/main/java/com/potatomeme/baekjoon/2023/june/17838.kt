package com.potatomeme.baekjoon.`2023`.june

import java.io.BufferedReader
import java.io.InputStreamReader

//https://www.acmicpc.net/problem/17838

//커맨드 다국어
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//0.5 초	256 MB	1789	631	546	38.262%
//문제
//평소 헥사던전이라는 비디오 게임을 좋아하는 윤표는 특히 키를 AABBABB로 입력해 사용하는 콤보기를 좋아한다.
//
//게임기에는 키가 무수히 많아, 만들어 낼 수 있는 커맨드 또한 다양하다. 게임에 통달한 윤표는 심심해져서 AABBABB말고도, BBCCBCC, CCDDCDD와 같이 형식은 같으나 구성 문자가 다른 커맨드를 사용해 보았고, 색다른 기술을 사용할 수 있음을 알게 되었다.
//
//이에 윤표는 윤표가 좋아하는 커맨드를 정의하였다.
//
//문자열의 길이는 7이다.
//문자열은 정확히 2가지 종류의 문자로 이루어져 있다.
//AABBABB 형식을 만족한다.
//이에 신이 난 윤표는 커맨드를 생성하는 매크로를 만들었으나, 코딩 실력이 부족하여 윤표가 좋아하는 커맨드만 생성하도록 만들 수는 없었다. 이를 답답하게 지켜본 서윤이는 어떤 커맨드가 윤표가 좋아하는 커맨드인지를 확인하는 프로그램을 만드려 한다.
//
//입력
//첫 줄에 테스트 케이스의 개수 T가 주어진다. (1 ≤ T ≤ 100)
//
//이후 T개의 줄에 길이 N이고 알파벳 대문자로만 이루어진 문자열이 입력된다. N은 10,000보다 작거나 같은 자연수이다.
//
//출력
//T개 각각의 테스트 케이스에 대해 윤표가 좋아하는 커맨드이면 1, 그렇지 않으면 0을 한 줄에 하나씩 출력한다.
//
//예제 입력 1
//1
//AABBABB
//예제 출력 1
//1
//예제 입력 2
//1
//ABBAABB
//예제 출력 2
//0
//예제 입력 3
//1
//ABCAFAGHWWE
//예제 출력 3
//0

fun isFavoriteCommand(command: String): Boolean {
    val pattern = Regex("^(\\w)\\1(\\w)\\2\\1\\2{2}$")
    return pattern.matches(command) && command[0] != command[2]
}

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()

    print(buildString {
        repeat(t) {
            val command = readLine()
            val result = if (isFavoriteCommand(command)) 1 else 0
            appendLine(result)
        }
    })
}