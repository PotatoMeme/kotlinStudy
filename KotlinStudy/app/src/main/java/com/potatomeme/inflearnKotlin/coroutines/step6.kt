package com.potatomeme.inflearnKotlin.coroutines

import kotlinx.coroutines.*

// Coroutine Context and Dispatchers
// 1. Dispatchers and threads -> 디스패처 및 스레드
//fun main() = runBlocking<Unit> {
//    launch {
//        // context of the parent, main runBlocking coroutine
//        // -> 상위 runBlocking 코루틴의 컨텍스트
//        println("main runBlocking : I'm working in thread ${Thread.currentThread().name}")
//        // main
//    }
//    launch(Dispatchers.Unconfined) {
//        // not confined -- will work with main thread
//        // ->
//        println("Unconfined : I'm working in thread ${Thread.currentThread().name}")
//        // main
//    }
//
//    launch(Dispatchers.IO) {
//        // will get dispatched to DefaultDispatcher
//        println("IO : I'm working in thread ${Thread.currentThread().name}")
//        // DefaultDispatcher-worker-1
//    }
//    launch(Dispatchers.Default) {
//        // will get dispatched to DefaultDispatcher
//        println("Default : I'm working in thread ${Thread.currentThread().name}")
//        // DefaultDispatcher-worker-2
//    }
//
//    launch(newSingleThreadContext("MyOwnThread1")) {
//        // will get its own new thread
//        println("newSingleThreadContext: I'm working in thread ${Thread.currentThread().name}")
//        // MyOwnThread
//    }// 이경우 close를 해줘야하기 때문에 밑에 방식으로 하는것이 좋음
//    newSingleThreadContext("MyOwnThread2").use {
//        launch(it) {
//            println("newSingleThreadContext: I'm working in thread ${Thread.currentThread().name}")
//        }
//    }
//}

//Unconfined : I'm working in thread main
//IO : I'm working in thread DefaultDispatcher-worker-1
//Default : I'm working in thread DefaultDispatcher-worker-2
//newSingleThreadContext: I'm working in thread MyOwnThread1
//newSingleThreadContext: I'm working in thread MyOwnThread2
//main runBlocking : I'm working in thread main

// The coroutine context includes a coroutine dispatcher
// -> 코루틴 컨텍스트의 요소에는 코루틴 디스패처가 포함됩니다.
// determines what thread for its execution
// -> 이 디스패처가 코루틴이 실행할 스레드나 스레드 풀에서를 결정합니다.
// All coroutine builders an optional CoroutineContext parameter
// -> 모든 코루틴 빌더는 optional로 CoroutineContext 매개변수를 가지고있습니다.
// that can be used to explicitly specify the dispatcher
// -> 디스패처를 명시적으로 지정하여 사용할 수 도있습니다.

// ----------------------------------------------------------------------------------------------------------

// 2. Debugging coroutines and threads
// -> 코루틴 및 스레드 디버깅

//fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")
//
//fun main() = runBlocking {
//    val a = async {
//        log("I'm computing a piece of the answer")
//        6
//    }
//    val b = async {
//        log("I'm computing another piece of the answer")
//        7
//    }
//    log("The answer is ${a.await() * b.await()}")
//}
//[main @coroutine#2] I'm computing a piece of the answer
//[main @coroutine#3] I'm computing another piece of the answer
//[main @coroutine#1] The answer is 42

// it might be hard to figure out what the coroutine was doing, where, and when.
// -> 코루틴이 무엇을, 어디서, 언제 수행했는지 파악하기 어려울 수 있습니다.
// kotlinx.coroutines includes debugging facilities to make it easier
// -> kotlinx.coroutines에는 디버깅 기능이 포함되어 더 쉽게 만들 수 있습니다.
// -Dkotlinx.coroutines.debug JVM option:

// ----------------------------------------------------------------------------------------------------------

// 3. Jumping between threads
// ->  스레드 간 점프
//fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")
//
//fun main() {
//    newSingleThreadContext("Ctx1").use { ctx1 ->
//        newSingleThreadContext("Ctx2").use { ctx2 ->
//            runBlocking(ctx1) {
//                log("started in ctx1")
//                withContext(ctx2) {
//                    log("working in ctx2")
//                }
//                log("back to ctx1")
//            }
//        }
//    }
//}

//[Ctx1 @coroutine#1] started in ctx1
//[Ctx2 @coroutine#1] working in ctx2
//[Ctx1 @coroutine#1] back to ctx1

// It demonstrates several new techniques
// -> 몇 가지 새로운 기술을 보여줍니다.
// withContext(): to change the context of a coroutine
// -> withContext(): 코루틴의 컨텍스트를 변경합니다.
// while still staying in the same coroutine
// -> 여전히 같은 코루틴에 머물면서
// uses the use function from the Kotlin standard library to release threads
// -> 스레드를 해제하기 위해 Kotlin 표준 라이브러리의 use 함수를 사용합니다.

// ----------------------------------------------------------------------------------------------------------

// 4. Job in the context

//fun main() = runBlocking<Unit> {
//    println("My job is ${coroutineContext[Job]}")
//
//    launch {
//        println("My job is ${coroutineContext[Job]}")
//    }
//    async {
//        println("My job is ${coroutineContext[Job]}")
//    }
//    // 여기서 isActive는 job이 살아있는지 확인하는
//    println(isActive)
//    println(coroutineContext[Job]?.isActive ?: false)
//}

