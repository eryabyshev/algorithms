package o1_matrix

import kotlin.math.abs

class Solution {
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val x = mat.size
        val y = mat.first().size
        val result = Array(x) { IntArray(y) { 0 } }

        for (i in mat.indices) {
            for (j in mat[i].indices) {
                if(mat[i][j] != 0) {
                    result[i][j] = findNearestZero(mat, i, j)
                }
            }
        }
        return result
    }


    fun findNearestZero(mat: Array<IntArray>, fromX: Int, fromY: Int): Int {
        var min = Int.MAX_VALUE

        listOf<(x: Int, y: Int) -> Pair<Int, Int>>(
            {x, y -> x+1 to y },
            {x, y -> x-1 to y },
            {x, y -> x to y+1 },
            {x, y -> x to y-1 },
        ).forEach {
            val result = search(mat, fromX, fromY, it)
            if(result == 1) {
                return result
            }
            if(result < min) {
                min = result
            }
        }
        return min
    }


    fun search(mat: Array<IntArray>, x: Int, y: Int, step: (x: Int, y: Int) -> Pair<Int, Int>): Int {
        var xNow = x
        var yNow = y

        while (true) {
            val pair = step.invoke(xNow, yNow)
            xNow = pair.first
            yNow = pair.second

            if(xNow > mat.size - 1 || xNow < 0) {
                return Int.MAX_VALUE
            }
            if(yNow > mat[x].size - 1 || yNow < 0) {
                return Int.MAX_VALUE
            }
            if(mat[xNow][yNow] == 0) {

                val byX = Math.abs(x - xNow)
                val byY = Math.abs(y - yNow)

                if(byX == 0) {
                    return Math.abs(y - yNow)
                }
                if(byY == 0) {
                    return Math.abs(x - xNow)
                }
                return Math.min(Math.abs(x - xNow), Math.abs(y - yNow))
            }
        }
    }
}

fun main() {
    Solution().updateMatrix(
        arrayOf(
            intArrayOf(0,0,0),
            intArrayOf(0,1,0),
            intArrayOf(1,1,1)
        )
    ).apply {
        println(this.joinToString("\n"){r -> r.joinToString(",")})
    }
}