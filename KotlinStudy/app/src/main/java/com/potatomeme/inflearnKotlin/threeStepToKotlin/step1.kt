package com.potatomeme.inflearnKotlin.threeStepToKotlin

import kotlin.properties.Delegates

fun main() {
    val human = Human1()
    human.name = "test"
}

// step1
// 1. 함수
fun helloWorld() {
    println("Hello World")
}

fun add(a: Int, b: Int) = a + b
// ..

// 2. var vs val

// 3. String Template
fun showString() {
    val a = 30
    println(
        "test" + "\n" +
                "a : $a" + "\n" +
                "a+a : ${a + a}"
    )
}

// 4. 조건식
fun maxBy(a: Int, b: Int) = if (a > b) a else b

fun checkNum(score: Int) {
    when (score) {
        0 -> println("it's 0")
        1 -> println("it's 1")
    }
    println(
        when (score) {
            0 -> "0"
            in 1..20 -> "1..20"
            else -> "default"
        }
    )
    var test = print("test")
}

// Expression vs Statement

// 코틀린에서 모든함수는 Expression, 안보이지만  Unit을  반환하고 있기때문
// 자바같은경우 Expression(반환값 O) 과 Statement(반환값 X)를 모두 가지고 있다

// 5. Array and List
// Array
// List 1. List(수정 불가) , 2. MutableList(수정가능)

fun arrayAndList() {
    var array = arrayOf(1, 2, 3) // Array<Int>
    val list = listOf(1, 2, 3) // List<Int>

    val array2 = arrayOf(1, 2, 3, "t", 11L) // Array<Any>
    val list2 = listOf(1, 2, 3, "t", 11L) // List<Any>

    array[0] = 5
    //list[0] = 5 // error!

    val mutableList = mutableListOf(1, 2, 3)
    val arrayList = arrayListOf(1, 2, 3)
    mutableList.add(30)
    arrayList.add(30)
}

// 6. for while
fun forAndWhile() {
    val students = arrayListOf("test1", "test2", "test3", "test4")
    for (name: String in students) println(name)
    for (i in 1..10) println("i : $i")
    for (i1 in 1..10 step 2) println("i1 : $i1")
    for (i2 in 1 until 100) println("i2 : $i2")
    for (i3 in 10 downTo 1) println("i3 : $i3")

    var num = 10
    while (num > 0) {
        num--
        println("num : $num")
    }
}

// 7. Nullable / NonNull
fun nullcheck() {
    // NPE  -> NullPointException
    var name: String? = null

    if (name != null) {
        println("test1 : ${name.uppercase()}")
    }
    name = "it's not null"
    if (name != null) {
        println("test1 : ${name.uppercase()}")
    }
    name = null

    // ?:
    println("test2 : ${name ?: "it's null".uppercase()}")
    name = "it's not null"
    println("test2 : ${name?.uppercase() ?: "it's null"}")
    name = null

    // !! -> null 아닌것을 확신한경우 null일경우 실행시 npe발생생
    //println("test3 : ${name!!.uppercase()}")
    name = "it's not null"
    println("test3 : ${name!!.uppercase()}")
    name = null


    // ?.let -> null이 아닐경우 실행
    //name?.let { println("test4 :  ${it.uppercase()}")}
    name = "it's not null"
    name?.let { println("test4 :  ${it.uppercase()}") }
    name = null
}

// 8. Class
class Human1 {
    var name = "defaultHuman"
    fun eatingCake() {
        println("eatingCake Now")
    }
}

// class Human2(name:String = "defaultHuman"){
// val realName = name
open class Human2(var name: String = "defaultHuman") {
    var age = 0

    init { // 생성자 코드블럭
        println("응애 나 아기 객체 $name $age 살")
    }

    constructor(name: String, age: Int) : this(name) { // 부생성자
        this.age = age
        println("응애 나 아기 객체 $name $age 살")
    }

    fun eatingCake() {
        println("eatingCake Now $name")
    }

    open fun singASong() {
        println("Sing a Song Now $name")
    }
}

class Korean : Human2() { // 상속은 1개만 가능
    override fun singASong() {
        //super.singASong()
        println("Sing a Song Now $name ,in Korea")
    }
}
