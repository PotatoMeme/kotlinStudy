package com.potatomeme.booksearch.data.repository

import androidx.paging.PagingData
import com.potatomeme.booksearch.data.model.Book
import com.potatomeme.booksearch.data.model.SearchResponse
import kotlinx.coroutines.flow.Flow
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

    fun getFavoriteBooks(): Flow<List<Book>>

    // DataStore
    suspend fun saveSortMode(mode: String)

    suspend fun getSortMode(): Flow<String>

    // Paging
    fun getFavoritePagingBooks(): Flow<PagingData<Book>>
}