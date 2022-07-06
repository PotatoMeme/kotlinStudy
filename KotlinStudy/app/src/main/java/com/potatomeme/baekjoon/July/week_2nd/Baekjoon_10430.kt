package com.potatomeme.baekjoon.July.week_2nd

import java.util.*

fun main() {
    val sc: Scanner = Scanner(System.`in`)
    var A = sc.nextInt()
    var B = sc.nextInt()
    var C = sc.nextInt()
    println((A + B) % C)
    println(((A % C) + (B % C)) % C)
    println((A * B) % C)
    println(((A % C) * (B % C)) % C)
}
