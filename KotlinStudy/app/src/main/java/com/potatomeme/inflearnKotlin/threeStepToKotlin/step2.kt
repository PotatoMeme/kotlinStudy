package com.potatomeme.inflearnKotlin.threeStepToKotlin

fun main() {
   testObject()
}
// step2
// 1. Lamda
// 람다식은 우리가  value 처럼 다룰 수 있는 익명함수이다.
// 1) 메소드의 파라미터로 넘겨줄수가 있다. fun maxBy(a:Int)
// 2) return 값으로 사용할 수가 있다.

// 람다의 기본정의
// val lamdaName :Type = {argumnetList -> codeBody}
fun lamdaTest(): (Int) -> Int {
    val square: (Int) -> Int = { number: Int -> number * number }
    println("square(3) : ${square(3)}")

    val nameFormat = { name: String -> "My name is $name" }
    println(nameFormat("sampleName"))

    // 확장 함수
    val pizzaIsGreat: String.() -> String = {
        "$this is Great Pizza"
    }
    println("Hawaiian Pizza".pizzaIsGreat())

    val ageFormat: String.(Int) -> String = {
        "${this}'s age is $it"
    }
    println("Jinsu".ageFormat(20))

    return square
}

// 람다를 표현하는 여러가지 방법
fun testInvokeLamda() {
    val lamda: (Double) -> Boolean = {
        when (it) {
            in 0.0..10.0 -> true
            else -> false
        }
    }
    println(invokeLamda(lamda))
    println(invokeLamda { it > 3.14 })
}

fun invokeLamda(lamda: (Double) -> Boolean): Boolean {
    return lamda(6.0)
}

//데이터 클래그
data class Ticket(val companyName: String, val name: String, var age: Int)
class TicketNormal(val companyName: String, val name: String, var age: Int)

fun dataClassTest(){
    val ticketA = Ticket("ACompany","TesterA",20)
    val ticketB = TicketNormal("BCompany","TesterB",20)
    val ticketC = Ticket("ACompany","TesterA",20)
    val ticketD = TicketNormal("BCompany","TesterB",20)

    println(ticketA) // Ticket(companyName=ACompany, name=TesterA, age=20)
    println(ticketB) // com.potatomeme.inflearnKotlin.threeStepToKotlin.TicketNormal@67b64c45
    println(ticketA == ticketC) // true
    println(ticketA.equals(ticketC)) // true
    println(ticketB == ticketD) // false
    println(ticketB.equals(ticketD)) // false

}

// companion
data class Book private constructor(val id:Int,val name: String){
    companion object BookFactory :IdProvider{// 자바의static 과 같음
        val test = "it's a test text"
        fun create() = Book(0,"HarryPorter")
        override fun getId(): Int {
            return 4444
        }
    }
}

interface IdProvider {
    fun getId() : Int
}

fun testCompanion(){
    val book1 = Book.BookFactory.create()
    val book2 = Book.create()

    println(Book.test)
    println(Book.getId())
    println(book1)
    println(book2)
    println( book1 == book2)

}

// Object -> Singleton Pattern
data class Car(val horsePower:Int)

object CarFactory{
    val cars = mutableListOf<Car>()
    fun makeCar(horsePower: Int):Car{
        val car = Car(horsePower)
        cars.add(car)
        return car
    }
}

fun testObject(){
    val car1 = CarFactory.makeCar(30)
    val car2 = CarFactory.makeCar(40)

    println(car1)
    println(car2)

    println(CarFactory.cars.size)
}