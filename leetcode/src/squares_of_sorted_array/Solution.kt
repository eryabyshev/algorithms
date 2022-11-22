package squares_of_sorted_array

import kotlin.math.pow

class Solution {
    fun sortedSquares(nums: IntArray): IntArray {
        if(nums.isEmpty()) {
            return nums
        }
        sort(nums)
        return nums
            .apply { this.forEachIndexed { index: Int, i: Int -> nums[index] = asPow(i) } }

    }

    fun asPow(a: Int): Int = a * a

    fun sort(nums: IntArray, left: Int = 0, right: Int = nums.size - 1) {
        if(nums.isEmpty()) {
            return
        }

        if(left >= right) {
            return
        }

        val mid = left + (right - left) / 2
        val pivot = nums[mid]

        var i = left
        var j = right

        while (i <= j) {

            while (asPow(nums[i]) < asPow(pivot)) {
                i++
            }

            while (asPow(nums[j]) > asPow(pivot)) {
                j--
            }

            if(i <= j) {
                val tmp = nums[i]
                nums[i] = nums[j]
                nums[j] = tmp
                i++
                j--
            }
        }

        if(left < j) {
            sort(nums, left, j)
        }
        if(right > i) {
            sort(nums, i, right)
        }
    }
}

fun main() {
    Solution().sortedSquares(
        intArrayOf(-4,-1,0,3,10)
    )
        .let { println(it.joinToString(", ")) }
}