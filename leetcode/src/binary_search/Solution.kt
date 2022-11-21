package binary_search

/** @link https://leetcode.com/problems/binary-search/?envType=study-plan&id=algorithm-i */

class Solution {

    fun search(nums: IntArray, target: Int): Int {
        if(nums.size == 1) {
            if(nums.first() == target) {
                return 0
            }
            return -1
        }
        return search(nums, target, 0, nums.size - 1)
    }


    fun search(nums: IntArray, target: Int, from: Int, to: Int): Int {
        if(from == to) {
            if(nums[from] == target) {
                return from
            }
            return -1
        }

        val pointer = from + (to - from) / 2

        if(nums[pointer] == target) {
            return pointer
        }

        if(nums[pointer] > target) {
            return search(nums, target, from, pointer)
        }

        return search(nums, target, pointer + 1, to)
    }
}


fun main() {
    val ar = intArrayOf(-1,0,3,5,9,12)
    println(Solution().search(ar, 13))
}