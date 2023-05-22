package com.potatomeme.programmers.codingtest.years23.may.level4

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*
import kotlin.math.abs
import kotlin.math.min


//올바른 괄호의 갯수
//문제 설명
//올바른 괄호란 (())나 ()와 같이 올바르게 모두 닫힌 괄호를 의미합니다. )(나 ())() 와 같은 괄호는 올바르지 않은 괄호가 됩니다. 괄호 쌍의 개수 n이 주어질 때, n개의 괄호 쌍으로 만들 수 있는 모든 가능한 괄호 문자열의 갯수를 반환하는 함수 solution을 완성해 주세요.
//
//제한사항
//괄호 쌍의 개수 N : 1 ≤ n ≤ 14, N은 정수
//입출력 예
//n	result
//2	2
//3	5
//입출력 예 설명
//입출력 예 #1
//2개의 괄호쌍으로 [ "(())", "()()" ]의 2가지를 만들 수 있습니다.
//입출력 예 #2
//3개의 괄호쌍으로 [ "((()))", "(()())", "(())()", "()(())", "()()()" ]의 5가지를 만들 수 있습니다.

class Solution12929() {
    private var cnt = 0

    fun solution(n: Int): Int {
        dfs(0, n * 2, 0, 0, n)
        return cnt
    }

    private fun dfs(depth: Int, maxDepth: Int, cnt1: Int, cnt2: Int, maxCnt: Int) {
        if (depth == maxDepth) {
            cnt++
            return
        }
        if (cnt1 < maxCnt) dfs(depth + 1, maxDepth, cnt1 + 1, cnt2, maxCnt)
        if (cnt2 < cnt1) dfs(depth + 1, maxDepth, cnt1, cnt2 + 1, maxCnt)
    }
    //테스트 1 〉	통과 (0.02ms, 60.7MB)
    //테스트 2 〉	통과 (0.02ms, 59.2MB)
    //테스트 3 〉	통과 (0.03ms, 62.2MB)
    //테스트 4 〉	통과 (0.08ms, 61.8MB)
    //테스트 5 〉	통과 (0.25ms, 58.6MB)
    //테스트 6 〉	통과 (0.11ms, 57.7MB)
    //테스트 7 〉	통과 (0.19ms, 58MB)
    //테스트 8 〉	통과 (0.25ms, 61.1MB)
    //테스트 9 〉	통과 (0.35ms, 60.6MB)
    //테스트 10 〉	통과 (1.17ms, 59.5MB)
    //테스트 11 〉	통과 (1.90ms, 61MB)
    //테스트 12 〉	통과 (4.08ms, 60.8MB)
    //테스트 13 〉	통과 (9.48ms, 59.2MB)
    //테스트 14 〉	통과 (28.16ms, 59MB)
}

/*
class Solution {
    private var cnt = 0

    fun solution(n: Int): Int {
        dfs(0,n*2,0)
        return cnt
    }

    private fun dfs(depth:Int,maxDepth:Int,check:Int) {
        if (check < 0) return
        if (depth == maxDepth){
            if (check == 0) cnt++
            return
        }
        dfs(depth+1,maxDepth,check+1)
        dfs(depth+1,maxDepth,check-1)
    }
}
* */

//테스트 1 〉	통과 (0.01ms, 60.9MB)
//테스트 2 〉	통과 (0.03ms, 62.4MB)
//테스트 3 〉	통과 (0.08ms, 58.7MB)
//테스트 4 〉	통과 (0.19ms, 58.5MB)
//테스트 5 〉	통과 (0.40ms, 62.2MB)
//테스트 6 〉	통과 (0.23ms, 59.1MB)
//테스트 7 〉	통과 (0.32ms, 61.9MB)
//테스트 8 〉	통과 (0.50ms, 61.8MB)
//테스트 9 〉	통과 (0.71ms, 61.1MB)
//테스트 10 〉	통과 (2.45ms, 60.6MB)
//테스트 11 〉	통과 (5.98ms, 59.1MB)
//테스트 12 〉	통과 (12.80ms, 59.3MB)
//테스트 13 〉	통과 (46.61ms, 59.5MB)
//테스트 14 〉	통과 (138.96ms, 59.1MB)
//