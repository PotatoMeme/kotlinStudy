package com.potatomeme.programmers.codingtest.years23.march.level2

import java.util.*


//귤 고르기
//문제 설명
//경화는 과수원에서 귤을 수확했습니다. 경화는 수확한 귤 중 'k'개를 골라 상자 하나에 담아 판매하려고 합니다. 그런데 수확한 귤의 크기가 일정하지 않아 보기에 좋지 않다고 생각한 경화는 귤을 크기별로 분류했을 때 서로 다른 종류의 수를 최소화하고 싶습니다.
//
//예를 들어, 경화가 수확한 귤 8개의 크기가 [1, 3, 2, 5, 4, 5, 2, 3] 이라고 합시다. 경화가 귤 6개를 판매하고 싶다면, 크기가 1, 4인 귤을 제외한 여섯 개의 귤을 상자에 담으면, 귤의 크기의 종류가 2, 3, 5로 총 3가지가 되며 이때가 서로 다른 종류가 최소일 때입니다.
//
//경화가 한 상자에 담으려는 귤의 개수 k와 귤의 크기를 담은 배열 tangerine이 매개변수로 주어집니다. 경화가 귤 k개를 고를 때 크기가 서로 다른 종류의 수의 최솟값을 return 하도록 solution 함수를 작성해주세요.
//
//제한사항
//1 ≤ k ≤ tangerine의 길이 ≤ 100,000
//1 ≤ tangerine의 원소 ≤ 10,000,000
//입출력 예
//k	tangerine	result
//6	[1, 3, 2, 5, 4, 5, 2, 3]	3
//4	[1, 3, 2, 5, 4, 5, 2, 3]	2
//2	[1, 1, 1, 1, 2, 2, 2, 3]	1
//입출력 예 설명
//입출력 예 #1
//
//본문에서 설명한 예시입니다.
//입출력 예 #2
//
//경화는 크기가 2인 귤 2개와 3인 귤 2개 또는 2인 귤 2개와 5인 귤 2개 또는 3인 귤 2개와 5인 귤 2개로 귤을 판매할 수 있습니다. 이때의 크기 종류는 2가지로 이 값이 최소가 됩니다.
//입출력 예 #3
//
//경화는 크기가 1인 귤 2개를 판매하거나 2인 귤 2개를 판매할 수 있습니다. 이때의 크기 종류는 1가지로, 이 값이 최소가 됩니다.

fun main() {
    println(Solution138476().solution(4, intArrayOf(1, 3, 2, 5, 4, 5, 2, 3)))
}

class Solution138476() {
    fun solution1(k: Int, tangerine: IntArray): Int {
        // unresolved reference: max
        // val max = tangerine.max()
        //                     ^
        // 왜 max()가 안됨?
        var max = Int.MIN_VALUE
        tangerine.forEach { if (max < it) max = it }
        val arr = IntArray(max + 1) { 0 }
        tangerine.forEach { arr[it]++ }
        var answer = Int.MAX_VALUE
        fun solve(idx: Int, sum: Int, cnt: Int) {
            if (sum >= k) {
                if (answer > cnt) answer = cnt
                return
            }
            if (idx == arr.size) return
            solve(idx + 1, sum, cnt)
            solve(idx + 1, sum + arr[idx], cnt + 1)
        }
        solve(1, 0, 0)
        return answer
    }//time out
    fun solution2(k: Int, tangerine: IntArray): Int {
        val map = mutableMapOf<Int,Int>()
        tangerine.forEach {
            map[it] = (map[it]?:0) + 1
        }
        val setArr = tangerine.toSortedSet().toIntArray()
        var answer = Int.MAX_VALUE
        fun solve(idx: Int, sum: Int, cnt: Int) {
            if (sum >= k) {
                if (answer > cnt) answer = cnt
                return
            }
            if (idx == setArr.size) return
            solve(idx + 1, sum, cnt)
            solve(idx + 1, sum + map[setArr[idx]]!!, cnt + 1)
        }
        solve(0, 0, 0)
        return answer
    }// time out
    fun solution3(k: Int, tangerine: IntArray): Int {
        val sorted_tangrine = tangerine.sorted()
        val arrayList = arrayListOf<Int>()
        var cnt = 1
        for (i in 1 until  sorted_tangrine.size){
            if (sorted_tangrine[i] != sorted_tangrine[i-1]){
                arrayList.add(cnt)
                cnt = 0
            }
            cnt++
        }
        arrayList.add(cnt)
        var answer = Int.MAX_VALUE
        fun solve(idx: Int, sum: Int, cnt: Int) {
            if (sum >= k) {
                if (answer > cnt) answer = cnt
                return
            }
            if (idx == arrayList.size) return
            solve(idx + 1, sum, cnt)
            solve(idx + 1, sum + arrayList[idx], cnt + 1)
        }
        solve(0, 0, 0)
        return answer
    }// time out

    fun solution(k: Int, tangerine: IntArray): Int {
        var answer = 0
        val map = mutableMapOf<Int,Int>()

        for (size in tangerine) {
            map[size] = (map[size]?:0) + 1
        }

        val arr = ArrayList(map.keys)
        arr.sortWith { o1: Int, o2: Int ->
            map[o2]!! - map[o1]!!
        }

        var sum = 0
        var i = 0
        while (sum < k) {
            sum += map[arr[i++]]!!
            answer++
        }
        return answer
    }
}