package com.potatomeme.baekjoon.July.week_2nd

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.sqrt

val baekjoon1929 = Baekjoon_1929()

fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    baekjoon1929.decimalSetting()
    val st = StringTokenizer(br.readLine())
    val arr = ArrayList<Int>()
    while (st.hasMoreTokens()) {
        arr.add(st.nextToken().toInt())
    }
    for (i in arr[0]..arr[1]) {
        if (!baekjoon1929.decimal[i]) write("${i}\n")
    }
    close()
}

class Baekjoon_1929() {
    val decimal = Array<Boolean>(1000001, { false })
    fun decimalSetting() {
        decimal[0] = true
        decimal[1] = true
        for (i in 2..sqrt(decimal.size.toDouble()).toInt()) {
            if (decimal[i]) continue
            for (j in i * i until decimal.size step i) {
                decimal[j] = true
            }
        }
    }
}

