package com.potatomeme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    lateinit var button_coroutines: Button
    lateinit var button_blocking: Button
    lateinit var button_clear: Button
    lateinit var text_view: TextView
    lateinit var progressBar1: ProgressBar
    lateinit var progressBar2: ProgressBar
    lateinit var progressBar3: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_coroutines = findViewById(R.id.button_coroutines)
        button_blocking = findViewById(R.id.button_blocking)
        button_clear = findViewById(R.id.button_clear)
        text_view = findViewById(R.id.text_view)
        progressBar1 = findViewById(R.id.progressBar1)
        progressBar2 = findViewById(R.id.progressBar2)
        progressBar3 = findViewById(R.id.progressBar3)

        button_coroutines.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                runDreamCode()
            }
        }
        button_blocking.setOnClickListener {
            runBlocking {
                runDreamCode()
            }
        }
        button_clear.setOnClickListener {
            text_view.text = ""
        }
        initProgress()
    }

    suspend fun runDreamCode() {
        val time = measureTimeMillis {
            val one = doSomethingUsefulOne()      // val user = fetchUserData() (Network I/O)
            val two = doSomethingUsefulTwo()      // cacheUserData(user) (Database I/O)
            println("The answer is ${one + two}") // textView.text = user.name (update ui)
        }
        println("Completed in $time ms")
    }

    suspend fun doSomethingUsefulOne(): Int {
        println("start> doSomethingUsefulOne 1")
        delay(2000L)
        println("end> doSomethingUsefulOne 1")
        return 13
    }

    suspend fun doSomethingUsefulTwo(): Int {
        println("start> doSomethingUsefulTwo 2")
        delay(2000L)
        println("end> doSomethingUsefulTwo 2")
        return 29
    }

    fun <T> println(msg: T) {
        val log = "$msg [${Thread.currentThread().name}]"
        runOnUiThread {
            text_view.append("\n$log")
        }
        Log.d("TEST", log)
    }

    fun initProgress() {
        progressBar1.max = 100
        progressBar2.max = 200
        progressBar3.max = 300
        GlobalScope.launch {
            while (isActive) {
                delay(10)
                var progress = progressBar1.progress + 1
                if (progress > progressBar1.max) {
                    progress = 0
                }
                progressBar1.progress = progress
                progress = progressBar2.progress + 1
                if (progress > progressBar2.max) {
                    progress = 0
                }
                progressBar2.progress = progress
                progress = progressBar3.progress + 1
                if (progress > progressBar3.max) {
                    progress = 0
                }
                progressBar3.progress = progress
            }
        }
    }
}
