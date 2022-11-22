package rotate_array

import kotlin.math.abs

class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {

        val pivot = k % nums.size
        reverse(nums)
        reverse(nums, 0, pivot - 1)
        reverse(nums, from = pivot)

    }

    private fun reverse(nums: IntArray, from: Int = 0, to: Int = nums.size - 1) {
        var left = from
        var right = to

        while (right > left) {
            val tmp = nums[left]
            nums[left] = nums[right]
            nums[right] = tmp
            left++
            right--
        }
    }

}

fun main() {

    val ar = intArrayOf(1,2,3,4,5,6,7)

    Solution().rotate(ar, 3)

    println(ar.joinToString(","))

}