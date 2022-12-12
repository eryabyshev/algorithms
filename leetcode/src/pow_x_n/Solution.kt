package pow_x_n

class Solution {
    fun myPow(x: Double, n: Int): Double {
        if(n == 1) {
            return x
        }
        if(n == 0) {
            return 1.0
        }

        var x1 = x
        var n1 = n

        if(n < 0) {
            x1 = 1 / x1
            n1 *= -1
        }


        var result = x1.toInt()


        repeat(n1 - 1) {
            result = result shl 1
        }
        return result.toDouble()
    }
}

fun main() {
    println(Solution().myPow(2.0, 10))
}