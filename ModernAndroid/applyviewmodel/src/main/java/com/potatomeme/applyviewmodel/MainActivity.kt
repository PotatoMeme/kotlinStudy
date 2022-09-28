package com.potatomeme.applyviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.potatomeme.applyviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        var counter = 100
//        binding.tvNum.text = counter.toString()
//
//        binding.btnIncrease.setOnClickListener {
//            counter++
//            binding.tvNum.text = counter.toString()
//        }
//
//        binding.btnDecrease.setOnClickListener {
//            counter--
//            binding.tvNum.text = counter.toString()
//        }

//        var myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
//        myViewModel.counter = 100
//        binding.tvNum.text = myViewModel.counter.toString()
//
//        binding.btnIncrease.setOnClickListener {
//            myViewModel.counter += 1
//            binding.tvNum.text = myViewModel.counter.toString()
//        }

        // ViewModelProvider로 ViewModel객체를 만들때 초기값을 전달해주는것이 금지 되었기때문에 factory 패턴으로 초기값을 전달해 주어야 합니다

//        val factory = MyViewModelFactory(100)
//        val myViewModel = ViewModelProvider(this, factory).get(MyViewModel::class.java)
//
//        binding.tvNum.text = myViewModel.counter.toString()
//
//        binding.btnIncrease.setOnClickListener {
//            myViewModel.counter += 1
//            binding.tvNum.text = myViewModel.counter.toString()
//        }

        // by 키워드로 손쉽게 만들수도 있습니다.
        // implementation("androidx.activity:activity-ktx:1.4.0")
        // implementation("androidx.fragment:fragment-ktx:1.4.1")
        // 추가후

//        val factory = MyViewModelFactory(100)
//        val myViewModel by viewModels<MyViewModel>() { factory }
//
//        binding.tvNum.text = myViewModel.counter.toString()
//
//        binding.btnIncrease.setOnClickListener {
//            myViewModel.counter += 1
//            binding.tvNum.text = myViewModel.counter.toString()
//        }

        // savedState
       val factory = MyViewModelFactory(100,this,savedInstanceState)
        val myViewModel : MyViewModel by viewModels { factory }
        binding.tvNum.text = myViewModel.counter.toString()

        binding.btnIncrease.setOnClickListener {
//            myViewModel.counter += 1
//            myViewModel.saveState()
            myViewModel.addCounter()
            binding.tvNum.text = myViewModel.counter.toString()
        }

    }
}