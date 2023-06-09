package com.potatomeme.baekjoon.`2023`.june

import java.lang.StringBuilder
import java.util.*


//https://www.acmicpc.net/problem/10173

//니모를 찾아서 다국어
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	256 MB	3719	1809	1625	52.589%
//문제
//니모에 대한 이미지 검색결과
//
//영어 문장속 숨어있는 니모(Nemo)를 찾아보자. 니모를 찾는데 있어서 대소문자는 중요하지 않다.
//
//입력
//여러 문장이 각 줄로 입력되며, 입력의 마지막에는 "EOI" 입력된다. 한 줄은 최대 80개의 글자로 이루어져 있다.
//
//출력
//숨겨진 니모를 찾으면 “Found”, 못찾으면 “Missing”를 각 줄에 맞게 출력하면 된다.
//
//예제 입력 1
//Marlin names this last egg Nemo, a name that Coral liked.
//While attempting to save nemo, Marlin meets Dory,
//a good-hearted and optimistic regal blue tang with short-term memory loss.
//Upon leaving the East Australian Current,(888*%$^&%0928375)Marlin and Dory
//NEMO leaves for school and Marlin watches NeMo swim away.
//EOI
//예제 출력 1
//Found
//Found
//Missing
//Missing
//Found

fun main() = with(System.`in`.bufferedReader()) {
    val regex = "[nN][eE][mM][oO]".toRegex()
    val sb = StringBuilder()
    var line = readLine()
    while (!(line.length == 3 && line == "EOI")) {
        sb.appendLine(if (line.contains(regex)) "Found" else "Missing")
        line = readLine()
    }
    print(sb.toString())
}

