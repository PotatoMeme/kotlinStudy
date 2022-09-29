package com.potatomeme.applyviewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MyViewModel(
    _counter : Int,
    private val savedStateHandle: SavedStateHandle,
): ViewModel() {


    //var counter: Int = 0
    var liveCounter : MutableLiveData<Int> = MutableLiveData(_counter)
    val modifiedCounter : LiveData<String> = Transformations.map(liveCounter){ counter ->
        "$counter 입니다."
    }

    init {
        Log.d(TAG,"test : ${savedStateHandle.get<Int>(SAVE_STATE_KEY).toString()}")
    }



    fun saveState() {
        savedStateHandle.set(SAVE_STATE_KEY, liveCounter.value)
        Log.d(TAG,"counter : ${savedStateHandle.get<Int>(SAVE_STATE_KEY).toString()}")
    }

    companion object {
        private const val SAVE_STATE_KEY = "counter"
        private const val TAG = "MyViewModel"
    }
}