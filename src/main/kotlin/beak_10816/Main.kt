package beak_10816

fun main(args: Array<String>) {
    val m = readLine()!!.toInt()
    val cards = readLine()!!.split(" ").map { it.toInt() }
    val n = readLine()!!.toInt()
    val targets = readLine()!!.split(" ").map { it.toInt() }

    val cardsMap = cards.groupingBy { it }.eachCount()

    targets.map { cardsMap.getOrDefault(it, 0) }.joinToString(" ").let(::println)
}
