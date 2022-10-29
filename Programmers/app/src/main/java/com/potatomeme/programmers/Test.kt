package com.potatomeme.programmers

import kotlin.math.abs


fun main() {
    var str = "01234"
    println(str.removeRange(1..2))
    println(str.substring(1))

    println("".replace("^$".toRegex(), "a"))
}

