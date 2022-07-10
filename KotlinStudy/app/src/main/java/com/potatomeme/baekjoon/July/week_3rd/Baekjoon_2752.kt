package com.potatomeme.baekjoon.July.week_3rd

import java.util.*

fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    val st = StringTokenizer(br.readLine())
    val list = mutableListOf<Int>()
    repeat(3){
        list.add(st.nextToken().toInt())
    }
    list.sort()
    for ( i in list){
        write("${i} ")
    }
    close()
}

