package com.potatomeme.baekjoon.July.week_3rd

import java.util.*

fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    val st = StringTokenizer(br.readLine())
    var sum = 0
    while (st.hasMoreTokens()){
        sum += st.nextToken().toInt()
    }
    write(sum.toString())
    close()
}

