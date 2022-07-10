package com.potatomeme.baekjoon.July.week_3rd

import java.util.*

fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    val num = br.readLine().toInt()
    repeat(num) {
        var st = StringTokenizer(br.readLine())
        var A = st.nextToken().toInt()
        var B = st.nextToken().toInt()
        if (A >= B) {
            write("MMM BRAINS\n")
        } else {
            write("NO BRAINS\n")
        }
    }
    close()
}

