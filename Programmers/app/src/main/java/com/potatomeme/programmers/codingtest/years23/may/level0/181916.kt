package com.potatomeme.programmers.codingtest.years23.may.level0

import kotlin.math.abs
import kotlin.math.min


//주사위 게임 3
//문제 설명
//1부터 6까지 숫자가 적힌 주사위가 네 개 있습니다. 네 주사위를 굴렸을 때 나온 숫자에 따라 다음과 같은 점수를 얻습니다.
//
//네 주사위에서 나온 숫자가 모두 p로 같다면 1111 × p점을 얻습니다.
//세 주사위에서 나온 숫자가 p로 같고 나머지 다른 주사위에서 나온 숫자가 q(p ≠ q)라면 (10 × p + q)2 점을 얻습니다.
//주사위가 두 개씩 같은 값이 나오고, 나온 숫자를 각각 p, q(p ≠ q)라고 한다면 (p + q) × |p - q|점을 얻습니다.
//어느 두 주사위에서 나온 숫자가 p로 같고 나머지 두 주사위에서 나온 숫자가 각각 p와 다른 q, r(q ≠ r)이라면 q × r점을 얻습니다.
//네 주사위에 적힌 숫자가 모두 다르다면 나온 숫자 중 가장 작은 숫자 만큼의 점수를 얻습니다.
//네 주사위를 굴렸을 때 나온 숫자가 정수 매개변수 a, b, c, d로 주어질 때, 얻는 점수를 return 하는 solution 함수를 작성해 주세요.
//
//제한사항
//a, b, c, d는 1 이상 6 이하의 정수입니다.
//입출력 예
//a	b	c	d	result
//2	2	2	2	2222
//4	1	4	4	1681
//6	3	3	6	27
//2	5	2	6	30
//6	4	2	5	2
//입출력 예 설명
//입출력 예 #1
//
//예제 1번에서 네 주사위 숫자가 모두 2로 같으므로 1111 × 2 = 2222점을 얻습니다. 따라서 2222를 return 합니다.
//입출력 예 #2
//
//예제 2번에서 세 주사위에서 나온 숫자가 4로 같고 나머지 다른 주사위에서 나온 숫자가 1이므로 (10 × 4 + 1)2 = 412 = 1681점을 얻습니다. 따라서 1681을 return 합니다.
//입출력 예 #3
//
//예제 3번에서 a, d는 6으로, b, c는 3으로 각각 같으므로 (6 + 3) × |6 - 3| = 9 × 3 = 27점을 얻습니다. 따라서 27을 return 합니다.
//입출력 예 #4
//
//예제 4번에서 두 주사위에서 2가 나오고 나머지 다른 두 주사위에서 각각 5, 6이 나왔으므로 5 × 6 = 30점을 얻습니다. 따라서 30을 return 합니다.
//입출력 예 #5
//
//예제 5번에서 네 주사위 숫자가 모두 다르고 나온 숫자 중 가장 작은 숫자가 2이므로 2점을 얻습니다. 따라서 2를 return 합니다.

class Solution181916 {
    fun solution1(a: Int, b: Int, c: Int, d: Int): Int {
        //네 주사위에서 나온 숫자가 모두 p로 같다면 1111 × p점을 얻습니다.
        if (a == b && b == c && c === d) return 1111 * a
        //세 주사위에서 나온 숫자가 p로 같고 나머지 다른 주사위에서 나온 숫자가 q(p ≠ q)라면 (10 × p + q)2 점을 얻습니다.
        if (a == b && b == c && a != d) return (10 * a + d) * (10 * a + d) // d가 다름
        if (a == b && b == d && a != c) return (10 * a + c) * (10 * a + c) // c가 다름
        if (a == c && c == d && a != b) return (10 * a + b) * (10 * a + b) // b가 다름
        if (b == c && c == d && b != a) return (10 * b + a) * (10 * b + a) // a가 다름
        //주사위가 두 개씩 같은 값이 나오고, 나온 숫자를 각각 p, q(p ≠ q)라고 한다면 (p + q) × |p - q|점을 얻습니다.
        if (a == b && c == d && a != c) return (a + c) * abs(a - c) // [a,b],[c,d]
        if (a == c && b == d && a != b) return (a + b) * abs(a - b) // [a,c],[b,d]
        if (a == d && b == c && a != b) return (a + b) * abs(a - b) // [a,d],[b,c]
        //어느 두 주사위에서 나온 숫자가 p로 같고 나머지 두 주사위에서 나온 숫자가 각각 p와 다른 q, r(q ≠ r)이라면 q × r점을 얻습니다.
        if (a == b && a != c && a != d && c != d) return c * d
        if (a == c && a != b && a != d && b != d) return b * d
        if (a == d && a != b && a != c && b != c) return b * c
        if (b == c && b != a && b != d && a != d) return a * d
        if (b == d && b != a && b != c && a != c) return a * c
        if (c == d && c != a && c != b && a != b) return a * b
        //네 주사위에 적힌 숫자가 모두 다르다면 나온 숫자 중 가장 작은 숫자 만큼의 점수를 얻습니다.
        return minOf(a, b, c, d)
    }

    fun solution2(a: Int, b: Int, c: Int, d: Int): Int {
        val min = minOf(a, b, c, d)
        val max = maxOf(a, b, c, d)

        // 네 주사위에서 나온 숫자가 모두 같다면 1111 × p점을 얻습니다.
        if (min == max) return 1111 * min

        val counts = intArrayOf(0, 0, 0, 0, 0, 0)
        counts[a - 1]++
        counts[b - 1]++
        counts[c - 1]++
        counts[d - 1]++

        // 네 주사위에 적힌 숫자가 모두 다르다면 나온 숫자 중 가장 작은 숫자 만큼의 점수를 얻습니다.
        if (counts[min - 1] == 1 && counts[max - 1] == 1) return min

        // 세 주사위에서 나온 숫자가 p로 같고 나머지 다른 주사위에서 나온 숫자가 q(p ≠ q)라면 (10 × p + q)2 점을 얻습니다.
        if (counts[min - 1] == 3 || counts[max - 1] == 3) {
            val p = if (counts[min - 1] == 3) min else max
            val q = if (counts[min - 1] == 3) max else min
            return (10 * p + q) * (10 * p + q)
        }

        // 주사위가 두 개씩 같은 값이 나오고, 나온 숫자를 각각 p, q(p ≠ q)라고 한다면 (p + q) × |p - q|점을 얻습니다.
        if (counts.contains(2) && counts.contains(1)) {
            val p = counts.indexOf(2) + 1
            val q = counts.indexOf(1) + 1
            return (p + q) * abs(p - q)
        }

        // 어느 두 주사위에서 나온 숫자가 p로 같고 나머지 두 주사위에서 나온 숫자가 각각 p와 다른 q, r(q ≠ r)이라면 q × r점을 얻습니다.
        if (counts.contains(2)) {
            val p = counts.indexOf(2) + 1
            val others = counts.filterIndexed { index, _ -> index != p - 1 }
            val q = others[0]
            val r = others[1]
            return q * r
        }

        return min
    }
}

