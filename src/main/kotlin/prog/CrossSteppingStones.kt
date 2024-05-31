package prog

fun main() {
    println(solution(intArrayOf(2, 4, 5, 3, 2, 1, 4, 2, 5, 1), 3))
}

fun solution(
    stones: IntArray,
    k: Int,
): Int {
    var answer = 0
    var left = stones.minOrNull() ?: 0
    var right = stones.maxOrNull() ?: 0

    while (left <= right) {
        val mid = (left + right) / 2
        if (isCrossable(stones, k, mid)) {
            answer = mid
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return answer
}

fun isCrossable(
    stones: IntArray,
    k: Int,
    mid: Int,
): Boolean {
    var count = 0
    for (stone in stones) {
        if (stone - mid < 0) {
            count++
            if (count >= k) return false
        } else {
            count = 0
        }
    }
    return true
}