// My job is "coroutine#1":BlockingCoroutine{Active}@5bc79255
// true
// true
// My job is "coroutine#2":StandaloneCoroutine{Active}@23faf8f2
// My job is "coroutine#3":DeferredCoroutine{Active}@4e7dc304

// The coroutine's Job is part of its context.
// -> 코루틴의 Job은 컨텍스트의 일부입니다
// can be retrieved from it using the coroutineContext[Job] expression
// -> coroutineContext[Job] 표현식을 사용하여 검색할 수 있습니다

// ----------------------------------------------------------------------------------------------------------

// 5. Children of a coroutine

//fun main() = runBlocking<Unit> {
//    // launch a coroutine to process some kind of incoming request
//    val request = launch {
//        // it spawns two other jobs, one with GlobalScope
//        GlobalScope.launch {
//            println("job1: I run in GlobalScope and execute independently!")
//            delay(1000)
//            println("job1: I am not affected by cancellation of the request")
//        }
//        // and the other inherits the parent context
//        launch {
//            delay(100)
//            println("job2: I am a child of the request coroutine")
//            delay(1000)
//            println("job2: I will not execute this line if my parent request is cancelled")
//        }
//    }
//    delay(500)
//    request.cancel() // cancel processing of the request
//    delay(1000) // delay a second to see what happens
//    println("main: Who has survived request cancellation?")
//}

//job1: I run in GlobalScope and execute independently!
//job2: I am a child of the request coroutine
//job1: I am not affected by cancellation of the request
//main: Who has survived request cancellation?

// the Job of the new coroutine becomes a child of the parent coroutine's job.
// -> 새 코루틴의 작업은 부모 코루틴 작업의 자식이 됩니다.
//GlobalScope is used to launch a coroutine, there is no parent for the job
// -> GlobalScope는 코루틴을 시작하는 데 사용되며 작업에 대한 부모가 없습니다.

// ----------------------------------------------------------------------------------------------------------

// 6. Parental responsibilities -> 부모의 책임
//fun main() = runBlocking {
//    // launch a coroutine to process some kind of incoming request
//    val request1 = launch {
//        repeat(3){ i -> // launch a few children jobs
//            launch {
//                delay((i+1)*200L) // variable delay 200ms, 400ms, 600ms
//                println("Coroutine $i is done")
//            }
//        }
//        println("request: I'm done and I don't explicitly join my children that are still active")
//    }
//    request1.join() // wait for completion of the request, including all its children
//    println("Now processing of the request is complete")
//
//    val request2 = launch {
//        repeat(3){ i -> // launch a few children jobs
//            launch {
//                delay((i+1)*200L) // variable delay 200ms, 400ms, 600ms
//                println("Coroutine $i is done")
//            }
//        }
//        println("request: I'm done and I don't explicitly join my children that are still active")
//    }
//    println("Now processing of the request is complete")
//}

//request: I'm done and I don't explicitly join my children that are still active
//Coroutine 0 is done
//Coroutine 1 is done
//Coroutine 2 is done
//Now processing of the request is complete
//Now processing of the request is complete
//request: I'm done and I don't explicitly join my children that are still active
//Coroutine 0 is done
//Coroutine 1 is done
//Coroutine 2 is done


//A parent coroutine always waits for completion of all its children
//->부모 코루틴은 항상 모든 자식의 완료를 기다립니다.
//does not have to explicitly track all the children
//->모든 자식을 명시적으로 추적할 필요가 없습니다.
//does not have to use Job.join
//->Job.join을 사용할 필요가 없습니다.

// ----------------------------------------------------------------------------------------------------------

// 7. Combining context elements -> 컨텍스트 요소 결합

//fun main() = runBlocking<Unit> {
//    launch(Dispatchers.Default + CoroutineName("test")) {
//        println("I'm working in thread ${Thread.currentThread().name}")
//    }
//}

//I'm working in thread DefaultDispatcher-worker-1 @test#2

// Sometimes we need to define multiple elements for a coroutine context.
// -> 때로는 코루틴 컨텍스트에 대해 여러 요소를 정의해야 합니다.
// We can use the + operator
//-> + 연산자를 사용할 수 있습니다.

// ----------------------------------------------------------------------------------------------------------

// 8. Coroutine scope

class Activity {
    private val mainScope = CoroutineScope(Dispatchers.Default)// use Default for test purposes

    fun destroy() {
        mainScope.cancel()
    }

    fun doSomething() {
        // launch ten coroutines for a demo, each working for a different time
        repeat(10) { i ->
            mainScope.launch {
                delay((i + 1) * 200L) // variable delay 200ms, 400ms, ... etc
                println("Coroutine $i is done")
            }
        }
    }
}// class Activity ends

fun main() = runBlocking {
    val activity = Activity()
    activity.doSomething() // run test function
    println("Launched coroutines")
    delay(500L) // delay for half a second
    println("Destroying activity!")
    activity.destroy() // cancels all coroutines
    delay(1000) // visually confirm that they don't work
}

//Launched coroutines
//Coroutine 0 is done
//Coroutine 1 is done
//Destroying activity!

// ----------------------------------------------------------------------------------------------------------

//Dispatchers and threads
//Debugging coroutines and threads
//Jumping between threads
//Job in the context
//Children of a coroutine
//Parental responsibilities
//Combining context elements
//Coroutine scope