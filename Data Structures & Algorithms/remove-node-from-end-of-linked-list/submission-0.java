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

    private int listSize = 0;

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return null;
        }

        int index = listSize++;

        head.next = removeNthFromEnd(head.next, n);

        if (index == listSize - n) {
            return head.next; 
        }

        return head;
    }
}
