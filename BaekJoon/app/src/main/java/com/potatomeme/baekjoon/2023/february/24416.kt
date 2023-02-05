package com.potatomeme.baekjoon.`2023`.february

//https://www.acmicpc.net/problem/24416

//조합 0의 개수
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	128 MB	45501	12791	10560	28.732%
//문제
// 
//$n \choose m$의 끝자리
//$0$의 개수를 출력하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 정수
//$n$,
//$m$ (
//$0 \le m \le n \le 2,000,000,000$,
//$n \ne 0$)이 들어온다.
//
//출력
//첫째 줄에
//$n \choose m$의 끝자리
//$0$의 개수를 출력한다.
//
//예제 입력 1
//25 12
//예제 출력 1
//2

// = ()

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val s = Solution24416(readLine().toInt())
    print("${s.count1} ${s.count2}")
}

class Solution24416(val n : Int){
    var count1 = 0
    var count2 = 0
    init{
        fib(n)
        fibonacci(n)
    }

    fun fib(n:Int){
        if (n==1 || n==2){
            count1++
        } else {
            fib(n-1)
            fib(n-2)
        }
    }

    fun fibonacci(n:Int){
        count2 = n - 2
    }
}