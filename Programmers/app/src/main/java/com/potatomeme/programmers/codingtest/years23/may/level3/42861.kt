package com.potatomeme.programmers.codingtest.years23.may.level3

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*
import kotlin.math.abs
import kotlin.math.min


//N-Queen
//문제 설명
//가로, 세로 길이가 n인 정사각형으로된 체스판이 있습니다. 체스판 위의 n개의 퀸이 서로를 공격할 수 없도록 배치하고 싶습니다.
//
//예를 들어서 n이 4인경우 다음과 같이 퀸을 배치하면 n개의 퀸은 서로를 한번에 공격 할 수 없습니다.
//
//Imgur
//Imgur
//
//체스판의 가로 세로의 세로의 길이 n이 매개변수로 주어질 때, n개의 퀸이 조건에 만족 하도록 배치할 수 있는 방법의 수를 return하는 solution함수를 완성해주세요.
//
//제한사항
//퀸(Queen)은 가로, 세로, 대각선으로 이동할 수 있습니다.
//n은 12이하의 자연수 입니다.
//입출력 예
//n	result
//4	2
//입출력 예 설명
//입출력 예 #1
//문제의 예시와 같습니다.

class Solution42861() {
    fun solution1(n: Int, costs: Array<IntArray>): Int {
        val arr = Array(n){ IntArray(n) }
        val visited = BooleanArray(n)
        costs.forEach {
            arr[it[0]][it[1]] = it[2]
            arr[it[1]][it[0]] = it[2]
        }

        var min = Int.MAX_VALUE
        fun dfs(depth:Int,currentMin:Int){
            if (min < currentMin){
                return
            }
            if (depth == n - 1){
                min = currentMin
                return
            }
            for (i in 0 until n){
                if (!visited[i]){
                    for (j in 0 until n){
                        if (visited[j] && arr[i][j] != 0){
                            visited[i] = true
                            dfs(depth+1,currentMin + arr[i][j])
                            visited[i] = false
                        }
                    }
                }
            }
        }
        visited[0] = true
        dfs(0,0)
        return min
    }// 4,6,7 time out


    fun solution2(n: Int, costs: Array<IntArray>): Int {
        costs.sortBy { it[2] } // 가중치로정렬

        val parent = IntArray(n) // Union Find, 각 트리의 부모를 저장

        for (i in 0 until n){
            parent[i] = i
        }// 처음에는 만들어진 그래프가 없기 때문에 본인이 부모임

        var total = 0
        var lineCnt = 1

        fun findParent(node:Int):Int{
            if (parent[node] == node) return node
            parent[node] = findParent(parent[node]) //가는 경로의 부모가 같아지도록 값을 세팅
            return parent[node]
        }

        for (edge in costs){
            val from = edge[0]
            val to = edge[1]
            val cost = edge[2]

            val frontParent = findParent(from)
            val toParent = findParent(to)

            if (frontParent == toParent) continue
            if (lineCnt == n) break
            total += cost
            lineCnt ++
            parent[toParent] = frontParent // 두 그래프를 연결

        }

        return total
    }
    // 최소신장트리
    // copied By : https://maetdori.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%84%AC-%EC%97%B0%EA%B2%B0%ED%95%98%EA%B8%B0
}