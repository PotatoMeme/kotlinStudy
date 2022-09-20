package com.potatomeme.mvvc_databinding_livedata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "SplashActivity"
    }

    lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        splashViewModel = ViewModelProvider(this)[SplashViewModel::class.java]

        GlobalScope.launch {
            delay(3000L)
            Log.d(TAG, "3초 지남")
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }
    }
}