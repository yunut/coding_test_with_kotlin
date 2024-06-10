package baek_2468

import java.util.LinkedList
import java.util.Queue

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()

    // init
    val numSet = mutableSetOf<Int>()
    val map = Array(n) { IntArray(n) { 0 } }
    for (i in 0 until n) {
        val s = readLine()!!.split(" ").map { it.toInt() }
        for (ii in 0 until n) {
            map[i][ii] = s[ii]
            numSet.add(s[ii])
        }
    }
    numSet.add(0)

    // checked
    var answer = 0
    for (num in numSet) {
        val isChecked = Array(n) { BooleanArray(n) { false } }

        var checkCount = 0
        val q: Queue<Pair<Int, Int>> = LinkedList()
        for (i in 0 until n) {
            for (ii in 0 until n) {
                if (isChecked[i][ii]) continue
                if (map[i][ii] <= num) {
                    continue
                }
                checkCount++
                q.add(Pair(i, ii))
                while (q.isNotEmpty()) {
                    val point = q.poll()
                    isChecked[point.first][point.second] = true

                    val moveUp = Pair(point.first - 1, point.second)
                    if (moveUp.first >= 0 && !isChecked[moveUp.first][moveUp.second]) {
                        if (map[moveUp.first][moveUp.second] > num) {
                            isChecked[moveUp.first][moveUp.second] = true
                            q.add(moveUp)
                        }
                    }

                    val moveDown = Pair(point.first + 1, point.second)
                    if (moveDown.first < n && !isChecked[moveDown.first][moveDown.second]) {
                        if (map[moveDown.first][moveDown.second] > num) {
                            isChecked[moveDown.first][moveDown.second] = true
                            q.add(moveDown)
                        }
                    }

                    val moveLeft = Pair(point.first, point.second - 1)
                    if (moveLeft.second >= 0 && !isChecked[moveLeft.first][moveLeft.second]) {
                        if (map[moveLeft.first][moveLeft.second] > num) {
                            isChecked[moveLeft.first][moveLeft.second] = true
                            q.add(moveLeft)
                        }
                    }

                    val moveRight = Pair(point.first, point.second + 1)
                    if (moveRight.second < n && !isChecked[moveRight.first][moveRight.second]) {
                        if (map[moveRight.first][moveRight.second] > num) {
                            isChecked[moveRight.first][moveRight.second] = true
                            q.add(moveRight)
                        }
                    }
                }
            }
        }

        if (answer < checkCount) {
            answer = checkCount
        }
    }

    println(answer)
}
