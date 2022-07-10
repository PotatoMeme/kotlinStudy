package com.potatomeme.baekjoon.July.week_3rd


fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    var i = 0
    while (true) {
        i++
        var num = br.readLine().toInt()
        if (num == 0) break
        write("${i}. ${if (num % 2 == 0) "even" else "odd"} ${num/2}\n")
    }
    close()
}

