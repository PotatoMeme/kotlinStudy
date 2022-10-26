package com.potatomeme.programmers.codingtest.years22.october.level2


class Solution70129 {
    fun mySolution1(s: String): IntArray {
        var str = s
        var count = 0
        var decZero = 0
        while (str != "1") {
            val strLength = str.filter { it == '1' }.length
            decZero += str.length - strLength
            count++
            str = Integer.toBinaryString(strLength)
        }
        return intArrayOf(count, decZero)
    }


    fun userSolution1(s: String): IntArray {
        var copiedS = s
        var removedZero = 0
        var count = 0

        while (copiedS != "1") {
            removedZero += copiedS.replace("1", "").count()
            copiedS = Integer.toBinaryString(copiedS.replace("0", "").count())
            count++
        }
        return intArrayOf(count, removedZero)
    }
}

