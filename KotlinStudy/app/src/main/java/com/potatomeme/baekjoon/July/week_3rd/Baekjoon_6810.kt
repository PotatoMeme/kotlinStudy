package com.potatomeme.baekjoon.July.week_3rd


fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    val A = br.readLine().toInt()
    val B = br.readLine().toInt()
    val C = br.readLine().toInt()
    var bool = true
    var result = 0
    for (i in listOf<Int>(9, 7, 8, 0, 9, 2, 1, 4, 1, 8, A, B, C)) {
        if (bool) {
            result += i
        } else {
            result += i * 3
        }
        bool = !bool
    }
    write("The 1-3-sum is ${result}")
    close()
}

