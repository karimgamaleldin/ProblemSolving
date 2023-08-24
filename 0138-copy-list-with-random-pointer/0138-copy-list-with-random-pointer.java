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
    public Node copyRandomList(Node head) {
        HashMap<Node , Node> map = new HashMap<>();
        Node dummy = new Node(0);
        Node d = dummy;
        Node curr = head;
        while(curr != null){
            Node t = new Node(curr.val);
            map.put(curr , t);
            d.next = t;
            d = d.next;
            curr = curr.next;
        }
        curr = head;
        d = dummy.next;
        while(curr != null){
            d.random = map.get(curr.random);
            d = d.next;
            curr = curr.next;
        }
        return dummy.next;
    }
}