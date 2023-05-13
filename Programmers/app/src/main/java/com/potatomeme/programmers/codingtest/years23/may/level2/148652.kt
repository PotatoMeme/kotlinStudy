package com.potatomeme.programmers.codingtest.years23.may.level2

import kotlin.math.pow


//유사 칸토어 비트열
//문제 설명
//수학에서 칸토어 집합은 0과 1 사이의 실수로 이루어진 집합으로, [0, 1]부터 시작하여 각 구간을 3등분하여 가운데 구간을 반복적으로 제외하는 방식으로 만들어집니다.
//
//남아는 칸토어 집합을 조금 변형하여 유사 칸토어 비트열을 만들었습니다. 유사 칸토어 비트열은 다음과 같이 정의됩니다.
//
//0 번째 유사 칸토어 비트열은 "1" 입니다.
//n(1 ≤ n) 번째 유사 칸토어 비트열은 n - 1 번째 유사 칸토어 비트열에서의 1을 11011로 치환하고 0을 00000로 치환하여 만듭니다.
//남아는 n 번째 유사 칸토어 비트열에서 특정 구간 내의 1의 개수가 몇 개인지 궁금해졌습니다.
//n과 1의 개수가 몇 개인지 알고 싶은 구간을 나타내는 l, r이 주어졌을 때 그 구간 내의 1의 개수를 return 하도록 solution 함수를 완성해주세요.
//
//제한사항
//1 ≤ n ≤ 20
//1 ≤ l, r ≤ 5n
//l ≤ r < l + 10,000,000
//l과 r은 비트열에서의 인덱스(1-base)이며 폐구간 [l, r]을 나타냅니다.
//입출력 예
//n	l	r	result
//2	4	17	8
//입출력 예 설명
//2 번째 유사 칸토어 비트열은 "1101111011000001101111011" 입니다. 음영 표시된 부분은 폐구간 [4, 17] 이며 구간 내의 1은 8개 있습니다.

class Solution148652() {
    //1 len 1
    //4 len 5 0space 3 0cnt 1
    //16 len 25 0space  3 8 11~15 18 23 0cnt 9
    //64 len 125 0space  3 8 11~15 18 23 ... 0cnt 9*4+25
    //256 len 625 0space  3 8 11~15 18 23 ... 0cnt (9*4+25)*4+125

    //n -> 5^n
    // 5^20 = 95,367,431,640,625

    // 1안
    // for i in l-1 .. r-1
    //(i/1)%5 == 2 || (i/5)%5 == 2 || (i/25)%5 == 2 || .. || (i/5^(n-1))==2 => 0 , /연산이 오래걸리고 부담도 되서 timeout이 나올것 같음

    //2안 l~r까지 쪼개기
    //l~r을쪽개 5로 나눠 쪼개 해당구간이 1이될때까지 쪼개서 그구간을 위 0연산으로 확인을하여 해당 연산에서 0가 아닐경우 depth만큼 4씩 재곱해줌 이걸반복
    fun solution(n: Int, l: Long, r: Long): Int {
        return countOne(n, l, r, 1)
    }

    private fun countOne(n: Int, s: Long, e: Long, idx: Long): Int {
        if (n == 0) {
            return 1
        }
        var num = 0
        val part = 5.0.pow((n - 1).toDouble()).toLong()
        for (i in 0..4) {
            if (i == 2 || e < idx + part * i || idx + part * (i + 1) - 1 < s) continue
            num += countOne(n - 1, s, e, idx + part * i)
        }
        return num
    }
}