package rotting_oranges

class Solution {


    var cantFound = 0


    fun orangesRotting(grid: Array<IntArray>): Int {

        var fresh = 0

        grid.forEach {
            it.forEach {i ->
                if(i == 1) {
                    fresh++
                }
            }
        }
        return doIt(grid, fresh)

    }


    fun doIt(grid: Array<IntArray>, freshCounter: Int, round: Int = 0): Int {
        val roundNow = round
        if(freshCounter == 0) {
            return roundNow
        }
        var spoil = 0
        var wasFound = false

        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if(grid[i][j] == 2 + round) {
                    spoil += spoil(grid, i, j, round)
                    wasFound = true
                }
            }

        }

        if(!wasFound) {
            cantFound++
        }
        if(cantFound > grid.size) {
            return -1
        }

        return doIt(grid, freshCounter-spoil, round + 1)
    }


    fun spoil(grid: Array<IntArray>, x: Int, y: Int, round: Int, total: Int = 0): Int {

        if(x < 0 || x > grid.size - 1) {
            return 0
        }
        if(y < 0 || y > grid[x].size - 1) {
            return 0
        }

        var result = total

        if(grid[x][y] == 0) {
            return 0
        }

        if(grid[x][y] == 1) {
            grid[x][y] = 2 + round + 1
            return 1
        }

        if(grid[x][y] == 2 + round) {
            grid[x][y] = -1
            result += spoil(grid, x, y+1, round, result)
            result += spoil(grid, x+1, y, round, result)

            result += spoil(grid, x, y-1, round, result)
            result += spoil(grid, x-1, y, round, result)

            return result
        }
        return 0
    }

}

fun main() {

    Solution().orangesRotting(
        arrayOf(
            intArrayOf(2,2,0,2),
            intArrayOf(2,1,2,2),
        )
    ).let { println(it) }


}