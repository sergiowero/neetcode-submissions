/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * head.next -> 

 */

class Solution {
    public ListNode reverseList(ListNode head) {
        
        ListNode prev = null;
        ListNode it = head;
        while(it != null) {
            var next = it.next;
            it.next = prev;
            prev = it;
            it = next;
        }

        return prev;
    }
}
