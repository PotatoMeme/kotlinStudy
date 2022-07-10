package com.potatomeme.baekjoon.July.week_3rd

import java.util.*


fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    var st = StringTokenizer(br.readLine())
    write("${st.nextToken().toInt() * st.nextToken().toInt()+st.nextToken().toInt() * st.nextToken().toInt()}\n")
    close()
}

