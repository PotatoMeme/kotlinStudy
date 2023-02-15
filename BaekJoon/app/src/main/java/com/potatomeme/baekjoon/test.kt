package com.potatomeme.baekjoon

fun main() = with(System.`in`.bufferedReader()) {

}

fun mergeSort(A: IntArray, low: Int, high: Int, B: IntArray) {
    // 1. base condition
    if (low >= high) return

    // 2. divide
    val mid = (low + high) / 2

    // 3. conquer
    mergeSort(A, low, mid, B)
    mergeSort(A, mid + 1, high, B)

    // 4. combine
    var i = low
    var j = mid + 1

    for (k in low..high) {
        if (j > high) {
            B[k] = A[i++]
        } else if (i > mid) {
            B[k] = A[j++]
        }else if (A[i] <= A[j]) {
            B[k] = A[i++]
        }else {
            B[k] = A[j++]
        }
    }

    // 5. copy
    for (i in low..high){
        A[i] = B[i]
    }
}
