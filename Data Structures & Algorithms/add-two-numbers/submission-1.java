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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int carry = 0;

        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while (l1 != null || l2 != null) {

            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;

            int sum = num1 + num2 + carry;
            int tens = sum / 10; 
            int unit = sum % 10; 

            carry = tens;
            curr.next = new ListNode(unit);
            curr = curr.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummy.next;
    }

    
}
