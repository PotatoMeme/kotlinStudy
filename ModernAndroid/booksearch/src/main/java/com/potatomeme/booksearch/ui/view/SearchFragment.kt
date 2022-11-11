package com.potatomeme.booksearch.ui.view

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.potatomeme.booksearch.databinding.FragmentSearchBinding
import com.potatomeme.booksearch.ui.adapter.BookSearchLoadStateAdapter
import com.potatomeme.booksearch.ui.adapter.BookSearchPagingAdapter
import com.potatomeme.booksearch.ui.viewmodel.BookSearchViewModel
import com.potatomeme.booksearch.util.Constants.SEARCH_BOOKS_TIME_DELAY
import com.potatomeme.booksearch.util.collectLatestStateFlow


class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private lateinit var bookSearchViewModel: BookSearchViewModel

    //private lateinit var bookSearchAdapter: BookSearchAdapter
    private lateinit var bookSearchAdapter: BookSearchPagingAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bookSearchViewModel = (activity as MainActivity).bookSearchViewModel
        setupRecyclerView()
        searchBooks()
        setupLoadState()

//        bookSearchViewModel.searchResult.observe(viewLifecycleOwner) { response ->
//            val books = response.documents
//            bookSearchAdapter.submitList(books)
//        }

        collectLatestStateFlow(bookSearchViewModel.searchPagingResult) {
            bookSearchAdapter.submitData(it)
        }
    }

    private fun setupRecyclerView() {

        //bookSearchAdapter = BookSearchAdapter()
        bookSearchAdapter = BookSearchPagingAdapter()
        binding.rvSearchResult.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
            //adapter = bookSearchAdapter
            adapter = bookSearchAdapter.withLoadStateFooter(
                footer = BookSearchLoadStateAdapter(bookSearchAdapter::retry)
                //Retry any failed load requests that would result in a LoadState.Error update to this
                //이에 대한 LoadState.Error 업데이트를 초래하는 실패한 로드 요청을 재시도하십시오.
            )
        }
        bookSearchAdapter.setOnItemClickListener {
            val action = SearchFragmentDirections.actionFragmentSearchToFragmentBook(it)
            findNavController().navigate(action)
        }
    }

    private fun searchBooks() {
        var startTime = System.currentTimeMillis()
        var endTime: Long

        binding.etSearch.text =
            Editable.Factory.getInstance().newEditable(bookSearchViewModel.query)

        binding.etSearch.addTextChangedListener { text: Editable? ->
            endTime = System.currentTimeMillis()
            if (endTime - startTime >= SEARCH_BOOKS_TIME_DELAY) {
                text?.let {
                    val query = it.toString().trim()
                    if (query.isNotEmpty()) {
                        //bookSearchViewModel.searchBooks(query)
                        bookSearchViewModel.searchBooksPaging(query)
                        bookSearchViewModel.query = query
                    }
                }
            }
            startTime = endTime
        }
    }

    private fun setupLoadState() {
        bookSearchAdapter.addLoadStateListener { combinedLoadStates ->
            //combinedLoadStates -> PagingSource와 RemoteMediator의 로딩 상태를 가지고 있음
            val loadState = combinedLoadStates.source
            //loadState.prepend -> 로딩시작시에 만들어짐
            //loadState.append -> 로딩종료시에 만들어짐
            //loadState.refresh ->  로딩갱신시에 만들어짐
            val isListEmpty = bookSearchAdapter.itemCount < 1
                    && loadState.refresh is LoadState.NotLoading
                    && loadState.append.endOfPaginationReached
            //loadState.append.endOfPaginationReached
            //false if there is more data to load in the LoadType this LoadState is associated with, true otherwise. This parameter informs Pager if it should continue to make requests for additional data in this direction or if it should halt as the end of the dataset has been reached.
            //Note: The REFRESHLoadType.REFRESH always has LoadState.endOfPaginationReached set to false.
            //이 LoadState가 연결된 LoadType에 로드할 데이터가 더 있으면 false이고, 그렇지 않으면 true입니다. 이 매개변수는 이 방향으로 추가 데이터를 계속 요청해야 하는지 또는 데이터 세트의 끝에 도달하여 중지해야 하는지를 Pager에 알립니다.
            //참고: REFRESHLoadType.REFRESH에는 항상 LoadState.endOfPaginationReached가 false로 설정되어 있습니다.

            binding.tvEmptylist.isVisible = isListEmpty
            binding.rvSearchResult.isVisible = !isListEmpty

            binding.progressBar.isVisible = loadState.refresh is LoadState.Loading

//            binding.btnRetry.isVisible = loadState.refresh is LoadState.Error
//                    || loadState.append is LoadState.Error
//                    || loadState.prepend is LoadState.Error
//            val errorState: LoadState.Error? = loadState.append as? LoadState.Error
//                ?: loadState.prepend as? LoadState.Error
//                ?: loadState.refresh as? LoadState.Error
//            errorState?.let {
//                Toast.makeText(requireContext(), it.error.message, Toast.LENGTH_SHORT).show()
//            }
        }

//        binding.btnRetry.setOnClickListener {
//            bookSearchAdapter.retry()
//        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}