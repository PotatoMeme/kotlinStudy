package com.potatomeme.baekjoon.`2023`.december

import java.lang.Integer.max
import java.util.StringTokenizer

//배열 돌리기 3
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	512 MB	9557	4914	3583	50.830%
//문제
//크기가 N×M인 배열이 있을 때, 배열에 연산을 R번 적용하려고 한다. 연산은 총 6가지가 있다.
//
//1번 연산은 배열을 상하 반전시키는 연산이다.
//
//1 6 2 9 8 4 → 4 2 9 3 1 8
//7 2 6 9 8 2 → 9 2 3 6 1 5
//1 8 3 4 2 9 → 7 4 6 2 3 1
//7 4 6 2 3 1 → 1 8 3 4 2 9
//9 2 3 6 1 5 → 7 2 6 9 8 2
//4 2 9 3 1 8 → 1 6 2 9 8 4
//   <배열>       <연산 결과>
//2번 연산은 배열을 좌우 반전시키는 연산이다.
//
//1 6 2 9 8 4 → 4 8 9 2 6 1
//7 2 6 9 8 2 → 2 8 9 6 2 7
//1 8 3 4 2 9 → 9 2 4 3 8 1
//7 4 6 2 3 1 → 1 3 2 6 4 7
//9 2 3 6 1 5 → 5 1 6 3 2 9
//4 2 9 3 1 8 → 8 1 3 9 2 4
//   <배열>       <연산 결과>
//3번 연산은 오른쪽으로 90도 회전시키는 연산이다.
//
//1 6 2 9 8 4 → 4 9 7 1 7 1
//7 2 6 9 8 2 → 2 2 4 8 2 6
//1 8 3 4 2 9 → 9 3 6 3 6 2
//7 4 6 2 3 1 → 3 6 2 4 9 9
//9 2 3 6 1 5 → 1 1 3 2 8 8
//4 2 9 3 1 8 → 8 5 1 9 2 4
//   <배열>       <연산 결과>
//4번 연산은 왼쪽으로 90도 회전시키는 연산이다.
//
//1 6 2 9 8 4 → 4 2 9 1 5 8
//7 2 6 9 8 2 → 8 8 2 3 1 1
//1 8 3 4 2 9 → 9 9 4 2 6 3
//7 4 6 2 3 1 → 2 6 3 6 3 9
//9 2 3 6 1 5 → 6 2 8 4 2 2
//4 2 9 3 1 8 → 1 7 1 7 9 4
//   <배열>       <연산 결과>
//5, 6번 연산을 수행하려면 배열을 크기가 N/2×M/2인 4개의 부분 배열로 나눠야 한다. 아래 그림은 크기가 6×8인 배열을 4개의 그룹으로 나눈 것이고, 1부터 4까지의 수로 나타냈다.
//
//1 1 1 1 2 2 2 2
//1 1 1 1 2 2 2 2
//1 1 1 1 2 2 2 2
//4 4 4 4 3 3 3 3
//4 4 4 4 3 3 3 3
//4 4 4 4 3 3 3 3
//5번 연산은 1번 그룹의 부분 배열을 2번 그룹 위치로, 2번을 3번으로, 3번을 4번으로, 4번을 1번으로 이동시키는 연산이다.
//
//3 2 6 3 1 2 9 7 → 2 1 3 8 3 2 6 3
//9 7 8 2 1 4 5 3 → 1 3 2 8 9 7 8 2
//5 9 2 1 9 6 1 8 → 4 5 1 9 5 9 2 1
//2 1 3 8 6 3 9 2 → 6 3 9 2 1 2 9 7
//1 3 2 8 7 9 2 1 → 7 9 2 1 1 4 5 3
//4 5 1 9 8 2 1 3 → 8 2 1 3 9 6 1 8
//     <배열>            <연산 결과>
//6번 연산은 1번 그룹의 부분 배열을 4번 그룹 위치로, 4번을 3번으로, 3번을 2번으로, 2번을 1번으로 이동시키는 연산이다.
//
//3 2 6 3 1 2 9 7 → 1 2 9 7 6 3 9 2
//9 7 8 2 1 4 5 3 → 1 4 5 3 7 9 2 1
//5 9 2 1 9 6 1 8 → 9 6 1 8 8 2 1 3
//2 1 3 8 6 3 9 2 → 3 2 6 3 2 1 3 8
//1 3 2 8 7 9 2 1 → 9 7 8 2 1 3 2 8
//4 5 1 9 8 2 1 3 → 5 9 2 1 4 5 1 9
//     <배열>            <연산 결과>
//입력
//첫째 줄에 배열의 크기 N, M과 수행해야 하는 연산의 수 R이 주어진다.
//
//둘째 줄부터 N개의 줄에 배열 A의 원소 Aij가 주어진다.
//
//마지막 줄에는 수행해야 하는 연산이 주어진다. 연산은 공백으로 구분되어져 있고, 문제에서 설명한 연산 번호이며, 순서대로 적용시켜야 한다.
//
//출력
//입력으로 주어진 배열에 R개의 연산을 순서대로 수행한 결과를 출력한다.
//
//제한
//2 ≤ N, M ≤ 100
//1 ≤ R ≤ 1,000
//N, M은 짝수
//1 ≤ Aij ≤ 108
//예제 입력 1
//6 8 1
//3 2 6 3 1 2 9 7
//9 7 8 2 1 4 5 3
//5 9 2 1 9 6 1 8
//2 1 3 8 6 3 9 2
//1 3 2 8 7 9 2 1
//4 5 1 9 8 2 1 3
//1
//예제 출력 1
//4 5 1 9 8 2 1 3
//1 3 2 8 7 9 2 1
//2 1 3 8 6 3 9 2
//5 9 2 1 9 6 1 8
//9 7 8 2 1 4 5 3
//3 2 6 3 1 2 9 7
//예제 입력 2
//6 8 1
//3 2 6 3 1 2 9 7
//9 7 8 2 1 4 5 3
//5 9 2 1 9 6 1 8
//2 1 3 8 6 3 9 2
//1 3 2 8 7 9 2 1
//4 5 1 9 8 2 1 3
//2
//예제 출력 2
//7 9 2 1 3 6 2 3
//3 5 4 1 2 8 7 9
//8 1 6 9 1 2 9 5
//2 9 3 6 8 3 1 2
//1 2 9 7 8 2 3 1
//3 1 2 8 9 1 5 4
//예제 입력 3
//6 8 1
//3 2 6 3 1 2 9 7
//9 7 8 2 1 4 5 3
//5 9 2 1 9 6 1 8
//2 1 3 8 6 3 9 2
//1 3 2 8 7 9 2 1
//4 5 1 9 8 2 1 3
//3
//예제 출력 3
//4 1 2 5 9 3
//5 3 1 9 7 2
//1 2 3 2 8 6
//9 8 8 1 2 3
//8 7 6 9 1 1
//2 9 3 6 4 2
//1 2 9 1 5 9
//3 1 2 8 3 7
//예제 입력 4
//6 8 1
//3 2 6 3 1 2 9 7
//9 7 8 2 1 4 5 3
//5 9 2 1 9 6 1 8
//2 1 3 8 6 3 9 2
//1 3 2 8 7 9 2 1
//4 5 1 9 8 2 1 3
//4
//예제 출력 4
//7 3 8 2 1 3
//9 5 1 9 2 1
//2 4 6 3 9 2
//1 1 9 6 7 8
//3 2 1 8 8 9
//6 8 2 3 2 1
//2 7 9 1 3 5
//3 9 5 2 1 4
//예제 입력 5
//6 8 1
//3 2 6 3 1 2 9 7
//9 7 8 2 1 4 5 3
//5 9 2 1 9 6 1 8
//2 1 3 8 6 3 9 2
//1 3 2 8 7 9 2 1
//4 5 1 9 8 2 1 3
//5
//예제 출력 5
//2 1 3 8 3 2 6 3
//1 3 2 8 9 7 8 2
//4 5 1 9 5 9 2 1
//6 3 9 2 1 2 9 7
//7 9 2 1 1 4 5 3
//8 2 1 3 9 6 1 8
//예제 입력 6
//6 8 1
//3 2 6 3 1 2 9 7
//9 7 8 2 1 4 5 3
//5 9 2 1 9 6 1 8
//2 1 3 8 6 3 9 2
//1 3 2 8 7 9 2 1
//4 5 1 9 8 2 1 3
//6
//예제 출력 6
//1 2 9 7 6 3 9 2
//1 4 5 3 7 9 2 1
//9 6 1 8 8 2 1 3
//3 2 6 3 2 1 3 8
//9 7 8 2 1 3 2 8
//5 9 2 1 4 5 1 9
//예제 입력 7
//6 8 6
//3 2 6 3 1 2 9 7
//9 7 8 2 1 4 5 3
//5 9 2 1 9 6 1 8
//2 1 3 8 6 3 9 2
//1 3 2 8 7 9 2 1
//4 5 1 9 8 2 1 3
//1 2 3 4 5 6
//예제 출력 7
//3 1 2 8 9 1 5 4
//1 2 9 7 8 2 3 1
//2 9 3 6 8 3 1 2
//8 1 6 9 1 2 9 5
//3 5 4 1 2 8 7 9
//7 9 2 1 3 6 2 3


