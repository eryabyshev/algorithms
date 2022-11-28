package longest_substring_without_repeating_characters

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val visited: MutableMap<Char, Int> = HashMap()
        var result = 0

            var start = 0
            var end = 0
            while (end <= s.length - 1) {
                val target: Char = s[end]
                if (visited.containsKey(target)) {
                    start = Math.max(visited[target]!! + 1, start)
                }
                result = Math.max(result, end - start + 1)
                visited[target] = end
                end++
            }

        return result
    }
}


fun main() {

    println(Solution().lengthOfLongestSubstring("dvdf"))

}