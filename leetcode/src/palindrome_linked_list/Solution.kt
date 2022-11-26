package palindrome_linked_list

class ListNode(var `val`: Int) {
    var next: ListNode? = null


    companion object {
        fun fromArray(ar: IntArray): ListNode {
            var node = ListNode(ar.first())
            val head = node
            ar.drop(1).forEach {
                val next = ListNode(it)
                node.next = next
                node = next
            }
            return head
        }

        fun toArray(node: ListNode?): IntArray {
            if(node == null) {
                return intArrayOf()
            }

            val result = mutableListOf<Int>()
            var head = node

            while (head != null) {
                result.add(head.`val`)
                head = head.next ?: break
            }
            return result.toIntArray()
        }
    }
}

//@link https://leetcode.com/problems/palindrome-linked-list/solution/

class Solution {
    fun isPalindrome(head: ListNode?): Boolean {

        if(head == null) {
            return false
        }

        var start = head

        val list = mutableListOf(head.`val`)

        while (start?.next != null) {
            start = start.next
            list.add(start!!.`val`)
        }

        if(list.size == 1) {
            return true
        }


        var first = 0
        var last = list.size - 1

        while (first <= last) {
            if(list[first] != list[last]) {
                return false
            }
            first++
            last--
        }

        return true
    }

}