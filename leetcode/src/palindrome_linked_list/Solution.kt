package palindrome_linked_list

class ListNode(var `val`: Int) {
    var next: ListNode? = null
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