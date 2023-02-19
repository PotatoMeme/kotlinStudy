package com.potatomeme.applyviewmodel

import android.os.Build.VERSION_CODES.M
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MyRepositoryImpl(counter : Int) : MyRepository {

    // Room생략
    private val livCounter = MutableLiveData<Int>(counter)

    override fun getCounter(): LiveData<Int> {
        return livCounter
    }

    override fun increaseCounter() {
        livCounter.value = livCounter.value?.plus(1)
    }
}