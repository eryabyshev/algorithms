package move_zeroes

class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        var lastNotZero = 0

        for (i in nums.indices) {
            if(nums[i] == 0) {
                continue
            }
            nums[lastNotZero] = nums[i]
            lastNotZero++
        }


        for (i in lastNotZero until nums.size) {
            nums[i] = 0
        }
    }



}

fun main() {

    val ar = intArrayOf(0,1,0,3,12)

    Solution().moveZeroes(ar)

    println(ar.joinToString(", "))

}