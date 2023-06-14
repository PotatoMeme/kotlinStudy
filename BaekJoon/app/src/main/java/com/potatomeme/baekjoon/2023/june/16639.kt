package com.potatomeme.baekjoon.`2023`.june

//https://www.acmicpc.net/problem/16639

//괄호 추가하기 3
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1.5 초 (추가 시간 없음)	512 MB	1224	495	398	44.669%
//문제
//길이가 N인 수식이 있다. 수식은 0보다 크거나 같고, 9보다 작거나 같은 정수와 연산자(+, -, ×)로 이루어져 있다. 곱하기의 연산자 우선순위가 더하기와 빼기보다 높기 때문에, 곱하기를 먼저 계산 해야 한다. 수식을 계산할 때는 왼쪽에서부터 순서대로 계산해야 한다. 예를 들어, 3+8×7-9×2의 결과는 41이다.
//
//수식에 괄호를 추가하면, 괄호 안에 들어있는 식은 먼저 계산해야 한다. 예를 들어, 3+8×7-9×2에 괄호를 (3+8)×7-(9×2)와 같이 추가했으면, 식의 결과는 59가 된다. 중첩된 괄호도 사용할 수 있고, 괄호 안에 여러 개의 연산자가 들어 있어도 된다. 즉, 3+((8×7)-9)×2, 3+((8×7)-(9×2)), (3+8)×(7-9×2) 모두 올바른 식이고, 결과는 97, 41, -121이다.
//
//수식이 주어졌을 때, 괄호를 적절히 추가해 만들 수 있는 식의 결과의 최댓값을 구하는 프로그램을 작성하시오. 추가하는 괄호 개수의 제한은 없으며, 추가하지 않아도 된다.
//
//입력
//첫째 줄에 수식의 길이 N(1 ≤ N ≤ 19)가 주어진다. 둘째 줄에는 수식이 주어진다. 수식에 포함된 정수는 모두 0보다 크거나 같고, 9보다 작거나 같다. 문자열은 정수로 시작하고, 연산자와 정수가 번갈아가면서 나온다. 연산자는 +, -, * 중 하나이다. 여기서 *는 곱하기 연산을 나타내는 × 연산이다. 항상 올바른 수식만 주어지기 때문에, N은 홀수이다.
//
//출력
//첫째 줄에 괄호를 적절히 추가해서 얻을 수 있는 결과의 최댓값을 출력한다. 정답은 231보다 작고, -231보다 크다.
//
//예제 입력 1
//9
//3+8*7-9*2
//예제 출력 1
//136
//예제 입력 2
//5
//8*3+5
//예제 출력 2
//64
//예제 입력 3
//7
//8*3+5+2
//예제 출력 3
//80
//예제 입력 4
//19
//1*2+3*4*5-6*7*8*9*0
//예제 출력 4
//100
//예제 입력 5
//19
//1*2+3*4*5-6*7*8*9*9
//예제 출력 5
//426384
//예제 입력 6
//19
//1-9-1-9-1-9-1-9-1-9
//예제 출력 6
//32


fun main() = with(System.`in`.bufferedReader()) {
    val lineLength = readLine().toInt()
    val line = readLine()

    val nums = IntArray(lineLength / 2 + 1)
    val visitedNums = BooleanArray(nums.size)
    val operators = CharArray(lineLength / 2)
    val visitedOperators = BooleanArray(operators.size)

    line.forEachIndexed { index, c ->
        if (index % 2 == 0) { // 숫자
            nums[index / 2] = c - '0'
        } else { // 연산자
            operators[index / 2] = c
        }
    }


    var max = Int.MIN_VALUE

    fun dfs(depth: Int) {
        if (depth == visitedOperators.size) {
            if (nums[0] > max) max = nums[0]
            return
        }

        for (i in visitedOperators.indices) {
            if (!visitedOperators[i]) {
                visitedOperators[i] = true
                var aIndex = i
                while (visitedNums[aIndex]) {
                    --aIndex
                }
                val a = nums[aIndex]
                var bIndex = i + 1
                while (visitedNums[bIndex]) {
                    ++bIndex
                }
                val b = nums[bIndex]
                visitedNums[bIndex] = true

                when (operators[i]) {
                    '+' -> nums[aIndex] = a + b
                    '-' -> nums[aIndex] = a - b
                    '*' -> nums[aIndex] = a * b
                }

                dfs(depth+1)

                nums[aIndex] = a
                visitedNums[bIndex] = false
                visitedOperators[i] = false
            }
        }
    }

    dfs(0)
    print(max)
}