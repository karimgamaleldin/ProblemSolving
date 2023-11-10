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
        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head;
        Node dummy = new Node(0);
        Node sol = dummy;
        while(curr != null){
            sol.next = new Node(curr.val);
            map.put(curr, sol.next);
            sol = sol.next;
            curr = curr.next;
        }
        curr = head;
        sol = dummy.next;
        while(sol != null){
            sol.random = map.get(curr.random);
            sol = sol.next;
            curr = curr.next;
        }
        return dummy.next;
    }
}