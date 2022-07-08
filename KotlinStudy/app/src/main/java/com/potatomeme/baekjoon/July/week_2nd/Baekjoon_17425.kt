package com.potatomeme.baekjoon.July.week_2nd


val br = System.`in`.bufferedReader()
val MAX = 1000001
val gx = LongArray(MAX){1}
fun fxSet(){
    for (i in 2 until MAX) {
        for (j in i until MAX step i){
            gx[j] += i.toLong()
        }
    }
}
fun gxSet(){
    for (i in 2 until MAX) {
        gx[i] += gx[i - 1]
    }
}
fun main() = with(System.out.bufferedWriter()){
    val testCase = br.readLine().toInt()
    fxSet()
    gxSet()
    repeat (testCase) {
        write("${gx[br.readLine().toInt()]}\n")
    }
    close()
}
