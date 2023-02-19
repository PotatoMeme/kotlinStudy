package com.potatomeme.applyviewmodel

import androidx.lifecycle.LiveData

interface MyRepository {
    fun getCounter() : LiveData<Int>
    fun increaseCounter()
}