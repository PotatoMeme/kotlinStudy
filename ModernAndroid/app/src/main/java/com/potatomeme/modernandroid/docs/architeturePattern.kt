package com.potatomeme.modernandroid.docs


// Architecture Pattern

// 개발하면서 공통으로 효율적으로 사용할수있는 구조가 있다
// 안드로이드에서는 MVC,MVP,MVVM이 주로 사용됨

// mvc -> mvp -> mvvm
// 주요 목적 : 관심사를 분리하면서 프로그램을 더안전하고 확장가능성이 더 높게 만들어줍니다

// 기존
// 액티비티안에서 대부분의 기능을 수행하며, 동작은 잘하더라도 코드는 가독성이 좋지않고 기능추가나 유지보수가 힘듭니다.

// --------------------------------------------------------------------------------------------------

// MVC : Model View Controller

// Model
// 데이터와 비지니스 로직이라고 불리는 앱의 UI와 관계 없는 부분을 담당, 앱의 두뇌와 같음

// ex)
//data class User(
//    // 데이터
//    var userName: String? = null,
//    var password: String? = null
//){
//    // 비지니스 로직
//    fun login(){
//        //.....
//    }
//
//    // 데이터
//    companion object{
//          //....
//    }
//}

// View
// 사용자에게 보여지는 UI 화면, 안드로이드에서는 xml이 그역할을 가짐

// Controller
// View와  Model의 상호작용을 도와주는 컨트롤 타워
// 외부에서 받은 내용을 처리하여 표시하는 프리젠테이션 로직을 가짐

//class MvcLoginActivity : AppCompatActivity() {
//    private val binding: ActivityMvcLoginBinding by lazy {
//        ActivityMvcLoginBinding.inflate(layoutInflater)
//    }
//    private lateinit var user: User
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        // 레이아웃 처리
//        setContentView(binding.root)
//
//        user = User()
//
//        // 프레젠테이션 로직
//        binding.included.loginBtn.setOnClickListener {
//          //....
//        }
//    }
//}

// -> 결과
// MVC 패턴에서는 Model 과 View가 완전히 분리 되므로 Model은 쉽게 테스트 가능
// Controller가 안드로이드에 종속되기 때문에 테스트가 어려워짐
// 안드로이드 특성상 액티비티가 View 표시와 Controller 역할을 같이 수행 해야하기 때문에 두요소의 결합도가 높아짐
// 많은 코드가 Controller로 모이게 되어 액티비티가 비대해짐 유닛테스트나 기능추가가 힘들어짐

// --------------------------------------------------------------------------------------------------

// MVP : Model View Presenter
// Model
// MVC의 Model과 동일 View와 직접적인 의존성이 사라짐 중간에 Presenter가 관리하도록 변경된

// Presenter
// 본질적으로 MVC의 Controller와 같은 역할을 가짐
// View의 참조를 직접 거치지 않고 이러안 interface를 통하여 교신하게 되었기 때문에 상대적으로 느슨해짐
// Controller 와는 달리 안드로이드 의존성을 가지지 않기 때문에 test도 용의 해짐

//interface LoginPresenter {
//    val user: User
//
//    fun login()
//}

//class LoginPresenterImpl(
//    private val mvpLoginView: MvpLoginView // View에 참조를 받음
//) : LoginPresenter {
//
//    override val user: User // Model에 참조를 받음
//        get() = User()
//
//    override fun login() {
//          //....
//        val isLoginSuccessful: Boolean = user.login(userName, password) // model로 부터 data를 받음
//        mvpLoginView.onLoginResult(isLoginSuccessful) // 받은 데이터를 View에 전달
//    }
//}

// View
// 온전한 View로 간주가 됨 model에 대한 참조가 사라진 대신 presenter를 참조함

//interface MvpLoginView {
//    val userName: String?
//    val password: String?
//
//    fun onLoginResult(isLoginSuccess: Boolean?)
//}
//class MvpLoginActivity : AppCompatActivity(), MvpLoginView {
//    private val binding: ActivityMvpLoginBinding by lazy {
//        ActivityMvpLoginBinding.inflate(layoutInflater)
//    }
//    private lateinit var loginPresenterImpl: LoginPresenterImpl // presenter를 참조
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(binding.root)
//
//        loginPresenterImpl = LoginPresenterImpl(this)
//        binding.included.loginBtn.setOnClickListener { loginPresenterImpl.login() }
//    }
//
//    override val userName: String
//        get() = binding.included.etUserName.text.toString()
//    override val password: String
//        get() = binding.included.etPassword.text.toString()
//
//    override fun onLoginResult(isLoginSuccess: Boolean?) {
//          //....
//    }
//}

// -> 결과
// View와 Model 사이의 데이터 흐름이 사라지고 Presenter가 중간에서 데이터 흐름을 제어
// 인터페이스를 추가로 구현해야하기 떄문에 구현 비용이 올라가게 됨
// View와 Presenter가 1:1로 대응 해야 하기 때문에 앱이 커질수록 두 요소의 의존성이 강해지게 됨

