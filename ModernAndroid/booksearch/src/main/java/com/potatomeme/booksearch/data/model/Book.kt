package com.potatomeme.booksearch.data.model


import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
@Entity(tableName = "books")
data class Book(

    @ColumnInfo(name = "authors")
    @field:Json(name = "authors")
    val authors: List<String>,

    @ColumnInfo(name = "contents")
    @field:Json(name = "contents")
    val contents: String,

    @ColumnInfo(name = "datetime")
    @field:Json(name = "datetime")
    val datetime: String,

    @PrimaryKey(autoGenerate = false)
    @field:Json(name = "isbn")
    val isbn: String,

    @ColumnInfo(name = "price")
    @field:Json(name = "price")
    val price: Int,

    @ColumnInfo(name = "publisher")
    @field:Json(name = "publisher")
    val publisher: String,

    @ColumnInfo(name = "sale_price")
    @field:Json(name = "sale_price")
    val salePrice: Int,

    @ColumnInfo(name = "status")
    @field:Json(name = "status")
    val status: String,

    @ColumnInfo(name = "thumbnail")
    @field:Json(name = "thumbnail")
    val thumbnail: String,

    @ColumnInfo(name = "title")
    @field:Json(name = "title")
    val title: String,

    @ColumnInfo(name = "translators")
    @field:Json(name = "translators")
    val translators: List<String>,

    @ColumnInfo(name = "url")
    @field:Json(name = "url")
    val url: String
) : Parcelable