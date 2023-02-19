package com.potatomeme.modernandroid.docs


// Room

// ---------------------------------------------------------------------------------------------------------------------------------------

// SQL 과 CRUD

// Structured Query Language (SQL)

// CRUD

// Create
// Read
// Update
// delete

// ---------------------------------------------------------------------------------------------------------------------------------------

// DataBase Management System

// ex) Oracle,MySQL

// SQLite

// Android 와 iOS에 기본 채택
// 미해군의 구축함에서 이용하기 우해서 만들어짐
// 전세계에서 1조개가 넘는 DB가 운용되고 있음

// 안드로이드에서의 SQLite 사용
// android.database.sqlite

// 안드로이드에서는 SQLite를 사용하여 데이터 저장을 권하지 않음
// 원시 SQL 쿼리에 관한 컴파일 시간 확인이 없습니다.
// 따라서 데이터 그래프가 변경됨에 따라 영향을 받는 SQL 쿼리를 수동으로 업데이트해야 합니다.
// 이 과정은 시간이 오래 걸리고 오류가 쉽게 발생할 수 있습니다.
// SQL 쿼리와 데이터 객체 간에 변환하려면 많은 상용구 코드를 사용해야 합니다.

// ---------------------------------------------------------------------------------------------------------------------------------------

// 구글에서는 안드로이드에서 SQLite를 다루기 위해서 안드로이드 SQLite 페키지를 만듬
// 이 SQLite 페키지를 더 안전하게 다루기 위하여 Room이라는 라이브러리를 만듬
// Room의 구조

// Room Database        <-- GetDao --> Rest of The App
// Data Access Objects  <-- Get Entities from db , Persist changes back to db --> Rest of The App
// Entities             <-- get / set field values --> Rest of The App

// @Entity
// data clas User(
//      @PrimaryKey val uid: Int,
//      @ColumnInfo(name = "first_name") val firstName: String?,
//      @ColumnInfo(name = "last_name") val lastName: String?
// )

// @Dao
//  interface UserDao {
//
//      @Query("SELECT * FROM user")
//      fun getAll(): List<User>
//
//      @Query("SELECT * FROM user WHERE uid IN (:userIds)")
//      fun loadAllByIds(userIds: IntArray): List<User>
//
//      @Query("SELECT * FROM user WHERE first_name LIKE :first AND last_name LIKE :last LIMIT 1")
//      fun loadAllByIds(first: String, last:String): User
//
//      @Insert
//      fun insert(user: User)
//
//      @Insert
//      fun insertAll(vararg users: User)
//
//      @Update
//      fun update(user: User)
//
//      @Delete
//      fun delete(user: User)
//  }

// @Database(entities = [User::class], version = 1)
// abstract class UserDatabase: RoomDatabase() {
//      abstract fun userDao(): UserDao
// }

// ---------------------------------------------------------------------------------------------------------------------------------------

// Room의 장점
// 보일러코드를 줄일수 있음
// 쿼리의 컴파일 시간을 체크할수 있습니다.
// 마이그레이션을 쉽게 만듭니다.
// test를 더 용이하게 만들어 줍니다.
// 메인스레드에서 DB를 다루지 않도록만들어줌