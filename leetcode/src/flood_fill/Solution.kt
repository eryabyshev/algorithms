package flood_fill

class Solution {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        val baseColor = image[sr][sc]
        if(baseColor == color) {
            return image
        }
        filler(image, sr, sc, baseColor, color)
        return image
    }

    private fun filler(image: Array<IntArray>, x: Int, y: Int, fromColor: Int, toColor: Int) {
        if(x < 0 || x > image.size - 1) {
            return
        }
        if(y < 0 || y > image[x].size - 1) {
            return
        }
        if(image[x][y] != fromColor) {
            return
        }

        image[x][y] = toColor

        filler(image, x, y-1, fromColor, toColor)
        filler(image, x, y+1, fromColor, toColor)
        filler(image, x-1, y, fromColor, toColor)
        filler(image, x+1, y, fromColor, toColor)
    }
}


fun main() {

    val image = arrayOf(
        intArrayOf(1, 1, 1),
        intArrayOf(1, 1, 0),
        intArrayOf(1, 0, 1),
    )

    Solution()
        .floodFill(image, 1, 1, 2)
        .joinToString("\n") { it.joinToString(", ") }
        .apply { println(this) }
}