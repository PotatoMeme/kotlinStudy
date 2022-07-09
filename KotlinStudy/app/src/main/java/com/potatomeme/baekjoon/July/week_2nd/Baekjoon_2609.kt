package com.potatomeme.baekjoon.July.week_2nd

import java.util.*


fun main() = with(System.out.bufferedWriter()) {
    val sc = Scanner(System.`in`)
    var A = sc.nextInt()
    var B = sc.nextInt()
    if (A < B) {
        var temp = A
        A = B
        B = temp
    }// A가 크다
    for (i in B downTo 1) {
        if (A % i == 0 && B % i == 0) {
            write("$i\n")
            break
        }
    }
    for (i in 1..B) {
        if ((A * i) % B == 0) {
            write("${A * i}")
            break
        }
    }
    close()
}
