package de.kotlin.udemy1.basics

// Data classes are used to store data - no boilerplate code for equals, hashCode, toString, etc required.
data class ItemDataClass(val name: String, val id: Int, var active: Boolean)

class ItemClassicClass(val name: String, val id: Int, var active: Boolean)

fun main() {
    val itemClassic = ItemClassicClass("Classic class", 201, false)
    itemClassic.active = true

    val itemDataClass = ItemDataClass("Classic class", 201, false)

    val copiedItem = itemDataClass.copy()

    println("normal class has default tostring ${itemClassic.toString()}")
    println("data class has better tostring ${itemDataClass.toString()}")
    println("copiedItem class has better tostring ${copiedItem.toString()}")
    // Eq vergleicht stanadrdmaessig die member bei data clases
    println(copiedItem.equals(itemDataClass))
    println(copiedItem.equals(itemClassic))
}