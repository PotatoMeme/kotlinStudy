package com.potatomeme.programmers.codingtest.years23.feb.level2

import java.util.*


//뒤에 있는 큰 수 찾기
//문제 설명
//정수로 이루어진 배열 numbers가 있습니다. 배열 의 각 원소들에 대해 자신보다 뒤에 있는 숫자 중에서 자신보다 크면서 가장 가까이 있는 수를 뒷 큰수라고 합니다.
//정수 배열 numbers가 매개변수로 주어질 때, 모든 원소에 대한 뒷 큰수들을 차례로 담은 배열을 return 하도록 solution 함수를 완성해주세요. 단, 뒷 큰수가 존재하지 않는 원소는 -1을 담습니다.
//
//제한사항
//4 ≤ numbers의 길이 ≤ 1,000,000
//1 ≤ numbers[i] ≤ 1,000,000
//입출력 예
//numbers	result
//[2, 3, 3, 5]	[3, 5, 5, -1]
//[9, 1, 5, 3, 6, 2]	[-1, 5, 6, 6, -1, -1]
//입출력 예 설명
//입출력 예 #1
//2의 뒷 큰수는 3입니다. 첫 번째 3의 뒷 큰수는 5입니다. 두 번째 3 또한 마찬가지입니다. 5는 뒷 큰수가 없으므로 -1입니다. 위 수들을 차례대로 배열에 담으면 [3, 5, 5, -1]이 됩니다.
//
//입출력 예 #2
//9는 뒷 큰수가 없으므로 -1입니다. 1의 뒷 큰수는 5이며, 5와 3의 뒷 큰수는 6입니다. 6과 2는 뒷 큰수가 없으므로 -1입니다. 위 수들을 차례대로 배열에 담으면 [-1, 5, 6, 6, -1, -1]이 됩니다.

class Solution154539() {
    fun solution1(numbers: IntArray): IntArray {
        val numbers_size = numbers.size

        val answer = IntArray(numbers_size)

        fun solve(idx: Int): Int {
            for (i in idx + 1 until numbers_size) {
                if (numbers[idx] < numbers[i]) return numbers[i]
            }
            return -1
        }
        for (i in answer.indices) {
            answer[i] = solve(i)
        }
        return answer
    }//time out,test 20~23

    fun solution2(numbers: IntArray): IntArray {
        val numbers_size = numbers.size
        val answer = IntArray(numbers_size) { -1 }
        var max = 0
        var max_idx = numbers_size - 1
        for (i in numbers_size - 1 downTo 0) {
            if (max <= numbers[i]) {
                max = numbers[i]
                max_idx = i
                continue
            }
            j@ for (j in i + 1..max_idx) {
                if (numbers[i] < numbers[j]) {
                    answer[i] = numbers[j]
                    break@j
                } else if (numbers[i] == numbers[j]) {
                    answer[i] = answer[j]
                    break@j
                }
            }
        }
        return answer
    }

    fun solution3(numbers: IntArray): IntArray {
        val numbers_size = numbers.size
        val answer = IntArray(numbers_size) { -1 }
        val stack = Stack<Int>()
        stack.add(numbers.last())
        for (i in numbers_size - 1 downTo 0) {
            if (stack[0] < numbers[i]) {
                repeat(stack.size) { stack.pop() }
                stack.add(numbers[i])
            } else if (stack[0] == numbers[i]) {
                repeat(stack.size - 1) { stack.pop() }
            } else {
                while (true) {
                    if (numbers[i] < stack.peek()) {
                        answer[i] = stack.peek()
                        stack.add(numbers[i])
                        break
                    }
                    stack.pop()
                }
            }
        }
        return answer
    }
}
