package com.potatomeme.modernandroid.docs

//Dependency Injection(의존성 주입) 기초

//-------------------------------------------------------------------------------------------------------

//SOLID 원칙 : 객체 지향 설계의 5대 원칙
//단일 책임 원칙 (Single responsibility principle, SRP)
//모든 클래스는 하나의 책임만 가지며, 클래스는 그 책임을 완전히 캡슐화해야 함을 일컫는다.
// => 클래스가 여러 책임을 가지게 되면 각 책임마다 클래스를 변경할수있는 이유가 생기기때문에 책임을 한가지만 가지도록 설계
// =>  이것이 클래스를 더욱 튼튼하게 만들기 때문
//https://ko.wikipedia.org/wiki/%EB%8B%A8%EC%9D%BC_%EC%B1%85%EC%9E%84_%EC%9B%90%EC%B9%99

//-------------------------------------------------------------------------------------------------------

//개방-폐쇄 원칙 (Open-closed principle, OCP)
//소프트웨어 개체(클래스, 모듈, 함수 등등)는 확장에 대해 열려 있어야 하고, 수정에 대해서는 닫혀 있어야 한다
// => 소프트웨어 개발 작업에 이용된 많은 모듈 중에 하나에 수정을 가할 때 그 모듈을 이용하는 다른 모듈을 줄줄이 고쳐야 한다면, 이와 같은 프로그램은 수정하기가 어렵다.
// => 개방-폐쇄 원칙은 시스템의 구조를 올바르게 재조직(리팩토링)하여 나중에 이와 같은 유형의 변경이 더 이상의 수정을 유발하지 않도록 하는 것
// => 개방-폐쇄 원칙이 잘 적용되면, 기능을 추가하거나 변경해야 할 때 이미 제대로 동작하고 있던 원래 코드를 변경하지 않아도, 기존의 코드에 새로운 코드를 추가함으로써 기능의 추가나 변경이 가능

//확장에 대해 열려 있다
// => 이것은 모듈의 동작을 확장할 수 있다는 것을 의미한다. 애플리케이션의 요구 사항이 변경될 때, 이 변경에 맞게 새로운 동작을 추가해 모듈을 확장할 수 있다. 즉, 모듈이 하는 일을 변경할 수 있다.

//수정에 대해 닫혀 있다
// => 모듈의 소스 코드나 바이너리 코드를 수정하지 않아도 모듈의 기능을 확장하거나 변경할 수 있다. 그 모듈의 실행 가능한 바이너리 형태나 링크 가능한 라이브러리(예를 들어 윈도의 DLL이나 자바의 .jar)를 건드릴 필요가 없다.
//https://ko.wikipedia.org/wiki/%EA%B0%9C%EB%B0%A9-%ED%8F%90%EC%87%84_%EC%9B%90%EC%B9%99

//-------------------------------------------------------------------------------------------------------

//리스코프 치환 원칙 (Liskov substitution principle, LSP)
//컴퓨터 프로그램에서 자료형 S가 자료형 T의 서브타입라면 필요한 프로그램의 속성(정확성, 수행하는 업무 등)의 변경 없이 자료형 T의 객체를 자료형 S의 객체로 교체(치환)할 수 있어야 한다는 원칙이다.
//https://ko.wikipedia.org/wiki/%EB%A6%AC%EC%8A%A4%EC%BD%94%ED%94%84_%EC%B9%98%ED%99%98_%EC%9B%90%EC%B9%99

//-------------------------------------------------------------------------------------------------------

//인터페이스 분리 원칙 (Interface segregation principle, ISP)
//클라이언트가 자신이 이용하지 않는 메서드에 의존하지 않아야 한다는 원칙이다.
// => 큰 덩어리의 인터페이스들을 구체적이고 작은 단위들로 분리시킴으로써 클라이언트들이 꼭 필요한 메서드들만 이용할 수 있게 한다.
//https://ko.wikipedia.org/wiki/%EC%9D%B8%ED%84%B0%ED%8E%98%EC%9D%B4%EC%8A%A4_%EB%B6%84%EB%A6%AC_%EC%9B%90%EC%B9%99

