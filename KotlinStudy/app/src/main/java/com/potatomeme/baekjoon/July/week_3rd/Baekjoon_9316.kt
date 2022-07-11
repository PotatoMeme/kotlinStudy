package com.potatomeme.baekjoon.July.week_3rd


fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    val num = br.readLine().toInt()
    for (i in 1 .. num){
        write("Hello World, Judge ${i}!\n")
    }
    close()
}

