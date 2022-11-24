package reverse_words_in_string_3

class Solution {
    fun reverseWords(s: String): String {
        return s.split(" ").joinToString(" ") { it.reversed() }
    }
}

fun main() {
    println(Solution().reverseWords("Let's take LeetCode contest"))
}