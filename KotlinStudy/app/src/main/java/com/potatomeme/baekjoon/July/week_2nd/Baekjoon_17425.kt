package com.potatomeme.baekjoon.July.week_2nd



val baekjoon17425 = Baekjoon_17425(1000001)

fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val testCase = br.readLine().toInt()
    baekjoon17425.fxSet()
    baekjoon17425.gxSet()
    repeat (testCase) {
        write("${baekjoon17425.gx[br.readLine().toInt()]}\n")
    }
    close()
}
class Baekjoon_17425(val MAX : Int = 1000001){

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
}