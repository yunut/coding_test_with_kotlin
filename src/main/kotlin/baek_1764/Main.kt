package baek_1764

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }

    val listenSet = mutableSetOf<String>()
    for (i in 0 until n) {
        val s = readLine()!!
        listenSet.add(s)
    }

    val answerList = mutableListOf<String>()
    for (i in 0 until m) {
        val s = readLine()!!
        if (listenSet.contains(s)) {
            answerList.add(s)
        }
    }

    println(answerList.size)
    answerList.sorted().forEach {
        println(it)
    }
}
