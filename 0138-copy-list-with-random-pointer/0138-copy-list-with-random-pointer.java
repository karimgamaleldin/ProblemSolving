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
        Node r = new Node(0);
        HashMap<Node , Node> map = new HashMap<Node , Node>();
        Node curr = head;
        Node create = r;
        while(curr != null){
            Node x = new Node(curr.val);
            map.put(curr , x);
            create.next = x;
            create = create.next;
            curr = curr.next;
        }
        curr = head;
        create = r.next;
        while(curr != null){
            Node x = map.getOrDefault(curr.random , null);
            create.random = x;
            create = create.next;
            curr = curr.next;
        }
        return r.next;
    }
}