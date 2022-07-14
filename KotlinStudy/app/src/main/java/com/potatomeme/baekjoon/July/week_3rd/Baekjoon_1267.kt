package com.potatomeme.baekjoon.July.week_3rd

import kotlin.math.ceil

fun main() {
    val case = readln().toInt()
    val list = readln().split(' ').map { it.toInt() }
    var Y = 0.0f
    var M = 0.0f
    var check_Y = false
    var check_M = false
    var result = 0
    for (i in 0 until case) {
        M += ceil((list[i]+1) / 60.toFloat()) * 15
        Y += ceil((list[i]+1) / 30.toFloat()) * 10
    }
    if (M == Y){
        result = Y.toInt()
        check_Y = true
        check_M = true
    }else if (M > Y){
        result = Y.toInt()
        check_Y = true
    }else{
        result = M.toInt()
        check_M = true
    }
    print("${if (check_Y) "Y " else ""}${if (check_M) "M " else ""}$result")
}

