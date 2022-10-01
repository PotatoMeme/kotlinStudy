package com.potatomeme.booksearch.data.repository

import com.potatomeme.booksearch.data.api.RetrofitInstance.api
import com.potatomeme.booksearch.data.model.SearchResponse
import retrofit2.Response

class BookSearchRepositoryImpl : BookSearchRepository {
    override suspend fun searchBooks(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): Response<SearchResponse> {
        return api.searchBooks(query, sort, page, size)
    }
}