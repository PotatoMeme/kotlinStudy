package com.potatomeme.programmers.codingtest.years22.october.level2


//피보나치 수
//링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12945

//문제 설명
//피보나치 수는 F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다.
//
//예를들어
//
//F(2) = F(0) + F(1) = 0 + 1 = 1
//F(3) = F(1) + F(2) = 1 + 1 = 2
//F(4) = F(2) + F(3) = 1 + 2 = 3
//F(5) = F(3) + F(4) = 2 + 3 = 5
//와 같이 이어집니다.
//
//2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.
//
//제한 사항
//n은 2 이상 100,000 이하인 자연수입니다.
//입출력 예
//n	return
//3	2
//5	5
//입출력 예 설명
//피보나치수는 0번째부터 0, 1, 1, 2, 3, 5, ... 와 같이 이어집니다.

class Solution12945 {
    fun mySolution1(n: Int): Int = when (n) {
        0 -> 0
        1 -> 1
        else -> (mySolution1(n - 1) + mySolution1(n - 2)) % 1234567
    }// 시간 초과

    fun mySolution2(n: Int): Int {
        val list = ArrayList<Int>()
        list.add(0)
        list.add(1)
        for (i in 2..n) {
            list.add((list[i - 1] + list[i - 2]) % 1234567)
        }
        return list[n]
    }

    fun mySolution3(n: Int): Int {
        val arr = IntArray(n+1)
        arr[0] = 0
        arr[1] = 1
        for (i in 2 .. n) {
            arr[i] = (arr[i-1] + arr[i-2]) % 1234567
        }
        return arr[n]
    }


    fun userSolution1(n: Int): Int {
        var ans = Array(n + 1) { i -> 0 }
        ans[1] = 1
        for (i in 2..n) ans[i] = (ans[i - 1] + ans[i - 2]) % 1234567
        return ans[n]
    }

    fun userSolution2(n: Int): Int {
        val answer = fibo(0, 1, 1, n)
        return answer
    }

    tailrec fun fibo(a: Int, b: Int, m: Int, n: Int): Int {
        if (m <=n) {
            return fibo(b, (a+b)%1234567, m+1, n)
        } else {
            return a
        }
    }
}
