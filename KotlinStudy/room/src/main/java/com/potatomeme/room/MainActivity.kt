package com.potatomeme.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.potatomeme.room.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //liveData를 사용하기 위해서
        binding.lifecycleOwner = this

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.viewModel = mainViewModel

        binding.btnAdd.setOnClickListener {
            mainViewModel.insert()
        }
    }
}