package baek_1541

// https://www.notion.so/2-9ffcc015bb104f4fa30eee205e2ed904?pvs=4
fun main(args: Array<String>) {
    val s = readLine()!!
    val splitMinusSAndSum =
        s.split("-").map {
            if (it == "") return@map 0
            it.split("+").map { it.toInt() }.sum()
        }

    println(splitMinusSAndSum[0] - splitMinusSAndSum.drop(1).sum())
}
