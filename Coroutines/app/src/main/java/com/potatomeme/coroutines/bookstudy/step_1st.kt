package com.potatomeme.coroutines.bookstudy

// 시퀀스 빌더
val seq1 = sequence {
    this // 여기서 이 this는SequenceScope<T>를 가리킴
    // SequenceScope는 suspend 이므로 비동기적으로 움직임

    //public abstract suspend fun yield(value: T)
    yield(1)
    yield(2)
    yield(3)
}// 해당 sequence함수는 짧은 DSL코드
//@SinceKotlin("1.3")
//public fun <T> sequence(@BuilderInference block: suspend SequenceScope<T>.() -> Unit): Sequence<T> = Sequence { iterator(block) }

//@RestrictsSuspension//리시버가 SequenceScope가 아닌경우 중단 함수를 사용하는것을 허용하지 않습니다.
//@SinceKotlin("1.3")
//public abstract class SequenceScope<in T> internal constructor()

val seq2 = sequence {
    println("Generating 1st")
    yield(1)
    println("Generating 2nd")
    yield(2)
    println("Generating 3rd")
    yield(3)
    println("Done")
}

val seq3 = sequence {
    println("Generating 1st")
    yield(1)
    println("Generating 2nd")
    yield(2)
    println("Generating 3rd")
    yield(3)
    println("Generating 4th")
    yield(4)
    println("Generating 5th")
    yield(5)
    println("Generating 6th")
    yield(6)
    println("Done")
}

fun main(){
    for (num in seq1){
        print(num)
    }//123

    println("\n----------")
    for (num in seq2){
        println(num)
    }
    //출력
    //Generating 1st
    //1
    //Generating 2nd
    //2
    //Generating 3rd
    //3
    //Done
    //중단 체제가 없으면 함수가 중간에 멈췄다가 나중에 중단된 지점에서 다시 실행되는것은 불가능함

    println("\n----------")
    val iterator = seq3.iterator()
    for (num in iterator){
        println(num)
        if (num == 3) break
    }
    println("out of repeat")
    println(iterator.next())
    println(iterator.next())
    println(iterator.next())
    // 출력
    //Generating 1st
    //1
    //Generating 2nd
    //2
    //Generating 3rd
    //3
    //out of repeat
    //Generating 4th
    //4
    //Generating 5th
    //5
    //Generating 6th
    //6

    //println(iterator.next())
    //Done
    //Exception in thread "main" java.util.NoSuchElementException

    // iterator를 사용하면 빌더의 이저지점으로 돌아갑니다. 코루틴이 이것을 도와주는것입니다.
    // 이행동을 thread 가 한다면 비용이 커질것이고 유지 관리도 힘들어 질것입니다.

    // 시퀀스 빌더는 반화이 아닌 중단 함수를 사용하면 안됩니다. 중단이 필요하다면 flow를 사용하는 좋습니다.
    // flow는 여러가지 코루틴 기능을 지원합니다.
}