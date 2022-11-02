package com.potatomeme.programmers.codingtest.years22.october.level1

import java.util.*

//햄버거 만들기
//문제 설명
//햄버거 가게에서 일을 하는 상수는 햄버거를 포장하는 일을 합니다. 함께 일을 하는 다른 직원들이 햄버거에 들어갈 재료를 조리해 주면 조리된 순서대로 상수의 앞에 아래서부터 위로 쌓이게 되고, 상수는 순서에 맞게 쌓여서 완성된 햄버거를 따로 옮겨 포장을 하게 됩니다. 상수가 일하는 가게는 정해진 순서(아래서부터, 빵 – 야채 – 고기 - 빵)로 쌓인 햄버거만 포장을 합니다. 상수는 손이 굉장히 빠르기 때문에 상수가 포장하는 동안 속 재료가 추가적으로 들어오는 일은 없으며, 재료의 높이는 무시하여 재료가 높이 쌓여서 일이 힘들어지는 경우는 없습니다.
//
//예를 들어, 상수의 앞에 쌓이는 재료의 순서가 [야채, 빵, 빵, 야채, 고기, 빵, 야채, 고기, 빵]일 때, 상수는 여섯 번째 재료가 쌓였을 때, 세 번째 재료부터 여섯 번째 재료를 이용하여 햄버거를 포장하고, 아홉 번째 재료가 쌓였을 때, 두 번째 재료와 일곱 번째 재료부터 아홉 번째 재료를 이용하여 햄버거를 포장합니다. 즉, 2개의 햄버거를 포장하게 됩니다.
//
//상수에게 전해지는 재료의 정보를 나타내는 정수 배열 ingredient가 주어졌을 때, 상수가 포장하는 햄버거의 개수를 return 하도록 solution 함수를 완성하시오.
//
//제한사항
//1 ≤ ingredient의 길이 ≤ 1,000,000
//ingredient의 원소는 1, 2, 3 중 하나의 값이며, 순서대로 빵, 야채, 고기를 의미합니다.
//입출력 예
//ingredient	result
//[2, 1, 1, 2, 3, 1, 2, 3, 1]	2
//[1, 3, 2, 1, 2, 1, 3, 1, 2]	0

class Solution133502 {
    fun solution_try1(ingredient: IntArray): Int {
        var str = ingredient.joinToString("")
        var answer = 0

        while (true) {
            val save = str.replace("1231", "")
            if (save == str) {
                break
            } else {
                str = save
                answer++
            }
        }
        return answer
    }// 시간초과

    fun solution_try2(ingredient: IntArray): Int {
        var answer = 0
        var arr1: List<Int>
        var arr2 = ingredient.toList()
        do {
            arr1 = arr2
            for (i in arr1.indices) {
                if (arr1[i] == 1) {
                    try {
                        if (arr1[i + 1] == 2 && arr1[i + 2] == 3 && arr1[i + 3] == 1) {
                            arr2 =
                                arr2.filterIndexed { index, _ -> index != i && index != i + 1 && index != i + 2 && index != i + 3 }
                            answer++
                            break
                        }
                    } catch (exception: Exception) {
                        break
                    }
                }
            }
        } while (arr1 != arr2)
        return answer
    }// 시간초과

    fun solution_try3(ingredient: IntArray): Int {
        var answer = 0
        var list = arrayListOf<Int>()
        for (i in ingredient) {
            list.add(i)
            if (list.size > 3) {
                if (list[list.size - 1] == 1 && list[list.size - 2] == 3 && list[list.size - 3] == 2 && list[list.size - 4] == 1) {
                    answer++
                    list.removeLast()
                    list.removeLast()
                    list.removeLast()
                    list.removeLast()
                }
            }
        }
        return answer
    }

    fun user1Solution(ingredient: IntArray): Int {
        var answer: Int = 0
        val sb = StringBuilder()
        for (item in ingredient) {
            sb.append('0' + item)
            if (sb.length >= 4 && sb.substring(sb.length - 4) == "1231") {
                sb.setLength(sb.length - 4)
                answer++
            }
        }
        return answer
    }

    fun user2Solution(ingredient: IntArray): Int {
        return ingredient.fold(Stack<Int>()) { acc, i ->
            acc.push(i)
            if (acc.size > 3 && acc[acc.lastIndex] == 1 && acc[acc.lastIndex - 1] == 3 && acc[acc.lastIndex - 2] == 2 && acc[acc.lastIndex - 3] == 1) {
                repeat(4) { acc.pop() }
                acc.insertElementAt(-1, 0)
            }
            return@fold acc
        }.count { it == -1 }
    }
}