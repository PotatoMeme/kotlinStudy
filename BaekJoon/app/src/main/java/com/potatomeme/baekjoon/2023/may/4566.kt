package com.potatomeme.baekjoon.`2023`.may


//https://www.acmicpc.net/problem/4566

//이 문제의 이름 다국어
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	128MB	177	67	55	42.969%
//문제
//철학자 Willard Van Orman Quine(1908–2000)은 자기 참조에서 발생할 수 있는 모순을 설명하기 위해 문장을 구성하는 새로운 방법을 설명했습니다. 이 작업은 단일 구문을 입력으로 사용하고 해당 구문에서 문장을 생성합니다. (저자 Douglas R. Hofstadter는 이 프로세스를 Quine에 대한 문구로 언급합니다.) Quine 작업을 다음과 같이 정의할 수 있습니다.
//
//콰인(A) = "A" A
//즉, A가 구인 경우 Quine(A)는 따옴표(")로 묶인 A, 공백, A 순입니다. 예를 들면 다음과 같습니다.
//
//Quine(HELLO WORLD) = "HELLO WORLD" HELLO WORLD
//다음은 Quine 작업으로 만들 수 있는 문장의 다른 예입니다. Quining은 아래의 마지막 문장과 같이 문장이 간접적으로 자기 참조적일 수 있다는 점에 유의하십시오.
//
//"Is a Sentence Fragment"는 문장 조각입니다.
//"이 문제의 이름입니다"는 이 문제의 이름입니다.
//"검증할 때 거짓을 산출합니다" 검증할 때 거짓을 산출합니다
//이 문제의 목표는 문장을 가져와서 그 문장이 Quine 작업의 결과인지 여부를 결정하는 것입니다.
//
//입력
//입력은 일련의 문장으로 구성되며, 한 줄에 한 문장씩, 단일 단어가 포함된 줄로 끝납니다 END. 각 문장에는 대문자, 공백 및 따옴표만 포함됩니다. 각 문장은 1~80자로 구성되며 선행, 후행 또는 연속 공백이 없습니다.
//
//각 문장이 Quine 작업의 결과인지 여부를 결정해야 합니다. Quine이 되려면 문장이 다음 패턴과 정확히 일치해야 합니다 .
//
//따옴표
//비어 있지 않은 일련의 문자 및 공백(이 구문을 A 라고 함 )
//따옴표
//우주
//문구 A — 정확히 (2)에 나타난 대로
//이 패턴과 일치하면 문장은 구문 A 의 Quine입니다 . 구문 A는 나타나는 두 번에 정확히 동일한 문자 시퀀스를 포함해야 합니다.
//
//출력
//데이터 세트의 각 문장에 대해 한 줄의 출력이 있습니다. 문장이 Quine 작업의 결과인 경우 출력은 형식이어야 합니다. 여기서 A 는 Quine이 문장을 생성하는 구문입니다.Quine(A)
//
//문장이 Quine 작업의 결과가 아닌 경우 출력은 구문이어야 합니다 not a quine.
//
//예제 입력 1
//"헬로월드" 헬로월드
//"Is a Sentence Fragment"는 문장 조각입니다.
//"이 문제의 이름입니다"는 이 문제의 이름입니다.
//"검증할 때 거짓을 산출합니다" 검증할 때 거짓을 산출합니다
//"안녕" 내가 말했어
//"무엇에 대해"
//" 추가 공간 없음 " 추가 공간 없음
//"NO"인용문"NO"인용문
//""
//끝
//예제 출력 1
//콰인(HELLO WORLD)
//콰인(SENTENCE Fragment)
//Quine(이 문제의 이름)
//콰인(퀴네일 때 허위 산출)
//퀸이 아니다
//퀸이 아니다
//퀸이 아니다
//퀸이 아니다
//퀸이 아니다

//문제
//The philosopher Willard Van Orman Quine (1908–2000) described a novel method of constructing a sentence in order to illustrate the contradictions that can arise from self-reference. This operation takes as input a single phrase and produces a sentence from that phrase. (The author Douglas R. Hofstadter refers to this process as to Quine a phrase.) We can define the Quine operation like so:
//
//Quine(A) = "A" A
//In other words, if A is a phrase, then Quine(A) is A enclosed in quotes ("), followed by a space, followed by A. For example:
//
//Quine(HELLO WORLD) = "HELLO WORLD" HELLO WORLD
//Below are some other examples of sentences that can be created by the Quine operation. Note that Quining allows sentences to be indirectly self-referential, such as the last sentence below.
//
//"IS A SENTENCE FRAGMENT" IS A SENTENCE FRAGMENT
//"IS THE NAME OF THIS PROBLEM" IS THE NAME OF THIS PROBLEM
//"YIELDS FALSEHOOD WHEN QUINED" YIELDS FALSEHOOD WHEN QUINED
//Your goal for this problem is to take a sentence and decide whether the sentence is the result of a Quine operation.
//
//입력
//The input will consist of a sequence of sentences, one sentence per line, ending with a line that has the single word, END. Each sentence will contain only uppercase letters, spaces, and quotation marks. Each sentence will contain between 1 and 80 characters and will not have any leading, trailing, or consecutive spaces.
//
//You must decide whether each sentence is the result of a Quine operation. To be a Quine, a sentence must match the following pattern exactly:
//
//A quotation mark
//Any nonempty sequence of letters and spaces (call this phrase A)
//A quotation mark
//A space
//Phrase A—exactly as it appeared in (2)
//If it matches this pattern, the sentence is a Quine of the phrase A. Note that phrase A must contain the exact same sequence of characters both times it appears.
//
//출력
//There will be one line of output for each sentence in the data set. If the sentence is the result of a Quine operation, your output should be of the form, Quine(A), where A is the phrase to Quine to create the sentence.
//
//If the sentence is not the result of a Quine operation, your output should be the phrase, not a quine.
//
//예제 입력 1
//"HELLO WORLD" HELLO WORLD
//"IS A SENTENCE FRAGMENT" IS A SENTENCE FRAGMENT
//"IS THE NAME OF THIS PROBLEM" IS THE NAME OF THIS PROBLEM
//"YIELDS FALSEHOOD WHEN QUINED" YIELDS FALSEHOOD WHEN QUINED
//"HELLO" I SAID
//WHAT ABOUT "WHAT ABOUT"
//" NO EXTRA SPACES " NO EXTRA SPACES
//"NO"QUOTES" NO"QUOTES
//""
//END
//예제 출력 1
//Quine(HELLO WORLD)
//Quine(IS A SENTENCE FRAGMENT)
//Quine(IS THE NAME OF THIS PROBLEM)
//Quine(YIELDS FALSEHOOD WHEN QUINED)
//not a quine
//not a quine
//not a quine
//not a quine
//not a quine

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    var line = readLine()
    while (line.length != 3 || line != "END") {
        val pattern = """^"([^"]+)" \1$""".toRegex()
        val match = pattern.matchEntire(line)
        if (match != null) {
            val phrase = match.groupValues[1]
            sb.append("Quine(").append(phrase).appendLine(")")
        } else {
            sb.appendLine("not a quine")
        }
        line = readLine()
    }
    print(sb.toString())
}




