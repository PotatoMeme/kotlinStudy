package com.potatomeme.inflearnKotlin.coroutines

import android.widget.TextView
import com.potatomeme.R

// Coroutine 루틴의 일종
// 협동 루틴이라 할 수 있다
// 코 루틴의 "Co"는 with 또는 together를 뜻한다
// 코 루틴은 이전에 자신의 실행이 마지막으로 중단되었던 지점 다음의 장소에서 실행을 재개한다.

// 코 루틴은 협력 작업, 예외, 이벤트 루프, 반복자, 무한 목록, 파이프등 친숙한
// 프로그램 구성 요소를 구현하는 데 적합합니다.

// 구글, 비동기 처리에 코 루틴을 추천
// 메이스레드가 블로킹되는것에 도움을 줍니다
// 비동기 처리 콜백과 코드들을 코루틴을 통해 순차적으로 만들수있게 해줌

/*

// fetchUserData 함수는 HttpConnection이나 Retrofit으로
// 서버 api를 조회해 유저 데이터를 받아오는 것을 뜻한다.
//The DreamCode V1
val user = fetchUserData() // NetworkOnMainThreadException 이게 아니더라도 ANR 발생
textView.text = user.name


//The DreamCode V2
thread {
    val user = fetchUserData()
    textView.text = user.name //CalledFromWrongThreadException 메인스레드가 아닌곳에서 UI를 업데이트를 하여 Exception 발생
}

// The Ok Code
fetchUserData { user -> // callback
    textView.text = user.name
}// OutOfMemoryError

// be the dreamCode with Coroutine

blocking.kt
async.kt
fun loadUser(){
    //val user = api.fetchUser() // error
    //show(user)

    api.fetchUser{ user ->
        show(user)
    }
}

coroutines.kt
suspend fun loadUser(){ // 비동기 처리 콜백과 코드들을 코루틴을 통해 순차적으로 만들수있게 해줌
    val user = api.fetchUser()
    show(user)
}
 */