//-------------------------------------------------------------------------------------------------------

//의존성 역전 원칙 (Dependency inversion principle, DIP)
//소프트웨어 모듈들을 분리하는 특정 형식을 지칭한다.
// => 상위 모듈은 하위 모듈에 의존해서는 안된다. 상위 모듈과 하위 모듈 모두 추상화에 의존해야 한다.
// => 추상화는 세부 사항에 의존해서는 안된다. 세부사항이 추상화에 의존해야 한다.
//https://ko.wikipedia.org/wiki/%EC%9D%98%EC%A1%B4%EA%B4%80%EA%B3%84_%EC%97%AD%EC%A0%84_%EC%9B%90%EC%B9%99

//-------------------------------------------------------------------------------------------------------

//의존성 주입(Dependency Injection, DI)

//의존관계
//Piston <- Engine <- Car
//

//순환참조(Circular reference) 이런경우 유지보수가 힘들어지기때문에 이런 경우는 피해야함. 이럴때 의존성 역전 원칙이 도움임됨
//Car -> Engine -> Piston -> Car -> Engine .....

//안드로이드 의존성 주입 라이브러리
//Dagger / Hilt / Koin / Kodein / Anvi

//-------------------------------------------------------------------------------------------------------

//의존성 주입 방식별 구분
//class DieselEngine {
//  val fuel = "diesel"
//}
//
//class Car {
//  val engine = DieselEngine()
//}

//생성자 주입 방식
//class DieselEngine {
//  val fuel = "diesel"
//}
//
//class Car(val engine: DieselEngine) {
//}
//
//fun main() {
//  val dieselEngine = DieselEngine()
//  val car = Car(dieselEngine)
//}

//-------------------------------------------------------------------------------------------------------

//메소드 주입 방식
//class DieselEngine {
//  val fuel = "diesel"
//}
//
//class Car {
//  val engine = null
//
//  private fun setEngine(engine: Engine) {
//      this.engine = engine
//  }
//}
//
//fun main() {
//  val dieselEngine = DieselEngine()
//  val car = Car()
//  car.setEngine(dieselEngine)
//}

//-------------------------------------------------------------------------------------------------------

//인터페이스를 통한 주입 방식
//interface DieselEngineInjector {
//  fun inject(dieselEngine: DieselEngine)
//}
//
//class DieselEngine {
//  val fuel = "diesel"
//}
//
//class Car implements DieselEngineInjector {
//  val engine = null
//
//  override fun inject(dieselEngine: DieselEngine) {
//      this.engine = engine
//  }
//}
//
//fun main() {
//  val dieselEngine = DieselEngine()
//  val car = Car()
//  car.inject(dieselEngine)
//}

//-------------------------------------------------------------------------------------------------------

//생성자 주입 방식
//필요한 모든 의존객체를 객체를 생성하는 시점에 준비 가능
//생성 시점에 의존객체가 정상인지 아닌지 판정 가능

//메소드와 인터페이스를 통한 주입 방식
//의존객체가 나중에 생성되는 경우에 사용 가능
//메소드의 이름을 통해 어떤 의존객체를 주입하는지 더 알기 쉬움

//-------------------------------------------------------------------------------------------------------

//서비스 로케이터 방식 : Locator의 의존성 주입을 클래스에 모아서 전달
//class GasolineEngine {
//  val fuel = "gasoline"
//}
//
//class DieselEngine {
//  val fuel = "diesel"
//}
//
//class Locator(
//  private val dieselEngine: DieselEngine,
//  private val gasolineEngine: GasolineEngine)
//{
//
//  fun getGasolineEngine(): GasolineEngine {
//      return gasolineEngine
//  }
//
//  fun getDieselEngine(): DieselEngine {
//      return dieselEngine
//  }
//
//  companion object {
//      private var instance: Locator? = null

//서비스 로케이터의 한계
//인터페이스 분리원칙을 위반하게 됨
//동일한 의존객체를 여러 클래스에서 사용해야 할 경우, 제공 메소드를 각 객체 수만큼 준비해야 함
//의존성에 문제가 있어도 컴파일 타임에 확인할 수 없음