package com.potatomeme.programmers.codingtest.years22.november.level0

import kotlin.math.sqrt

//제곱수 판별하기
//문제 설명
//어떤 자연수를 제곱했을 때 나오는 정수를 제곱수라고 합니다. 정수 n이 매개변수로 주어질 때, n이 제곱수라면 1을 아니라면 2를 return하도록 solution 함수를 완성해주세요.
//
//제한사항
//1 ≤ n ≤ 1,000,000
//입출력 예
//n	result
//144	1
//976	2
//입출력 예 설명
//입출력 예 #1
//
//144는 12의 제곱이므로 제곱수입니다. 따라서 1을 return합니다.
//입출력 예 #2
//
//976은 제곱수가 아닙니다. 따라서 2를 return합니다.

class Solution120909 {
    // public int solution(int[] nums) {
    //        Set<Integer> set_nums = new HashSet<>();
    //        for (int i: nums) set_nums.add(i);
    //        if (nums.length/2 > set_nums.size() ){
    //            return set_nums.size();
    //        }else{
    //            return nums.length/2;
    //        }
    //    }

    fun solution(nums: IntArray): Int {
        val set_nums: MutableSet<Int> = HashSet()
        for (i in nums) set_nums.add(i)
        return if (nums.size / 2 > set_nums.size) {
            set_nums.size
        } else {
            nums.size / 2
        }
    }

    fun solution(n: Int): Int =  if(sqrt(n.toDouble())%1 == 0.0) 1 else 2
    // 0.03 ~ 0.07
}