package com.potatomeme.kotlinbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.potatomeme.R
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            myFunction(){ println("Test")}
        }

    }
}
// suspend 정지함수
// 실행되고 끝날때까지 대기
// 메인스레드에서는 못함
// suspend함수 안에서만 실행 가능 but 코루틴안에서 실행 가능
suspend fun myFunction(callback: () -> Unit = {}){
    println("함수 시작")
    callback()
    println("함수 끝")
}