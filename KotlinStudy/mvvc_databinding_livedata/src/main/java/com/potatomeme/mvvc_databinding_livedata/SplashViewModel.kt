package com.potatomeme.mvvc_databinding_livedata

import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay

class SplashViewModel : ViewModel() {
    companion object{
        private const val TAG = "SplashViewModel"
    }

    init {
        Log.d(TAG, "SplashViewModel 생성")
    }
}