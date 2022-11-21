package search_insert_position

class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var from = 0
        var to = nums.size - 1

        while (from <= to) {

            val mid = from + (to - from) / 2

            if(nums[mid] == target) {
                return mid + 1
            }

            if(target > nums[mid]) {
                from = mid + 1
            } else {
                to = mid - 1
            }
        }
        return from
    }
}

fun main() {
    Solution().searchInsert(
        intArrayOf(1, 3, 5, 6),
        2
    ).let { println(it) }
}