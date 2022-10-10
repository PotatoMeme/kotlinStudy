package com.potatomeme.booksearch.data.repository

import androidx.lifecycle.LiveData
import com.potatomeme.booksearch.data.api.RetrofitInstance.api
import com.potatomeme.booksearch.data.db.BookSearchDatabase
import com.potatomeme.booksearch.data.model.Book
import com.potatomeme.booksearch.data.model.SearchResponse
import retrofit2.Response

class BookSearchRepositoryImpl(
    private val db: BookSearchDatabase
) : BookSearchRepository {
    override suspend fun searchBooks(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): Response<SearchResponse> {
        return api.searchBooks(query, sort, page, size)
    }

    override suspend fun insertBook(book: Book) {
        db.bookSearchDao().insertBook(book)
    }

    override suspend fun deleteBook(book: Book) {
        db.bookSearchDao().deleteBook(book)
    }

    override fun getFavoriteBooks(): LiveData<List<Book>> {
        return db.bookSearchDao().getFavoriteBooks()
    }
}