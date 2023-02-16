package com.potatomeme.baekjoon.`2023`.february

import java.util.StringTokenizer


//https://www.acmicpc.net/problem/1931

//회의실 배정 성공
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	128 MB	158299	49908	35102	29.699%
//문제
//한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다. 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자. 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다. 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.
//
//입력
//첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 시작 시간과 끝나는 시간은 231-1보다 작거나 같은 자연수 또는 0이다.
//
//출력
//첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.
//
//예제 입력 1
//11
//1 4
//3 5
//0 6
//5 7
//3 8
//5 9
//6 10
//8 11
//8 12
//2 13
//12 14
//예제 출력 1
//4


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = Array(n) { Pair(0, 0) }
    repeat(n) {
        val st = StringTokenizer(readLine())
        arr[it] = Pair(st.nextToken().toInt(), st.nextToken().toInt())
    }

    arr.sortWith(compareBy ({ it.second },{ it.first }))
    var endtime = 0
    var cnt = 0
    for (i in 0 until n){
        if (arr[i].first >= endtime){
            cnt++
            endtime = arr[i].second
        }
    }
    print(cnt)
}

//    var max = Int.MIN_VALUE
//    fun solve(depth:Int,index:Int,last:Int){
//        for (i in index until n){
//            if (arr[i].first >= last){
//                solve(depth+1,i+1,arr[i].second)
//            }
//        }
//        if (max > depth){
//            max = depth
//        }
//    }//time out
//    solve(0,0,0)
//    print(max)

