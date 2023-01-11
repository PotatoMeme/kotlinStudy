package com.potatomeme.baekjoon

fun main() = with(System.`in`.bufferedReader()) {

}

fun insertionSort(arr: IntArray) {
    for (index in 1 until arr.size) {
        val temp = arr[index]
        var aux = index - 1
        while (aux >= 0 && arr[aux] > temp) {
            arr[aux + 1] = arr[aux]
            aux--
        }
        arr[aux + 1] = temp
    }
}