package maximum_subarray

class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var left = 0
        var right = 1
        var sum = 0
        var max = Int.MIN_VALUE


        while (left < right && right <= nums.size) {
            sum += nums[right - 1]
            max = if (sum > max) sum else max
            if (sum <= 0) {
                left = right
                sum = 0
            }
            right++
        }
        return max
    }
}

fun main(args: Array<String>) {
    Solution().maxSubArray(intArrayOf(-2,1)).apply { println(this) }
}