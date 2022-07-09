package com.potatomeme.baekjoon.July.week_2nd

import android.system.Os.close
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.sqrt


val baekjoon1978 = Baekjoon_1978()

fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    val num = br.readLine().toInt()
    val st = StringTokenizer(br.readLine())
    val arr = ArrayList<Int>()
    repeat(num) {
        arr.add(st.nextToken().toInt())
    }
    for (i in arr){
        baekjoon1978.result(i)
    }
    write(baekjoon1978.cnt.toString())
    close()
}

class Baekjoon_1978() {
    var cnt = 0
    fun result(num: Int) {
        if (num == 1) return
        for (i: Int in 2..sqrt(num.toDouble()).toInt()) {
            if (num%i == 0) return
        }
        cnt ++
        return
    }

}