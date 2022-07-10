package com.potatomeme.baekjoon.July.week_3rd

import java.util.*

fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    val st = StringTokenizer(br.readLine())
    val result = st.nextToken().toInt() - st.nextToken().toInt()
    if (result > 0){
        write(">")
    }else if(result == 0){
        write("==")
    }else{
        write("<")
    }
    close()
}

