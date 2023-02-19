package com.potatomeme.modernandroid.docs

// UI Layer [ UI elements , State holders ] -> Domain Layer (optional) -> Data Layer [ Repositories , Data Source]
// View,ViewModel -> UseCase ->  Repository , Data Source

// Repository란?
// --------------------------------------------------------------------------------------------------

// A Repository mediates between the domain and data mapping layers, acting like an in-memory domain object collection.
// Client objects construct query specifications declaratively and submit them to Repository for satisfaction.
// Objects can be added to and removed from the Repository, as they can from a simple collection of objects,
// and the mapping code encapsulated by the Repository will carry out the appropriate operations behind the scenes.
// Conceptually, a Repository encapsulates the set of objects persisted in a data store and the operations performed over them,
// providing a more object-oriented view of the persistence layer.
// Repository also supports the objective of achieving a clean separation and one-way dependency between the domain and data mapping layers.

// --------------------------------------------------------------------------------------------------

// Repository는 메모리 내 도메인 개체 컬렉션처럼 작동하여 도메인과 데이터 매핑 레이어 사이를 중재합니다.
// 클라이언트 개체는 쿼리 사양을 선언적으로 구성하고 만족을 위해 리포지토리에 제출합니다.
// 개체는 단순한 개체 컬렉션에서와 마찬가지로 저장소에 추가 및 제거할 수 있으며 저장소에 의해 캡슐화된
// 매핑 코드는 배후에서 적절한 작업을 수행합니다.
// 개념적으로 리포지토리는 데이터 저장소에 지속되는 개체 집합과 이에 대해 수행되는 작업을 캡슐화하여 지속성 계층에 대한
// 보다 개체 지향적인 보기를 제공합니다.
// Repository는 또한 도메인과 데이터 매핑 레이어 간의 명확한 분리 및 단방향 종속성을 달성하는 목표를 지원합니다.

// --------------------------------------------------------------------------------------------------

// 데이터가 로컬DB인지 웹 응답인지에 관계없이 동일한 인터페이스를 통해서 데이터에 접근할수 있게하는 구조를 Repository pattern이라고 하고,
// 데이터에 접근하는데 필요한 논리를 캡슐화한것을 Repository라고 합니다.
// Repository pattern을 도입하는 가장 중요한 이유는 데이터 본체와 데이터 로직을 분리함으로서 각 코드사이의 결합도를 낮추는 것입니다.

// --------------------------------------------------------------------------------------------------

// 안드로이드 앱 아키테처와 Repository

// 클라이언트 <-- Api --> 서버

// ViewModel <-- Repository --> 데이터 소스

//     observes -->         observes -->
// view  ----->  viewModel  ------->   Repository ---> RoomDataSource,FireStoreDataSource
//    user actions -->    data request -->
//   Presentation Layer                         Data Layer