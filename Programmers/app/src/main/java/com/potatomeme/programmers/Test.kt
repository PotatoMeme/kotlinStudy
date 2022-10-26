package com.potatomeme.programmers



fun main() {
    val s = "-1 -2 -3 -4"
    var list = mutableListOf<Int>()
    var save = ""
    s.split(" ").forEach {
        list.add(it.toInt())
    }
   print(list)
}