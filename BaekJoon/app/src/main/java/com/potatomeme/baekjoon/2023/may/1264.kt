package com.potatomeme.baekjoon.`2023`.may


//https://www.acmicpc.net/problem/1264

//모음의 개수 다국어
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	128 MB	15895	8525	7727	56.262%
//문제
//영문 문장을 입력받아 모음의 개수를 세는 프로그램을 작성하시오. 모음은 'a', 'e', 'i', 'o', 'u'이며 대문자 또는 소문자이다.
//
//입력
//입력은 여러 개의 테스트 케이스로 이루어져 있으며, 각 줄마다 영어 대소문자, ',', '.', '!', '?', 공백으로 이루어진 문장이 주어진다. 각 줄은 최대 255글자로 이루어져 있다.
//
//입력의 끝에는 한 줄에 '#' 한 글자만이 주어진다.
//
//출력
//각 줄마다 모음의 개수를 세서 출력한다.
//
//예제 입력 1
//How are you today?
//Quite well, thank you, how about yourself?
//I live at number twenty four.
//#
//예제 출력 1
//7
//14
//9

fun main() = with(System.`in`.bufferedReader()) {
    //to regex
    fun solveToRegex(): String {
        val regex = "[aeiouAEIOU]".toRegex()
        val sb = StringBuilder()
        while (true) {
            val line = readLine()
            if (line.length == 1 && line == "#") break
            sb.appendLine(regex.findAll(line).count())
        }
        return sb.toString()
    }

    //just solve
    fun justSolve(): String {
        val sb = StringBuilder()
        while (true) {
            val sb = StringBuilder()
            val set = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
            while (true) {
                val line = readLine()
                if (line.length == 1 && line == "#") break
                val count = line.count { it in set }
                sb.appendLine(count)
            }
            print(sb.toString())
        }
        return sb.toString()
    }
    print(solveToRegex())
    //to solve

}



