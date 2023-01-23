package com.potatomeme.baekjoon.`2023`.january

import java.util.*

//https://www.acmicpc.net/problem/2609

//최대공약수와 최소공배수 성공
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	128 MB	83528	48245	39185	58.286%
//문제
//두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.
//
//출력
//첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.
//
//예제 입력 1
//24 18
//예제 출력 1
//6
//72

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val x = st.nextToken().toInt()
    val y = st.nextToken().toInt()
    //print(if (x < y) solve(x, y) else solve(y, x))
    print(solution2609().solve_type2(x, y))
}

class solution2609() {
    fun solve(x: Int, y: Int): String {//x < y
        var result1 = 1
        for (i in x downTo 1) {
            if (x % i == 0 && y % i == 0) {
                result1 = i
                break
            }
        }
        var result2 = 1
        for (i in 1..x) {
            if ((y * i) % x == 0) {
                result2 = y * i
                break
            }
        }

        return "$result1\n${result2}"
    }

    fun solve_type1(a: Int, b: Int): String {
        //gcd
        var _a = a
        var _b = b
        var result = 1
        var count = 2
        while (_a != 1 && _b != 1 && _a >= count && _b >= count) {
            while (_a % count == 0 && _b % count == 0) {
                _a /= count
                _b /= count
                result *= count
            }
            count++
        }
        //lcm -> (a*b)/gcd(a,b)
        return "$result\n${a * b / result}"
    }

    fun solve_type2(a: Int, b: Int): String {
        //gcd
        var _a = if (a > b) a else b
        var _b = if (a > b) b else a
        var result = gcd(_a, _b)
        //lcm -> (a*b)/gcd(a,b)
        return "$result\n${a * b / result}"
    }

    fun gcd(p: Int, q: Int): Int {
        return if (q == 0) p else gcd(q, p % q)
    }
}