package beak_10816

// https://www.notion.so/f8d61f359a1f46eb95e479beaf9004c0?pvs=4
fun main(args: Array<String>) {
    val m = readLine()!!.toInt()
    val cards = readLine()!!.split(" ").map { it.toInt() }
    val n = readLine()!!.toInt()
    val targets = readLine()!!.split(" ").map { it.toInt() }

    val cardsMap = cards.groupingBy { it }.eachCount()

    targets.map { cardsMap.getOrDefault(it, 0) }.joinToString(" ").let(::println)
}