fun main() {
    with(System.`in`.bufferedReader()) {
        val (n, m, r) = readLine().split(" ").map { it.toInt() }
        val max = max(n, m)
        val arr = Array(max) { idx1 ->
            if (idx1 < n) {
                val st = StringTokenizer(readLine())
                IntArray(max) { idx2 ->
                    if (idx2 < m) st.nextToken().toInt() else 0
                }
            } else {
                IntArray(max)
            }
        }
        val tempArr = Array(max) { IntArray(max) }

        val st = StringTokenizer(readLine())
        val orderArr = IntArray(r) {
            st.nextToken().toInt()
        }

        var currentWidth = m
        var currentHeight = n

        for (order in orderArr) {
            when (order) {
                1 -> { //1번 연산은 배열을 상하 반전시키는 연산이다.
                    for (i in 0 until currentHeight) {
                        for (j in 0 until currentWidth) {
                            tempArr[currentHeight - i - 1][j] = arr[i][j]
                        }
                    }
                }

                2 -> { //2번 연산은 배열을 좌우 반전시키는 연산이다.
                    for (i in 0 until currentHeight) {
                        for (j in 0 until currentWidth) {
                            tempArr[i][currentWidth - j - 1] = arr[i][j]
                        }
                    }
                }

                3 -> { //3번 연산은 오른쪽으로 90도 회전시키는 연산이다.
                    val temp = currentWidth
                    currentWidth = currentHeight
                    currentHeight = temp
                    for (i in 0 until currentHeight) {
                        for (j in 0 until currentWidth) {
                            tempArr[i][j] = arr[currentWidth - j - 1][i]
                        }
                    }
                }

                4 -> { //4번 연산은 왼쪽으로 90도 회전시키는 연산이다.
                    val temp = currentWidth
                    currentWidth = currentHeight
                    currentHeight = temp
                    for (i in 0 until currentHeight) {
                        for (j in 0 until currentWidth) {
                            tempArr[i][j] = arr[j][currentHeight - i - 1]
                        }
                    }
                }

                5 -> { // 5번 연산
                    val halfWidth = currentWidth / 2
                    val halfHeight = currentHeight / 2

                    for (i in 0 until halfHeight) {
                        for (j in 0 until halfWidth) {
                            tempArr[i][j + halfWidth] = arr[i][j]
                            tempArr[i + halfHeight][j + halfWidth] = arr[i][j + halfWidth]
                            tempArr[i + halfHeight][j] = arr[i + halfHeight][j + halfWidth]
                            tempArr[i][j] = arr[i + halfHeight][j]
                        }
                    }
                }

                6 -> { // 6번 연산
                    val halfWidth = currentWidth / 2
                    val halfHeight = currentHeight / 2

                    for (i in 0 until halfHeight) {
                        for (j in 0 until halfWidth) {
                            tempArr[i + halfHeight][j] = arr[i][j]
                            tempArr[i + halfHeight][j + halfWidth] = arr[i + halfHeight][j]
                            tempArr[i][j + halfWidth] = arr[i + halfHeight][j + halfWidth]
                            tempArr[i][j] = arr[i][j + halfWidth]
                        }
                    }
                }
            }
            for (i in 0 until currentHeight) {
                for (j in 0 until currentWidth) {
                    arr[i][j] = tempArr[i][j]
                }
            }
        }
        val sb = StringBuilder()
        for (i in 0 until currentHeight) {
            for (j in 0 until currentWidth) {
                sb.append(arr[i][j]).append(" ")
            }
            sb.appendLine()
        }
        print(sb.toString())
    }
}