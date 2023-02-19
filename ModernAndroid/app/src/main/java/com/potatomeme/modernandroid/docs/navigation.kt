package com.potatomeme.modernandroid.docs

// Navigation

// ---------------------------------------------------------------------------------------------------------------------------------------

// Jetpack Navigation 도입

// FragmentManager
// add
// replace
// commit
// supportFragmentManager.beginTransaction()
//          .replace(R.id.frame_layout,TestFragment)
//          .commit

// Single activity
// 가능한 여러액티비티를 사용하는것이아닌 최소한의 액티비티를 사용하고 프래그먼트들을 이용하자 => 화면 전환을 직접전환하지 말고 라이브러리에 맡기자

// ---------------------------------------------------------------------------------------------------------------------------------------

// Navigation의  3대 컴포넌트
// Navigation graph, editor나 xml을 수정하여 앱에서 사용할 화면과 그연관 관계 이동 방법을 정의 res>navigation

// Navigation host, Navigation graph에서 정의한 프레그먼트를 화면에 표시하기위한 컨테이너
// <androidx.fragment.app.FragmentContainerView
//      android:id="@+id/fragment_container_view"
//      android:layout_width="match_parent"
//      android:layout_height="match_parent"
//      android:name="androidx.navigation.fragment.NavHostFragment" -> view가 NavHostFragment에 연결됨
//      app:defaultNavHost="true" -> System의 back버튼을 가로체 이전 화면으로 전환 하게함
//      app:navGraph="@navigation/mobile_navigation" -> Navigation graph를 지정
//      />

// Navigation controller
// 화면전환을 수행하는 컨트롤러
// 모든 navigation host는 하나의 Navigation controller를 가지게됨
// fragment를 전환하기 위해서는 navigation host로부터 Navigation controller의 instance를 얻어서 navigate method를 실행 시켜줘야함


// Fragment 에서는
// val navController = findNavController()

// Activity 에서는
// val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
// val navController = navHostFragment.navController

// ---------------------------------------------------------------------------------------------------------------------------------------

// SaveArgs를 사용하여 프래그머트간 데이터 전달하기

// 기존에 프래그먼트사이에 값을 전달하기 위해서는 key value 타입의 번들을 사용함
// 그렇지만 bundle은 type 안정성을 보장하지 않는 한계가 있음
// Navigation componet 에서는 SaveArgument 개념을 도입하여 데이터들을 안전하게 전달할수 있도록 함

// SaveArgs를 활성화시 3종류의 클래스가 자동으로 만들어집니다.
// 1. 내비게이션의 'action' 이 시작되는  대상의 이름에 'Directions' 라는 접미어가 붙은 클래스
// 2. 'argument'를 전달하는데 사용한 'action' 의 이름과 동일한 이름의 클래스
// 3. 데이터를 수신하는 대상의 이름에  'Args' 라는 접미어가 붙은 클래스

// ex)
// override fun onClick(v:View){
//      val amountTv : EditText = view!!.findViewById(R.id.editTextAmount)
//      val amount : SpecifyAmountFragmentDirections.confirmationAction(amount)
//      v.findNavController().navigate(action)
// }