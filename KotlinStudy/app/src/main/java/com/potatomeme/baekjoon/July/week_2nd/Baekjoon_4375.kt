package com.potatomeme.baekjoon.July.week_2nd

import java.util.*

var baekjoon4375 = Baekjoon_4375()
fun main() {
    val sc: Scanner = Scanner(System.`in`)
    while (sc.hasNextInt()){
        println(baekjoon4375.One(sc.nextInt()))
    }
}
class Baekjoon_4375 (){
    fun One(num : Int):Int{
        var x = 1
        for (i in 1 .. Int.MAX_VALUE){
            x %= num
            x = x *10 +1
            if(x == 1) return i
        }
        return 0
    }
}

