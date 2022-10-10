package com.potatomeme.booksearch.data.repository

import androidx.lifecycle.LiveData
import com.potatomeme.booksearch.data.model.Book
import com.potatomeme.booksearch.data.model.SearchResponse
import retrofit2.Response

interface BookSearchRepository {

    suspend fun searchBooks(
        query: String,
        sort: String,
        page: Int,
        size: Int,
    ): Response<SearchResponse>

    // Room
    suspend fun insertBook(book: Book)

    suspend fun deleteBook(book: Book)

    fun getFavoriteBooks(): LiveData<List<Book>>
}