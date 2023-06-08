package com.potatomeme.baekjoon.`2023`.june

//https://www.acmicpc.net/problem/13022

//늑대와 올바른 단어
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	512 MB	1733	499	389	29.030%
//문제
//다음은 늑대 나라에서 사용하는 올바른 단어에 대한 설명이다.
//
//임의의 양의 정수 n에 대해서, 'w'가 n번 나오고, 그 다음에 'o'가 n번, 그 다음에 'l'이 n번, 그 다음에 'f'가 n번 나온 단어는 올바른 단어이다.
//올바른 단어 두 개를 이은 단어도 올바른 단어이다.
//1번과 2번 조건으로 만들 수 있는 단어만 올바른 단어이다.
//다음은 올바른 단어의 예시이다.
//
//1번 규칙으로 만든 "wolf", "wwoollff", "wwwooolllfff"는 모두 올바른 단어이다.
//2번 규칙으로 만든 "wolfwwoollff"은 올바른 단어이다.
//2번 규칙을 두 번 써서 만든 "wolfwwoollffwolf"은 올바른 단어이다.
//"wfol"은 올바른 단어가 아니다. (순서가 올바르지 않음)
//"wwolfolf"는 올바른 단어가 아니다. (문자열의 중간에 다른 문자열을 집어 넣음)
//"wwwoolllfff"는 올바른 단어가 아니다. (o가 2번 들어갔다)
//입력
//첫째 줄에 단어가 주어진다. 단어는 w, o, l, f로만 이루어져 있으며, 길이는 50을 넘지 않는다.
//
//출력
//입력으로 주어진 단어가 올바른 단어인 경우에는 1을, 아니면 0을 출력한다.
//
//예제 입력 1
//wolf
//예제 출력 1
//1
//예제 입력 2
//wwolfolf
//예제 출력 2
//0


fun main() = with(System.`in`.bufferedReader()) {
    print(if(isItGoodWolf(readLine())) 1 else 0)
}

fun isItGoodWolf(str: String): Boolean {
    var before = str.first()
    if (before != 'w') return false
    var cnt = 1
    var check = 1
    for (i in 1 until str.length) {
        val c = str[i]
        if (c == before) { // 이전과 같은 경우
            cnt++
            if (before == 'w') {
                check++
            } else if (check < cnt) return false // 더 많아질 경우
        } else { // 이전과 같지 않은 경우
            if (cnt != check) return false
            cnt = 1
            if (c == 'w' && before == 'f') check = 1
            else if (!(c == 'o' && before == 'w' || c == 'l' && before == 'o' || c == 'f' && before == 'l')) return false
            before = c
        }
    }
    if (before != 'f' || cnt != check) return false
    return true
}