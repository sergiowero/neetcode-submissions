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

    // [2,4,6,8,10]
    //  2 6
    //  4 8
    // 
    // [2,10,4,8,6]

    public void reorderList(ListNode head) {
        
        ListNode middle = middleOfList(head);
        ListNode second = middle.next;
        middle.next = null;
        ListNode reversed = reverseList(second);
        
        ListNode l1 = head;
        ListNode l2 = reversed;
        print(l1);
        print(l2);

        ListNode dummy = new ListNode();
        ListNode res = dummy;

        while(l1 != null && l2 != null) {

            var c1 = l1;
            l1 = l1.next;

            var c2 = l2;
            l2 = l2.next;

            res.next = c1;
            c1.next = c2;
            res = c2;
        }

        res.next = l1;
        
    }

    public ListNode reverseList(ListNode head) {

        // a -> b -> c -> d
        // 

        ListNode prev = null;
        ListNode it = head;
        while (it != null) {
            ListNode cur = it;  // cur = a.   | curr = b
            it = it.next;       // it = b.    | it = c
            cur.next = prev;    // a -> null. | b -> a  
            prev = cur;         // prev = a.  | prev = b
        }
        return prev;
    }

    public ListNode middleOfList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Mientras el puntero rápido pueda avanzar dos pasos
        while (fast != null && fast.next != null) {
            slow = slow.next;       // Avanza 1 nodo
            fast = fast.next.next;  // Avanza 2 nodos
        }
        
        // Cuando fast llega al final, slow está en la mitad
        return slow;
    }

    public void print(ListNode node) {
        System.out.print("[");
        while(node != null){
            System.out.print(node.val + ",");
            node = node.next;
        }
        System.out.println("]");
    }


}
