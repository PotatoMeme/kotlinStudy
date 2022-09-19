package com.potatomeme.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).allowMainThreadQueries().build()

        db.todoDao().selectAll().observe(this) {
            tv_result.text = it.toString()
        }

        btn_add.setOnClickListener {
            db.todoDao().insert(Todo(et_name.text.toString()))
        }
    }
}