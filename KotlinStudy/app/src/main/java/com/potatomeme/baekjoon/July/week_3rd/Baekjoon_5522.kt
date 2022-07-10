package com.potatomeme.baekjoon.July.week_3rd


fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    var sum = 0
    repeat(5){
        sum += br.readLine().toInt()
    }
    write(sum.toString())
    close()
}

