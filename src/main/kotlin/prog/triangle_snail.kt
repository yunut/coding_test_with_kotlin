package prog

fun main() {
    println(solution(1000).joinToString { it.toString() }.toString())
}

private val down = Pair(1, 0)
private val right = Pair(0, 1)
private val leftUp = Pair(-1, -1)

private val direction = arrayOf(down, right, leftUp)

fun solution(n: Int): IntArray {
    val size = n * (n + 1) / 2
    var answer: IntArray = intArrayOf()

    // 1. create Map
    val map = Array(n) { IntArray(n) }

    // 2. 각 방향으로 0이 아닐떄까지 계속 증가
    var point = Pair(0, 0)
    map[point.first][point.second] = 1

    var count = 1
    var directionIndex = 0
    while (count < size) {
        val nowDirection = direction[directionIndex]
        var nextPoint = Pair(point.first + nowDirection.first, point.second + nowDirection.second)
        while (nextPoint.first < map.size && nextPoint.second < map[0].size && map[nextPoint.first][nextPoint.second] == 0) {
            map[nextPoint.first][nextPoint.second] = ++count
            point = nextPoint
            nextPoint = Pair(nextPoint.first + nowDirection.first, nextPoint.second + nowDirection.second)
        }

        if (directionIndex < direction.size - 1) {
            directionIndex++
        } else {
            directionIndex = 0
        }
    }

    return map.flatMap { it.filter { it != 0 } }.toIntArray()
}
