package max_area_of_island

class Solution {

    var max = 0

    data class ArrayCounter(var counter: Int = 0)

    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        findIsland(grid)
        return max
    }


    fun findIsland(grid: Array<IntArray>) {
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if(grid[i][j] == 1) {
                    val a = ArrayCounter()
                    countArea(grid, i, j, a)
                    max = Math.max(max, a.counter)
                }
            }
        }
    }

    fun countArea(grid: Array<IntArray>, x: Int, y: Int, area: ArrayCounter): ArrayCounter {

        if(x < 0 || x > grid.size - 1) {
            return area
        }
        if(y < 0 || y > grid[x].size - 1) {
            return area
        }
        if(grid[x][y] != 1) {
            return area
        }
        grid[x][y] = 2

        countArea(grid, x, y-1, area)
        countArea(grid, x, y+1, area)
        countArea(grid, x-1, y, area)
        countArea(grid, x+1, y, area)

        area.counter++
        return area
    }

}

fun main() {
    val grid = arrayOf(
        intArrayOf(0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
        intArrayOf(0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
        intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0),
        intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0),
    )

    println(Solution().maxAreaOfIsland(grid))
}