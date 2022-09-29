package com.potatomeme.modernandroid.docs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations

// LiveData의 개념

// LiveData is a data holder class that can be observed within a given lifecycle.
// LiveData는 주어진 수명 주기 내에서 관찰할 수 있는 데이터 홀더 클래스입니다.

// This class is designed to hold individual data fields of ViewModel,
// but can also be used for sharing data between different modules in your application in a decoupled fashion.
// 이 클래스는 ViewModel의 개별 데이터 필드를 보유하도록 설계되었지만
// 분리된 방식으로 애플리케이션의 서로 다른 모듈 간에 데이터를 공유하는 데 사용할 수도 있습니다.

// Observer Pattern의 개념
// Subject의 상태 변화를 관찰 하는 Observer들을 객체와 연결
// Subject의 상태 변화를 초래하는 Event가 발생하면 객체가 그 Event를 직접 Observer에게 통지


// 옵저버에 의해 값의 변경을 감시할수 있는 안드로이드 데이터 홀더로는 Observable과 LiveData가 있습니다.

// Observable의 경우
//private val observableString = ObservableField<String>("Default value")
//
//observableString.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
//    override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
//        //Do something
//    }
//})//ObservableField는 DataBinding을 활성화해야 사용 가능합니다.

// LiveData의 경우
//private val observableString = MutableLiveData<String>("Default value")
//
//observableString.observe(lifecycleOwner, Observer {
//    //Do something
//})

// 차이점

// Observable :  콜백 등록
// lifecycle을 알 수 없으므로 등록한 콜백이 상시 작동되어야 함
// 작동이 필요없어지면 removeOnPropertyChangedCallback을 호출하여 콜백을 수동으로 직접 제거해야 함

// LiveData : lifecycleOwner 전달
// lifecycle이 start 혹은  resumed로 활성화 상태일 때만 observe를 수행
// 나머지 상태에서는 자동으로 비활성화

// LiveData의 이점
// UI와 데이터 상태의 일치 보장
// 메모리 누수 없음
// 중지된 활동으로 인한 비정상 종료 없음
// 수명 주기를 더이상 수동으로 처리하지 않음
// 최신 데이터 유지
// 적절한 구성 변경
// 리소스 공유

//  Tranformations로  LiveData 값 변경하기

// * map
//val userLiveData : LiveData<User> = MutableLiveData(User("Jone", "Doe"))
//val userNameLiveData : LiveData<String> = Transformations.map(userLiveData) { user ->
//    user.firstName + user.lastName
//}
// map의 첫 번째 인자로 LiveData source를 넘겨준다.
// 넘겨준 LiveData source 가 변경될 때마다 map이 반환하는 새로운 LiveData의 value역시 새롭게 갱신된다.
// 두 번째 인자로는 함수를 넘겨준다.
// 함수의 파라미터 타입은 source로 넘겨준 LiveData의 value Type(<User>)이며 함수의 return값은 무엇이든 상관없다.
// Transformations.map의 return 값(람다의 결과물 말고)은 LiveData이다.
// 기존 컬렉션의 map이 그러하듯 Transformations.map 역시 내용물 요소의 값만 변환 시킬 뿐 LiveData를 리턴한다.


// * switchMap
//val userIdLiveData: MutableLiveData<Int> = MutableLiveData<Int>().apply { value = 1 };
//val userLiveData: LiveData<User> = Transformations.switchMap(userIdLiveData) { id ->
//    repository.getUserById(id)
//}
//
//fun setUserId(userId: Int) {
//    userIdLiveData.setValue(userId);
//}
// switchMap의 첫 번째 인자로 LiveData source를 넘겨준다.
// 넘겨준 LiveData source 가 변경될 때마다 switchMap이 반환하는 새로운 LiveData의 value역시 새롭게 갱신된다.
// 두 번째 인자로는 함수를 넘겨준다.
// 함수의 파라미터 타입은 source로 넘겨준 LiveData의 value Type(<Int>)이며 함수의 return값은 LiveData이어야만 한다.

