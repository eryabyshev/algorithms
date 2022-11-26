package remove_th_node

import palindrome_linked_list.ListNode

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if(head?.next == null) {
            return null
        }

        var length = 0
        var pointer = head

        while (pointer != null) {
            pointer = pointer.next
            length++
        }

        if(length == 2) {
            if(n == 1) {
                head.next = null
                return head
            } else {
                return head.next
            }
        }
        val target = length - n

        pointer = head

        if(target == 0) {
            pointer = pointer.next
            return pointer
        }

        var counter = 1

        while (counter < target) {
            pointer = pointer?.next
            counter++
        }
        pointer?.next = pointer?.next?.next
        return head
    }
}

fun main() {


    Solution()
        .removeNthFromEnd(ListNode.fromArray(intArrayOf(1,2, 3)), 1)
        .apply {
            println(ListNode.toArray(this).joinToString(","))
        }


}