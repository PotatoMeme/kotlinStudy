package com.potatomeme.programmers.codingtest.years23.april.level1


//아방가르드 타일링
//문제 설명
//정우는 예술적 감각이 뛰어난 타일공입니다. 그는 단순한 타일을 활용하여 불규칙하면서도 화려하게 타일링을 하곤 합니다.
//
//어느 날 정우는 가로 길이 n, 세로 길이 3 인 판을 타일링하는 의뢰를 맡았습니다. 아방가르드한 디자인 영감이 떠오른 정우는 다음과 같은 두 가지 종류의 타일로 타일링을 하기로 결정했습니다.
//그림1.png
//각 타일은 90도씩 회전할 수 있으며 타일의 개수는 제한이 없습니다.
//
//n이 주어졌을 때, 이 두 가지 종류의 타일로 n x 3 크기의 판을 타일링하는 방법의 수를 return 하도록 solution 함수를 완성해주세요.
//
//제한 사항
//1 ≤ n ≤ 100,000
//결과는 매우 클 수 있으므로 1,000,000,007 로 나눈 나머지를 return합니다.
//입출력 예
//n	result
//2	3
//3	10
//입출력 예 설명
//입출력 예 #1
//그림2.png
//위 그림과 같이 3 가지 방법으로 타일링할 수 있습니다.
//
//입출력 예 #2
//그림3.png
//위 그림과 같이 10 가지 방법으로 타일링할 수 있습니다.

// n
// f(1) ->  1
// 2 -> (f(1)) + 2 = 3
// 3 -> (f(2)) + (f(1)*2) + (1+ 4) = 3 + 2 + 5
// 4 -> f(3) + f(2)*2 + f(1)*5
// if(n > 3) n -> f(n-1) + f(n-2)*2 + f
class Solution181186() {
    // n
    // f(1) ->  1
    // 2 -> (f(1)) + 2 = 3
    // 3 -> (f(2)) + (f(1)*2) + (1+ 4) = 3 + 2 + 5
    // 4 -> f(3) + f(2)*2 + f(1)*5 + (2) = 10 + 6 + 5 + 2 = 21
    // 5 -> f(4) + f(3)*2 + f(2)*5 + f(1)*2 + (2)
    // 6 -> f(5) + f(4)*2 + f(3)*5 + f(2)*2 + f(1)*2 +4
    // 7 -> f(6) + f(5)*2 + f(4)*5 + f(3)*2 + f(2)*2 + f(1)*4 +2
    // 8 -> f(7) + f(6)*2 + f(5)*5 + f(4)*2 + f(3)*2 + f(2)*4 + f(1)*2 +2
    // 9 -> f(8) + f(7)*2 + f(6)*5 + f(5)*2 + f(4)*2 + f(3)*4 + f(2)*2 + f(1)*2 +4
    // f(9) - f(6) =  f(8) + f(7)*2 + f(6)*5 + f(5) - f(3)
    // f(9) = f(8) + f(7)*2 + f(6)*6 + f(5) - f(3)
    // if(n > 6) n -> f(n-1) + f(n-2)*2 + f(n-3)*6 + f(n -4) - f(n-6)
    fun solution1(n: Int): Int {
        if (n == 1) return 1
        if (n == 2) return 3
        if (n == 3) return 10
        val arr = IntArray(100_001)
        arr[1] = 1
        arr[2] = 3
        arr[3] = 10
        for (i in 4..n) {
            var long = (arr[i - 1] + arr[i - 2] * 2L + arr[i - 3] * 5L) % 1000000007
            for (j in 4 until i) {
                long += if (j % 3 == 0) {
                    arr[i - j] * 4L
                } else {
                    arr[i - j] * 2L
                }
            }
            arr[i] = ((long + if (i % 3 == 0) 4 else 2) % 1000000007).toInt()
        }
        return arr[n]
    }// time out


    fun solution(n: Int): Int {
        when (n) {
            1 -> return 1
            2 -> return 3
            3 -> return 10
            4 -> return 23
            5 -> return 62
            6 -> return 170
        }
        val arr = IntArray(n + 1)
        arr[1] = 1
        arr[2] = 3
        arr[3] = 10
        arr[4] = 23
        arr[5] = 62
        arr[6] = 170
        for (i in 7..n) {
            var l: Long = arr[i - 1] + arr[i - 2] * 2L + arr[i - 3] * 6L + arr[i - 4]
            if (l < arr[i - 6]) l += 1000000007
            l = (l - arr[i - 6])
            arr[i] = (l % 1000000007).toInt()
        }
        return arr[n]
    }
}