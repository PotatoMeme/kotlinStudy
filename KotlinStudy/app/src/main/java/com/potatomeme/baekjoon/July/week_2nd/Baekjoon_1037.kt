package com.potatomeme.baekjoon.July.week_2nd

import java.util.*

var baekjoon1037 = Baekjoon_1037(min = 1000000, max = 0)
fun main() {
    val sc: Scanner = Scanner(System.`in`)
    var size = sc.nextInt();
    while (size-- > 0) {
        baekjoon1037.check(sc.nextInt())
    }
    print(baekjoon1037.result())
}

class Baekjoon_1037(var min: Int, var max: Int) {
    fun check(num: Int) {
        min = if (min > num) num else min
        max = if (max > num) max else num
    }

    fun result(): Int {
        return min * max
    }
}