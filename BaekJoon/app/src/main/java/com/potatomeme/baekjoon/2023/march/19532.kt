package com.potatomeme.baekjoon.`2023`.march

import java.util.StringTokenizer


//https://www.acmicpc.net/problem/19532

//수학은 비대면강의입니다
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초 (추가 시간 없음)	1024 MB	8171	4082	3628	52.694%
//문제
//수현이는 4차 산업혁명 시대에 살고 있는 중학생이다. 코로나 19로 인해, 수현이는 버추얼 학교로 버추얼 출석해 버추얼 강의를 듣고 있다. 수현이의 버추얼 선생님은 문자가 2개인 연립방정식을 해결하는 방법에 대해 강의하고, 다음과 같은 문제를 숙제로 냈다.
//
//다음 연립방정식에서
//$x$와
//$y$의 값을 계산하시오.
//
//\[\begin{cases}ax+by=c\\dx+ey=f\end{cases}\] 
//4차 산업혁명 시대에 숙제나 하고 앉아있는 것보다 버추얼 친구들을 만나러 가는 게 더 가치있는 일이라고 생각했던 수현이는 이런 연립방정식을 풀 시간이 없었다. 다행히도, 버추얼 강의의 숙제 제출은 인터넷 창의 빈 칸에 수들을 입력하는 식이다. 각 칸에는
//$-999$ 이상
//$999$ 이하의 정수만 입력할 수 있다. 수현이가 버추얼 친구들을 만나러 버추얼 세계로 떠날 수 있게 도와주자.
//
//입력
//정수
//$a$,
//$b$,
//$c$,
//$d$,
//$e$,
//$f$가 공백으로 구분되어 차례대로 주어진다. (
//$-999 \leq a,b,c,d,e,f \leq 999$)
//
//문제에서 언급한 방정식을 만족하는
//$\left(x,y\right)$가 유일하게 존재하고, 이 때
//$x$와
//$y$가 각각
//$-999$ 이상
//$999$ 이하의 정수인 경우만 입력으로 주어짐이 보장된다.
//
//출력
//문제의 답인
//$x$와
//$y$를 공백으로 구분해 출력한다.
//
//예제 입력 1
//1 3 -1 4 1 7
//예제 출력 1
//2 -1
//예제 입력 2
//2 5 8 3 -4 -11
//예제 출력 2
//-1 2


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val a = st.nextToken().toLong()
    val b = st.nextToken().toLong()
    val c = st.nextToken().toLong()
    val d = st.nextToken().toLong()
    val e = st.nextToken().toLong()
    val f = st.nextToken().toLong()

    val x: Long
    val y: Long

    if (a == 0L || b == 0L || d == 0L || e == 0L) {
        if (a == 0L) {
            y = c / b
            x = (f - e * y) / d
        } else if (b == 0L) {
            x = c / a
            y = (f - d * x) / e
        } else if (d == 0L) {
            y = f / e
            x = (c - b * y) / a
        } else {
            x = f / d
            y = (c - a * x) / b
        }
    } else {
        y = (c * d - f * a) / (b * d - e * a)
        x = (c - b * y) / a
    }
    print("$x $y")
}