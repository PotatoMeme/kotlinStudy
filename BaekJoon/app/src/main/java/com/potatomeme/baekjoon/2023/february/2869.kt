package com.potatomeme.baekjoon.`2023`.february

import java.util.StringTokenizer
import kotlin.math.ceil


//https://www.acmicpc.net/problem/2869

//달팽이는 올라가고 싶다 성공다국어
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//0.25 초 (추가 시간 없음)	128 MB	196969	61780	48147	30.647%
//문제
//땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.
//
//달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 또, 정상에 올라간 후에는 미끄러지지 않는다.
//
//달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 세 정수 A, B, V가 공백으로 구분되어서 주어진다. (1 ≤ B < A ≤ V ≤ 1,000,000,000)
//
//출력
//첫째 줄에 달팽이가 나무 막대를 모두 올라가는데 며칠이 걸리는지 출력한다.
//
//예제 입력 1
//2 1 5
//예제 출력 1
//4
//예제 입력 2
//5 1 6
//예제 출력 2
//2
//예제 입력 3
//100 99 1000000000
//예제 출력 3
//999999901


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()
    val v = st.nextToken().toInt()
    print(solve2869ToMath(a, b, v))
}

fun solve2869(a:Int,b:Int,v:Int):Int{
    var sum = a
    var d = 1
    val up = a-b
    while (true){
        if (sum >= v) return d
        d++
        sum += up
    }
}//time out
fun solve2869ToMath(a:Int,b:Int,v:Int):Int{
    var sum = v - a
    if (sum <= 0) return 1
    val up = a-b
    return 2 + (sum-1)/up
}