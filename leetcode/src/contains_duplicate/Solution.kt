package contains_duplicate


class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        if(nums.size == 1) {
            return false
        }

        nums.sort()

        var right = nums.size - 1
        var left = 0

        while (right > left) {
            if(nums[left] == nums[left + 1]) {
                return true
            }
            if(nums[right] == nums[right - 1]) {
                return true
            }
            right--
            left++
        }
        return false
    }
}

fun main() {
    Solution().containsDuplicate(intArrayOf(1,2,3,4)).apply { println(this) }
}