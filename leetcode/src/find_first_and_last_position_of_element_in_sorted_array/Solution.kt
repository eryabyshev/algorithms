package find_first_and_last_position_of_element_in_sorted_array

import palindrome_linked_list.prettyPrint

class Solution {

    fun searchRange(nums: IntArray, target: Int): IntArray {
        if(nums.isEmpty()) {
            return intArrayOf(-1, -1)
        }
        if(nums.size == 1) {
            return if(nums.first() == target) intArrayOf(0 , 0) else intArrayOf(-1, -1)
        }
        return search(nums, target, 0, nums.size - 1)
    }


    private fun search(nums: IntArray, target: Int, from: Int, to: Int): IntArray {
        if(from == to) {
            if(nums[from] == target) {
                return getPair(nums, from, target)
            }
            return intArrayOf(-1, -1)
        }

        val pointer = from + (to - from) / 2

        if(nums[pointer] == target) {
            return getPair(nums, pointer, target)
        }

        if(nums[pointer] > target) {
            return search(nums, target, from, pointer)
        }

        return search(nums, target, pointer + 1, to)
    }


    private fun getPair(nums: IntArray, pointer: Int, target: Int): IntArray {

        var start = pointer
        var finish = pointer

        while(start-1 >=0 && nums[start-1] == target){
            start--;
        }
        while(finish+1 < nums.size && nums[finish+1] == target){
            finish++;
        }
        return intArrayOf(start, finish)
    }
}

fun main() {
    println(
        Solution().searchRange(intArrayOf(1, 2, 3), 2).prettyPrint()
    )
}