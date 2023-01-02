package best_time_to_buy_and_sell_stock_2

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var profit = 0
        for (i in 1 until prices.size) {

            if(prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1]
            }
        }
        return profit
    }
}

fun main() {
    Solution().maxProfit(intArrayOf(1,2,3,4,5)).apply { println(this) }
}