package remove_duplicates_from_sorted_array

class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var insertIndex = 1
        for (i in 1 until nums.size) {
            if (nums[i - 1] != nums[i]) {
                nums[insertIndex] = nums[i]
                insertIndex++
            }
        }
        return insertIndex

    }
}

fun main() {

    val arr = intArrayOf(0,0,1,1,1,2,2,3,3,4)

    Solution().removeDuplicates(arr)
        .apply {
            println(this)
            println(arr.take(this))
        }
}