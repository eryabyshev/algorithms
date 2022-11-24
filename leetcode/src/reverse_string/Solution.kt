package reverse_string

class Solution {
    fun reverseString(s: CharArray): Unit {
        var start = 0
        var finish = s.size - 1

        while (start <= finish) {
            val tmp = s[start]
            s[start] = s[finish]
            s[finish] = tmp
            start++
            finish--
        }
    }
}

fun main() {

    val ar = charArrayOf('h','e','l','o')

    Solution().reverseString(ar)

    println(ar.joinToString())
}