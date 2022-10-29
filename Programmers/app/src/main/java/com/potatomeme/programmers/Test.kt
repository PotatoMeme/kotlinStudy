package com.potatomeme.programmers


fun main() {
    var str = "01234"
    println(str.removeRange(1..2))
    println(str.substring(1))

    println("".replace("^$".toRegex(), "a"))
}
