package middle_of_the_linked_list

import palindrome_linked_list.ListNode
import palindrome_linked_list.ListNode.Companion.fromArray


class Solution {
    fun middleNode(head: ListNode?): ListNode? {
        var head = head
        var fast = head

        while (head != null && fast?.next != null) {
            head = head.next
            fast = fast.next?.next
        }
        return head
    }
}

fun main() {

    val fromArray = fromArray(intArrayOf(1, 2, 3, 4, 5))

    val middleNode = Solution().middleNode(fromArray)

    println(ListNode.toArray(middleNode).joinToString(", "))

}
