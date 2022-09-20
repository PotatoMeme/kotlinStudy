package com.potatomeme.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val db = Room.databaseBuilder(
        application,
        AppDatabase::class.java, "database-name"
    ).build()

    var todos: LiveData<List<Todo>>
    var newTodo:String? = null
    init {
        todos = selectAll()
    }

    fun selectAll(): LiveData<List<Todo>> {
        return db.todoDao().selectAll()
    }

    fun insert(){
        viewModelScope.launch(Dispatchers.IO){
            newTodo?.let { Todo(it) }?.let { db.todoDao().insert(it) }
        }
    }


}