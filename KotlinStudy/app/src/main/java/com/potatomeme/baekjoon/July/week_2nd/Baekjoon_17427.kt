package com.potatomeme.baekjoon.July.week_2nd

import java.util.*


fun main() {
    val sc: Scanner = Scanner(System.`in`)
    var num = sc.nextInt()
    var sum = 0
    for (i in 1 .. num){
        sum += (num/i)*i
    }
   print(sum)
}
