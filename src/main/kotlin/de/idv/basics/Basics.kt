package de.kotlin.udemy1.basics

fun main() {
    var num: Int = 11
    num += 1

    val finalNum: Int = 12
// sollte direkt von deiner IDE als nicht möglich erkannt werden nach einkommentieren
// finalNum += 1

    // simple function
    println(getMessageFor("Max Mustermann"))

    // simple classes
    println(Basics().getMessage())

    val finalVariables = Variables("Name", 99)
    finalVariables.printValues()
    finalVariables.alter = 20
    finalVariables.printValues()
}

fun getMessageFor(student: String) = "hello student $student"

class Variables(val name: String, var alter: Int = 3) {
    private var text = "Name: "
    fun printValues() {
        println(text + name)
        text = text.replace("Name", "Alter")
        println(text + alter)

    }
}

class Basics {
    fun getMessage(): String {
        return "hello function"
    }
}
