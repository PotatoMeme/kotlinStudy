package com.potatomeme.baekjoon.July.week_3rd


fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    val year = br.readLine().toInt()
    if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
        write("1")
    } else {
        write("0")
    }
    close()
}

