package com.potatomeme.booksearch.data.repository

import com.potatomeme.booksearch.data.model.SearchResponse
import retrofit2.Response

interface BookSearchRepository {

    suspend fun searchBooks(
        query: String,
        sort: String,
        page: Int,
        size: Int,
    ): Response<SearchResponse>
}