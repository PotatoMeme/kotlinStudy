package com.potatomeme.baekjoon.July.week_3rd

fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    for (i in br.readLine().toInt() downTo 1) {
        write("${i}\n")
    }
    close()
}