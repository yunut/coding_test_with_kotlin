package baek_1541

fun main(args: Array<String>) {
    val s = readLine()!!
    val splitMinusSAndSum =
        s.split("-").map {
            if (it == "") return@map 0
            it.split("+").map { it.toInt() }.sum()
        }

    println(splitMinusSAndSum[0] - splitMinusSAndSum.drop(1).sum())
}
