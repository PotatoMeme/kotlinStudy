package com.potatomeme.baekjoon.`2023`.june


//https://www.acmicpc.net/problem/14906

//스러피
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	512 MB	581	247	158	39.109%
//문제
//스러피(Slurpy)란 다음에서 설명할 어떠한 속성이 존재하는 문자열을 지칭한다. 문자열을 읽어서 스러피가 존재하는지를 판단하는 프로그램을 작성하라.
//
//우선, 스럼프(Slump)는 다음 조건을 만족하는 문자열이다.
//
//첫 번째 문자가 ‘D’ 또는 ‘E’ 이다.
//첫 번째 문자 뒤에는 하나 이상의 ‘F’가 반복되어 연달아 나온다.
//위 2의 조건에서 반복되는 ‘F’ 뒤에는 또 다른 스럼프나 ‘G’가 온다. 따라서 항상 스럼프는 ‘F’ 끝에 오는 스럼프나 ‘G’로 끝난다. 예를 들어, DFFEFFFG는 첫 번째 문자가 ‘D’로 시작하고 두 개의 ‘F’가 연달아 나오며, 또 다른 스럼프 ‘EFFFG’로 끝난다. (똑같은 방식으로 ‘EFFFG’는 스럼프임을 알 수 있다)
//위의 경우가 아니면 스럼프가 아니다.
//그리고 스림프(Slimp)는 다음 조건을 만족하는 문자열을 말한다.
//
//첫 번째 문자는 ‘A’이다.
//두개의 문자로만 된 스림프이라면 두 번째 문자는 ‘H’이다.
//세 개이상의 문자로 된 스림프라면 다음중 하나의 형식을 띈다.
//‘A’ + ‘B’ + 스림프 + ‘C’
//‘A’ + 스럼프 + ‘C’
//스림프는 길이 2이상이며, 위의 경우가 아니면 스림프가 아니다
//마지막으로 스러피는 ‘스림프 + 스럼프’로 구성되는 문자열이라고 정의한다.
//
//예를 들어,
//
//Slumps: DFG, EFG, DFFFFFG, DFDFDFDFG, DFEFFFFFG
//Not Slumps: DFEFF, EFAHG, DEFG, DG, EFFFFDG
//Slimps: AH, ABAHC, ABABAHCC, ADFGC, ADFFFFGC, ABAEFGCC, ADFDFGC
//Not Slimps: ABC, ABAH, DFGC, ABABAHC, SLIMP, ADGC
//Slurpys: AHDFG, ADFGCDFFFFFG, ABAEFGCCDFEFFFFFG
//Not Slurpys: AHDFGA, DFGAH, ABABCC
//입력
//첫 번째 줄에는 입력될 문자열의 개수를 나타내는 10보다 작거나 같은 양의 정수 N이 주어진다. 다음 줄부터 N개의 문자열이 입력된다. 문자열의 길이는 60 이하이며 알파벳 대문자로만 이루어져 있다..
//
//출력
//첫 줄에는 “SLURPYS OUTPUT”을 출력한다. N개의 문자열 입력에 대해서 각 문자열이 스러피인지를 “YES” 또는 “NO”로 표기한다. 마지막으로 ‘END OF OUTPUT”를 출력한다.
//
//예제 입력 1
//2
//AHDFG
//DFGAH
//예제 출력 1
//SLURPYS OUTPUT
//YES
//NO
//END OF OUTPUT

class Solution14906 {
    private var line: String = ""

    private fun isSlump(startIdx: Int): Int {
        var idx = startIdx
        if (idx >= line.length || !(line[idx] == 'D' || line[idx] == 'E')) return -1
        var fCount = 0
        idx++
        while (idx < line.length) {
            when (line[idx]) {
                'D', 'E' -> {
                    if (fCount == 0) return -1
                    fCount = 0
                }

                'F' -> {
                    fCount++
                }

                'G' -> {
                    return if (fCount == 0) -1 else idx
                }
            }
            idx++
        }
        return -1
    }

    private fun isSlimp(startIdx: Int): Int {
        var idx = startIdx
        var beforeChar = line[idx++]
        var isSlump = false
        var isSlimp = false
        if (idx >= line.length || beforeChar != 'A') return -1
        while (idx < line.length) {
            when (line[idx]) {
                'H' -> {
                    return if (beforeChar != 'A' || isSlimp || isSlump) -1 else idx
                }

                'B' -> {
                    if (beforeChar != 'A' || isSlimp || isSlump) return -1
                    beforeChar = 'B'
                }

                'C' -> {
                    if (isSlump || isSlimp) return idx
                    return -1
                }

                else -> {
                    if (isSlimp || isSlump) return -1
                    if (beforeChar == 'B') {
                        val isSlimpIdx = isSlimp(idx)
                        if (isSlimpIdx == -1) return -1 else {
                            isSlimp = true
                            idx = isSlimpIdx
                        }
                    } else if (beforeChar == 'A') {
                        val isSlumpIdx = isSlump(idx)
                        if (isSlumpIdx == -1) return -1 else {
                            isSlump = true
                            idx = isSlumpIdx
                        }
                    } else return -1
                }

            }
            idx++
        }
        return -1
    }

    private fun isSlupy(): Boolean {
        var idx = 0
        idx = isSlimp(idx)
        if (idx == -1) return false
        idx = isSlump(idx + 1)
        if (idx != line.length - 1) return false
        return true
    }

    fun solution(str: String): String {
        line = str
        return if (isSlupy()) "YES" else "NO"
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val solution14906 = Solution14906()
    print(
        buildString {
            appendLine("SLURPYS OUTPUT")
            repeat(readLine().toInt()) {
                appendLine(solution14906.solution(readLine()))
            }
            appendLine("END OF OUTPUT")
        }
    )
}