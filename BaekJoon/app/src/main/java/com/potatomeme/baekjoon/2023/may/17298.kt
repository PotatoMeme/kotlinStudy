package com.potatomeme.baekjoon.`2023`.may

import java.util.Stack
import java.util.StringTokenizer


//https://www.acmicpc.net/problem/17298

//오큰수
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	512 MB	62835	21377	15287	32.829%
//문제
//크기가 N인 수열 A = A1, A2, ..., AN이 있다. 수열의 각 원소 Ai에 대해서 오큰수 NGE(i)를 구하려고 한다. Ai의 오큰수는 오른쪽에 있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다. 그러한 수가 없는 경우에 오큰수는 -1이다.
//
//예를 들어, A = [3, 5, 2, 7]인 경우 NGE(1) = 5, NGE(2) = 7, NGE(3) = 7, NGE(4) = -1이다. A = [9, 5, 4, 8]인 경우에는 NGE(1) = -1, NGE(2) = 8, NGE(3) = 8, NGE(4) = -1이다.
//
//입력
//첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄에 수열 A의 원소 A1, A2, ..., AN (1 ≤ Ai ≤ 1,000,000)이 주어진다.
//
//출력
//총 N개의 수 NGE(1), NGE(2), ..., NGE(N)을 공백으로 구분해 출력한다.
//
//예제 입력 1
//4
//3 5 2 7
//예제 출력 1
//5 7 7 -1
//예제 입력 2
//4
//9 5 4 8
//예제 출력 2
//-1 8 8 -1

fun main() = with(System.`in`.bufferedReader()) {
    /** try1 timeout 68% */
    /*val n = readLine().toInt()
    val st= StringTokenizer(readLine())

    class NGE(val realN : Int, var num:Int, var idx:Int)
    val arr = Array(n){NGE(st.nextToken().toInt(),0,-1)}

    fun rightSearch(baseIdx:Int, idx: Int,to:Int){
        if (idx == to) {
            arr[baseIdx].num = -1
            return
        }
        if (arr[idx].realN > arr[baseIdx].realN){
            arr[baseIdx].num = arr[idx].realN
            arr[baseIdx].idx = idx
        }else if (arr[idx].realN == arr[baseIdx].realN){
            arr[baseIdx].num = arr[idx].num
            arr[baseIdx].idx = arr[idx].idx
        }else{
            if (arr[idx].num == -1){
                arr[baseIdx].num = -1
            }else if (arr[idx].num > arr[baseIdx].realN){
                rightSearch(baseIdx,idx+1,arr[idx].idx+1)
            }else if (arr[idx].num == arr[baseIdx].realN){
                rightSearch(baseIdx,arr[idx].idx+1,to)
            }else{
                rightSearch(baseIdx,idx+1,to)
            }
        }
    }

    for (i in n-1 downTo 0) rightSearch(i,i+1,n)

    print(buildString { arr.forEach { append(it.num).append(' ')} })*/

    /** try2 success */
     val n = readLine().toInt()
     val st= StringTokenizer(readLine())
     val arr = IntArray(n){st.nextToken().toInt()}
     val stack = Stack<Int>()

     arr.forEachIndexed { index, i ->
         while (stack.isNotEmpty() && arr[stack.peek()] < i){
             arr[stack.pop()] = i
         }
         stack.push(index)
     }

     while (stack.isNotEmpty()) arr[stack.pop()] = -1
     print(buildString { arr.forEach { append(it).append(' ')} })

    /** try3 use Pair */
    /*val n = readLine().toInt()
    val st= StringTokenizer(readLine())
    val arr = IntArray(n){st.nextToken().toInt()}
    val stack = Stack<Pair<Int,Int>>()//first : idx , second : value

    arr.forEachIndexed { index, i ->
        while (stack.isNotEmpty() && stack.peek().second < i){
            arr[stack.pop().first] = i
        }
        stack.push(Pair(index,i))
    }

    while (stack.isNotEmpty()) arr[stack.pop().first] = -1
    print(buildString { arr.forEach { append(it).append(' ')} })*/
}