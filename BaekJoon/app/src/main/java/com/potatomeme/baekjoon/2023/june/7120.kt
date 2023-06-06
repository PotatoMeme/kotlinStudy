package com.potatomeme.baekjoon.`2023`.june

//https://www.acmicpc.net/problem/7120

//String 다국어
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	128 MB	225	171	156	77.228%
//문제
//It sometimes happens that a button on the computer keyboard sticks and then in the printed text there are more than one identical letters. For example, the word "piano" can change into "ppppppiaanooooo".
//
//Your task is to write a program that corrects these errors: finds all the places within the given string, where identical letters follow each other and replaces them with one letter- that is, erases all the other identical letters and adds the remaining part of the string onto the end of the one remaining letter.
//
//입력
//The first line of the input is a string containing only lowercase latin letters. The string is at most 250 symbols in length.
//
//출력
//Output the corrected string in the first line of the output.
//
//예제 입력 1
//ppppppiaanooooo
//예제 출력 1
//piano


fun main() = with(System.`in`.bufferedReader()) {

    val line = readLine()
    //TO REGEX
    val regex = "(.)\\1+".toRegex()
    print(line.replace(regex) { "${it.value[0]}" })
    // JUST SOLVE
    var lastChar = ' '
    print(buildString {
        line.forEach {
            if (it != lastChar) {
                append(it)
                lastChar = it
            }
        }
    })
}