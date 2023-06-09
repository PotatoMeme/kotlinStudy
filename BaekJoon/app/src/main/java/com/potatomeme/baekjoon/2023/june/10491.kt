package com.potatomeme.baekjoon.`2023`.june

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Scanner


//https://www.acmicpc.net/problem/10491

//Quite a problem 다국어
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	256 MB	514	236	194	48.020%
//문제
//It gets tiring, looking for all ways in which the word ‘problem’ can be used (and mis-used) in the news media. And yet, that’s been your job for several years: looking through news stories for that word. Wouldn’t it be better if you could automate the process?
//
//입력
//Each line of input is one test case. Lines are at most 80 characters long. There are at most 1000 lines of input. Input ends at end of file.
//
//출력
//For each line of input, print yes if the line contains ‘problem’, and no otherwise. Any capitalization of ‘problem’ counts as an occurrence.
//
//예제 입력 1
//Problematic pair programming
//"There’s a joke that pairs, like fish and house guests, go
//rotten after three days," said Zach Brock, an engineering
//manager. Working out problems with a pairing partner can be
//a lot like working out problems with a significant other.
//During one recent rough patch, Jamie Kite, a developer, sat
//her partner down for a talk. "Hey, it feels like we’re
//driving in different directions," she recalls saying. "It’s
//like any relationship," Ms. Kite said. "If you don’t talk
//about the problems, it’s not going to work." When those
//timeouts don’t solve the problem, partners can turn to
//on-staff coaches who can help with counseling. "People who
//have been pairing a while, they’ll start acting like old
//married couples," said Marc Phillips, one of the coaches.
//People can be as much of a challenge as writing software.
//(Excerpted from "Computer Programmers Learn Tough Lesson in
//Sharing"; Wall Street Journal, August 27, 2012)
//예제 출력 1
//yes
//no
//no
//yes
//yes
//no
//no
//no
//no
//yes
//yes
//no
//no
//no
//no
//no
//no

fun main() = with(Scanner(System.`in`)) {
    val regex = Regex("problem", RegexOption.IGNORE_CASE)
    while (hasNextLine()) {
        println(if (regex.containsMatchIn(nextLine())) "yes" else "no")
    }
}

