package com.potatomeme.modernandroid.docs

// Singleton Pattern

// Singleton
// 소프트웨어 디자인 패턴중하나
// 클래스의 인스턴스를 단 하나만 만들어야 할때 사용
// ex ) DBHelper

// 자바의 경우
// public class DBHelper {
//      private static DBHelper instance;
//      private DBHelper(){}
//      public static DBHelper getInstance(){
//          if (instance == null){
//              instance = new DBHelper();
//          }
//          return instance;
//      }
// }

// 코틀린의 경우
// object DBHandler {...}
// val dbHandler = DBHandler
// 이경우 파라미터를 전달할수 없음

// 클래스로 구현하기
// class DBHandler private constructor(context : Context){
//      companion object {
//          private var instance : DBHandler? = null
//          fun getInstance(context : Context) =
//              instance ?: DBHandler(context).also {
//                  instance = it
//              }
//      }
// }
// 동시접근할경우 Singleton이 깨지게 됨,스레드 동기화 문제

// Double Checked Locking
// class DBHandler private constructor(context : Context){
//      companion object {
//          @Volatile // 매번 변수의 값을 Read/Write 할 때마다 CPU cache에 저장된 값이 아닌 Main Memory에서 스레드로 스택을 거치지않고 바로 가져와서 사용합니다.
//          private var instance : DBHandler? = null
//          fun getInstance(context : Context) =
//              instance ?: synchronized(DBHandler::class.java) { // 동시사용 막기
//                  instance ?: DBHandler(context).also {
//                      instance = it
//                  }
//          }
//      }
// }
// 자주 쓰이지만 이방법처럼 잠그는방식은 처리속도에 영향을 줄수 있다

// Bill Pugh Solution(Java)
// public class DBHandler {
//      private DBHandler(){}
//      private static class Holder{
//          private static final DBHandler INSTANCE = new DBHandler();
//      }
//      public static BHandler getInstance(){
//          return Holder.INSTANCE;
//      }
// }
// Bill Pugh Solution(Kotlin)
// class DBHandler private constructor(){
//      companion object {
//          var instance : DBHandler by lazy { Holder.instance }
//      }
//      private object Holder{
//          val instance = DBHandler()
//      }
// }
// 코틀린에서는 내부클래스가 Object가 되서 파라미터를 줄수 없기 때문에 Object로 사용하는것이 구현하기 더 좋음
