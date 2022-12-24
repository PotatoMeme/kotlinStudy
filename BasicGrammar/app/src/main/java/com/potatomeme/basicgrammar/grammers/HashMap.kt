package com.potatomeme.basicgrammar.grammers

import android.os.Build


fun main() {
    val test = HashMap()
    test.testingSpace()
}

class HashMap() {

    fun testingSpace() {
        //HashMap : 코틀린에서 key , value 형태로 데이터를 저장할 수 있습니다
        //초기 해쉬맵 객체 선언
        var t_hashMap = HashMap<String, Any>()
        var map = mapOf<String, Int>("안드" to 1, "로이드" to 2)
        var mutableMap = mutableMapOf<String, Int>("안드" to 1, "로이드" to 2)

        //put : 해쉬맵에서 데이터를 추가할때 사용합니다
        t_hashMap["name"] = "투케이" // t_hashMap.put("name", "투케이")
        t_hashMap["age"] = 28 // t_hashMap.put("age", 28)
        println("put 데이터 : $t_hashMap")
        //출력 : put 데이터 : {name=투케이, age=28}

        //containsKey : 해쉬맵에서 특정 key 값이 포함된지 확인합니다
        println("name 포함 여부 : " + t_hashMap.containsKey("name"))
        //출력 : name 포함 여부 : true

        //get : 해쉬맵에서 특정 key 값 데이터를 얻어옵니다
        println("name 데이터 : " + t_hashMap.get("name"))

        //for : 반복문을 수행하면서 해쉬맵에 들어있는 데이터를 순차적으로 출력합니다
        for ((key, value) in t_hashMap) {
            println("전체 : $key : $value")
        }

        //remove : 해쉬맵에서 특정 key 값을 삭제합니다
        t_hashMap.remove("age")
        println("remove 데이터 : $t_hashMap")
        //출력 : remove 데이터 : {name=투케이}

        //replace : 해쉬맵에서 특정 key 값 데이터를 변경합니다
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            t_hashMap.replace("name", "케이투")
        }
        println("replace 데이터 : $t_hashMap")

        //clear : 해쉬맵을 전체 초기화합니다
        t_hashMap.clear()
        println("clear 데이터 : $t_hashMap")
        //출력 : clear 데이터 : {}

        //count : 조건에 맞는 원소의 개수를 반환
        println("count All : ${mutableMap.count()}")
        println("count 1 : ${mutableMap.count { it.value == 1 }}")

        //filter : 조건에 맞는거만 남김
        println("filter 1 ${mutableMap.filter { it.value == 1 }}")

        //List를 Map으로 변환
        //1.List.map{ }.toMap()
        val list1 = listOf<String>("1번", "2번", "3번")
        val list2 = listOf<Int>(1, 2, 3)
        val map1 = list1.mapIndexed { index, s -> s to list2[index] }.toMap()
        println(map1.toString())
        //출력 : {1번=1, 2번=2, 3번=3}

        //2.List.associate()
        val map2= list1.associateWith { 0 }
        //associateBy()와는 반대로 List를 전체 탐색하면서 List의 인자를 key로, 매개변수로 받은 valueSelector를 value로 Map<K, V>를 만들어 return합니다.
        //val map2= list1.associate { it to 0 }
        println(map2)//{1번=1, 2번=2, 3번=3}

        val map3 = list1.associateBy { 0 }
        //List를 전체 탐색하면서 매개변수로 받은 keySelector를 key로, List의 인자를 value로 Map<K, V>를 만들어 return
        println(map3)//{0=3번}

        //3.List.groupBy()
        val map4 = list2.groupBy { it%4 }
        println(map4)//{1=[1], 2=[2], 3=[3]}

    }
}

//참고
//https://kkh0977.tistory.com/648
//https://yang-droid.tistory.com/29
//https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-hash-map/
//https://github.com/JetBrains/kotlin/blob/f3385fbdcb8b9dc29661a8a4973c855cdcf73767/libraries/stdlib/common/src/kotlin/collections/HashMap.kt#L8
