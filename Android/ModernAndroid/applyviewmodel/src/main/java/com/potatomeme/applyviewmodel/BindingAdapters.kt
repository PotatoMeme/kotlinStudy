package com.potatomeme.applyviewmodel

import android.util.Log
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter

//@BindingAdapter("app:progressScaled")
//fun setProgress(progressBar: ProgressBar,counter:Int){
//    progressBar.progress = counter
//}// app:progressScaled가 값을 전달받을때마다 BindingAdapter의 setProgress가 실행됨
//// 파라미터로는 view와 해당하는 속성값을 전달하면 됩니다.

// "app:progressScaled","android:max"를 관찰하면 실행(복수개)
@BindingAdapter( value = ["app:progressScaled","android:max"], requireAll = true)
fun setProgress(progressBar: ProgressBar,//View
                counter: Int,//"app:progressScaled"
                max: Int//"android:max"
) {
    progressBar.progress = (counter * 2).coerceAtMost(max)
}