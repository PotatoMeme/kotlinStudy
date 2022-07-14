package com.potatomeme.baekjoon.July.week_3rd

import java.math.BigInteger


fun main() {
    var (s,e) = readln().split(' ').map { it.toBigInteger() }.sorted()
    val stringBuilder = StringBuilder()
    if (e.subtract(s) > BigInteger.ONE) {
        stringBuilder.append(e.subtract(s).subtract(BigInteger.ONE)).append('\n')
        while ( s != e.subtract(BigInteger.ONE)){
            s = s.add(BigInteger.ONE)
            stringBuilder.append("$s ")
        }
    } else{
        stringBuilder.append(0).append('\n')
    }
    print(stringBuilder)
}

