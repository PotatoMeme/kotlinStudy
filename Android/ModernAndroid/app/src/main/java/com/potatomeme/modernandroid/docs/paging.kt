package com.potatomeme.modernandroid.docs

//Paging이란
//Paging : 하나의 문서를 분리된 페이지로 나누는 것
//android 구글 검색 결과

//대량의 데이터들을 불러와 UI로 한번에 출력을 학거나 변환을 할경우 과부하가 걸리기때문에 Paging을 하여 부담을 줄일수 있음

//Jetpack Paging
//https://developer.android.com/jetpack/androidx/releases/paging

//이라이브러리를 통해 페이징의 구현을 하지않고도 손쉽게 페이징을 할수있음

//Jetpack Paging의 구성요소

//Repository
//PagingSource : 데이터 소스와 그 소스에서 데이터를 검색하는 방법을 정의.
//RemoteMediator : 로컬 데이터베이스에 네트워크 데이터를 캐시하는 동작을 관리.

//ViewModel
//Pager : Repository에서 정의한 PagingSource와 PagingConfig를 생성자로 받아 PagingData를 반환하는 API를 제공.
//PagingData : Pager에 의해 페이징 된 데이터를 담는 컨테이너.

//UI
//PagingDataAdapter : PagingData를 표시할 수 있는 RecyclerView 어댑터


//Jetpack Paging의 동작원리

//case Database
//in Repository
//Database -> PagingSource
//in ViewModel
//-> Pager -(Flow<PagingData>)
//in UI
//-> PagingDataAdapter

//case Network
//in Repository
//(NetWork -> RemoteMediator -> Database) -> PagingSource ->
//in ViewModel
//-> Pager -(Flow<PagingData>)
//in UI
//-> PagingDataAdapter