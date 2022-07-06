package com.potatomeme.baekjoon.July.week_2nd

import java.util.*

fun main() {
    val sc: Scanner = Scanner(System.`in`)
    while (sc.hasNextInt()){
        println(One(sc.nextInt()))
    }
}

fun One(num : Int):Int{
    var x = 1
    for (i in 1 .. Int.MAX_VALUE){
        x %= num
        x = x *10 +1
        if(x == 1) return i
    }
    return 0
}
