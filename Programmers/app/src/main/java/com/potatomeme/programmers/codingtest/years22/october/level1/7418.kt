package com.potatomeme.programmers.codingtest.years22.october.level1

class Solution7418 {
    fun solution(new_id: String): String =
       new_id.step1()
           .step2()
           .step3()
           .step4()
           .step5()
           .step6()
           .step7()
    /**
     * 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
     * */
    fun String.step1(): String = this.lowercase()

    /**
     * 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
     * */
    fun String.step2(): String = this.filter { it !in speacialKey }
    fun String.user1_step2() = this.filter { it.isLetter().or(it.isDigit()).or(it == '.').or(it == '_').or(it == '-') }
    fun String.user2_step2() = this.replace("""([^a-z0-9-_. ])""".toRegex(),"")

    /**
     * 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
     * */
    fun String.step3(): String {
        var count = 0
        var saveStr = this
        return try {
            for (i in this.length - 1 downTo 0) {
                if (this.get(i) == '.') {
                    count++
                } else {
                    if (count > 1) {
                        saveStr = saveStr.removeRange(i + 2..i + count)
                    }
                    count = 0
                }
            }
            if (count > 1) saveStr = saveStr.substring(count-1)
            saveStr
        } catch (exception: Exception) {
            ""
        }
    }
    fun String.user1_step3() = this.replace(Regex("[.]+"), ".")

    /**
     * 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
     * */
    fun String.step4(): String {
        var save = this
        if (save.isNotEmpty()) if (save[0] == '.') save = save.substring(1)
        if (save.isNotEmpty()) if (save.last() == '.') save =
            save.removeRange(save.length - 1 .. save.length - 1)
        return save
    }
    fun String.user1_step4() = this.filterIndexed { index, c -> (index != 0 || c != '.') && (index != this.lastIndex || c != '.') }
    fun String.user2_step4() = this.replace("""^[.]""".toRegex(),"") .replace("""[.]$""".toRegex(),"")

    /**
     * 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
     * */
    fun String.step5(): String = this.ifEmpty { "a" }
    fun String.user1_step5() = this.replace("""^$""".toRegex(), "a")

    /**
     * 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
    만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
     * */
    fun String.step6(): String =
        if (this.length > 15) this.substring(0..14).let {
            if (it.last() == '.') it.substring(0..13) else it
        } else this
    fun String.user1_step6() = if (this.length >= 16) this.substring(0..14).filterIndexed { index, c -> !(index == 14 && c == '.')} else this
    fun String.user2_step6() = this.replace("""(?<=.{15}).*$""".toRegex(), "")

    /**
     * 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
     * */
    fun String.step7(): String {
        return if (this.length < 3) {
            var str = this
            while (str.length < 3) {
                str += str.last()
            }
            str
        } else {
            this
        }
    }
    fun String.user1_step7() = if (this.length <= 2) this + this.last().toString().repeat(3 - this.length) else this
}

val speacialKey = listOf(
    '~',
    '!',
    '@',
    '#',
    '$',
    '%',
    '^',
    '&',
    '*',
    '(',
    ')',
    '=',
    '+',
    '[',
    '{',
    ']',
    '}',
    ':',
    '?',
    ',',
    '<',
    '>',
    '/'
)
