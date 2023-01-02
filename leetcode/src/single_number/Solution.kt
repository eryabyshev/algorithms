package single_number

class Solution {
    fun singleNumber(nums: IntArray): Int {
       var xor = 0
        nums.forEach {
          xor = xor xor it
        }
        return xor
    }
}

fun main() {
    Solution().singleNumber(intArrayOf(4,1,2,1,2)).apply { println(this) }
}