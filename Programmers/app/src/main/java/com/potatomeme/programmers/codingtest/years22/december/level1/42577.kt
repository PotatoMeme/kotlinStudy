package com.potatomeme.programmers.codingtest.years22.december.level1

//전화번호 목록
//문제 설명
//전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
//전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
//
//구조대 : 119
//박준영 : 97 674 223
//지영석 : 11 9552 4421
//전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
//
//제한 사항
//phone_book의 길이는 1 이상 1,000,000 이하입니다.
//각 전화번호의 길이는 1 이상 20 이하입니다.
//같은 전화번호가 중복해서 들어있지 않습니다.
//입출력 예제
//phone_book	return
//["119", "97674223", "1195524421"]	false
//["123","456","789"]	true
//["12","123","1235","567","88"]	false
//입출력 예 설명
//입출력 예 #1
//앞에서 설명한 예와 같습니다.
//
//입출력 예 #2
//한 번호가 다른 번호의 접두사인 경우가 없으므로, 답은 true입니다.
//
//입출력 예 #3
//첫 번째 전화번호, “12”가 두 번째 전화번호 “123”의 접두사입니다. 따라서 답은 false입니다.
//
//알림
//
//2021년 3월 4일, 테스트 케이스가 변경되었습니다. 이로 인해 이전에 통과하던 코드가 더 이상 통과하지 않을 수 있습니다.


class Solution42577 {
    // 내마음대로 풀기
    fun solution(
        phone_book: Array<String>,
    ): Boolean {
        val sortedArray = phone_book.sorted()
        for (i in 0 until phone_book.size - 1) {
            if (sortedArray[i].length < sortedArray[i + 1].length
                && sortedArray[i + 1].startsWith(sortedArray[i])
            ) return false
        }
        return true
    }

    // 해시로 풀어보자
    fun solutionToHash(
        phone_book: Array<String>,
    ): Boolean {
        val map = phone_book.associateWith { 0 }
        phone_book.forEach {
            for (i in it.indices){
                if (map.containsKey(it.substring(0,i))) return false
            }
        }
        return true
    }
}

//Java,이전에 Java로 푼것
//import java.util.Arrays;
//class Solution {
//    public boolean solution(String[] phone_book) {
//        Arrays.sort(phone_book);
//        for(int i=0;i<phone_book.length-1;i++){
//            if (phone_book[i].length()<phone_book[i+1].length()){
//                if(phone_book[i+1].startsWith(phone_book[i])){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//}