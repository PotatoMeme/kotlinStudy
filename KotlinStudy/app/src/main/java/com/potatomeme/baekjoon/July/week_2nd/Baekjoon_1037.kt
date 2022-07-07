package com.potatomeme.baekjoon.July.week_2nd

import java.util.*
var min = 1000000
var max = 0
fun main() {
    val sc: Scanner = Scanner(System.`in`)
    var size = sc.nextInt();
    while (size -->0){
        check(sc.nextInt())
    }
    print(min* max)
}
fun check( num : Int){
    min = if (min > num ) num else min
    max = if (max > num ) max else num
}
