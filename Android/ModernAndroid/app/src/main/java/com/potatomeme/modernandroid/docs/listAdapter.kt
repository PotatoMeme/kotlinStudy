package com.potatomeme.modernandroid.docs

// ListAdapter

// 리사이클러뷰의 아이템이 변경된 경우 리사이클러뷰에서 제공하는 notifyItem method를 통하여 viewHolder 의 값들을 최신화를 해줘야합니다.

// notifyItem method
// notifyItemChange(int) , item 변경됬을 경우
// notifyItemInserted(int) , item 추가됬을 경우
// notifyItemRemoved(int) , item 삭제됬을 경우
// notifyItemRangeChange(int) , 범위에서 변경됬을 경우
// notifyItemRangeInserted(int) , 범위에서 추가됬을 경우
// notifyItemRangeRemoved(int) , 범위에서 삭제됬을 경우

// 데이터가 변경되는것을 확인해야되 일일이 notify를 해준다든가 갱신이 필요없는 viewHolder 까지 갱신 한다는 불편함이 있었음

// ---------------------------------------------------------------------------------------------------------------------------------------

// DiffUtil
// 2개의 데이터셋을 받아서 그차이를 계산해주는 클래스입니다.
// DiffUtil을 사용하면 2개의 데이터셋을 비교하여 다른부분을 파악하여 그부분만 리사이클러뷰에 반영할수 있음

// 구현
// DiffUtil 콜백을 상속받아야함
// areItemsTheSame() -> 2객체가 동일한지 확인
// areContentsTheSame() -> 2개의 item의 내용까지 동일한지 확인

// ex)
// companion object {
//      private val BookDiffCallback = object : DiffUtil.ItemCallback<Book>() {
//          override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
//              return oldItem.isbn == newItem.isbn
//          }
//
//          override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
//              return oldItem == newItem
//          }
//      }
//  }

// ---------------------------------------------------------------------------------------------------------------------------------------

// AsyncsListDiffer
// DiffUtil은 아이템 개수가 많을 경우 백그란운드 스레드에서 처리되어야 함
// AsyncsListDiffer DiffUtil을 편하게 사용하기위하여 만들어진 클래스
// DiffUtil에 대해 자체적으로 스레드 처리를 해주는 클래스

// ex)
// class BookSearchAdapter : RecyclerView.Adapter<BookSearchViewHolder> {
//      기존
//      private var mBook : List<Book>
//      AsyncsListDiffer
//      private final AsyncListDiffer<Book> mDiffer = new AsyncListDiffer(this,DIFF_CALLBACK);
// }

// ---------------------------------------------------------------------------------------------------------------------------------------

// ListAdapter
// AsyncsListDiffer를 더 쓰기 편하도록 랩핑한 클래스
// 리사이클러뷰 어댑터가 ListAdapter를 상속하게 하고 초기화시 DiffUtil 콜백 객체를 넘겨줌
// submitList()로 전체 데이터를 넘겨주면 어댑터가 백그라운드 스레드를 사용해 리스트 차이를 계산하여 화면을 갱신시켜줌