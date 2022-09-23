package com.potatomeme.inflearnKotlin.coroutines

import android.os.Build.VERSION_CODES.S
import kotlinx.coroutines.*

// 어떻게하면 코루틴을 취소하는지

// 1. Cancelling coroutine execution
//fun main() = runBlocking {
//    val job = launch {
//        repeat(1000){
//            println("job : $it")
//            delay(500L)
//        }
//    }
//    delay(3000L)
//    println("main : I'm tired of waiting!")
//    job.cancel()
//    job.join()
//    println("main : finish")
//}
//job : 0
//job : 1
//job : 2
//job : 3
//job : 4
//job : 5
//main : I'm tired of waiting!
//main : finish

// Job that can be used to cancel the running coroutine
// job으로 코루틴이 돌아가는중에 취소시킬수 있습니다.

// 2. Cancellation is cooperative

//fun main() = runBlocking {
//    val startTime = System.currentTimeMillis()
//    val job = launch(Dispatchers.Default) {
//        try {
//            var nextPrintTime = startTime
//            var i = 0
//            while (i < 8) {// computation loop, just wastes CPU
//                // print a message twice a second
//                if (System.currentTimeMillis() >= nextPrintTime) {
//                    //delay(1L)
//                    //yield()
//                    // suspend함수 delay(1L)나 yield()같은 함수가 없어 츼소할수 없다
//                    println("job: I'm sleeping ${i++} ...")
//                    nextPrintTime += 500L
//                }
//            }
//            delay(1300L)
//        } catch (e: Exception) {// cancel을 할경우 Exceptio 발생으로 나옵니다
//            kotlin.io.println(e)
//            // kotlinx.coroutines.JobCancellationException: StandaloneCoroutine was cancelled;
//            // job=StandaloneCoroutine{Cancelling}@d027a
//        }
//
//    }
//    println("main: I'm tired of waiting!")
//    job.cancelAndJoin() // cancels the job and waits for its completion
//    println("main: Now I can quit.")
//}
//main: I'm tired of waiting!
//job: I'm sleeping 0 ...
//job: I'm sleeping 1 ...
//job: I'm sleeping 2 ...
//job: I'm sleeping 3 ...
//job: I'm sleeping 4 ...
//job: I'm sleeping 5 ...
//job: I'm sleeping 6 ...
//job: I'm sleeping 7 ...
//main: Now I can quit.

//Coroutine cancellation is cooperative
//코루틴이 취소에 협조적이지 않음
//A coroutine code has to cooperate to be cancellable -> 코루틴 코드는 취소 가능하도록 협력해야 합니다.
//suspending functions are cancellable -> suspend(일시 중지)함수들은 취소 가능합니다.

// 3. Making computation code cancelllable
//fun main() = runBlocking {
//    val startTime = System.currentTimeMillis()
//    val job = launch(Dispatchers.Default) {
//        try {
//            var nextPrintTime = startTime
//            var i = 0
//            while (isActive) {// isActive 코루틴이 실제로 종료되었는지 확인
//                if (System.currentTimeMillis() >= nextPrintTime) {
//                    println("job: I'm sleeping ${i++} ...")
//                    nextPrintTime += 500L
//                }
//            }
//            println(isActive)
//
//        } catch (e: Exception) {// 이경우 Exception 발생안함
//            kotlin.io.println(e)
//        }
//    }
//    delay(1300L) // delay a bit
//    println("main: I'm tired of waiting!")
//    job.cancelAndJoin() // cancels the job and waits for its completion
//    println("main: Now I can quit.")
//}
//job: I'm sleeping 0 ...
//job: I'm sleeping 1 ...
//job: I'm sleeping 2 ...
//main: I'm tired of waiting!
//main: Now I can quit.

//way 1: to periodically invoke a suspending -> suspend(일시 중지)함수들 주기적으로 호출하기
//way 2: explicitly check the cancellation status (isActive) -> 취소 상태를 명시적으로 확인(isActive)

