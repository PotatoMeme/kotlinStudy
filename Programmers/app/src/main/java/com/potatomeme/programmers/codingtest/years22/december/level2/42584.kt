package com.potatomeme.programmers.codingtest.years22.december.level1

import java.util.*

//주식가격
//문제 설명
//초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
//
//제한사항
//prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
//prices의 길이는 2 이상 100,000 이하입니다.
//입출력 예
//prices	return
//[1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
//입출력 예 설명
//1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다.
//2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다.
//3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다.
//4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다.
//5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다.
//※ 공지 - 2019년 2월 28일 지문이 리뉴얼되었습니다.

// 1번
// 매번 위로 탐색을 하여 있는지 없는지 확인

// 2번
// stack을 이용

class Solution42584 {
    // 내마음대로 풀기
    fun solution(prices: IntArray): IntArray {
        val arr = IntArray(prices.size) { 0 }
        var stack = Stack<Pair<Int, Int>>()
        for ((index, item) in prices.withIndex()) {
            while (stack.isNotEmpty() || stack.peek().second > item) {
                val data = stack.pop()
                arr[data.first] = index - data.first
            }
            stack.add(Pair(index, item))
        }
        stack.forEach {
            arr[it.first] = prices.size - it.first - 1
        }
        return arr
    }//2번 방법

    fun user_solution(prices: IntArray): IntArray {
        val len: Int = prices.size
        val answer = IntArray(len)
        for (i in prices.indices) {
            for (j in i + 1 until len) {
                answer[i]++
                if (prices[i] > prices[j]) break
            }
        }
        return answer
    }//1번 방법
}

//자바로 푼것
//class Solution {
//    public int[] solution(int[] prices) {
//       int[] arr = new int[prices.length];
//        Stack<int[]> stack = new Stack<>();
//        for (int i = 0; i < prices.length; i++) {
//            while (!stack.isEmpty()){
//                if (stack.peek()[1] > prices[i]){
//                    int[] data = stack.pop();
//                    arr[data[0]] = i - data[0];
//                }else{
//                    break;
//                }
//            }
//            stack.add(new int[]{i, prices[i]});
//        }
//        while (!stack.isEmpty()){
//            int[] data = stack.pop();
//            arr[data[0]] = prices.length - data[0]-1;
//        }
//        return arr;
//    }
//}

