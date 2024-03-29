package com.potatomeme.baekjoon.`2023`.january

import java.util.StringTokenizer

//https://www.acmicpc.net/problem/1934

//최소공배수
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	128 MB	52220	29338	25093	57.775%
//문제
//두 자연수 A와 B에 대해서, A의 배수이면서 B의 배수인 자연수를 A와 B의 공배수라고 한다. 이런 공배수 중에서 가장 작은 수를 최소공배수라고 한다. 예를 들어, 6과 15의 공배수는 30, 60, 90등이 있으며, 최소 공배수는 30이다.
//
//두 자연수 A와 B가 주어졌을 때, A와 B의 최소공배수를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다. 둘째 줄부터 T개의 줄에 걸쳐서 A와 B가 주어진다. (1 ≤ A, B ≤ 45,000)
//
//출력
//첫째 줄부터 T개의 줄에 A와 B의 최소공배수를 입력받은 순서대로 한 줄에 하나씩 출력한다.
//
//예제 입력 1
//3
//1 45000
//6 10
//13 17
//예제 출력 1
//45000
//30
//221

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val num = readLine().toInt()
    val solution = Solution1934()
    repeat(num){
        val st = StringTokenizer(readLine())
        solution.solveType2(
            st.nextToken().toInt(),
            st.nextToken().toInt()
        )
        //val a = st.nextToken().toInt()
        //val b = st.nextToken().toInt()
        //if (a<b) solution.solve(a,b) else solution.solve(b,a)
    }
    print(solution.sb.toString())
}

class Solution1934() {
    val sb = StringBuilder()
    fun solve(a: Int, b: Int) {//a < b
        for (i in 1..a) {
            if (b * i % a == 0) {
                sb.append(b * i).appendLine()
                return
            }
        }
    }

    fun solveType2(a:Int,b:Int) = sb.append((a*b)/gcd(a,b)).appendLine()

    fun gcd(a:Int,b:Int):Int{
        if (b == 0) return a else return gcd(b,a%b)
    }


}

