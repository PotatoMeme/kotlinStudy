package com.potatomeme.collectionsinkotlin.testingspace

fun main(){

    // 목록(list)
    val numbers = listOf(0, 3, 8, 4, 0, 5, 5, 8, 9, 2)
    println("list:   ${numbers}") // list:   [0, 3, 8, 4, 0, 5, 5, 8, 9, 2]
    println("sorted: ${numbers.sorted()}") // sorted: [0, 0, 2, 3, 4, 5, 5, 8, 8, 9]

    // ----------------------------------------------------------------------------------------------

    // 집합(set)
    // 관련 항목의 그룹이지만 목록과 달리 중복될 수 없으며 순서는 중요하지 않습니다.
    // 집합에는 항목이 있을 수도 있고 없을 수도 있지만, 있는 항목의 경우 사본은 하나만 존재합니다.
    // 이는 집합의 수학적 개념과 유사합니다. 내가 읽은 책의 집합을 예로 들겠습니다.
    // 특정 책을 여러 번 읽더라도 이 책이 내가 읽은 책의 집합에 속한다는 사실은 변하지 않습니다.
    val setOfNumbers = numbers.toSet()
    println("set:    ${setOfNumbers}") // set:    [0, 3, 8, 4, 5, 9, 2]

    val set1 = setOf(1,2,3)
    val set2 = mutableSetOf(3,2,1)
    println("$set1 == $set2: ${set1 == set2}") // [1, 2, 3] == [3, 2, 1]: true

    // 집합(set)에서 할 수 있는 기본 작업 중 하나는 contains() 함수를 사용하여 특정 항목이 집합에 속하는지 여부를 확인하는 것입니다.
    // 이전에 contains() 함수를 본 적이 있지만 목록(list)에 사용했습니다.
    println("contains 7: ${setOfNumbers.contains(7)}") // contains 7: false

    // 수학의 집합과 마찬가지로 Kotlin에서도 두 집합의 교집합(∩) 또는 합집합(∪)과 같은 연산을 intersect() 또는 union()을 사용하여 실행할 수 있습니다.
    set2.add(5)
    set2.remove(3)
    println("set1.intersect(set2): ${set1.intersect(set2)}") // set1.intersect(set2): [1, 2]
    println("set1.union(set2): ${set1.union(set2)}") // set1.union(set2): [1, 2, 3, 5]
    // 차집합
    println("set2.subtract(set1): ${set2.subtract(set1)}") // set2.subtract(set1): [5]

    // ----------------------------------------------------------------------------------------------

    // 맵(map)
    // 맵은 특정 키가 부여된 값을 쉽게 찾을 수 있도록 설계된 키-값 쌍의 집합입니다.
    // 키는 고유하며 각 키는 정확히 하나의 값에 매핑되지만, 값은 중복될 수 있습니다.
    // 맵의 값은 문자열, 숫자, 객체일 수 있으며 목록 또는 집합과 같은 다른 컬렉션일 수도 있습니다.

    val peopleAges = mutableMapOf<String, Int>(
        "Fred" to 30,
        "Ann" to 23
    )
    println(peopleAges) // {Fred=30, Ann=23}
    peopleAges.put("Barbara", 42)
    peopleAges["Joe"] = 51
    println(peopleAges) // {Fred=30, Ann=23, Barbara=42, Joe=51}
    peopleAges["Fred"] = 31
    println(peopleAges) // {Fred=31, Ann=23, Barbara=42, Joe=51}

    // ----------------------------------------------------------------------------------------------

    // forEach() -> 자동으로 모든 항목을 탐색한 후 항목별로 작업을 실행
    peopleAges.forEach { print("${it.key} is ${it.value}, ") } // Fred is 31, Ann is 23, Barbara is 42, Joe is 51,
    print("\n")

    // map() -> 컬렉션의 각 항목에 변환을 적용
    println(peopleAges.map { "${it.key} is ${it.value}" }.joinToString(", ") ) // Fred is 31, Ann is 23, Barbara is 42, Joe is 51
    print("\n")
    val peopleAgesMap = peopleAges.map { "${it.key} is ${it.value}" } // map -> List
    println(peopleAgesMap) // [Fred is 31, Ann is 23, Barbara is 42, Joe is 51]

    // filter() -> 컬렉션의 또 다른 작업은 특정 조건과 일치하는 항목을 찾는 것
    val filteredNames = peopleAges.filter { it.key.length < 4 }
    println(filteredNames) // {Ann=23, Joe=51}

    val peopleNames = listOf("Fred", "Ann", "Barbara", "Joe")
    println(peopleNames.sorted()) // [Ann, Barbara, Fred, Joe]
    println(peopleNames.sortedWith { str1: String, str2: String -> str1.length - str2.length }) // [Ann, Joe, Fred, Barbara]

    // ----------------------------------------------------------------------------------------------

    val words = listOf("about", "acute", "awesome", "balloon", "best", "brief", "class", "coffee", "creative")
    val filteredWords1 = words.filter { it.startsWith("b", ignoreCase = true) }
    println(filteredWords1) // [balloon, best, brief]
    val filteredWords2 = filteredWords1.shuffled()
    println(filteredWords2) // [brief, balloon, best]
    val filteredWords3 = filteredWords2.take(2)
    println(filteredWords3) // [brief, balloon]
    val filteredWords4 = filteredWords3.sorted()
    println(filteredWords4) // [balloon, brief]
}