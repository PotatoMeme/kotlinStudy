package com.potatomeme.applyviewmodel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MyViewModel(
    _counter : Int,
    private val savedStateHandle: SavedStateHandle,
): ViewModel() {


    var counter: Int = 0

    init {
        counter = savedStateHandle.get<Int>(SAVE_STATE_KEY) ?: _counter
        Log.d("tag","test : ${savedStateHandle.get<Int>(SAVE_STATE_KEY).toString()}")
    }


    fun addCounter(){
        counter++
        saveState()
        Log.d("tag","test : ${savedStateHandle.get<Int>(SAVE_STATE_KEY).toString()}")

    }

    fun saveState() {
        savedStateHandle.set(SAVE_STATE_KEY, counter)
    }

    companion object {
        private const val SAVE_STATE_KEY = "counter"
    }
}