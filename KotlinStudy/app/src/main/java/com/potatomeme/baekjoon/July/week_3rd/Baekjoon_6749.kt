package com.potatomeme.baekjoon.July.week_3rd


fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    val A = br.readLine().toInt()
    val B = br.readLine().toInt()
    write("${B - A + B}")
    close()
}

