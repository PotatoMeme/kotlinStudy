package com.potatomeme.programmers

import java.math.BigInteger


fun main() {
    val n =50
    var list = ArrayList<BigInteger>()
    list.add(BigInteger.valueOf(0))
    list.add(BigInteger.valueOf(1))
    for (i in 2..n){
        list.add(list.get(i-1)+list.get(i-2))
    }
    print(list.get(n))

}

fun solution(n: Int): Int = when (n) {
    0 -> 0
    1 -> 1
    else -> solution(n - 1) + solution(n - 2)
}
