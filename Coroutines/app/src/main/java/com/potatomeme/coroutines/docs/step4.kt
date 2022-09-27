package com.potatomeme.coroutines.docs

import kotlinx.coroutines.*
import java.lang.ArithmeticException
import kotlin.system.*

// suspending함수 일시중단 되는함수를 어떻게 조합하여 코루틴을 유용하게 작성할수 있는지

// 1. Sequential by default

//fun main() = runBlocking {
//    val time = measureTimeMillis {
//        val one = doSomethingUsefulOne()
//        val two = doSomethingUsefulTwo()
//        println("The answer is ${one + two}")
//    }
//    println("Completed in $time ms")
//}
//suspend fun doSomethingUsefulOne(): Int {
//    println("doSomethingUsefulOne")
//    delay(1000L) // pretend we are doing something useful here
//    return 13
//}
//
//suspend fun doSomethingUsefulTwo(): Int {
//    println("doSomethingUsefulTwo")
//    delay(1000L) // pretend we are doing something useful here, too
//    return 29
//}

//doSomethingUsefulOne
//doSomethingUsefulTwo
//The answer is 42
//Completed in 2008 ms

//coroutine, just like in the regular code, is sequential by default
//->코루틴은 일반 코드와 마찬가지로 기본적으로 순차적입니다.

//The Dream Code
//to simplify code that executes asynchronously.
//-> 비동기적으로 실행되는 코드를 단순화합니다.
//converts async callbacks to sequential code.
//-> 비동기 콜백을 순차 코드로 변환합니다.
//Use suspend functions to make async code sequential
//-> 일시 중단 기능을 사용하여 비동기 코드를 순차적으로 만들기

//2. Concurrent using async -> 비동기를 동시에 사용한
//fun main() = runBlocking {
//    val time = measureTimeMillis {
//        val one = async{ doSomethingUsefulOne() }
//        val two = async{ doSomethingUsefulTwo() }
//        println("The answer is ${one.await() + two.await()}")
//    }
//    println("Completed in $time ms")
//}
//suspend fun doSomethingUsefulOne(): Int {
//    println("doSomethingUsefulOne")
//    delay(1000L) // pretend we are doing something useful here
//    return 13
//}
//
//suspend fun doSomethingUsefulTwo(): Int {
//    println("doSomethingUsefulTwo")
//    delay(1000L) // pretend we are doing something useful here, too
//    return 29
//}

//doSomethingUsefulOne
//doSomethingUsefulTwo
//The answer is 42
//Completed in 1017 ms

//What if there are no dependencies between invocations
//->호출 간에 종속성이 없으면 어떻게 됩니까?
//we want to get the answer faster, by doing both concurrently?
//->두 가지를 동시에 수행하여 더 빨리 답을 얻고 싶습니까?
//This is twice as fast, because the two coroutines execute concurrently.
//-> 이는 두 개의 코루틴이 동시에 실행되기 때문에 두 배 빠릅니다.
//Note that concurrency with coroutines is always explicit.
//-> 코루틴과의 동시성은 항상 명시적입니다.

//3. Lazily started async -> 지연 시작 비동기
//fun main() = runBlocking {
//    val time = measureTimeMillis {
//        val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne() }
//        val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo() }
//        one.start() // start the first one
//        two.start() // start the second one
//        println("The answer is ${one.await() + two.await()}")
//    }
//    println("Completed in $time ms")
//}
//suspend fun doSomethingUsefulOne(): Int {
//    println("doSomethingUsefulOne")
//    delay(1000L) // pretend we are doing something useful here
//    return 13
//}
//
//suspend fun doSomethingUsefulTwo(): Int {
//    println("doSomethingUsefulTwo")
//    delay(1000L) // pretend we are doing something useful here, too
//    return 29
//}

//doSomethingUsefulOne
//doSomethingUsefulTwo
//The answer is 42
//Completed in 1015 ms

//Optionally, async can be made lazy by setting its start parameter
//->  선택적으로 시작 매개변수를 설정하여 비동기를 지연시킬 수 있습니다.
//its result is required by await, or if its Job's start function is invoked
//-> 그 결과는 대기에 의해 필요하거나 작업의 시작 기능이 호출되는 경우
//if we just call await in println without first calling start
//-> 먼저 start를 호출하지 않고 println에서 await를 호출하면 순차적으로 실행이 됩니다.

