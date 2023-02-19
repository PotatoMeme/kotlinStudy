package com.potatomeme.modernandroid.docs

// DataStore

// 데이터를 앱에 저장하는 방법

// 1. 파일 I/O (내부 또는 외부 저장소)
// 접근 권한을 획득하고 파일을 열었다 닫았다 하는 수고가 필요

// 2. 관계형 데이터베이스
// SQLite 등을 이용해 복잡한 관계형 데이터를 저장할 수 있음
// 간단한 데이터를 저장할거라면 구축과 관리에 많은 시간과 노력이 요구됨

// 3. SharedPreference
// Key/Value 형태로 이용함
// 내부적으로는 XML 파일로 저장됨
// 파일을 열고 닫을 필요 없이 핸들러를 만들어서 간편하게 사용가능

// ---------------------------------------------------------------------------

// SharedPreferences 사용법

// 핸들러 준비
// val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)

// 데이터 저장
// val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
// with (sharedPref.edit()) {
//      putInt(getString(R.string.saved_high_score_key), newHighScore)
//      apply()
// }

// 데이터 로드
// val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
// val defaultValue = resources.getInteger(R.integer.saved_high_score_default_key)
// val highScore = sharedPref.getInt(getString(R.string.saved_high_score_key), defaultValue

// ---------------------------------------------------------------------------

// DataStore의 발표

// Preferences DataStore
// 키를 사용하여 데이터를 저장하고 데이터에 액세스합니다.
// 이 구현은 유형 안전성을 제공하지 않으며 사전 정의된 스키마가 필요하지 않습니다.

// Proto Datastore
// 맞춤 데이터 유형의 인스턴스로 데이터를 저장합니다.
// 이 구현은 유형 안전성을 제공하며 프로토콜 버퍼를 사용하여 스키마를 정의해야 합니다

//Feature                               SharedPreferences                                    PreferencesDataStore                                ProtoDataStore
//Async API                             ✅ (only for reading changed values, via listener)   ✅ (via Flow and RxJava 2 & 3 Flowable)              ✅ (via Flow and RxJava 2 & 3 Flowable)
//Synchronous API                       ✅ (but not safe to call on UI thread)               ❌                                                   ❌
//Safe to call on UI thread             ❌1                                                  ✅ (work is moved to Dispatchers.IO under the hood)  ✅ (work is moved to Dispatchers.IO under the hood)
//Can signal errors                     ❌                                                   ✅                                                   ✅
//Safe from runtime exceptions          ❌2                                                  ✅                                                   ✅
//Has a transactional API with strong
//consistency guarantees                ❌                                                   ✅                                                   ✅
//Handles data migration                ❌                                                   ✅                                                   ✅
//Type safety                           ❌                                                   ❌                                                   ✅ with Protocol Buffers