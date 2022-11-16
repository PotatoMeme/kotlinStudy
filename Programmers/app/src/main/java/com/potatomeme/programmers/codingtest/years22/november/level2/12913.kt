package com.potatomeme.programmers.codingtest.years22.november.level2

import java.util.*

class Solution12913 {

    // IN JAVA
//    int solution(int[][] land) {
//        for(int i=1; i<land.length; i++){
//            land[i][0] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][3]);
//            land[i][1] += Math.max(Math.max(land[i-1][0], land[i-1][2]), land[i-1][3]);
//            land[i][2] += Math.max(Math.max(land[i-1][1], land[i-1][0]), land[i-1][3]);
//            land[i][3] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][0]);
//        }
//
//        int[] answer = land[land.length-1];
//        Arrays.sort(answer);
//
//        return answer[answer.length-1];
//    }

    // JAVA TO KOTLIN
    fun solution(land: Array<IntArray>): Int {
        for (i in 1 until land.size) {
            land[i][0] += Math.max(Math.max(land[i - 1][1], land[i - 1][2]),
                land[i - 1][3])
            land[i][1] += Math.max(Math.max(land[i - 1][0], land[i - 1][2]),
                land[i - 1][3])
            land[i][2] += Math.max(Math.max(land[i - 1][1], land[i - 1][0]),
                land[i - 1][3])
            land[i][3] += Math.max(Math.max(land[i - 1][1], land[i - 1][2]),
                land[i - 1][0])
        }
        val answer = land[land.size - 1]
        Arrays.sort(answer)
        return answer[answer.size - 1]
    }

    fun solution_refactory(land: Array<IntArray>): Int {
        for (i in 1 until land.size) {
            land[i][1] += maxOf(land[i - 1][1], land[i - 1][2], land[i - 1][3])
            land[i][2] += maxOf(land[i - 1][0], land[i - 1][2], land[i - 1][3])
            land[i][3] += maxOf(land[i - 1][0], land[i - 1][1], land[i - 1][3])
            land[i][4] += maxOf(land[i - 1][0], land[i - 1][1], land[i - 1][2])
        }
        val answer = land[land.size - 1]
        return answer.max()
    }
}