// 4. Closing resources with finally
//fun main() = runBlocking {
//    val job = launch {
//        try {
//            repeat(1000) {// isActive 코루틴이 실제로 종료되었는지 확인
//                println("job: I'm sleeping ${it} ...")
//                delay(500L)
//            }
//        } finally {
//            // exception이 발생후 최종적으로 resources 들을 해재시켜주는 공간
//            println("job: I'm running finally")
//        }
//    }
//    delay(1300L) // delay a bit
//    println("main: I'm tired of waiting!")
//    job.cancelAndJoin() // cancels the job and waits for its completion
//    println("main: Now I can quit.")
//}

//job: I'm sleeping 0 ...
//job: I'm sleeping 1 ...
//job: I'm sleeping 2 ...
//main: I'm tired of waiting!
//job: I'm running finally
//main: Now I can quit.

//Cancellable suspending functions throw CancellationException
// -> 취소 가능한 suspending가 CancellationException을 발생시킵니다.
//try {...} finally {...}

// 5. Run non-cancellable bloc
//fun main() = runBlocking {
//    val job = launch {
//        try {
//            repeat(1000) {// isActive 코루틴이 실제로 종료되었는지 확인
//                println("job: I'm sleeping ${it} ...")
//                delay(500L)
//            }
//        } finally {
////            println("job: I'm running finally")
////            delay(1000L)// 원래는 여기서 끝남
////            println("job: And I've just delayed for 1 sec because I'm non-cancellable")
//            withContext(NonCancellable){
//                println("job in withContext: I'm running finally")
//                delay(3000L)
//                println("job in withContext: And I've just delayed for 1 sec because I'm non-cancellable")
//            }
//        }
//    }
//    delay(1300L) // delay a bit
//    println("main: I'm tired of waiting!")
//    job.cancelAndJoin() // cancels the job and waits for its completion
//    println("main: Now I can quit.")
//}

//job: I'm sleeping 0 ...
//job: I'm sleeping 1 ...
//job: I'm sleeping 2 ...
//main: I'm tired of waiting!
//job: I'm running finally
//job: And I've just delayed for 1 sec because I'm non-cancellable
//main: Now I can quit.

// in the rare case -> 휘기한 Case
// when you need to suspend in a cancelled coroutine
// -> 취소된 코루틴 내부에서 suspend함수를 불러 또 종료해야하는경우
//withContext(NonCancellable) {...}

// 6. Timeout
//fun main() = runBlocking {
//    try {
//        withTimeout(1300L) {
//            repeat(1000){
//                println("I'm sleeping $it ...")
//                delay(500L)
//            }
//        }
//    } catch (e:Exception){
//        println(e)
//    }
//}
//I'm sleeping 0 ...
//I'm sleeping 1 ...
//I'm sleeping 2 ...
//kotlinx.coroutines.TimeoutCancellationException: Timed out waiting for 1300 ms

//its execution time has exceeded some timeout
//there is a ready to use withTimeout function
//CancellationException is considered to be a normal reason for coroutine completion.
//we have used withTimeout right inside the main function.


// 7. withTimeoutOrNull
//fun main() = runBlocking {
//    val result = withTimeoutOrNull(1300L) {
//        repeat(1000) {
//            println("I'm sleeping $it ...")
//            delay(500L)
//        }
//        "Done" // will get cancelled before it produces this result
//    }
//    println("Result is $result")
//}
//I'm sleeping 0 ...
//I'm sleeping 1 ...
//I'm sleeping 2 ...
//Result is null

//withTimeoutOrNull
//returns null on timeout instead of throwing an exception

//Kotlin Coroutines 특징
//Job
// cancel()
//
//Cancellation is cooperative
//way 1: to periodically invoke a suspending
//way 2: explicitly check the cancellation status (isActive)
//
//Timeout
//withTimeout
//withTimeoutOrNull


// testing
fun main() = runBlocking {
    val job1 = launch(Dispatchers.Default) {
        delay(1000L)
        repeat(10000) {
            //yield()
            println("test$it")
        }
        println("job : finish")
        delay(1000L)// suspending함수 호출시 cancel일 경우 여기에서 멈춤
    }
    delay(1000L)

    println("main : try finish")
    job1.cancelAndJoin()
    println("main : finish")

    val job2 = launch(Dispatchers.Default) {
       var i = 0
        while (isActive){
           println("test${i++}")
       }
    }
    delay(10L)
    println("main : try finish")
    job2.cancelAndJoin()
    println("main : finish")
}