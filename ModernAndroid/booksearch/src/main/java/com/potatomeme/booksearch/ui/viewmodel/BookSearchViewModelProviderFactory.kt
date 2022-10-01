package com.potatomeme.booksearch.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.potatomeme.booksearch.data.repository.BookSearchRepository

class BookSearchViewModelProviderFactory(
    private val bookSearchRepository: BookSearchRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BookSearchViewModel::class.java)) {
            return BookSearchViewModel(bookSearchRepository) as T
        }
        throw java.lang.IllegalArgumentException("ViewModel class not found")
    }
}