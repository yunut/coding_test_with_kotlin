package beak_11724

import java.util.LinkedList
import java.util.Queue

// https://www.notion.so/f91d9bea8e584cf4bd066bcdf5fdf13f?pvs=4
fun main(args: Array<String>) {
    val s = readLine()!!.split(" ")
    val n = s[0].toInt()
    val m = s[1].toInt()

    val graph = Array(n + 1) { mutableListOf<Int>() }
    val visited = BooleanArray(n + 1)

    for (i in 0 until m) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

    var count = 0
    for (i in 1..n) {
        if (!visited[i]) {
            bfs(i, graph, visited)
            count++
        }
    }

    println(count)
}

fun bfs(
    start: Int,
    graph: Array<MutableList<Int>>,
    visited: BooleanArray,
) {
    val queue: Queue<Int> = LinkedList()
    queue.add(start)
    visited[start] = true

    while (queue.isNotEmpty()) {
        val current = queue.poll()
        for (next in graph[current]) {
            if (!visited[next]) {
                queue.add(next)
                visited[next] = true
            }
        }
    }
}
