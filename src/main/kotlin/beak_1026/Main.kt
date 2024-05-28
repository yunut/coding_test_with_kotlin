package beak_1026

// https://www.notion.so/36d3758440854d75be18acd933355e62?pvs=4
fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map { it.toInt() }
    val b = readLine()!!.split(" ").map { it.toInt() }

    val sortA = a.sorted()
    val reverseSortB = b.sorted().reversed()

    var sum = 0
    for (i in 0 until n) {
        sum += sortA[i] * reverseSortB[i]
    }

    println(a.sorted().zip(b.sorted().reversed()).map { it.first * it.second }.sum())
}