// --------------------------------------------------------------------------------------------------

// MVVM : Model View ViewModel
// Model
// MVC 의 Model 과 같음

// ViewModel
// View를 만드는데 필요한 로직을 가진 모델
// View를 참조하지 않기 때문에 ViewModel과 View가 1:N 관계를 가지게됨
// 중복되는 코드를 ViewModel에 묶어 코드의 양을 줄일수 있게됨

//class LoginViewModel : ViewModel() {
//    private val user: User = User()
//    private val _isLoginSuccessfulFlag: MutableLiveData<Boolean> = MutableLiveData()
//    val isLoginSuccessfulFlag: LiveData<Boolean>
//        get() = _isLoginSuccessfulFlag
//    val userName: String
//        get() = user.userName.toString()
//
//
//    private fun setIsLoginSuccessfulFlag(isLoginSuccessful: Boolean) {
//        _isLoginSuccessfulFlag.postValue(isLoginSuccessful)
//    }
//
//    fun login(userName: String, password: String) {
//        val isLoginSuccessful: Boolean = user.login(userName, password)
//        if (isLoginSuccessful) {
//            setIsLoginSuccessfulFlag(true)
//        } else {
//            setIsLoginSuccessfulFlag(false)
//        }
//    }
//}

// View
// 사용자에게 보여지는 UI 파트
// 데이터 바인디을 통해서 ViewModel로 부터 일방적으로 통지 받은 데이터를 표시하는 역할을 함
// ViewModel에서는 View를 참조하지는 않지만 뷰에 바인딩할 옵저버블 데이터를 가지고있기때문에
// View가 이데이터를 옵저빙 함으로서 UI갱신가능

//class MvvmLoginActivity : AppCompatActivity() {
//    private val binding: ActivityMvvmLoginBinding by lazy {
//        ActivityMvvmLoginBinding.inflate(layoutInflater)
//    }
//    private lateinit var loginViewModel: LoginViewModel
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(binding.root)
//
//        binding.included.loginBtn.setOnClickListener {
//            loginViewModel.login(
//                binding.included.etUserName.text.toString(),
//                binding.included.etPassword.text.toString()
//            )
//        }
//        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
//        loginViewModel.isLoginSuccessfulFlag.observe(this, loginObserver)
//    }
//
//    // 데이터 바인딩
//    private val loginObserver = Observer<Boolean> { isLoginSuccessful ->
//        if (isLoginSuccessful) {
//            Toast.makeText(
//                this@MvvmLoginActivity, loginViewModel.userName + " Login Successful",
//                Toast.LENGTH_SHORT
//            ).show()
//        } else {
//            Toast.makeText(this@MvvmLoginActivity, "Login Failed", Toast.LENGTH_SHORT).show()
//        }
//    }
//}

// -> 결과
// View와 Model사이에 의존성이 없으며, ViewModel도 View에 의존성을 가지지 않음
// 참조는 View -> ViewModel -> Model순으로 단방향으로만 일어납니다.
// 유지보수가 용이 해짐

// --------------------------------------------------------------------------------------------------

//  Activity / Fragment -> ViewModel[LiveData] -> Repository -> Model [Room] -> Sqlite
//                                                           -> Remote Data Source [Retrofit] ->  webService

// in 2022 3개의 Layer로 접근
// UI Layer [ UI elements , State holders ] -> Domain Layer (optional) -> Data Layer [ Repositories , Data Source]
// View,ViewModel -> UseCase ->  Repository , Data Source
// UseCase가 없으면 ViewModel이 비지니스 로직으로 비대해진다는 문재가 생김

// --------------------------------------------------------------------------------------------------

// 생각
// MVVM 이나 Clean Architecture가 있으며 이는 권장사항일뿐 필수사항은 아님
// Architecture 사용시 앱은 더욱 견고해짐

// --------------------------------------------------------------------------------------------------

// 용어 설명

// 프리젠테이션 로직
// 말 그래도 보여주기 위한 로직을 말한다.
// 즉 화면상의 디자인 구성을 위한 로직을 일컫는 말로써,
// 게시판에서의 표시하기 위한 for(or while)문 등의 사용이 여기에 해당한다.

// 비즈니스 로직
// 특정한 값을 얻기 위해 데이터의 처리를 수행하는 응용프로그램의 일부를 말한다.
// 즉 원하는 값을 얻기 위해서 백엔드에서 일어나는 각종 처리를 일컫는 말이다.

// UseCase
// 서비스를 사용하고 있는 사용자(User)가 해당 서비스를 통해 하고자 하는 것을 의미한다.

// 참고 : https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=semi7623&logNo=100005637337
// 참고 : https://heegs.tistory.com/58