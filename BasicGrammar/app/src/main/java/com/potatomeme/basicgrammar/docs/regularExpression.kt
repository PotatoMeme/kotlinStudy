package com.potatomeme.basicgrammar.docs

// 정규 표현식
// 정규 표현식 또는 정규식은 특정한 규칙을 가진 문자열의 집합을 표현하기 위해 사용하는 형식 언어.
// 어떤 문자열에서 특정한 조건의 문자열을 찾고 싶을 때, 그 조건이 복잡한 경우 유용.
// 예를 들어 비밀번호 설정(최소 8자리에 숫자, 문자, 특수문자 각각 1개 이상 포함 등)

// 정규 표현식 문법
// ^    : 문자열의 시작을 의미.
// $    : 문자열의 끝을 의미.
// .    : 문자 한 개를 의미. '.'이 위치한 곳에 어떤 문자든지 1개의 문자가 들어감.
// [ ]  : 대괄호에 있는 문자 중 한 개를 의미. [abc]는 a, b, c 중 하나를 선택.
// [^]  : not의 의미로, 대괄호에서 쓴다면 [^abc] : a, b, c 제외하고 나머지를 의미.
// |    : or을 의미. a|b : a 또는 b.
// ()   : 공통되는 부분을 묶을 때, 서브 패턴을 지정할 때 사용. abc|abd -> ab(c|d)로 바꿀 수 있음.
// ?    : 문자가 0회 또는 1회 등장. a? b는 a가 나올 수도, 없을 수도 있음. ab, b.
// *    : 문자가 0회 이상 등장. a*b : b, ab, aaab, aaab..
// +    : 문자가 1회 이상 등장. a+b : ab, aab, aaab..
// {n}  : 문자가 n개 나옴. a {2} b : aab
// {n,} : 문자가 n개 이상 나옴. a {2,} b : aab, aaab, aaaab..
// {n,m}: 문자가 n개 이상 m개 이하로 나옴. a {1,3 } b : ab, aab, aaab
// \s   : 공백 제거
// \t   : 탭
// \d   : 숫자, [0-9]와 동일
// \b   : 단어의 경계, 문자 사이의 공백
// \w   : 알파벳이나 숫자, [a-zA-Z0-9_]와 동일

// -----------------------------------------------------------------------

fun main() {
    regexProblem07()
}

// Regex  -> 정규 표현식을 처리
fun regexTest() {
    // case1 -> Regex 클래스의 생성자 이용
    val regex = Regex("[0-9|a-z]")
    // case2 -> String 클래스의 확장 함수 toRegex() 이용
    // val regex = "[0-9|a-z]".toRegex()
    // case3 -> Regex 클래스의 Compnion Object 함수 fromLiteral() 이용
    // val regex = Regex.fromLiteral("[0-9|a-z]")
    // case4 -> 삼중 따옴표를 이용한 정규식 처리
    // val regex = """\([A-Z]\w+\)""".toRegex()

    // matchEntire() , 입력값이 정규식과 일치하는지 확인하고 싶을 때 사용하는 함수입니다.
    val matchResult1: MatchResult? = regex.matchEntire("abcd")
    println(matchResult1?.value)

    // find()
    val matchResult2: MatchResult? = regex.find("abcd")
    println(matchResult2?.value ?: null) // a
    println(matchResult2?.range ?: null) // 0..0
    println(matchResult2?.groups?.get(0)?.range) // 0..0
    println(matchResult2?.next()?.value ?: null) // b
    println(matchResult2?.next()?.range ?: null) // 1..1

    val matchResult3 = """a([bc]+)d?""".toRegex().find("abcd") //  a [bc]+d? , [bc]+
    val groupValues: List<String> = matchResult3!!.groupValues
    println(groupValues) // [abcd, bc]

    // findAll()
    val matchResult4: Sequence<MatchResult> = "[0-9|a-c]".toRegex().findAll("abcd")
    println(matchResult4.count()) // 3
}

fun regexProblem01(){
    val path = "https://naver.com"
    val regex = "https://(.+)".toRegex()
    isMatch(path, regex) // match
}

fun regexProblem02(){
    val path1 = "https://naver.com"
    val path2 = "http://daum.net"
    val path3 = "ftp://example.com"
    val path4 = "telnet://abc.com"
    val regex = "(https|http|ftp|telnet)://(.+)".toRegex()

    isMatch(path1, regex) // match
    isMatch(path2, regex) // match
    isMatch(path3, regex) // match
    isMatch(path4, regex) // match
}

fun regexProblem03(){
    val path = "https://naver.com/path/data?key=value"
    val regex = "([a-z]+)://([a-z.]+)/(.*)\\?(.*)".toRegex()

    isMatch(path, regex).also {
        println(it) // match

        val res = regex.matchEntire(path)
        if (res != null) {
            for (value in res.groupValues) {
                println(value)
            }
            //kotlin.Unit
            //https://naver.com/path/data?key=value
            //https
            //naver.com
            //path/data
            //key=value

            val (s, h, p, q) = res.destructured
            println("scheme: $s, host: $h, path: $p, query: $q")
            // scheme: https, host: naver.com, path: path/data, query: key=value
        }
    }
}

fun regexProblem04(){
    val path = "https://naver.com"
    val regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]".toRegex()

    isMatch(path, regex)
}

fun regexProblem05(){
    val path = "folder1/folder2/folder3/filename.java"
    val regex = "(.+)/(.+)\\.(.+)".toRegex()

    isMatch(path, regex).also {
        println(it)
        // kotlin.Unit

        val res = regex.matchEntire(path)
        if (res != null) {
            val (p, n, e) = res.destructured

            println("$p, filename: $n, extension: $e")
            // folder1/folder2/folder3, filename: filename, extension: java
        }
    }
}

fun regexProblem06(){
    val path = "folder1/folder2/folder3/filename.java"

    val filename = path.substringBeforeLast(".").substringAfterLast("/")
    val extension = path.substringAfterLast(".")

    println("filename: $filename, extension: $extension") // filename: filename, extension: java
}

fun regexProblem07(){
    val path = "192.168.0.125"
    val regex1 = path.replace("\\.\\d+$".toRegex(), ".111")

    println(regex1)//192.168.0.111

    val regex2 = path.replace("\\d+".toRegex(), "a")

    println(regex2)//a.a.a.a
}

fun isMatch(path: String, regex: Regex) {
    if (path.matches(regex)) println("match")
    else println("not match")
}