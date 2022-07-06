package com.potatomeme.kotlinbasic

import java.lang.Exception
import java.lang.Integer.max
import java.lang.reflect.Type
import java.util.*
import kotlin.math.min
import kotlin.random.Random

// 톱 레벨 상수
// const 사용시 컴파일 타입 상수 메인함수보다 우선시되어 실행
const val Tag = 9959

fun main() {
    //변수 선언
    // => 재대입 가능
    var i1 = 1
    var i2 = 3.14//Double
    var i3 = "TestingApp"

    //변수 타입
    // 정수
    // Byte , Short , Int ,Long
    // 실수
    // Float,Double
    // 문자열
    // String
    // 문자타입
    // Char
    // 논리타입
    // Boolean


    var i4: Int = 1
    var i5: Float = 3.14f
    var i6: Double = 3.14
    var i7: Char = 'a'
    var i8: String = "Testing App"

    // 상수
    // =>  재대입 불가 , 자바의 final과 비슷
    val i9 = 5

    // 형변환
    // 코드린에서는 형(타입)이 다를경우 들어가지않음 그렇기때문에 타입 캐스팅을 해줘야함
    i5 = i2.toFloat()//int -> float
    i4 = i2.toInt()// Double -> int
    i8 = i7.toString()// Char -> String

    // 문자열
    println(i3)
    println(i3[0])
    println(i3[i3.length - 1])
    println(i3.uppercase())
    println(i3.lowercase())

    println("This is a " + i3)
    println("This is a ${i3}")
    println("This is a $i3 입니다")
    println("This is a $i3.uppercase()")
    println("This is a ${i3.uppercase()}")

    // max,min
    println(max(3, 5))
    println(Math.max(3, 5))
    println(kotlin.math.max(3, 5))
    println(min(3, 5))

    // random
    val randomIntNum = Random.nextInt(0, 100) // 0 ~ 99
    val randomDoubleNum = Random.nextDouble(0.0, 1.0) // 0.0 ~ 0.9

    // 입력 함수
    val reader = Scanner(System.`in`)
    println(reader.javaClass.name)//java.util.Scanner
    println(reader.nextInt().javaClass.name)//int
    println(reader.next().javaClass.name)//String

    // 조건문
    if (randomIntNum > 80) {
        println("80보다 큰값입니다")
    } else if (randomIntNum > 60) {
        println("60보다 큰값입니다")
    } else if (randomIntNum > 40) {
        println("40보다 큰값입니다")
    } else {
        println("범위 외의 값입니다")
    }

    when {
        randomIntNum > 80 -> {
            println("80보다 큰값입니다")
        }
        randomIntNum > 60 -> {
            println("60보다 큰값입니다")
        }
        randomIntNum > 40 -> {
            println("40보다 큰값입니다")
        }
        else -> {
            println("범위 외의 값입니다")
        }
    }

    val result = if (randomIntNum > 80) {
        "80보다 큰값입니다"
    } else if (randomIntNum > 60) {
        "60보다 큰값입니다"
    } else if (randomIntNum > 40) {
        "40보다 큰값입니다"
    } else {
        "범위 외의 값입니다"
    }

    // 3항 연산자
    println(if (3 > 10) true else false)

    // 반복문
    val items = listOf(1, 2, 3, 4, 5)
    for (item in items) {
        println(item)
    }

    items.forEach { item ->
        println(item)
    }

    for (i in 0..(items.size - 1)) {
        println(items[i])
    }
    //  while 자바랑 동일, continue , break 동일
    while (i4-- > 0) {
        println(i4)
    }

    // List
    val items_defaultlist = listOf(1, 2, 3, 4, 5) // 변경불가
    val items_mutablelist = mutableListOf(1, 2, 3, 4, 5) // 변경 가능
    // val items_mutablelist : MutableList<Int> = mutableListOf(1,2,3,4,5) // 변경 가능
    items_mutablelist[1] = 5
    items_mutablelist.add(5)
    items_mutablelist.remove(5)

    // 배열
    val items_defaultarray = arrayOf(1, 2, 3)
    items_defaultarray[0] = 10

    // 예외 처리
    try {
        println(items[items.size])
    } catch (e: Exception) {
        println(e.message)//Index 5 out of bounds for length 5
    }

    // null Safety
    val nullTest = null
    var name: String? = null
    println(name)//null
    name = "Test"
    println(name)//Test
    name = null
    var name2: String = ""
    // 에러
    // name2 = name

    // name2 = name!!
    // name 이 null이라 NullPointerException 발생
   if (name != null) {
        name2 = name
    }
    name?.let {
        name2 = name
    }

    // 함수
    println(sum1(3, 4))
    println(sum2(3, 4))
    println(sum2(3, 4, 5))
    println(sum2(a = 3, b = 4, c = 5))

    // Class
    println(Person1(name="name",33).age)

    // dataClass
    val kim1 = Person3("kim",30)
    val kim2 = Person3("kim",30)
    val lee = Person3("lee",30)

    println(kim1)//Person3(name=kim, age=30)
    println(kim2)//Person3(name=kim, age=30)
    println(lee)//Person3(name=lee, age=30)

    println(kim1 == kim2)//true
    println(kim1 == lee)//false

}

// 함수
fun sum1(a: Int, b: Int): Int {
    return a + b
}
fun sum2(a: Int, b: Int) = a + b
//fun sum2(a:Int,b:Int): Int = a+b
fun sum2(a: Int, b: Int, c: Int, d: Int = 3) = a + b + c + d

// Class
class Person1(val name:String, var age : Int){
    var adult : Boolean = false
        private set
        get() = field

    init {
        println("Person1_init")
        adult = if (age>20) true else false
    }

    override fun toString(): String {
        return "Person1(name='$name', age=$age)"
    }

}

class Person2(
    private val name: String,
    var age: Int//default public
)
// data class
data class Person3(val name:String, var age : Int){

}

// 다음은 상속