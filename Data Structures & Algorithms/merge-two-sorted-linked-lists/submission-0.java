/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode head = new ListNode();
        ListNode it = head;
        ListNode l1 = list1;
        ListNode l2 = list2;

        while (l1 != null || l2 != null) {

            if (l1 != null && l2 != null) {
                if(l1.val < l2.val) {
                    it.next = l1;
                    it = l1;
                    l1 = l1.next;
                } else {
                    it.next = l2;
                    it = l2;
                    l2 = l2.next;
                }
            } else if(l1 != null) {
                it.next = l1;
                it = l1;
                l1 = l1.next;
            } else {
                it.next = l2;
                it = l2;
                l2 = l2.next;
            }
        }

        return head.next;
    }
}