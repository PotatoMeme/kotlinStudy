package com.potatomeme.programmers.codingtest.years22.october.level1

import java.lang.StringBuilder
import kotlin.math.abs

class Solution67256 {
    fun solution(numbers: IntArray, hand: String): String {
        var lX = 0
        var lY = 3
        var rX = 2
        var rY = 3
        val state = hand == "right"
        val result = StringBuilder()
        val arrY: IntArray = intArrayOf(3, 0, 0, 0, 1, 1, 1, 2, 2, 2)
        numbers.forEach {
            if (it == 1 || it == 4 || it == 7) {
                lX = 0
                lY = arrY[it]
                result.append('L')
            } else if (it == 3 || it == 6 || it == 9) {
                rX = 2
                rY = arrY[it]
                result.append('R')
            } else if (it == 2 || it == 5 || it == 8 || it == 0) {
                val y: Int = arrY[it]
                val lDistance = abs(lX - 1) + abs(lY - y)
                val rDistance = abs(rX - 1) + abs(rY - y)
                if (lDistance > rDistance) {
                    rX = 1
                    rY = y
                    result.append('R')
                } else if (lDistance < rDistance) {
                    lX = 1
                    lY = y
                    result.append('L')
                } else {
                    if (state) {
                        rX = 1
                        rY = y
                        result.append('R')
                    } else {
                        lX = 1
                        lY = y
                        result.append('L')
                    }
                }
            }
        }
        return result.toString()
    }
}

class user1Solution67256 {

    lateinit var keypadHash: HashMap<Char, ArrayList<Int>>
    val ROW = 0
    val COL = 1

    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""
        var leftThumb = ArrayList<Int>(2)
        var rightThumb = ArrayList<Int>(2)

        initHash()
        leftThumb = keypadHash['*']!!
        rightThumb = keypadHash['#']!!

        numbers.forEach {
            val key = (it + 48).toChar()
            when (key) {

                '1', '4', '7' -> {
                    answer += "L"
                    leftThumb = keypadHash[key]!!
                }

                '3', '6', '9' -> {
                    answer += "R"
                    rightThumb = keypadHash[key]!!
                }

                '2', '5', '8', '0' -> {
                    var stdKey = keypadHash[key]!!
                    var leftDistance = Math.abs(stdKey[ROW] - leftThumb[ROW]) +
                            Math.abs(stdKey[COL] - leftThumb[COL])
                    var rightDistance = Math.abs(stdKey[ROW] - rightThumb[ROW]) +
                            Math.abs(stdKey[COL] - rightThumb[COL])

                    if (leftDistance < rightDistance) {
                        answer += "L"
                        leftThumb = stdKey
                    } else if (leftDistance > rightDistance) {
                        answer += "R"
                        rightThumb = stdKey
                    } else {
                        if (hand == "right") {
                            answer += "R"
                            rightThumb = stdKey
                        } else {
                            answer += "L"
                            leftThumb = stdKey
                        }
                    }
                }
            }
        }

        return answer
    }

    fun initHash() {

        keypadHash = hashMapOf<Char, ArrayList<Int>>(
            '1' to arrayListOf<Int>(0, 0),
            '2' to arrayListOf<Int>(0, 1),
            '3' to arrayListOf<Int>(0, 2),
            '4' to arrayListOf<Int>(1, 0),
            '5' to arrayListOf<Int>(1, 1),
            '6' to arrayListOf<Int>(1, 2),
            '7' to arrayListOf<Int>(2, 0),
            '8' to arrayListOf<Int>(2, 1),
            '9' to arrayListOf<Int>(2, 2),
            '*' to arrayListOf<Int>(3, 0),
            '0' to arrayListOf<Int>(3, 1),
            '#' to arrayListOf<Int>(3, 2)
        )
    }
}

class user2Solution {
    val info = mapOf(
        0 to Pair(1, 3),
        1 to Pair(0, 0),
        2 to Pair(1, 0),
        3 to Pair(2, 0),
        4 to Pair(0, 1),
        5 to Pair(1, 1),
        6 to Pair(2, 1),
        7 to Pair(0, 2),
        8 to Pair(1, 2),
        9 to Pair(2, 2)
    )

    fun solution(numbers: IntArray, hand: String): String {
        val lefthanded = hand == "left"
        var nowLeft = Pair(0, 3)
        var nowRight = Pair(2, 3)
        return numbers.map {
            if (info[it]!!.first == 0) {
                nowLeft = info[it]!!
                'L'
            } else if (info[it]!!.first == 2) {
                nowRight = info[it]!!
                'R'
            } else {
                val distLeft =
                    abs(info[it]!!.first - nowLeft.first) + abs(info[it]!!.second - nowLeft.second)
                val distRight =
                    abs(info[it]!!.first - nowRight.first) + abs(info[it]!!.second - nowRight.second)
                if (distLeft > distRight) {
                    nowRight = info[it]!!
                    'R'
                } else if (distLeft < distRight) {
                    nowLeft = info[it]!!
                    'L'
                } else {
                    if (lefthanded) {
                        nowLeft = info[it]!!
                        'L'
                    } else {
                        nowRight = info[it]!!
                        'R'
                    }
                }
            }
        }.joinToString("")
    }
}