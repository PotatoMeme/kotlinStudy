package com.potatomeme.modernandroid.docs

// Data Binding Library

// The Data Binding Library is a support library that allows you to bind UI components in your layouts to data sources in your app using a declarative format rather than programmatically.
// 데이터 바인딩 라이브러리는 프로그래밍 방식이 아닌 선언적 형식을 사용하여 레이아웃의 UI 구성 요소를 앱의 데이터 소스에 바인딩할 수 있는 지원 라이브러리입니다.
// 코틀린 코드와 xml의 UI컴포넌트를 연결하는 라이브러리

// DataBinding 의 3가지 특징
// Remove findViewById
// Custom Binding Adapter -> custom 바인딩 어뎁터를 사용
// Two-way DataBinding -> 양방향 데이터 결합

// Android 생태계에서 이미 많이 사용되고 있는 DataBinding(데이터바인딩)은 간단하게 xml파일에 Data를 연결(binding)해서 사용할 수 있게 도와주며 Android JetPack 라이브러리의 하나의 기능 입니다.

// 데이터바인딩은 애플리케이션 로직과 레이아웃을 binding하는 데 필요한 글루 코드를 최소화합니다.

// 글루 코드란?
// 프로그램의 요구사항 구현에는 기여하지 않지만, 본래 호환성이 없는 부분끼리 결합하기 위해 작동하는 코드

// 필요 라이버리리 및 플러그인 세팅

// kotlin-kapt

// dataBinding {
// 	   enabled true
//   }

//1. Databinding을 사용하면 findViewById(), 버터나이프를 쓰지 않아도 xml에 만든 View들을 자동으로 만들어 준다.
//2. Data가 바뀌면 알아서 바뀐 Data로 View를 변경하게 할수도 있다. (옵저블 사용시)
//3. RecyclerView에서 각각의 item을 세팅 해주는 작업도 xml에서 다 써주면 알아서 척척 값이 들어간다. (요거 엄청 편리합니다.)
//4. JakeWharton의 Butterknife가 Deprecated 되었고 구글에서 권장하므로 앞으로는 Databinding을 사용 해야한다.

//  private lateinit var binding: ActivityMainBinding
//  binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

// val binding =
//            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)