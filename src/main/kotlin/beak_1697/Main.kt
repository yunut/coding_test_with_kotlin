package beak_1697

import java.util.LinkedList
import java.util.Queue

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }

    // -1: not visited
    val checkedList = IntArray(100000 + 1) { -1 }

    var count = 0
    val queue: Queue<Int> = LinkedList()
    queue.add(n)
    while (queue.isNotEmpty()) {
        val cycleList = mutableListOf<Int>()
        while (queue.isNotEmpty()) {
            cycleList.add(queue.poll())
        }

        for (data in cycleList) {
            checkedList[data] = count
            if (data == m) {
                queue.clear()
                break
            }

            val minusX = data.minus(1)
            val plusX = data.plus(1)
            val mulX = data * 2
            if (minusX >= 0 && checkedList[minusX] == -1) {
                queue.add(minusX)
            }
            if (plusX < checkedList.size && checkedList[plusX] == -1) {
                queue.add(plusX)
            }
            if (mulX < checkedList.size && checkedList[mulX] == -1) {
                queue.add(mulX)
            }
        }
        count++
    }

    println(checkedList[m])
}
