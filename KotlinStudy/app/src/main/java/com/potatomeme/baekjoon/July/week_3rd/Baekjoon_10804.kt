package com.potatomeme.baekjoon.July.week_3rd


fun main() {
    val list = mutableListOf<Int>(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)
    repeat(10){
        var (s,e) = readln().split(' ').map { it.toInt() }.sorted()
        var copy = list.toIntArray()
        var j = 0
        for ( i in s-1 .. e-1  ){
            list[i] = copy[e-1-j]
            j++
        }
    }
    for (i in list){
        print("$i ")
    }
}


