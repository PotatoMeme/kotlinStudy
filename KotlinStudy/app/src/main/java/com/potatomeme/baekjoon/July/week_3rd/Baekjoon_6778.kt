package com.potatomeme.baekjoon.July.week_3rd


fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    val A = br.readLine().toInt()
    val B = br.readLine().toInt()
    if (A >= 3 && B <= 4) {
        write("TroyMartian\n")
    }
    if (A <= 6 && B >= 2){
        write("VladSaturnian\n")
    }
    if (A <= 2 && B <= 3){
        write("GraemeMercurian\n")
    }
    close()
}

