package com.potatomeme.baekjoon.`2023`.may


//https://www.acmicpc.net/problem/5177

//출력 형식이 잘못되었습니다 다국어
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	128 MB	933	340	258	38.166%
//문제
//지금껏 문제를 풀면서 출력 형식 오류 메시지를 본 적이 있을 것이다.
//
//출력 형식 오류는 답은 적절히 맞았으나 공백 설정이 잘못되었거나, 일부 답안에 대해 자칫 지나치기 쉬운 사소한 오타를 냈을 때 볼 수가 있다.
//
//이번 기회에 출력 형식 오류를 직접 잡아내는 프로그램을 작성해보면서 출력 형식 오류에 대한 이해도를 높이고 실수를 줄여보도록 하자.
//
//프로그램은 두 개의 문자열을 비교하여 두 문자열이 출력 형식을 감안하면 같은 문자열인지, 혹은 그냥 서로 다른 문자열인지를 판정해야 한다.
//
//프로그램에 입력되는 문자열은 다음의 문자들로만 이루어져 있다.
//
//대문자 혹은 소문자 영문 알파벳
//숫자
//공백 (탭이 아닌 스페이스바)
//특수 부호
//특수 부호의 목록은 아래와 같다.
//
//( ) [ ] { } . , ; :
//출력 형식만 다른 문자열인지는 아래의 규칙에 따라 판정한다.
//
//알파벳 대문자와 소문자는 구별하지 않는다.
//공백이 하나 이상이라면, 공백의 크기는 관계없다. 물론 어떤 문자열엔 공백이 있고 어떤 문자열엔 공백이 없는 것, 즉 공백 유무의 차이 자체는 문제가 된다.
//문자열의 맨 앞 혹은 맨 뒤에 나타나는 공백은 있으나 없으나 관계없다.
//특수 부호의 바로 앞이나 바로 뒤에 나오는 공백도 있으나 없으나 상관없다.
//여는 괄호끼리는 종류를 구별하지 않는다.
//닫는 괄호끼리는 종류를 구별하지 않는다.
//쉼표(",")와 세미콜론(";")은 구별하지 않는다.
//입력
//첫 줄에 테스트 케이스의 수 K가 주어진다.
//
//이어 두 줄에 걸쳐 문자열 s1과 문자열 s2가 주어진다.
//
//각 문자열의 길이는 1000 이하이다.
//
//개행 문자는 문자열에 포함되지 않는다.
//
//출력
//각 테스트 케이스마다, Data Set K: 를 출력한 뒤
//
//만일 두 문자열이 출력 형식을 감안했을 때 동일한 문자열이라면 equal을, 출력 형식을 잘 조작해도 서로 다른 문자열이라면 not equal을 출력한다.
//
//각 테스트 케이스의 사이엔 빈 줄을 하나 출력한다.
//
//예제 입력 1
//3
//( 1, 4 ) (2,3) (2,4)
//{ 1; 4 )   {2;3)  {2;4)
//Data Set 1: equal
//data   set 1 :  EQUAL
//Data Set 1: equal
//DataSet 1: equal
//예제 출력 1
//Data Set 1: equal
//
//Data Set 2: equal
//
//Data Set 3: not equal

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sb = StringBuilder()
    repeat(n) {
        sb.append("Data Set ").append(it+1).append(": ")
        val str1 = readLine()
        val str2 = readLine()
        if (isEqual(str1,str2)){
            sb.appendLine("equal")
        }else {
            sb.appendLine("not equal")
        }
        sb.appendLine()
    }
    print(sb.toString())
}

fun isEqual(str1: String, str2: String): Boolean {
    var str1 = str1
    var str2 = str2
    if (str1 == str2) return true
    //알파벳 대문자와 소문자는 구별하지 않는다.
    str1 = str1.lowercase()
    str2 = str2.lowercase()
    if (str1 == str2) return true
    //공백이 하나 이상이라면, 공백의 크기는 관계없다. 물론 어떤 문자열엔 공백이 있고 어떤 문자열엔 공백이 없는 것, 즉 공백 유무의 차이 자체는 문제가 된다.
    str1 = str1.replace("[ ]+".toRegex(), " ")
    str2 = str2.replace("[ ]+".toRegex(), " ")
    if (str1 == str2) return true
    //문자열의 맨 앞 혹은 맨 뒤에 나타나는 공백은 있으나 없으나 관계없다.
    str1 = str1.trim()
    str2 = str2.trim()
    if (str1 == str2) return true
    //특수 부호의 바로 앞이나 바로 뒤에 나오는 공백도 있으나 없으나 상관없다.
    str1 = str1.replace("[ ]*([()\\[\\]{}.,;:]+)[ ]*".toRegex()) {
        it.value.trim()
    }
    str2 = str2.replace("[ ]*([()\\[\\]{}.,;:]+)[ ]*".toRegex()) {
        it.value.trim()
    }
    if (str1 == str2) return true
    //여는 괄호끼리는 종류를 구별하지 않는다.
    str1 = str1.replace("[({]".toRegex(), "[")
    str2 = str2.replace("[({]".toRegex(), "[")
    if (str1 == str2) return true
    //닫는 괄호끼리는 종류를 구별하지 않는다.
    str1 = str1.replace("[)}]".toRegex(), "]")
    str2 = str2.replace("[)}]".toRegex(), "]")
    if (str1 == str2) return true
    //쉼표(",")와 세미콜론(";")은 구별하지 않는다.
    str1 = str1.replace(",", ";")
    str2 = str2.replace(",", ";")
    if (str1 == str2) return true
    return false
}


