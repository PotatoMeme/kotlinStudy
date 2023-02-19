package com.potatomeme.booksearch.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.potatomeme.booksearch.data.api.RetrofitInstance.api
import com.potatomeme.booksearch.data.model.Book
import com.potatomeme.booksearch.util.Constants.PAGING_SIZE
import retrofit2.HttpException
import java.io.IOException

class BookSearchPagingSource(
    private val query: String,
    private val sort: String,
) : PagingSource<Int, Book>() {//Int -> 페이지 타입, Book -> Data 타입

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Book> { // 페이지가 데이터를 호출할때마다 불리는 함수
        return try {
            val pageNumber = params.key ?: STARTING_PAGE_INDEX

            val response = api.searchBooks(query, sort, pageNumber, params.loadSize)
            val endOfPaginationReached = response.body()?.meta?.isEnd!!

            val data = response.body()?.documents!!
            val prevKey = if (pageNumber == STARTING_PAGE_INDEX) null else pageNumber - 1
            val nextKey = if (endOfPaginationReached) {
                null
            } else {
                // initial load size = 3 * NETWORK_PAGE_SIZE
                // ensure we're not requesting duplicating items, at the 2nd request
                pageNumber + (params.loadSize / PAGING_SIZE)
            }
            LoadResult.Page(
                data = data,
                prevKey = prevKey,
                nextKey = nextKey,
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Book>): Int? {// 여러이유로 페이지를 갱신을 할때 호출이되는 함수
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    companion object {
        const val STARTING_PAGE_INDEX = 1 // 키 초기값 용
    }
}