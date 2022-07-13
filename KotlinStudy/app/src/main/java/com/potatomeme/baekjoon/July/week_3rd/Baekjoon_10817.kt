package com.potatomeme.baekjoon.July.week_3rd

import java.util.*

fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    val st = StringTokenizer(br.readLine())
    val arr = Array<Int>(3, { st.nextToken().toInt() })
    arr.sort()
    write("${arr[1]}")
    close()
}


