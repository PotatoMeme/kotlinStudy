package com.potatomeme.baekjoon.`2023`.june


//https://www.acmicpc.net/problem/19844

//단어 개수 세기
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초 (추가 시간 없음)	1024 MB	847	278	233	33.622%
//문제
//키파는 프랑스어를 배우고 있다. 프랑스어는 띄어쓰기 단위로 단어가 완벽하게 분리되는 언어는 아니다.
//
//기본적으로는 띄어쓰기나 -(하이픈) 단위로 단어를 구분한다.
//앞 단어가 ce, je, ne, me, te, se, le, la, de, que 혹은 si이고 뒤 단어가 모음(a, e, i, o, u, h)으로 시작하는 경우, 앞 단어의 마지막 모음이 사라지고, 대신 '(어포스트로피)가 붙으면서 이어진다.
//프랑스어에서 h는 언제나 묵음이므로, 이 문제에서는 일반적으로 알려진 모음 a, e, i, o, u는 물론이고 h도 모음으로 취급함에 유의하라.
//예를 들어, je는 “나”라는 뜻이고, aime는 “(내가) 좋아한다”라는 뜻이고, (les) pommes는 “사과”라는 뜻이다. 이 단어들로 “나는 사과를 좋아한다”라는 프랑스어 문장을 만들 때는 j'aime les pommes와 같이 쓴다. 앞 단어가 je이고 뒤 단어의 모음인 a가 만났기 때문에 e가 사라지고 대신 어포스트로피가 붙은 것이다. 그래서, 프랑스어 초짜인 키파는 이런 식으로 프랑스어 문장의 단어를 쪼개기로 했다.
//
//먼저 띄어쓰기와 -(하이픈)을 기준으로 “단어”를 쪼갠다.
//각각의 “단어”에서, 위처럼 줄어들었을 가능성이 있는 경우(즉, c', j', n', m', t', s', l', d', qu'로 시작하고 어포스트로피 뒤 글자가 모음인 경우) 이 단어들을 한 번 더 분리해 준다.
//그런데 생각해 보니 이 과정을 프랑스어 문장에만 적용할 수 있는 것은 아니었다!
//
//임의의 문자열이 주어졌을 때, 키파의 발상대로 단어 단위를 만들었을 경우 몇 단어가 되는지를 구하는 프로그램을 작성하라.
//
//입력
//첫째 줄에 “문장”을 나타내는 문자열이 주어진다. 이 문자열은 영어 소문자, 띄어쓰기, -(하이픈), '(어포스트로피)로만 이루어져 있다. 이때 띄어쓰기, 하이픈, 어포스트로피 중 어느 것도 인접해 있지 않고, 문장의 시작이나 끝에 있지 않다.
//
//출력
//키파의 발상대로 입력된 “문장”을 단어로 쪼개었을 경우 몇 단어가 되는지를 출력하라.
//
//제한
//“문장”은 길이가 1 이상이고 5,000 이하인 문자열이다.
//“문장”은 영어 소문자, 띄어쓰기, -(하이픈), '(어포스트로피)로만 이루어져 있다.
//띄어쓰기, 하이픈, 어포스트로피 중 어느 것도 인접해 있지 않고, 문장의 시작이나 끝에 있지 않다.
//예제 입력 1
//qu'est-ce qu'il mange aujourd'hui
//예제 출력 1
//7
//키파의 발상을 따라가면 다음과 같다.
//
//먼저 띄어쓰기와 하이픈을 기준으로 “단어”로 분리해 준다: qu'est / ce / qu'il / mange / aujourd'hui.
//첫 번째 “단어”인 qu'est는 qu'로 시작하고 모음인 e로 이어지기 때문에 que와 est가 만나서 줄어든 것이다. 따라서 이 단어를 분리해 준다: que / est / ce / qu'il / mange / aujourd'hui.
//세 번째 “단어” 역시 마찬가지로 분리해 준다: que / est / ce / que / il / mange / aujourd'hui.
//마지막 “단어”는 어포스트로피가 있고 모음으로 취급되는 h로 이어지지만 앞 단어가 줄어들어 생긴 어포스트로피가 아니므로, 분리하지 않고 한 단어로 둔다.
//따라서 총 7개의 단어가 있다. 이 문장의 뜻은 "오늘 그는 무엇을 먹습니까?"이다.

fun main() = with(System.`in`.bufferedReader()) {
    val line = readLine()
    val list = line.replace("[\\- ]".toRegex(), "  ")
        .replace("(^|[ \\-])(c|j|n|m|t|l|d|qu|s)'[aeiouh]".toRegex(), "a a")
        .split(" {1,2}".toRegex())
    print(list.size)
}
