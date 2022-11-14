package com.potatomeme.programmers.codingtest.years22.november.level2

//모음 사전
//문제 설명
//사전에 알파벳 모음 'A', 'E', 'I', 'O', 'U'만을 사용하여 만들 수 있는, 길이 5 이하의 모든 단어가 수록되어 있습니다. 사전에서 첫 번째 단어는 "A"이고, 그다음은 "AA"이며, 마지막 단어는 "UUUUU"입니다.
//
//단어 하나 word가 매개변수로 주어질 때, 이 단어가 사전에서 몇 번째 단어인지 return 하도록 solution 함수를 완성해주세요.
//
//제한사항
//word의 길이는 1 이상 5 이하입니다.
//word는 알파벳 대문자 'A', 'E', 'I', 'O', 'U'로만 이루어져 있습니다.
//입출력 예
//word	result
//"AAAAE"	6
//"AAAE"	10
//"I"	1563
//"EIO"	1189
//입출력 예 설명
//입출력 예 #1
//
//사전에서 첫 번째 단어는 "A"이고, 그다음은 "AA", "AAA", "AAAA", "AAAAA", "AAAAE", ... 와 같습니다. "AAAAE"는 사전에서 6번째 단어입니다.
//
//입출력 예 #2
//
//"AAAE"는 "A", "AA", "AAA", "AAAA", "AAAAA", "AAAAE", "AAAAI", "AAAAO", "AAAAU"의 다음인 10번째 단어입니다.
//
//입출력 예 #3
//
//"I"는 1563번째 단어입니다.
//
//입출력 예 #4
//
//"EIO"는 1189번째 단어입니다.

// 수식이다
// A 1
// AA 2
// AAA 3

// size = 1 -> 5
// size = 2 -> 25
// size = 3 -> 125
// size = 4 -> 625
// size = 5 -> 3125

// f("AAAAE") -> (1)*1 +1*5
// f("AAAE") -> (1+5)+1*4
// f("I") -> (1 + 5 + 25 + 125 +625 ) * 2 + 1
// f("EIO") -> (1 + 5 + 25 + 125 +625 ) + (1 + 5 + 25 + 125) *2 + (1 + 5 + 25)*3 + 1*3


class Solution84512 {
    fun solution(word: String): Int {
        var total = word.length
        total += (1 + 5 + 25 + 125 + 625) * getNum(word[0])
        if (word.length > 1) {
            total += (1 + 5 + 25 + 125) * getNum(word[1])
            if (word.length > 2) {
                total += (1 + 5 + 25) * getNum(word[2])
                if (word.length > 3) {
                    total += (1 + 5) * getNum(word[3])
                    if (word.length > 4) {
                        total += (1) * getNum(word[4])
                    }
                }
            }
        }
        return total
    }//0.02 ~ 0.04ms

    fun getNum(key: Char) = when (key) {
        'A' -> 0
        'E' -> 1
        'I' -> 2
        'O' -> 3
        'U' -> 4
        else -> 0
    }

    // user1Solution 5~13ms
    val arr = arrayOf("A", "E", "I", "O", "U")
    val result = mutableListOf<String>()

    fun user1Solution(word: String): Int {
        dfs("")
        result.forEachIndexed { idx, s ->
            if(s == word) return idx
        }
        return -1
    }

    fun dfs(str: String) {
        if(str.length > 5) return
        result.add(str)
        for(a in arr) {
            dfs(str + a)
        }
    }
}