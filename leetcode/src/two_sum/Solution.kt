package two_sum

//@link https://leetcode.com/problems/two-sum/solution/

class Solution {

    fun twoSum(nums: IntArray, target: Int): IntArray {

        val mutableMap = mutableMapOf<Int, Int>()

        for (i in 0..nums.size) {
            val dif = target - nums[i]
            if(mutableMap.containsKey(dif)) {
                return intArrayOf(i, mutableMap[dif]!!)
            }
            mutableMap[nums[i]] = i
        }
        return IntArray(0)
    }

}