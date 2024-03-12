package de.kotlin.udemy1.basics

import java.io.IOException

fun main() {
    try {
        throwException()
        println("This line is unreachable.")
    } catch (e: Exception) {
        println(e.message)
    }

    throwException()
    println("This line is unreachable.")
}

fun throwException() {
    throw IOException("Kotlin has no checked Exceptions. In Java IOException is checked.")
}
