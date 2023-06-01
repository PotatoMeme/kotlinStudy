package com.potatomeme.baekjoon.`2023`.june

//https://www.acmicpc.net/problem/5698

//URLs 다국어
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	128 MB	1805	499	293	25.172%
//문제
//In the early nineties, the World Wide Web (WWW) was invented. Nowadays, most people think that the WWW simply consists of all the pretty (or not so pretty) HTML-pages that you can read with your WWW browser. But back then, one of the main intentions behind the design of the WWW was to unify several existing communication protocols.
//
//Then (and even now), information on the Internet was available via a multitude of channels: FTP, HTTP, E-Mail, News, Gopher2, and many more. Thanks to the WWW, all these services can now be uniformly addressed via URLs (Uniform Resource Locators). The syntax of URLs is defined in the Internet standard RFC 1738. For our problem, we consider a simplified version of the syntax, which is as follows:
//
//< protocol > "://" < host > [ ":" < port > ] [ "/" < path > ]
//
//The square brackets [] mean that the enclosed string is optional and may or may not appear. Examples of URLs are the following:
//
//http://www.informatik.uni-ulm.de/acm
//ftp://acm.baylor.edu:1234/pub/staff/mr-p
//gopher://veryold.edu
//More specifically,
//
//< protocol > is always one of http, ftp or gopher.
//< host > is a string consisting of alphabetic (a-z, A-Z) or numeric (0-9) characters and points (.), dash (-), underscore(_).
//< port > is a positive integer, smaller than 65536.
//< path > is a string that contains no spaces.
//You are to write a program that parses an URL into its components.
//
//2The ancestor of today’s WWW. Now nearly extinct, but quite important when the WWW was invented.
//
//입력
//The input starts with a line containing a single integer n, the number of URLs in the input file. The following n lines contain one URL each, in the format described above. The URLs will consist of at most 60 characters each.
//
//출력
//For each URL in the input first print the number of the URL, as shown in the sample output. Then print four lines, stating the protocol, host, port and path specified by the URL. If the port and/or path are not given in the URL, print the string <default> instead. Adhere to the format shown in the sample output.
//
//Print a blank line after each test case.
//
//예제 입력 1
//3
//ftp://acm.baylor.edu:1234/pub/staff/mr-p
//http://www.informatik.uni-ulm.de/acm
//gopher://veryold.edu
//예제 출력 1
//URL #1
//Protocol = ftp
//Host     = acm.baylor.edu
//Port     = 1234
//Path     = pub/staff/mr-p
//
//URL #2
//Protocol = http
//Host     = www.informatik.uni-ulm.de
//Port     = <default>
//Path     = acm
//
//URL #3
//Protocol = gopher
//Host     = veryold.edu
//Port     = <default>
//Path     = <default>

fun main() = with(System.`in`.bufferedReader()) {
    val regex = "^(http|ftp|gopher)://([a-zA-Z0-9.\\-_]*):?([0-9]*)/?(.*)$".toRegex()
    val sb = StringBuilder()
    val n = readLine().toInt()
    repeat(n) {
        val line = readLine()
        val results = regex.find(line)?.groupValues
        sb.append("URL #").appendLine(it + 1)
            .append("Protocol = ").appendLine(results?.get(1))
            .append("Host     = ").appendLine(results?.get(2))
            .append("Port     = ").appendLine(if (results?.get(3).isNullOrEmpty()) "<default>" else results?.get(3))
            .append("Path     = ").appendLine(if (results?.get(4).isNullOrEmpty()) "<default>" else results?.get(4))
            .appendLine()
    }
    print(sb.toString())
}

