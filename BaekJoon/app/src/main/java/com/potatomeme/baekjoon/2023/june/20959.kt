package com.potatomeme.baekjoon.`2023`.june


//https://www.acmicpc.net/problem/20959

//Šifra 다국어
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	512MB	133	103	88	79.279%
//문제
//Knight Borna는 적의 비밀 편지를 해독하려고 합니다. 그는 최근 암호에 사용되는 특별한 종이를 손에 넣었습니다. 종이에는 소문자와 숫자로 구성된 한 단어가 포함되어 있습니다.
//
//비밀 코드는 모든 문자가 공백으로 대체될 때 단어에 나타나는 개별 정수의 수입니다. 정수는 선행 0 없이 기록됩니다.
//
//Borna는 숫자를 잘 다루지 못하기 때문에 당신에게 도움을 요청했습니다.
//
//입력
//첫 번째 줄에는 길이가 1에서 100 사이인 단어가 포함됩니다. 단어에는 소문자와 숫자만 포함됩니다. 그 안의 모든 정수는 최대 3자리입니다.
//
//출력
//비밀 코드를 출력합니다.
//
//예제 입력 1
//abc123abc2a3a1
//예제 출력 1
//4
//예제 입력 2
//Borna123vitez
//예제 출력 2
//1
//예제 입력 3
//as23dkrf23smk1asd23sam9
//예제 출력 3
//3

fun main() = with(System.`in`.bufferedReader()) {
    val line = readLine()
    val checkArr = BooleanArray(1000)
    /*"([0-9]+)".toRegex().findAll(line).toList().forEach {
        checkArr[it.value.toInt()] = true
    }*/
    line.replace("[a-z]".toRegex()," ").split(" ").forEach {
        if (it.isNotBlank())checkArr[it.toInt()] = true
    }
    print(checkArr.count { it })
}

