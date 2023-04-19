package com.potatomeme.programmers.codingtest.years23.april.level2


//행렬 테두리 회전하기
//문제 설명
//rows x columns 크기인 행렬이 있습니다. 행렬에는 1부터 rows x columns까지의 숫자가 한 줄씩 순서대로 적혀있습니다. 이 행렬에서 직사각형 모양의 범위를 여러 번 선택해, 테두리 부분에 있는 숫자들을 시계방향으로 회전시키려 합니다. 각 회전은 (x1, y1, x2, y2)인 정수 4개로 표현하며, 그 의미는 다음과 같습니다.
//
//x1 행 y1 열부터 x2 행 y2 열까지의 영역에 해당하는 직사각형에서 테두리에 있는 숫자들을 한 칸씩 시계방향으로 회전합니다.
//다음은 6 x 6 크기 행렬의 예시입니다.
//
//grid_example.png
//
//이 행렬에 (2, 2, 5, 4) 회전을 적용하면, 아래 그림과 같이 2행 2열부터 5행 4열까지 영역의 테두리가 시계방향으로 회전합니다. 이때, 중앙의 15와 21이 있는 영역은 회전하지 않는 것을 주의하세요.
//
//rotation_example.png
//
//행렬의 세로 길이(행 개수) rows, 가로 길이(열 개수) columns, 그리고 회전들의 목록 queries가 주어질 때, 각 회전들을 배열에 적용한 뒤, 그 회전에 의해 위치가 바뀐 숫자들 중 가장 작은 숫자들을 순서대로 배열에 담아 return 하도록 solution 함수를 완성해주세요.
//
//제한사항
//rows는 2 이상 100 이하인 자연수입니다.
//columns는 2 이상 100 이하인 자연수입니다.
//처음에 행렬에는 가로 방향으로 숫자가 1부터 하나씩 증가하면서 적혀있습니다.
//즉, 아무 회전도 하지 않았을 때, i 행 j 열에 있는 숫자는 ((i-1) x columns + j)입니다.
//queries의 행의 개수(회전의 개수)는 1 이상 10,000 이하입니다.
//queries의 각 행은 4개의 정수 [x1, y1, x2, y2]입니다.
//x1 행 y1 열부터 x2 행 y2 열까지 영역의 테두리를 시계방향으로 회전한다는 뜻입니다.
//1 ≤ x1 < x2 ≤ rows, 1 ≤ y1 < y2 ≤ columns입니다.
//모든 회전은 순서대로 이루어집니다.
//예를 들어, 두 번째 회전에 대한 답은 첫 번째 회전을 실행한 다음, 그 상태에서 두 번째 회전을 실행했을 때 이동한 숫자 중 최솟값을 구하면 됩니다.
//입출력 예시
//rows	columns	queries	result
//6	6	[[2,2,5,4],[3,3,6,6],[5,1,6,3]]	[8, 10, 25]
//3	3	[[1,1,2,2],[1,2,2,3],[2,1,3,2],[2,2,3,3]]	[1, 1, 5, 3]
//100	97	[[1,1,100,97]]	[1]
//입출력 예 설명
//입출력 예 #1
//
//회전을 수행하는 과정을 그림으로 표현하면 다음과 같습니다.
//example1.png
//입출력 예 #2
//
//회전을 수행하는 과정을 그림으로 표현하면 다음과 같습니다.
//example2.png
//입출력 예 #3
//
//이 예시에서는 행렬의 테두리에 위치한 모든 칸들이 움직입니다. 따라서, 행렬의 테두리에 있는 수 중 가장 작은 숫자인 1이 바로 답이 됩니다. 있습니다. 따라서 3은 조건에 해당하는 양의 정수입니다. 하지만, 철수가 가진 카드들에 적힌 숫자들은 모두 7로 나눌 수 있고, 영희가 가진 카드들에 적힌 숫자는 모두 7로 나눌 수 없습니다. 따라서 최대값인 7을 return 합니다.


class Solution77485() {
    lateinit var arr: Array<IntArray>
    lateinit var ans: IntArray
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        arr = Array(rows) { i1 -> IntArray(columns) { i2 -> i1 * columns + i2 + 1 } }
        ans = IntArray(queries.size)
        queries.forEachIndexed { index, ints ->
            ans[index] = rotate(ints[0] - 1, ints[1] - 1, ints[2] - 1, ints[3] - 1)
        }
        return ans.sortedArray()
    }

    private fun rotate(x1: Int, y1: Int, x2: Int, y2: Int): Int {
        val first = arr[x1][y1]
        var min = first
        var temp = first
        for (i in y1 until y2) {
            val n = temp
            if (n < min) min = temp
            temp = arr[x1][i + 1]
            arr[x1][i + 1] = n
        }

        for (i in x1 until x2) {
            val n = temp
            if (n < min) min = temp
            temp = arr[i + 1][y2]
            arr[i + 1][y2] = n
        }

        for (i in y2 downTo y1 + 1) {
            val n = temp
            if (n < min) min = temp
            temp = arr[x2][i - 1]
            arr[x2][i - 1] = n
        }

        for (i in x2 downTo x1 + 1) {
            val n = temp
            if (n < min) min = temp
            temp = arr[i - 1][y1]
            arr[i - 1][y1] = n
        }

        return min
    }
}