package com.potatomeme.modernandroid.docs

// Flow

// 코루틴에서 Flow는 단일 값만 반환하는 suspend 함수와 달리 여러 값을 순차적으로 내보낼 수 있는 유형입니다
// 예를 들면 Flow를 사용하여 데이터베이스에서 실시간 업데이트를 수신할 수 있습니다.
// Flow는 코루틴을 기반으로 빌드되며 여러 값을 제공할 수 있습니다.
// Flow는 비동기식으로 계산할 수 있는 데이터 스트림의 개념입니다.
// 내보낸 값은 동일한 유형이어야 합니다. ex) Flow<Int>

// Flow는 값 시퀀스를 생성하는 Iterator와 매우 비슷하지만 정지 함수를 사용하여 값을 비동기적으로 생성하고 사용합니다
// 예를 들어 Flow는 기본 스레드를 차단하지 않고 다음 값을 생성할 네트워크 요청을 안전하게 만들 수 있습니다.

// 데이터 스트림에는 다음과 같은 세 가지 항목이 있습니다.


// 생산자(Producer)는 스트림에 추가되는 데이터를 생산합니다.
// 코루틴 덕분에 흐름에서 비동기적으로 데이터가 생산될 수도 있습니다.

// (선택사항) 중개자(Intermediary)는 스트림에 내보내는 각각의 값이나 스트림 자체를 수정할 수 있습니다.

// 소비자(Consumer)는 스트림의 값을 사용합니다.

// Android에서 Repository는 일반적으로 UI 데이터 생산자입니다.
// 이때 사용자 인터페이스(UI)는 최종적으로 데이터를 표시하는 소비자입니다.
// UI 레이어가 사용자 입력 이벤트의 생산자이고 계층 구조의 다른 레이어가 이 이벤트를 사용하기도 합니다.
// 생산자와 소비자 사이의 레이어는 일반적으로 다음 레이어의 요구사항에 맞게 조정하기 위해 데이터 스트림을 수정하는 중개자의 역할을 합니다

// ------------------------------------------------------------------------------------------------------------------

// Flow의 동작

// val flow : Flow<Int> = flow {
//      for (i in 1..10){
//          delay(100)
//          emit(i)// 방출
//      }
// }

// https://kotlinlang.org/docs/flow.html

// 스레드
//fun simple(): Sequence<Int> = sequence { // sequence builder
//    for (i in 1..3) {
//        Thread.sleep(100) // pretend we are computing it
//        yield(i) // yield next value
//    }
//}
//
//fun main() {
//    simple().forEach { value -> println(value) }
//}

// 코루틴
//suspend fun simple(): List<Int> {
//    delay(1000) // pretend we are doing something asynchronous here
//    return listOf(1, 2, 3)
//}
//
//fun main() = runBlocking<Unit> {
//    simple().forEach { value -> println(value) } // 3초후 한번에 값이 나옴
//}

// Flow
//fun simple(): Flow<Int> = flow { // flow builder
//    for (i in 1..3) {
//        delay(100) // pretend we are doing something useful here
//        emit(i) // emit next value
//    }
//}
//
//fun main() = runBlocking<Unit> {
//    // Launch a concurrent coroutine to check if the main thread is blocked
//    launch {
//        for (k in 1..3) {
//            println("I'm not blocked $k")
//            delay(100)
//        }
//    }
//    // Collect the flow
//    simple().collect { value -> println(value) }
//}

//I'm not blocked 1
//1
//I'm not blocked 2
//2
//I'm not blocked 3
//3

// ------------------------------------------------------------------------------------------------------------------

// Flow 분류

// 코트린에서 Flow는 ColdStream 채널은 HotStream으로 분류

// ColdStream: 요청이 있을때만 방출 ex) 플레이어
// HotStream: 요청이 있건 없건 방출 ex) 라디오

//fun simple(): Flow<Int> = flow {
//    println("Flow started")
//    for (i in 1..3) {
//        delay(100)
//        emit(i)
//    }
//}
//
//fun main() = runBlocking<Unit> {
//    println("Calling simple function...")
//    val flow = simple()
//    println("Calling collect...")
//    flow.collect { value -> println(value) }
//    println("Calling collect again...")
//    flow.collect { value -> println(value) }
//}

//Calling simple function...
//Calling collect...
//Flow started
//1
//2
//3
//Calling collect again...
//Flow started
//1
//2
//3

// ------------------------------------------------------------------------------------------------------------------

// Flow vs Livedata

// Flow

// Coroutine Scope안에서 동작
// ViewModelScope나 LifecycleScope와 함께사용하면
// 라이브 데이터처럼 뷰모델이나 액티비티니 프레그먼트의 생명주기에 맞춰 동작을 실행하거나 정지가 가능

// Operator
// Livedata 보다 풍부한연산자가 있어 필요에따라 유연하게 변화시킬수 있음

// Android Dependency
// 코트린에 종속되있어 안드로이드의 의존성에 있어 자유로움

//Livedata
//생명주기를 가진 데이터 홀더
//메인스레드에서 동작
//안드로이드와 밀접하게 연결되어 있음

//Flow
//CoroutineScope 안에서 동작
//안드로이드 라이프사이클 감지가능
//안드로이드 의존성 제거가능
//Cold stream
//상태가 없음

// ------------------------------------------------------------------------------------------------------------------

// SharedFlow & StateFlow

// SharedFlow : 핫스트림으로 동작하게 구성된 Flow의 종류
// StateFlow : SharedFlow에 상태를 부여하여 현재의 값을 구할수 있도록 제한을 가한것

// Livedata -> StateFlow
// Livedata와 비슷한 동작을 하면서도 UI에서 데이터레밸까지 사용할수있는 데이터 홀더

// fun <T> Flow<T>.stateIn(scope: CoroutineScope, started: SharingStarted, initialValue: T): StateFlow<T

// scope : StateFlow가 작동할 스코프
// started : 구독을 시작하는 타이밍
// SharingStarted.Eagerly: collector가 존재하지 않더라도 바로 sharing이 시작되며 중간에 중지되지 않음.
// SharingStarted.Lazily: collector가 등록된 이후부터 sharing이 시작되며 중간에 중지되지 않음.
// SharingStarted.WhileSubscribed: collector가 등록되면 바로 sharing을 시작하며 collector가 전부 없어지면 바로 중지됨.
// initialValue : 초기값