// 4. Async-style functions -> 비동기식 함수
//fun main() {
//    try {
//        val time = measureTimeMillis {
//            val one = somethingUsefulOneAsync()
//            val two = somethingUsefulTwoAsync()
//
//            throw Exception("my exception")
//
//            runBlocking {
//                println("The answer is ${one.await() + two.await()}")
//            }
//        }
//        println("Completed in $time ms")
//    } catch (e: Exception) {
//    }
//    runBlocking {
//        delay(10000L)
//    }
//}
//
//// GlobalScope로 async 함수를 만든경우
//// exception이 발생한다면 멈추지않고 다실행이 됩니다
//fun somethingUsefulOneAsync() = GlobalScope.async {
//    println("strat > somethingUsefulOneAsync")
//    val res = doSomethingUsefulOne()
//    println("end > somethingUsefulOneAsync")
//    res
//}
//
//fun somethingUsefulTwoAsync() = GlobalScope.async {
//    println("strat > somethingUsefulTwoAsync")
//    val res = doSomethingUsefulTwo()
//    println("end > somethingUsefulTwoAsync")
//    res
//}
//
//suspend fun doSomethingUsefulOne(): Int {
//    println("doSomethingUsefulOne")
//    delay(1000L) // pretend we are doing something useful here
//    return 13
//}
//
//suspend fun doSomethingUsefulTwo(): Int {
//    println("doSomethingUsefulTwo")
//    delay(1000L) // pretend we are doing something useful here, too
//    return 29
//}
//strat > somethingUsefulTwoAsync
//strat > somethingUsefulOneAsync
//doSomethingUsefulTwo
//doSomethingUsefulOne
//end > somethingUsefulOneAsync
//end > somethingUsefulTwoAsync

//We can define async-style functions
//-> 비동기식 함수를 정의할 수 있습니다.
//xxxAsync functions are not suspending functions
//-> Async 함수는 함수를 일시 중단하지 않습니다.
//They can be used from anywhere
//-> 그들은 어디에서나 사용할 수 있습니다
//Using this style with Kotlin coroutines is strongly discouraged
//-> Kotlin 코루틴과 함께 이 스타일을 사용하는 것은 강력히 권장하지 않습니다
//This problem does not happen with structured concurrency
//-> 이 문제는 구조화된 동시성에서는 발생하지 않습니다.

// 5. Structured concurrency with async
// -> 비동기를 사용한 구조적 동시성
//fun main() = runBlocking {
//    val time = measureTimeMillis {
//        println("The answer is ${concurrentSum()}")
//    }
//    println("Completed in $time ms")
//}
//
//suspend fun concurrentSum(): Int = coroutineScope {
//    val one = async { doSomethingUsefulOne() }
//    val two = async { doSomethingUsefulTwo() }
//    one.await() + two.await()
//}
//
//suspend fun doSomethingUsefulOne(): Int {
//    println("doSomethingUsefulOne")
//    delay(1000L) // pretend we are doing something useful here
//    return 13
//}
//
//suspend fun doSomethingUsefulTwo(): Int {
//    println("doSomethingUsefulTwo")
//    delay(1000L) // pretend we are doing something useful here, too
//    return 29
//}
//doSomethingUsefulOne
//doSomethingUsefulTwo
//The answer is 42
//Completed in 1017 ms

//This way, if throws an exception, all the coroutines will be cancelled.
//->이렇게 하면 예외가 발생하면 모든 코루틴이 취소됩니다.

// 6. Cancellation propagated coroutines hierarchy
//-> 취소 전파 코루틴 계층
fun main() = runBlocking<Unit> {
    try {
        print(failedConcurrentSum())
    } catch (e: ArithmeticException) {
        println("Computation failed with ArithmeticException")
    }
}

suspend fun failedConcurrentSum(): Int = coroutineScope {
    val one = async<Int> {
        try {
            delay(Long.MAX_VALUE) // Emulates very long computation
            42
        } finally {
            println("First child was cancelled")
        }
    }
    val two = async<Int> {
        println("Second child throws an exception")
        throw ArithmeticException()
    }
    one.await() + two.await()
}
//Second child throws an exception
//First child was cancelled
//Computation failed with ArithmeticException

// Note how both the first async and the awaiting parent are cancelled
// on failure of one of the children (namely, two):
// 자식 중 하나(즉, 두 개)가 실패하면 첫 번째 비동기와
// 대기 중인 부모가 모두 취소되는 방식에 유의하세요.

//Async to sequential
//Sequential by default
//The Dream Code on Android
//
//async
//Concurrent using async
//Lazily started async
//
//Structured concurrency
//Async-style functions (strongly discouraged)
//Structured concurrency with async