package remove_element

import palindrome_linked_list.prettyPrint

class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var result = 0
        var left = 0

        while (left <= nums.size - 1) {
            nums[left - result] = nums[left]
            if(nums[left] == `val`) {
                result++
            }
            left++
        }
        return nums.size - result
    }
}

fun main() {

    val intArrayOf = intArrayOf(0,1,2,2,3,0,4,2)

    println(Solution().removeElement(intArrayOf, 2))
    println(intArrayOf.prettyPrint())
}