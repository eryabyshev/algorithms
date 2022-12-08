package swap_nodes_in_pairs

import palindrome_linked_list.ListNode
import palindrome_linked_list.prettyPrint

class Solution {
    fun swapPairs(head: ListNode?): ListNode? {
        if(head == null || head.next == null) {
            return head
        }
        val one = head.next
        val two = head.next?.next
        one?.next = head
        head.next = swapPairs(two)
        return one
    }
}

fun main() {
    Solution()
        .swapPairs(ListNode.fromArray(intArrayOf(1, 2, 3, 4)))
        .let {
            ListNode.toArray(it).prettyPrint()
        }
        .apply {
            println(this)
        }
}

