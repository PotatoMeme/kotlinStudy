package com.potatomeme.baekjoon.July.week_3rd


fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    var case = br.readLine().toInt()
    repeat(case){
        var num = br.readLine().toInt()
        write("Pairs for ${num}:")
        for ( i in 1 .. num/2 ){
            if (num == i+i) break
            if ( i>1)write(",")
            write(" ${i} ${num - i}")
        }
        write("\n")
    }
    close()
}

