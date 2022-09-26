package com.potatomeme.inflearnKotlin.modernAndroid

// SupportLibrary
// API의 하위 호환성 문제를 해결하기 위함
// ex) RecyclerView
// RecyclerView는 API 21이하부터는 사용할수 없지만
// SupportLibrary인 RecyclerView를 추가할경우 API 7이상의 기기까지 폭이 넓어 집니다.
// com.android.support

// v숫자 => 최소 Api를 말함

// *문제점

// 최소 API 레벨 문제
// - SupportLibrary 버전 26.0.0 부터는 최소 API를 14로 올림
//      => V7이라도 최소 API는 7이아니라 14가 됨

// 필요없는 라이브러리의 추가
// - 낭비가 커짐

// 버전 통일 문제
// 복수개의 SupportLibrary 를 사용할경우 버전을 맞춰 줘야 합니다.
//  => 1개라도 버전이 다르다면

// --------------------------------------------------------------------------------------------------

// Androidx 체계의 도입
// Android Library 패키징 방식을 변경하게 됨
// SupportLibrary -> AndroidExtensionLibraries(Androidx)

// 1. 라이브러리의 기능별 분리

// support-core-ui -> asynclayoutinflater
//                  -> drawerlayout
//                  -> interpolator
//                  -> cursoradapter
//                  -> customview
//                  -> slideingpanellayout
//                  -> viewpager

// 2. 버저닝 방식 변경
// API레벨과 동기화되어 올라가던 버저닝 방식은 28.0.0 부터 1.0.0으로 리셋

// Major.Minor.Patch 형식의 Semantic Versioning을 준수하게 됨
// MAJOR version when you make incompatible API changes
// 호환되지 않는 API 변경을 수행할 때
// MINOR version when you add functionality in a backwards compatible manner
// 이전 버전과 호환되는 방식으로 기능을 추가할 때
// PATCH version when you make backwards compatible bug fixes
// 이전 버전과 호환되는 버그 수정을 할 때

// RecyclerView의 업데이트가 이루어지면 RecyclerView 패키지만 개별적으로 업데이트 가능

// 3. 패키징 방식 변경
// 어떤 기능을 가졌는지 알수 없었던 SupportLibrary
// ex) android.support.v7.app

// 패키지 이름이 기능을 나타내도록 변경됨
// JavaPackage : androidx.<feature>.ClassName
// Maven id : androidx.<feature>.<feature>-<sub-feature>
// Class Mappings,Artifact Mappings

// 업데이트 확인
// Androidx의 최신 릴리즈 내용 : Recent Release Notes
// 개별커밋 Github

// --------------------------------------------------------------------------------------------------

// Android Jetpack

// 안드로이드 앱을 더욱 완성도있는 앱을만들기위해 도와주는 라이브러리들
// 4가지 카테고리로  구성
// Architecture( ex) DataBinding,Lifecycles,Navigation,Paging,Room,ViewModel,WorkManager) /
// UI( ex) Animation,Transitions,Auto,Tv,Wear,Emoji,Fragment,Layout,Palette) /
// Behavior( ex) Download Manager,Media,Playback,Permissions,Notifications,Sharing,Slices) /
// Foundation( ex)AppCompat,Android KTX,Multidex,Test)

// 특징

// Modern App Architecture, 최신 앱 아키텍처
// Eliminate Boiler Plate Code,보일러 플레이트 코드 제거
// Simplifying Complex Tasks, 복잡한 작업 단순화
// Robust Backwards Compatibility, 강력한 역호환성

// --------------------------------------------------------------------------------------------------

// 용어
// Boilerplate code
// 최소한의 변경으로 여러곳에서 재사용되며, 반복적으로 비슷한 형태를 띄는 코드
// 매번 프로그래밍을 할 때마다 보일러플레이트 코드를 작성하는 것은 비효율적이고 귀찮다.
// 리팩토링을 하게 되면 보일러플레이트 코드도 같이 수정해야하는 경우도 많다.

// 참고 : https://www.charlezz.com/?p=44186