package de.bsi.basics.streams

import java.util.stream.Collectors

val names = listOf("Ardbeg", "Lagavulin", "Jim Beam", "Teeling", "Jameson", "Johnny Walker")

data class Whisky(val name: String, val length: Int)

fun demoMapAndToList(): List<Whisky> {
    // Map all Strings to Whisky objects and collect in List.
    val whiskiesOld = mutableListOf<Whisky>()
    for (name in names){
        val w = Whisky(name, name.length)
        whiskiesOld.add(w)
    }

    val whiskies = names.stream().map { n -> Whisky(n, n.length) }.toList()
//    println(whiskies)
    return whiskies
}

fun main() {
    val whiskies = demoMapAndToList()
//    demoSortedAndForEach(whiskies)
//    demoFilterAndCount(whiskies)
//    demoPeekAndFindFirst(whiskies)
//    demoMatch(whiskies)
//    demoGroupBy(whiskies)
    demoParallelProcessing(whiskies)
}

fun demoSortedAndForEach(whiskies: List<Whisky>) {
    // Sort objects in Stream and consume each.
    whiskies.stream().sorted { o1, o2 -> o2.length - o1.length  }.forEach (::println)
}

private fun demoFilterAndCount(whiskies: List<Whisky>) {
    // Count objects in Stream, which match filter condition
    val lengthHigher7 = whiskies.stream().filter { w -> w.length > 7 }.count()
    println("Wiskey größer 7  = $lengthHigher7")
}

fun demoPeekAndFindFirst(whiskies: List<Whisky>) {
    // Find first object in Stream, which matches filter condition, additionally its position is counted.
    var counter = 0
    whiskies.stream().peek {_ -> counter++  }.filter { it.name.contains("J") }.findFirst().ifPresent { println("Found Whisky ${it.name} on position $counter") }

}

fun demoMatch(whiskies: List<Whisky>) {
    // Check condition of all elements in Stream
    println("All Whiskies have name with more than 0 characters: " + whiskies.stream().allMatch { it.length > 0 })
    println("No Whisky has name with more than 0 characters: " + whiskies.stream().noneMatch { it.length < 0 })
    println("Any Whisky has name with more than 10 characters: " + whiskies.stream().anyMatch{ it.length > 10 })
}

fun demoGroupBy(whiskies: List<Whisky>) {
    // Group Whiskies by attribute
    whiskies.stream().collect(Collectors.groupingBy{ it.length }).forEach(::println)
}

fun demoParallelProcessing(whiskies: List<Whisky>) {
//    whiskies.stream().parallel().forEach(::println)
    // 10 times bigger Stream.
    IntRange(0,10).flatMap { _ -> whiskies }.parallelStream().forEach(::println)
}