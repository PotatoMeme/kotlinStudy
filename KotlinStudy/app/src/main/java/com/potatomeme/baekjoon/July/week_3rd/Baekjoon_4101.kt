package com.potatomeme.baekjoon.July.week_3rd

import java.util.*
fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    var A: Int
    var B: Int
    while (true) {
        var st = StringTokenizer(br.readLine())
        A = st.nextToken().toInt()
        B = st.nextToken().toInt()
        if (A == 0 && B == 0) break
        if (A > B) {
            write("Yes\n")
        } else {
            write("No\n")
        }
    }
    close()
}

