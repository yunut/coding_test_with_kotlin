package beak_8958

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    for (i in 0 until n) {
        val s = readLine()!!

        var result = 0
        var point = 0
        s.forEach {
            if (it == 'O') {
                point++
                result += point
            } else {
                point = 0
            }
        }
        println(result)
    }
}
