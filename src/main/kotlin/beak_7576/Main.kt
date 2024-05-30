package beak_7576

import java.util.LinkedList
import java.util.Queue

fun main(args: Array<String>) {
    var answer = -1

    val (n, m) = readLine()!!.split(" ").map { it.toInt() }

    // init
    val map = Array(m) { IntArray(n) }
    map.forEachIndexed { index, it ->
        map[index] = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    }

    // 초기에 모두 익었는지 체크
    if (!map.any { it.contains(0) }) {
        println(0)
        return
    }

    // bfs 수행
    val q: Queue<Pair<Int, Int>> = LinkedList()
    map.forEachIndexed { i, arr ->
        arr.forEachIndexed { ii, arr2 ->
            if (map[i][ii] == 1) {
                q.add(Pair(i, ii))
            }
        }
    }

    while (q.isNotEmpty()) {
        // 회차당 큐에 들어있는 좌표를 체크해야 되기 때문에 모두 꺼냄
        val checkList = mutableListOf<Pair<Int, Int>>()
        while (q.isNotEmpty()) {
            val value = q.poll()
            checkList.add(value)
        }

        checkList.forEach {
            map[it.first][it.second] = 1
        }
        val checkedSet = mutableSetOf<Pair<Int, Int>>()
        for (point in checkList) {
            // check left
            val leftPoint = Pair(point.first, point.second - 1)
            if (leftPoint.second >= 0) {
                if (map[leftPoint.first][leftPoint.second] == 0) checkedSet.add(leftPoint)
            }

            // check right
            val rightPoint = Pair(point.first, point.second + 1)
            if (rightPoint.second < map[0].size) {
                if (map[rightPoint.first][rightPoint.second] == 0) checkedSet.add(rightPoint)
            }

            // check up
            val upPoint = Pair(point.first - 1, point.second)
            if (upPoint.first >= 0) {
                if (map[upPoint.first][upPoint.second] == 0) checkedSet.add(upPoint)
            }

            // check down
            val downPoint = Pair(point.first + 1, point.second)
            if (downPoint.first < map.size) {
                if (map[downPoint.first][downPoint.second] == 0) checkedSet.add(downPoint)
            }
        }
        checkedSet.forEach {
            q.add(it)
        }
        answer++
    }

    if (map.any { it.any { it == 0 } }) {
        println(-1)
    } else {
        println(answer)
    }
}
