package com.potatomeme.baekjoon.`2023`.february

import java.util.StringTokenizer


//https://www.acmicpc.net/problem/25206

//너의 평점은 스페셜 저지
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	1024 MB	840	563	519	69.292%
//문제
//인하대학교 컴퓨터공학과를 졸업하기 위해서는, 전공평점이 3.3 이상이거나 졸업고사를 통과해야 한다. 그런데 아뿔싸, 치훈이는 깜빡하고 졸업고사를 응시하지 않았다는 사실을 깨달았다!
//
//치훈이의 전공평점을 계산해주는 프로그램을 작성해보자.
//
//전공평점은 전공과목별 (학점 × 과목평점)의 합을 학점의 총합으로 나눈 값이다.
//
//인하대학교 컴퓨터공학과의 등급에 따른 과목평점은 다음 표와 같다.
//
//A+	4.5
//A0	4.0
//B+	3.5
//B0	3.0
//C+	2.5
//C0	2.0
//D+	1.5
//D0	1.0
//F	0.0
//P/F 과목의 경우 등급이 P또는 F로 표시되는데, 등급이 P인 과목은 계산에서 제외해야 한다.
//
//과연 치훈이는 무사히 졸업할 수 있을까?
//
//입력
//20줄에 걸쳐 치훈이가 수강한 전공과목의 과목명, 학점, 등급이 공백으로 구분되어 주어진다.
//
//출력
//치훈이의 전공평점을 출력한다.
//
//정답과의 절대오차 또는 상대오차가
//\(10^{-4}\) 이하이면 정답으로 인정한다.
//
//제한
//1 ≤ 과목명의 길이 ≤ 50
//과목명은 알파벳 대소문자 또는 숫자로만 이루어져 있으며, 띄어쓰기 없이 주어진다. 입력으로 주어지는 모든 과목명은 서로 다르다.
//학점은 1.0,2.0,3.0,4.0중 하나이다.
//등급은 A+,A0,B+,B0,C+,C0,D+,D0,F,P중 하나이다.
//적어도 한 과목은 등급이 P가 아님이 보장된다.
//예제 입력 1
//ObjectOrientedProgramming1 3.0 A+
//IntroductiontoComputerEngineering 3.0 A+
//ObjectOrientedProgramming2 3.0 A0
//CreativeComputerEngineeringDesign 3.0 A+
//AssemblyLanguage 3.0 A+
//InternetProgramming 3.0 B0
//ApplicationProgramminginJava 3.0 A0
//SystemProgramming 3.0 B0
//OperatingSystem 3.0 B0
//WirelessCommunicationsandNetworking 3.0 C+
//LogicCircuits 3.0 B0
//DataStructure 4.0 A+
//MicroprocessorApplication 3.0 B+
//EmbeddedSoftware 3.0 C0
//ComputerSecurity 3.0 D+
//Database 3.0 C+
//Algorithm 3.0 B0
//CapstoneDesigninCSE 3.0 B+
//CompilerDesign 3.0 D0
//ProblemSolving 4.0 P
//예제 출력 1
//3.284483


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    var sum_ij = 0.0f
    var sum_i = 0.0f
    fun solve(str: String) {
        val st = StringTokenizer(str)
        st.nextToken()
        val i = st.nextToken().toFloat()
        val j = st.nextToken()
        if (j == "P") {
            return
        }
        sum_i += i
        sum_ij += i * when (j) {
            "A+" -> 4.5f
            "A0" -> 4.0f
            "B+" -> 3.5f
            "B0" -> 3.0f
            "C+" -> 2.5f
            "C0" -> 2.0f
            "D+" -> 1.5f
            "D0" -> 1.0f
            else -> 0.0f
        }
    }

    repeat(20) {
        solve(readLine())
    }

    print(sum_ij / sum_i)
}

