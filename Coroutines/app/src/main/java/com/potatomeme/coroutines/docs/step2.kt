package com.potatomeme.coroutines.docs

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

// 어떻게하면 코루틴을 실행시킬수 있는지

/** main 1, Essentially, coroutines are light-weight threads */
/*
fun main() {
    //testA1()
    testA2()

    println("Hello,") // main thread continues while coroutine is delayed
    testB2()
} // -> Hello,World!
*/

/** 코루틴 GlobalScope.launch test */
fun testA1() {
    // 코루틴스코프.빌더{}
    GlobalScope.launch {
        // launch a new coroutine in background and continue
        // GlobalScope : 전역 스코프
        // launch는 코루틴 빌더이며 내부적으로 코루틴을 만들어 반환을 해줍니다.
        delay(1000L) // non-blocking delay for 1 second
        println("World!") // print after delay
    } // -> 코루틴은 코루틴 스코프에서 실행된다!
}

/** 코루틴 -> thread */
fun testA2() {
    thread {
        //delay(1000L) // non-blocking delay for 1 second
        Thread.sleep(1000L)
        println("World!") // print after delay
    }
}

/** 코루틴 Thread.sleep */
fun testB1() {
    Thread.sleep(2000L) // block main thread for 2 seconds to keep JVM alive
}

/** 코루틴 runBlocking */
fun testB2() {
    // The main thread invoking runBlocking blocks until the coroutine inside runBlocking completes.
    runBlocking { // but this expression blocks the main thread
        delay(2000L)  // ... while we delay for 2 seconds to keep JVM alive
    }
}
/*

suspend fun testB3(){ // Suspend function 'testB3' should be called only from a coroutine or another suspend function
    delay(2000L)  // ... while we delay for 2 seconds to keep JVM alive
}

 */

/** main 2, rewritten in a more idiomatic way */
/*
// 안의 소스가 다실행되기 전까지 메이스레드가 runBlocking 때문에 Return 이 안됨
fun main() = runBlocking<Unit> {
        testA1()
        println("World!")
        delay(2000L)
}
*/

/** main 3, Waiting for a job */
/*
fun main() = runBlocking { // start main coroutine
    val job = GlobalScope.launch { // launch의 return은 Job객체
        delay(3000L)
        println("World!")
    }
    println("Hello,") // main coroutine continues here immediately
    job.join() // wait until child coroutine completes
    // tobLevel Coroutine인 runBlocking과 job을 join하여 job이 종료할때까지 대기
}
*/

/** main 4, Structured concurrency */
/*
// 구조적으로 만들어줌 runBlocking의 자식으로 빌드를 하여 부모인 runBlocking이 자식이 끝날때까지 기다려줌
fun main() = runBlocking { // start main coroutine
    this.launch {
        delay(3000L)
        println("World!")
    }
    println("Hello,")
}
*/

/** main 5, Extract function refactoring */
/*
fun main() = runBlocking { // start main coroutine
    this.launch {
        doWorld()
    }
    println("Hello,")
}

suspend fun doWorld() {
    delay(3000L)
    println("World!")
}
*/

/** main 6,Coroutines ARE light-weight */
/*
// 코루틴이 thread보다 구조적으로 가벼움
fun main() = runBlocking { // start main coroutine
    repeat(100_000){
        launch {
            delay(1000L)
            print(".")
        }
    }
}
*/


/** main 7, Global coroutines are like daemon threads */
/*
fun main() = runBlocking { // start main coroutine
    GlobalScope.launch{
        repeat(1000){ i ->
            println("I'm sleeping $i ...")
            delay(500L)
        }
    }
    delay(1300L)
}
// Active coroutines that were launched in GlobalScope do not keep the process alive.
// They are like daemon threads
*/


//Coroutine builder
//launch
//runBlocking
//
//Scope
//CoroutineScope
//GlobalScope
//
//Suspend function
//suspend
//delay()
//join()
//
//Structured concurrency

/** main 8,Global coroutines are like daemon threads */
/*
fun main() = runBlocking {
    launch {
        repeat(5) {
            println("Coroutine A, $it")
            delay(500L)
        }
    }
    launch {
        repeat(5) {
            println("Coroutine B, $it")
            delay(500L)
        }
    }
    println("Coroutine Outer")
}

fun <T>println(msg : T){
    kotlin.io.println("$msg [${Thread.currentThread().name}]")
}
*/
