/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    Map<Node, Node> refs = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        Node copied = new Node(head.val);

        refs.put(head, copied);

        copied.next = copyRandomList(head.next);
        if (head.random != null) {
            copied.random = refs.get(head.random);
        }

        return copied;
    }
}
