package beak_1654

// https://www.notion.so/da62867f2b1a4852aa8cefd46844fa84?pvs=4
fun main(args: Array<String>) {
    val s = readLine()!!.split(" ")
    val k = s[0].toInt()
    val n = s[1].toInt()

    var left: Long = 0
    var right: Long = 0
    val list = mutableListOf<Long>()
    for (i in 0 until k) {
        val num = readLine()!!.toLong()
        list.add(num)
        if (right < num) right = num
    }

    while (left <= right) {
        val mid = (left + right) / 2

        if (mid == 0L) {
            right = 1
            break
        }

        var count: Long = 0
        for (i in 0 until k) {
            count += list[i] / mid
        }

        if (count < n) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    println(right)
}
