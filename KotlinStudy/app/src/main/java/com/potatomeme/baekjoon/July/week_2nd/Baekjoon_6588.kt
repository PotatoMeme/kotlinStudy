package com.potatomeme.baekjoon.July.week_2nd

import kotlin.math.sqrt

const val EndNum = 0
val baekjoon6588 = Baekjoon_6588()
fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    var num: Int
    baekjoon6588.setting()
    while (true) {
        num = br.readLine().toInt()
        if (num == EndNum) {
            break
        }
        var result = baekjoon6588.result(num)
        if (result != null) {
            write("${num} = ${result[1]} + ${result[0]}\n")
        }
    }
    close()
}

class Baekjoon_6588() {
    val decimalSize = 1000001
    val decimal = Array<Boolean>(decimalSize, { false })
    fun setting() {
        decimal[0] = true
        decimal[1] = true
        for (i in 2..sqrt(decimalSize.toDouble()).toInt()) {
            if (decimal[i]) continue
            for (j in i * i until decimalSize step i) {
                decimal[j] = true
            }
        }
    }

    fun result(num: Int): List<Int>? {
        for (i in num - 1 downTo 3 step 2) {
            for (j in 3..i step 2) {
                if (i + j > num) break;
                if (!decimal[i] && !decimal[j]) {
                    if (num == i + j) return listOf(i, j)
                }
            }
        }
        return null
    }
}