package de.kotlin.udemy1.basics

fun main() {
    demoFor()
    demoWhile()
    demoDoWhile()
}

fun demoFor() {
    println("For loop:")

    for (i in 1..5)
        println(i)
}

fun demoWhile() {
    println("While loop:")
    var i = 5
    while(i > 0){
        println("i--")
        println(i--)
    }
}

fun demoDoWhile() {
    println("Do while loop:")
    var i = 5
    do {
        println("i--")
        println(i--)
    }
    while (i > 0)
}
