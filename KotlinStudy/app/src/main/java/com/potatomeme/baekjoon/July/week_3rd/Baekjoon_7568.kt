package com.potatomeme.baekjoon.July.week_3rd


fun main() {
    val count = readln().toInt()
    val inputs = Array(count) { readln().split(' ').map { it.toInt() } }

    val output = StringBuilder()
    for (input1 in inputs) {
        var rank = 1
        for(input2 in inputs) {
            if(input2[0] > input1[0] && input2[1] > input1[1]) rank++
        }
        output.append(rank).append(' ')
    }
    println(output)
}

